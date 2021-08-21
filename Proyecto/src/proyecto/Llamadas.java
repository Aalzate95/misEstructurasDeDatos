/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author Juan Camilo
 */
public class Llamadas {
    //fecha, hora, ip fuente, ip destino, DNIS, ANI, estado, duración
    private String fecha;
    private String hora;
    private String ipFuente;
    private String ipDestino;
    private String dnis;
    private String ani;
    private String estado;
    private String duracion;
    public Llamadas(){
        
    }
    public Llamadas(String fecha, String hora, String ipFuente, String ipDestino, String dnis, String ani, String estado, String duracion) {
        this.fecha = fecha;
        this.hora = hora;
        this.ipFuente = ipFuente;
        this.ipDestino = ipDestino;
        this.dnis = dnis;
        this.ani = ani;
        this.estado = estado;
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIpFuente() {
        return ipFuente;
    }

    public void setIpFuente(String ipFuente) {
        this.ipFuente = ipFuente;
    }

    public String getIpDestino() {
        return ipDestino;
    }

    public void setIpDestino(String ipDestino) {
        this.ipDestino = ipDestino;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public void infoLlamadas(ArrayList<Llamadas> datosLlamadas){
        for (Llamadas i : datosLlamadas){
            float costo;
            if (i.getEstado().equals("E")){
                costo = 0;
                String cliente = i.getIpFuente();
                String proveedor = i.getIpDestino();
                
            }
        }
    }
    
}
