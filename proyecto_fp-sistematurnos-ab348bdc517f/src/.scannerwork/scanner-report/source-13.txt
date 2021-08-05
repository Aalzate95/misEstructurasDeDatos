/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.modelo.tdas;

/**
 *
 * @author Charles
 */
public class Sintoma {
    private String tipo;
    private int prioridad;

    public Sintoma(String tipo, int prioridad) {
        this.tipo = tipo;
        this.prioridad = prioridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
    
    
    
}
