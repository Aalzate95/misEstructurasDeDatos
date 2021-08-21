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
public class Proveedores {
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;

    public Proveedores(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public Proveedores(){
        
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void escribirArchivoProveedores(ArrayList <Proveedores> datosProveedores) throws IOException{
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese codigo: ");
        String cod = entrada.next();
        FileWriter flwriter = null;
        try{
            flwriter = new FileWriter("proveedores.csv");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for(Proveedores p: datosProveedores){
                if ( p.getCodigo().equals(cod)){
                    System.out.println("Nombre: "+p.getNombre()+"Direccion: "+p.getDireccion()+"Telefono: "+p.getTelefono());
                    int bandera = 0;
                    while(bandera==0){        
                    System.out.println(
                            "*************************************** \n"+
                            " 1. Nombre \n"+
                            " 2. Direccion \n"+
                            " 3. Telefono \n"+
                            
                            " Ingrese que informacion desea editar:");
                    int opc = entrada.nextInt();
                    if(opc >= 1 && opc<=3){
                        switch(opc){
                            case 1: opc = 1;
                                System.out.println("Ingrese nuevo Nombre: ");
                                String nuevo1 = entrada.next();
                                p.setNombre(nuevo1);
                                break;
                            case 2: opc = 2;
                                System.out.println("Ingrese nueva Direccion: ");
                                String nuevo2 = entrada.next();
                                p.setDireccion(nuevo2);
                                break;
                            case 3: opc = 3;
                                System.out.println("Ingrese nuevo Telefono: ");
                                String nuevo3 = entrada.next();
                                p.setTelefono(nuevo3);
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
            for (Proveedores p: datosProveedores){
                bfwriter.write(p.getCodigo()+","+p.getNombre()+ "," + p.getDireccion() + ","  +p.getTelefono() + "\n" );    
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
