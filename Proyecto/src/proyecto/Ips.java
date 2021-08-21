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
public class Ips {
    private String ip;
    private String tipo;
    private String codigo; //codigo cliente o proveedor (con este se identifica la ip)
    
    public Ips(){
        
    }
    public Ips(String ip, String tipo, String codigo) {
        this.ip = ip;
        this.tipo = tipo;
        this.codigo = codigo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   //METODO VALIDACION DE IPS
    public boolean validarCodigo(String cod){
        inicializarSistema datos = new inicializarSistema();
        ArrayList<Clientes> datosClientes = datos.leerArchivoClientes();
        int bandera = 0;
        boolean validar = false;
        while(bandera == 0){
            for (Clientes i:datosClientes){
                if (cod.equals(i.getCodigo())){
                    bandera = 1;
                    validar =true;
                    break;
                }
            }
        }
        return validar;
    }
    public boolean validarTipo(String tipo){
        Scanner entrada = new Scanner(System.in);
        boolean validar=false;
        int bandera=0;
        while(bandera==0){
           if (tipo.equals("P") || tipo.equals("C")){
                validar= true;
                break;
            }
            else{System.out.println("Error, vuelva a intentarlo");}
        }
        return validar;
    }
    public boolean validarIps(ArrayList<Ips> datosIps,String ip){         
        Scanner entrada = new Scanner(System.in);
        int bandera= 0;
        boolean validacion=true;
        while(bandera==0){
            String [] sNumeros=ip.split("\\.");
            int [] Numeros= new int[4];
            for(Ips i: datosIps){
                if(ip.equals(i.getIp())){
                    System.out.println("Error esta ip: " + ip + "  Ya existe...\n Vuelva a intentarlo.");
                    validacion = false;
                }                
            }
            if (sNumeros.length <4 || sNumeros.length >4){
                System.out.println("Error esto: " + ip + "  NO es una direccion IP...\n Vuelva a intentarlo.");
                validacion = false;
            }
            if (validacion ==true){
                break;
            }
        }
        return validacion;
    }
    //METODO MENU DE IPS
    public void menuIps(ArrayList<Ips> datosIps) throws IOException{
        int banderaIps = 0;
        while(banderaIps == 0){
            inicializarSistema datos = new inicializarSistema();
            datosIps = datos.leerArchivoIps();                            
            System.out.println(
                    "**************************************\n"+       
                    "          INFORMACION DE IPS          \n"+
                    "--------------------------------------\n");
            for(Ips a : datosIps){
                    System.out.println(
                    "IP: "+a.getIp()+" Tipo: "+a.getTipo()+" Codigo: "+a.getCodigo()+"\n"+
                    "------------------------------------------------------------------");
                    }
            Scanner entrada = new Scanner(System.in);
            System.out.println( "Menu\n"+ "1. Agregar IP\n"+"2. Editar IP\n"+"3. Volver al menu principal");
            String opcion = entrada.next();
            if (opcion.equals("1")||opcion.equals("2")||opcion.equals("3")){
                int opc = Integer.parseInt(opcion);
                switch(opc){
       //INGRESAR NUEVA IP
                    case 1: opc = 1;
                    //Se usan metodos en la misma clase para su validacion
                        int bandera=0;
                        String ip="000.000.000.000",tipo=" ",codigo= " ";
                        while(bandera==0){
                            System.out.println("Ingrese Ip (Recuerde que este valor es unico): ");
                            ip = entrada.next();
                            boolean valIp = validarIps(datosIps,ip);
                            if (valIp ==true){
                                 System.out.println("Ingrese tipo de asignacion (C -> Cliente, P -> Proveedor)");
                                 tipo = entrada.next().toUpperCase();
                                 boolean valtipo = validarTipo(tipo);
                                 if (valtipo==true){
                                     System.out.println("Ingrese Codigo: ");
                                     codigo = entrada.next();
                                     boolean valcod=validarCodigo(codigo);
                                     if(valcod==true){
                                         
                                         bandera = 1;
                                         break;
                                     }
                                     
                                 }
                            }
                        }
                        FileWriter flwriter = null;
                        try{
                            flwriter = new FileWriter("ips.csv",true);
                            BufferedWriter bfwriter = new BufferedWriter(flwriter);
                            bfwriter.write(ip+","+tipo+","+codigo+"\n");
                             
                            bfwriter.close();
                            System.out.println("Archivo modificado satisfactoriamente..");
                            
                            }
                        catch (IOException e) {
                            e.printStackTrace();
                            } 
                        finally {
                            if (flwriter != null) {
                                try {
                                        flwriter.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                            } 
                        }
                        break;
                        
                       
                    case 2: opc = 2;
                        escribirArchivoIps(datosIps);
                        break;
                    case 3: opc = 3;
                        banderaIps = 1;
                        break;
                    
                }
            }
            else{System.out.println("Error, Vuelva a intentarlo");}
        }   
    }
    //MODIFICAR IPS
    public void escribirArchivoIps(ArrayList<Ips> datosIps) throws IOException{
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese Ip: ");
        String ip = entrada.next();
        FileWriter flwriter = null;
        try{
            flwriter = new FileWriter("ips.csv");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for(Ips p: datosIps){
                if ( p.getIp().equals(ip)){
                    System.out.println("IP: "+p.getIp()+"Tipo: "+p.getTipo()+"Codigo: "+p.getCodigo());
                    int bandera = 0;
                    while(bandera==0){        
                    System.out.println(
                            "*************************************** \n"+
                            " 1. Tipo \n"+
                            " 2. Codigo \n"+
                            " Ingrese que informacion desea editar:");
                    String opcion = entrada.next();
                    if(opcion.equals("1")||opcion.equals("2")){
                        int opc = Integer.parseInt(opcion);
                        switch(opc){
                            case 1: opc = 1;
                                System.out.println("Ingrese nuevo tipo de asignacion (C -> Cliente, P -> Proveedor): ");
                                String nuevo1 = entrada.next();
                                p.setTipo(nuevo1);
                                break;
                            case 2: opc = 2;
                                System.out.println("Ingrese nuevo Codigo: ");
                                String nuevo2 = entrada.next();
                                p.setCodigo(nuevo2);
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
            for (Ips p: datosIps){
                bfwriter.write(p.getIp()+","+p.getTipo()+ "," + p.getCodigo()+"\n" );    
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

