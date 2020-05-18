package pe.edu.pucp.lp2soft.model;

import java.util.ArrayList;

public class Empleado extends Persona {
    private ArrayList<Pedido> pedidos;
    private String cargo;
    private float sueldo;
    private boolean activo;

    public Empleado(){
        
    }

     public Empleado(String nombreCompleto, String DNI, String cargo, float sueldo) {
        super(nombreCompleto, DNI);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }
    
    
    
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    public String mostrarDatos(){
        return super.getIdPersona() + " - " 
                + super.getDNI() + " - "
                + super.getNombreCompleto() + " - "
                + cargo + " - " + sueldo;
    }
    
}
