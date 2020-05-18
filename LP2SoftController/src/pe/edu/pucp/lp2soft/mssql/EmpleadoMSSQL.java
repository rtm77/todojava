package pe.edu.pucp.lp2soft.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.model.Empleado;

public class EmpleadoMSSQL implements EmpleadoDAO{

    @Override
    public int insertar(Empleado empleado) {
        int resultado = 0;
        try{
        //Registrar el Driver Conexion
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Establecer la conexión
        Connection con = 
        DriverManager.getConnection(DBManager.urlMSSQL, 
                DBManager.user, DBManager.password);
        String sql = "INSERT INTO EMPLEADO(NOMBRE_COMPLETO,"
                + "CARGO,SUELDO,ACTIVO) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, empleado.getNombreCompleto());
        ps.setString(2, empleado.getCargo());
        ps.setFloat(3, empleado.getSueldo());
        ps.setBoolean(4, true);
        
        //Ejecutar la sentencia SQL
        resultado = ps.executeUpdate();
        //Cerrar la conexión
        con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public int actualizar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empleado> listar() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try{
            //Registrar el Driver Conexion
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Establecer la conexión
            Connection con = 
            DriverManager.getConnection(DBManager.urlMSSQL, 
                DBManager.user, DBManager.password);
            String sql = "SELECT * FROM EMPLEADO WHERE ACTIVO = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setIdPersona(rs.getInt("ID_EMPLEADO"));
                emp.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
                emp.setCargo(rs.getString("CARGO"));
                emp.setSueldo(rs.getFloat("SUELDO"));
                emp.setActivo(rs.getBoolean("ACTIVO"));
                empleados.add(emp);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return empleados;
    }
    
}
