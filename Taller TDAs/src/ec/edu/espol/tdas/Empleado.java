/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tdas;

/**
 *
 * @author alexa
 */
public class Empleado {
    private  String cedula,nombres,apellidos;
    private  float salario;
    private int porcentaje;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
//metodos    
    public static String nombreCompleto(Empleado empleado){
        return empleado.getNombres()+" "+empleado.getApellidos();
    }
    public static float salarioAnual(Empleado empleado){
        return empleado.getSalario()*12;
    }
    public static float incremento(int porcentaje,Empleado empleado){
        float nuevoSalario = (porcentaje/100*empleado.getSalario())+empleado.getSalario();
        return nuevoSalario;
    }

    public static void toString(Empleado empleado) {
        System.out.println(
                "Empleado: "+empleado.getNombres()+" "+ empleado.getApellidos()+
                        "\nCedula: "+empleado.getCedula()+
                        "\nSalario: "+empleado.getSalario());
    }
    public static boolean equals(Empleado empleado1,Empleado empleado2){
        String ciEmpleado1 = empleado1.getCedula();
        String ciEmpleado2 = empleado2.getCedula();
        if(ciEmpleado1.equals(ciEmpleado2)){
            return true;
        }
        else{
            return false;
        }
    }
}
