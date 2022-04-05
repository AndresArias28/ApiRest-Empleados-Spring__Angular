package col.san.GestionEmpleados.dominio.servicio;

import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.dominio.repositorio.RepositorioEmpleado;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioBuscarEmpleados {

    private final RepositorioEmpleado repositorioEmpleado;

    public ServicioBuscarEmpleados(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public Object ejecutar() {
        List<Empleado> empleadosLista;
        empleadosLista = repositorioEmpleado.ObtenerEmpleados();
        return empleadosLista;
    }

    public void guardar(Empleado empleado){
        repositorioEmpleado.agregarEmpleado(empleado);
    }
}
