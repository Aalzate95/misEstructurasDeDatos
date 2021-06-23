/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;


/**
 *
 * @author Alexander Alzate
 */
public class Player implements Comparable<Player> {
    private int puntaje, tiempo;
    private String nombre;

    public Player( String nombre,int puntaje, int tiempo) {
        this.puntaje = puntaje;
        this.tiempo = tiempo;
        this.nombre = nombre;
    }
    
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Player t) {
        return this.nombre.compareTo(t.getNombre());
    }
    
}
