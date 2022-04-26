package col.san.GestionEmpleados.dominio.repositorio;


import col.san.GestionEmpleados.dominio.Empleado;

import java.util.List;
import java.util.Map;

public interface RepositorioEmpleado {

    List<Empleado> ObtenerEmpleados();

    void agregarEmpleado(Empleado empleado);

    Empleado obtenerEmpleadopordId(Long id);

    Object actualizarEmpleado(Long id, Empleado detalleEmpleado);

    Map<String, Boolean> eliminarEmpleado(Long id);
}
