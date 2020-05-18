package pe.edu.pucp.lp2soft.main;

import java.util.ArrayList;
import pe.edu.pucp.lp2soft.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.model.Empleado;
import pe.edu.pucp.lp2soft.mssql.EmpleadoMSSQL;
import pe.edu.pucp.lp2soft.mysql.EmpleadoMySQL;

public class Principal {
    public static void main(String[] args){
        ArrayList<Empleado> empleados = 
                new ArrayList<>();
        
        EmpleadoDAO daoEmpleado = 
                new EmpleadoMySQL();
        
        
        
        empleados = daoEmpleado.listar();
        
        for(Empleado e : empleados){
            System.out.println(e.mostrarDatos());
         
        }
        
        
//        Empleado emp1 = new Empleado("Carlitos","44323983",
//                "Jefe de Proyecto",800.00f);
//        int id_empleado = daoEmpleado.insertar(emp1);
//        if (id_empleado==0) System.out.println("Ha ocurrido un error");
//        else{
//            System.out.println("Se ha registrado de manera exitosa");
//            System.out.println("El id generado para el nuevo empleado es: " +
//                    id_empleado);
//        }
        
    }
}
