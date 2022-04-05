package col.san.GestionEmpleados.infraestructura.controlador;

import col.san.GestionEmpleados.aplicacion.manejadores.ManejadorObtenerEmpleado;
import col.san.GestionEmpleados.aplicacion.manejadores.ManejadorRegistrarEmpleado;
import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.dominio.excepciones.ResourceNotFoundException;
import col.san.GestionEmpleados.infraestructura.persistencia.repositorio.RepositorioEmpleadoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {

    @Autowired
    RepositorioEmpleadoJPA repositorioEmpleadoJPA;

    private final ManejadorObtenerEmpleado manejadorObtenerEmpleado;
    private final ManejadorRegistrarEmpleado manejadorRegistrarEmpleado;

    public EmpleadoControlador(ManejadorObtenerEmpleado manejadorObtenerEmpleado, ManejadorRegistrarEmpleado manejadorRegistrarEmpleado) {
        this.manejadorObtenerEmpleado = manejadorObtenerEmpleado;
        this.manejadorRegistrarEmpleado = manejadorRegistrarEmpleado;
    }

    @GetMapping("/empleados")
    public ResponseEntity<?> buscarEmpleado(){
        Object respuestaPrestamo = this.manejadorObtenerEmpleado.ejecutar();
        return new ResponseEntity<>(respuestaPrestamo, HttpStatus.OK);
    }

    @PostMapping("/empleados")
    public void guardarEmpleado(@RequestBody Empleado empleado){
        this.manejadorRegistrarEmpleado.ejecutar(empleado);
           //return repositorioEmpleadoJPA.save(empleado);

    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadopordId(@PathVariable Long id){
        Empleado empleado = repositorioEmpleadoJPA.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe empleado con el el Id: " + id));
        return  ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detalleEmpleado){
        Empleado empleado = repositorioEmpleadoJPA.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe empleado con el el Id: " + id));
        empleado.setNombre(detalleEmpleado.getNombre());
        empleado.setApellido(detalleEmpleado.getApellido());
        empleado.setEmail(detalleEmpleado.getEmail());

        Empleado empleadoActualizado = repositorioEmpleadoJPA.save(empleado);

        return  ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Empleado empleado = repositorioEmpleadoJPA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repositorioEmpleadoJPA.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
