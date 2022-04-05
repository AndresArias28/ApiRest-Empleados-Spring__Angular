package col.san.GestionEmpleados.infraestructura.persistencia.repositorio;

import col.san.GestionEmpleados.dominio.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleadoJPA extends CrudRepository<Empleado, Long> {
}
