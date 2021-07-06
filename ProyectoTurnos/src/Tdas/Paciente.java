/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tdas;

import Main.CargarSistema;

/**
 *
 * @author alexa
 */
public class Paciente {
    private String cedula,nombre,apellido,genero,turno;
    private Sintoma sintoma;
    private String sintNombre;
    private int edad;
    private static int countPaciente;

    public Paciente(String cedula, String nombre, String apellido, String genero, int edad,Sintoma sintoma) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.sintoma = sintoma;
        //this.turno = asignarTurno(sintoma);
        //CargarSistema.addPaciente(this);
        
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public static String asignarTurno(Sintoma sintoma) {
        return sintoma.getNombre().charAt(0) + String.valueOf(++countPaciente);
    }
    
}
