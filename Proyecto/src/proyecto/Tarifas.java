package proyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
public class Tarifas {
    private String codigoTarifa;
    private String codigoProveedor;
    private String codigoPais;
    private String nombreRegion;
    private String prefijoRegion;
    private float tarifa;
    public Tarifas(){
        
    }

    public Tarifas(String codigoProveedor, String codigoPais, String nombreRegion, float tarifa,String codigoTarifa) {
        this.codigoProveedor = codigoProveedor;
        this.codigoPais = codigoPais;
        this.nombreRegion = nombreRegion;
        this.prefijoRegion = prefijoRegion;
        this.tarifa = tarifa;
        this.codigoTarifa = codigoTarifa;
    }
    public String getCodigoTarifa() {
        return codigoTarifa;
    }

    public void setCodigoTarifa(String codigoTarifa) {
        this.codigoTarifa = codigoTarifa;
    }
    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getPrefijoRegion() {
        return prefijoRegion;
    }

    public void setPrefijoRegion(String prefijoRegion) {
        this.prefijoRegion = prefijoRegion;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    public boolean esDecimal(String cad){
    try{
      Double.parseDouble(cad);
      return true;
    }catch(NumberFormatException nfe){
      return false;
    }
    }
    public void infoTarifas(ArrayList<Tarifas> datosTarifas){
        System.out.println(
                "*******************************************************"+"\n"+
                "*                INFORMACION DE TARIFAS               *"+"\n"+
                "*-----------------------------------------------------*");
        for (Tarifas a : datosTarifas){
            System.out.println(
                "cod Tarifa: " +a.getCodigoTarifa()+" Cod Pais: "+a.getCodigoPais()+" Nombre Region: "+a.getNombreRegion()+"\n"+
                "Prefijo Region: "+a.getPrefijoRegion()+"  Tarifa: "+a.getTarifa()+" Cod Proveedor: "+a.getCodigoProveedor()+"\n"+
                "*-----------------------------------------------------*");                                        
        }
    }
   public void menuTarifas(ArrayList<Tarifas> datosTarifas){
       Scanner entrada = new Scanner(System.in);
        infoTarifas(datosTarifas);
        int banderaInfoPais= 0;
        while (banderaInfoPais == 0){
            System.out.println("Desea editar informacion de tarifas s/n ?");
            String continuar = entrada.next().toUpperCase();
            if (continuar.equals("S")){
                System.out.println("Ingrese codigo: ");
                String cod = entrada.next();
                FileWriter flwriter = null;
                boolean validar=false;
                try{
                    flwriter = new FileWriter("Tarifas.csv");
                    BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    for(Tarifas p: datosTarifas){
                        if ( p.getCodigoTarifa().equals(cod)){
                            System.out.println("cod Tarifa: " +p.getCodigoTarifa()  +" Cod pais: "+p.getCodigoPais()+"Nombre Region: "+p.getNombreRegion()+"\n"+
                                    " Prefijo Region: "+p.getPrefijoRegion()+" Tarifa: "+p.getTarifa()+" Cod Proveedor : "+p.getCodigoProveedor());
                            int bandera = 0;
                            while(bandera==0){    
                                System.out.println("Ingrese nueva tarifa: ");
                                String nuevo1 = entrada.next();
                                if (esDecimal(nuevo1)==true){
                                    float x = Float.parseFloat(nuevo1);
                                    p.setTarifa(x);
                                    bandera=1;
                                    banderaInfoPais = 0;
                                    validar = true;
                                    break;
                                }
                                else{System.out.println("Error, el valor ingresado no es correcto");}
                              }
                        }
                    }
                    if (validar == true){
                        for (Tarifas p: datosTarifas){
                            bfwriter.write(p.getCodigoProveedor()+","+p.getCodigoPais()+ "," + p.getNombreRegion() + ","  +p.getPrefijoRegion() + "," + p.getTarifa()+ "," +p.getCodigoTarifa()+"\n" );    
                        }
                        bfwriter.close();
                        System.out.println("Informacion editada satisfactoriamente..\n");
                    }
                    else{System.out.println("Error, codigo no existe.");}

                    }
                    catch (IOException e) {
                                    e.printStackTrace();
                            } finally {
                                    if (flwriter != null) {
                                            try {//cierra el flujo principal
                                                    flwriter.close();
                                            } catch (IOException e) {
                                                    e.printStackTrace();
                                            }
                                    }
                    }    
                }
                else if (continuar.equals("N")){
                    banderaInfoPais = 1;
                    break;
                }
                else{
                    System.out.println("Opcion no valida, vuelva a intentarlo");
                }
        
        }
   }
}
