package pe.edu.pucp.lp2soft.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.model.Empleado;

public class EmpleadoMySQL implements EmpleadoDAO{

    Connection con;
    
    @Override
    public int insertar(Empleado empleado) {
        int rpta = 0;
         try{
            //Registrar el JAR de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexion
            con = DriverManager.getConnection(DBManager.urlMySQL, 
                    DBManager.user, DBManager.password);
            
            CallableStatement cs = con.prepareCall(
                    "{call INSERTAR_EMPLEADO2(?,?,?,?,?)}");
            
            //datos que necesita el procedimiento almacenado 
            //para poder ejecutarse
            
    cs.registerOutParameter("_ID_EMPLEADO", java.sql.Types.INTEGER);
    cs.setString(3, empleado.getDNI());
    cs.setString(4, empleado.getCargo());
    cs.setString(2, empleado.getNombreCompleto());
    cs.setFloat(5, empleado.getSueldo());
    cs.executeUpdate();
    
    rpta = cs.getInt("_ID_EMPLEADO");
            con.close();
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
         return rpta;
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
            //Registrar el JAR de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer una conexión a la BD
            Connection con = DriverManager.
          getConnection("jdbc:mysql://"+
         "inf28220201.cx9ws7aw0g5e.us-east-1.rds.amazonaws.com"+
                  ":3306/lp2", "admin", "abcd1234");
            //Ejecutar una sentencia
            String sentencia = "SELECT * FROM EMPLEADO INNER JOIN "
                    + "PERSONA ON PERSONA.ID_PERSONA = EMPLEADO.ID_EMPLEADO";
            Statement st = con.createStatement();
            //executeQuery -> SELECT
            //executeUpdate -> INSERT, UPDATE, DELETE
            ResultSet rs = st.executeQuery(sentencia);
            //Recorrer todas las filas que devuelve la ejecucion sentencia
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setIdPersona(rs.getInt("ID_EMPLEADO"));
                empleado.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
                empleado.setDNI(rs.getString("DNI"));
                empleado.setCargo(rs.getString("CARGO"));
                empleado.setSueldo(rs.getFloat("SUELDO"));
                empleado.setActivo(rs.getBoolean("ACTIVO"));
                empleados.add(empleado);
            }
            //cerrar conexion
            con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Devolviendo los empleados
        return empleados;
    }

}
