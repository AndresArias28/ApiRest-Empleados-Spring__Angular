package col.san.GestionEmpleados.dominio.repositorio;


import col.san.GestionEmpleados.dominio.Empleado;

import java.util.List;

public interface RepositorioEmpleado {
    List<Empleado> ObtenerEmpleados();


    void agregarEmpleado(Empleado empleado);
}
