package col.san.GestionEmpleados.infraestructura.persistencia.repositorio;

import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.dominio.excepciones.ResourceNotFoundException;
import col.san.GestionEmpleados.dominio.repositorio.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositorioEmpleadoImp implements RepositorioEmpleado {

    @Autowired
    RepositorioEmpleadoJPA repositorioEmpleadoJPA;

    @Override
    public List<Empleado> ObtenerEmpleados() {
        return (List<Empleado>) repositorioEmpleadoJPA.findAll();
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        repositorioEmpleadoJPA.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadopordId(Long id) {
        return  repositorioEmpleadoJPA.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe empleado con el el Id: " + id));
    }

    @Override
    public Object actualizarEmpleado(Long id, Empleado detalleEmpleado) {
        Empleado empleado = repositorioEmpleadoJPA.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe empleado con el el Id: " + id));
        empleado.setNombre(detalleEmpleado.getNombre());
        empleado.setApellido(detalleEmpleado.getApellido());
        empleado.setEmail(detalleEmpleado.getEmail());

        Empleado empleadoActualizado = repositorioEmpleadoJPA.save(empleado);
        return empleadoActualizado;
    }

    @Override
    public  Map<String, Boolean>  eliminarEmpleado(Long id) {

        Empleado empleado = repositorioEmpleadoJPA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        repositorioEmpleadoJPA.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return respuesta;
        //repositorioEmpleadoJPA.deleteAllById(Collections.singleton(id));
    }
}
