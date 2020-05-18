package pe.edu.pucp.lp2soft.dao;

import java.util.ArrayList;
import pe.edu.pucp.lp2soft.model.Empleado;

public interface EmpleadoDAO {
    int insertar(Empleado empleado);
    int actualizar(Empleado empleado);
    int eliminar(int idEmpleado);
    ArrayList<Empleado> listar();
}