/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tdas;

/**
 *
 * @author alexa
 */
public class Medico {
    private String cedula, Nombre, Apellido;

    public Medico(String cedula, String Nombre, String Apellido) {
        this.cedula = cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
}
