package proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;


public class Clientes {
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String tipoCliente;
    
    public Clientes(){
        
    }
    public Clientes(String codigo, String nombre, String direccion, String telefono, String tipoCliente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    // TENEMOS PROBLEMAS CUANDO QUEREMOS CAMBIAR EL DATO DE ALGO Y USAR ESPACIO EN EL STRING DA ERROR DE SECUENCIA
    public void escribirArchivoClientes(ArrayList <Clientes> datosClientes) throws IOException{
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese codigo: ");
        String cod = entrada.next();
        FileWriter flwriter = null;
        try{
            flwriter = new FileWriter("clientes.csv");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for(Clientes p: datosClientes){
                if ( p.getCodigo().equals(cod)){
                    System.out.println("Nombre: "+p.getNombre()+"Direccion: "+p.getDireccion()+"Telefono: "+p.getTelefono()+"Tipo: "+p.getTipoCliente());
                    int bandera = 0;
                    while(bandera==0){        
                    System.out.println(
                            "*************************************** \n"+
                            " 1. Nombre \n"+
                            " 2. Direccion \n"+
                            " 3. Telefono \n"+
                            " 4. Tipo \n"+
                            " Ingrese que informacion desea editar:");
                    int opc = entrada.nextInt();
                    if(opc >= 1 && opc<=4){
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
                            case 4: opc = 4;
                                System.out.println("Ingrese nuevo Tipo: ");
                                String nuevo4 = entrada.next();
                                p.setTipoCliente(nuevo4);
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
            for (Clientes p: datosClientes){
                bfwriter.write(p.getCodigo()+","+p.getNombre()+ "," + p.getDireccion() + ","  +p.getTelefono() + "," + p.getTipoCliente()+"\n" );    
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
    
    
/*public void escribirArchivoClientes(ArrayList <Clientes> datosClientes) throws IOException{
        Scanner entrada = new Scanner(System.in);
        String csvFile = "C:\\Users\\Juan Camilo\\Documents\\NetBeansProjects\\Proyecto\\src\\Archivos";//nombre de archivo de salida
        System.out.println("Ingrese codigo: ");
        String cod = entrada.next();
        File archivo = new File(csvFile);//objeto filewriter
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter(archivo));
        
        for(Clientes p: datosClientes){
            if ( p.getCodigo().equals(cod)){
                System.out.println("Nombre: "+p.getNombre()+"Direccion: "+p.getDireccion()+"Telefono: "+p.getTelefono()+"Tipo: "+p.getTipoCliente());
                System.out.println("Ingrese que informacion desea editar: \n"+
                        "1. Nombre \n"+
                        "2. Direccion \n"+
                        "3. Telefono \n"+
                        "4. Tipo");
                int opc = entrada.nextInt();
                switch(opc){
                    case 1: opc = 1;
                        System.out.println("Ingrese nuevo Nombre: ");
                        String nuevo = entrada.next();
                        p.setNombre(nuevo);
                        break;

                }
            }
            //calcular el sueldo
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(p.getNombre()+ "," + p.getDireccion() + ","  +p.getTelefono() + "," + p.getTipoCliente()+"\n" );
                
        }


    
        bw.close();//cerrar archivo

       
    }
    */

