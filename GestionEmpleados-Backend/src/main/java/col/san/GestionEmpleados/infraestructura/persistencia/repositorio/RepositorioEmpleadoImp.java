package col.san.GestionEmpleados.infraestructura.persistencia.repositorio;

import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.infraestructura.persistencia.repositorio.RepositorioEmpleadoJPA;
import col.san.GestionEmpleados.dominio.repositorio.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

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
}
