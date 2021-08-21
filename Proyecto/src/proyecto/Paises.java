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
public class Paises {
    private String codigo;
    private String nombre;
    private String prefijo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    public Paises(){
        
    }
    public Paises(String codigo, String nombre, String prefijo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.prefijo = prefijo;
    }
    public void escribirArchivoPaises(ArrayList<Paises> datosPaises){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese codigo: ");
        String cod = entrada.next();
        FileWriter flwriter = null;
        try{
            flwriter = new FileWriter("paises.csv");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for(Paises p: datosPaises){
                if ( p.getCodigo().equals(cod)){
                    System.out.println("Nombre: "+p.getNombre()+"Prefijo: "+p.getPrefijo());
                    int bandera = 0;
                    while(bandera==0){        
                    System.out.println(
                            "*************************************** \n"+
                            " 1. Nombre \n"+
                            " 2. Prefijo \n"+
                            " Ingrese que informacion desea editar:");
                    int opc = entrada.nextInt();
                    if(opc >= 1 && opc<=2){
                        switch(opc){
                            case 1: opc = 1;
                                System.out.println("Ingrese nuevo Nombre: ");
                                String nuevo1 = entrada.next();
                                p.setNombre(nuevo1);
                                break;
                            case 2: opc = 2;
                                System.out.println("Ingrese nuevo Prefijo: ");
                                String nuevo2 = entrada.next();
                                p.setPrefijo(nuevo2);
                                break;
                        }                
                    }
                    else{System.out.println("opcion no existe, vuelva a intentarlo");}
                    System.out.println("Desea editar alguna otra opcion S/N ?");
                    String continuar = entrada.next().toUpperCase();
                                        if (continuar.equals("S")){
                                            bandera = 0;
                                        }
                                        else if (continuar.equals("N")){
                                            bandera = 1;
                                        }
                                        else{
                                            System.out.println("Opcion no valida, vuelva a intentarlo");
                                        }
                }
                }
            }        
            for (Paises p: datosPaises){
                bfwriter.write(p.getCodigo()+","+p.getNombre()+ "," + p.getPrefijo() +"\n" );    
            }
            bfwriter.close();
            System.out.println("Informacion editada satisfactoriamente..\n");
                
            
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
    
}
