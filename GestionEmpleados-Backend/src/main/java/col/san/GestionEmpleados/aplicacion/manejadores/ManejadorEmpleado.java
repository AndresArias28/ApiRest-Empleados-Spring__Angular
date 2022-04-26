package col.san.GestionEmpleados.aplicacion.manejadores;

import col.san.GestionEmpleados.dominio.Empleado;
import col.san.GestionEmpleados.dominio.servicio.ServicioCrudEmpleados;
import col.san.GestionEmpleados.dominio.servicio.ServicioRepoEmpleados;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ManejadorEmpleado {
    private final ServicioRepoEmpleados servicioRepoEmpleados;
    //private final ServicioCrudEmpleados servicioCrudEmpleados;

    public ManejadorEmpleado(ServicioRepoEmpleados servicioRepoEmpleados) {
        this.servicioRepoEmpleados = servicioRepoEmpleados;
       // this.servicioCrudEmpleados = servicioCrudEmpleados;
    }

    public Object obtenerEmpleado() {
        return this.servicioRepoEmpleados.obtenerEmpleado();
    }

    public void guardarEmpleado(Empleado empleado) {
         this.servicioRepoEmpleados.guardarEmpleado(empleado);
    }

    public Object buscarPorId(Long id) {
        return this.servicioRepoEmpleados.buscarporID(id);
    }

    public Object actualizarEmpleado(Long id, Empleado detalleEmpleado) {
        return this.servicioRepoEmpleados.actualizarEmpleado(id, detalleEmpleado);
    }

    public Map<String, Boolean> eliminarEmpleado(Long id) {
        return this.servicioRepoEmpleados.eliminarEmpleado(id);
    }

}
