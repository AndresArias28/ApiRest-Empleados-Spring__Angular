package col.san.GestionEmpleados.dominio.servicio;

import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.dominio.repositorio.RepositorioEmpleado;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ServicioCrudEmpleados implements ServicioRepoEmpleados{

    private final RepositorioEmpleado repositorioEmpleado;

    public ServicioCrudEmpleados(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public Object obtenerEmpleado() {
        List<Empleado> empleadosLista = repositorioEmpleado.ObtenerEmpleados();

        return empleadosLista;
    }

    public void guardarEmpleado(Empleado empleado){
        repositorioEmpleado.agregarEmpleado(empleado);
    }

    public Empleado buscarporID(Long ig){
       return  repositorioEmpleado.obtenerEmpleadopordId(ig);
    }

    public Object actualizarEmpleado(Long id, Empleado detalleEmpleado) {
        return repositorioEmpleado.actualizarEmpleado(id, detalleEmpleado);
    }

    public Map<String, Boolean> eliminarEmpleado(Long id) {
        return repositorioEmpleado.eliminarEmpleado(id);
    }
}
