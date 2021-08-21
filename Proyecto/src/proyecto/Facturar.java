/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Facturar {
    private String fecha,hora,ipfuente,ipdestino,DNIS,ANI;
    private String estado;
    private int duracion;
    private String codigo_cliente, codigo_proveedor, codigo_pais, costo_cliente, costo_proveedor;
    private double minutos;
    private double tarifa;

    
    
    public Facturar(){
        
    }
     
    public Facturar(String fecha, String hora, String ipfuente, String ipdestino, String DNIS, String ANI, String estado, int duracion) {
        this.fecha = fecha;
        this.hora = hora;
        this.ipfuente = ipfuente;
        this.ipdestino = ipdestino;
        this.DNIS = DNIS;
        this.ANI = ANI;
        this.estado = estado;
        this.duracion = duracion;
        minutos=duracion/60;
    }

    public String getEstado() {
        return estado;
    }
    

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getIpfuente() {
        return ipfuente;
    }

    public String getIpdestino() {
        return ipdestino;
    }

    public String getDNIS() {
        return DNIS;
    }

    public String getANI() {
        return ANI;
    }

    public String isEstado() {
        return estado;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setIpfuente(String ipfuente) {
        this.ipfuente = ipfuente;
    }

    public void setIpdestino(String ipdestino) {
        this.ipdestino = ipdestino;
    }

    public void setDNIS(String DNIS) {
        this.DNIS = DNIS;
    }

    public void setANI(String ANI) {
        this.ANI = ANI;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public float estableceCostoCliente(){
        float costo_cliente = 0;
        if (duracion==0){
        }
        else {
            costo_cliente=(float) (duracion*tarifa);
            
        }
                    
        
        return costo_cliente;
    }
    public float estableceCostoProveedor(){
        float costo_proveedor = 0;
        if (duracion==0){
        }
        else {
            costo_proveedor=(float) (duracion*tarifa);
            
        }
                    
        
        return costo_proveedor;
    }
     
    public ArrayList<Facturar> leerArchivo(){
         ArrayList<Facturar> listaLlamadas = new ArrayList<Facturar>();

        


        String csvFile = "llamadas.csv";
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                //crea un objeto Profesor con esos datos
                Facturar individuo = new Facturar(datos[0],datos[1],datos[2],datos[3],datos[4]
                        ,datos[5],datos[6],Integer.parseInt(datos[7]));
                //agrego el objeto a la lista
                listaLlamadas.add(individuo);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

         return listaLlamadas;
    }
    
}
