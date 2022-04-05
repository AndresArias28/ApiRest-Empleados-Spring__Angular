package col.san.GestionEmpleados.aplicacion.manejadores;

import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.dominio.servicio.ServicioBuscarEmpleados;
//import col.san.GestionEmpleados.dominio.servicio.ServicioRegistrarEmpleados;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarEmpleado {
    private final ServicioBuscarEmpleados servicioBuscrarEmpleados;

    public ManejadorRegistrarEmpleado(ServicioBuscarEmpleados servicioBuscrarEmpleados) {
        this.servicioBuscrarEmpleados = servicioBuscrarEmpleados;
    }

    public void ejecutar(Empleado empleado) {
        this.servicioBuscrarEmpleados.guardar(empleado);
    }
}
