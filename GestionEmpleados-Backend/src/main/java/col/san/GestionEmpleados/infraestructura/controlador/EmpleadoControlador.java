package col.san.GestionEmpleados.infraestructura.controlador;

import col.san.GestionEmpleados.aplicacion.manejadores.ManejadorEmpleado;
import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.dominio.excepciones.ResourceNotFoundException;
import col.san.GestionEmpleados.infraestructura.persistencia.repositorio.RepositorioEmpleadoJPA;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {


    private final ManejadorEmpleado manejadorEmpleado;

    public EmpleadoControlador(ManejadorEmpleado manejadorEmpleado) {
        this.manejadorEmpleado = manejadorEmpleado;
    }
/*
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var empleado = manejadorEmpleado.obtenerEmpleado();
       //log.info("ejecutando el controlador Spring MVC");
        //log.info("usuario que hizo login:" + user);
        model.addAttribute("empleado", empleado);
        return "index";
    }*/

    @GetMapping("/empleados")
    public ResponseEntity<?> obtenerEmpleado(){
        Object respuestaPrestamo = this.manejadorEmpleado.obtenerEmpleado();
        return new ResponseEntity<>(respuestaPrestamo, HttpStatus.OK);
        //return "Hello !";
    }

    @PostMapping("/empleados")
    public void guardarEmpleado(@RequestBody Empleado empleado){
        this.manejadorEmpleado.guardarEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<?> obtenerEmpleadopordId(@PathVariable Long id){
        Object empleado = this.manejadorEmpleado.buscarPorId(id);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detalleEmpleado){
        Object empleadoActualizado = this.manejadorEmpleado.actualizarEmpleado(id,detalleEmpleado);

        return  new ResponseEntity<Empleado>((Empleado) empleadoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Map<String, Boolean> respuesta = this.manejadorEmpleado.eliminarEmpleado(id);
        return ResponseEntity.ok(respuesta);
    }
}
