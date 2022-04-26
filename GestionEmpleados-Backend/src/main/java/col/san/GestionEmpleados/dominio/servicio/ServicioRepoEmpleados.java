package col.san.GestionEmpleados.dominio.servicio;

import col.san.GestionEmpleados.dominio.Empleado;

import java.util.Map;

public interface ServicioRepoEmpleados {
    Object obtenerEmpleado();

    void guardarEmpleado(Empleado empleado);

    Object buscarporID(Long id);

    Object actualizarEmpleado(Long id, Empleado detalleEmpleado);

    Map<String, Boolean> eliminarEmpleado(Long id);
}
