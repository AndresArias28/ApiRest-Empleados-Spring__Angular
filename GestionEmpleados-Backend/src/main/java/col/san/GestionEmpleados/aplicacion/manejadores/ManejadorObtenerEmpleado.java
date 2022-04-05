package col.san.GestionEmpleados.aplicacion.manejadores;

import col.san.GestionEmpleados.dominio.servicio.ServicioBuscarEmpleados;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerEmpleado {
    private final ServicioBuscarEmpleados servicioBuscarEmpleados;

    public ManejadorObtenerEmpleado(ServicioBuscarEmpleados servicioBuscarEmpleados) {
        this.servicioBuscarEmpleados = servicioBuscarEmpleados;
    }

    public Object ejecutar() {
        return this.servicioBuscarEmpleados.ejecutar();
    }
}
