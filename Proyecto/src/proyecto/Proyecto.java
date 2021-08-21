/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class Proyecto {

    
    public static void main(String[] args) throws IOException {
        inicializarSistema datos = new inicializarSistema();
        Proveedores metodosProveedores = new Proveedores();
        Ips metodosIps = new Ips();
        Clientes metodosClientes = new Clientes();
        Tarifas metodosTarifas = new Tarifas();
        Llamadas metodosLlamadas = new Llamadas();
        //LISTAS CON LOS DATOS DE LOS ARCHIVOS YA COMO OBJETOS
        ArrayList<Usuarios> datosUsuarios = datos.leerArchivoUsuarios();
        ArrayList<Paises> datosPaises = datos.leerArchivoPaises();
        ArrayList<Proveedores> datosProveedores = datos.leerArchivoProveedores();
        ArrayList<Clientes> datosClientes = datos.leerArchivoClientes();
        ArrayList<Ips> datosIps = datos.leerArchivoIps();
        ArrayList<Tarifas> datosTarifas = datos.leerArchivoTarifas();
        ArrayList<Llamadas> datosLlamadas = datos.leerArchivoLlamadas();
        // INICIO DE SESION
        
        int banderaPrincipal=0;
        while(banderaPrincipal == 0){
            Scanner entrada = new Scanner(System.in);
            String usuario, contraseña;
            System.out.println("******************************\n"
                             + "**     INICIO DE SESION     **\n"+
                               "*////////////////////////////*");
            System.out.println("* Ingrese Usuario:           *");
            usuario = entrada.next();
            System.out.println("* Ingrese Contraseña         *");
            contraseña = entrada.next();

            //incio programacion tecnicos
            for (Usuarios i : datosUsuarios){
                if (usuario.equals(i.getUsuario()) && contraseña.equals(i.getContraseña())){
                    if(i.getNivel().equals("tecnico")){
                        int opc = 0;
                        while(opc != 7){
                            System.out.println(
                                    "********MENU TECNICO******"+"\n"+
                                    "1. Información​ ​de​ ​Clientes"+"\n"+
                                    "2. Información​ ​de​ ​Proveedores"+"\n"+
                                    "3. Información​ ​de​ ​Países"+"\n"+
                                    "4. Administrar​ ​IPs "+"\n"+
                                    "5. Información​ ​de​ ​Tarifa​ ​de​ ​Región"+"\n"+
                                    "6. Facturar​ ​llamadas "+"\n"+
                                    "7. Salir"+"\n"+
                                    "Ingrese opcion: ");
                            opc = entrada.nextInt();
                            if (opc>0&&opc <8){
                                switch(opc){
    // INICIO OPCION 1
                                   case 1:opc = 1;
                                        System.out.println(
                                                "*****************************************************"+"\n"+
                                                "*              INFORMACION DE CLIENTES              *"+"\n"+
                                                "*---------------------------------------------------*");
                                        for(Clientes a: datosClientes){
                                            System.out.println(
                                                "  codigo: "+a.getCodigo()+"  Nombre: "+a.getNombre()+"\n"+
                                                "  Direccion: "+a.getDireccion()+"\n"+
                                                "  Telefono: "+a.getTelefono()+"  Tipo: "+a.getTipoCliente()+"\n"+
                                                "*----------------------------------------------------*"        
                                            );
                                        }

                                        int banderaInfoClientes= 0;
                                        while (banderaInfoClientes == 0){
                                            System.out.println("Desea editar informacion de clientes s/n ?");
                                            String continuar = entrada.next().toUpperCase();
                                            if (continuar.equals("S")){
                                                //Escribir documento
                                                metodosClientes.escribirArchivoClientes(datosClientes);
                                                banderaInfoClientes=1;
                                                //NOT Group
                                            }
                                            else if (continuar.equals("N")){
                                                banderaInfoClientes = 1;
                                            }
                                            else{
                                                System.out.println("Opcion no valida, vuelva a intentarlo");
                                            }
                                        }
                                        break;
    // INICIO OPCION 2                                    
                                    case 2:opc = 2;
                                        System.out.println(
                                                "******************************************************"+"\n"+
                                                "*            INFORMACION DE PROVEEDORES              *");
                                        System.out.println(
                                                "* Código ​ ​ Nombre ​ ​  ​   Dirección ​ ​    Teléfono      *");
                                        for(Proveedores a : datosProveedores){
                                            System.out.println(
                                                "    "+  a.getCodigo()+"       "+a.getNombre()+"     "+a.getDireccion()+"    "+a.getTelefono());
                                        }
                                        System.out.println(
                                                "*****************************************************");
                                        int banderaInfoProvee= 0;
                                        while (banderaInfoProvee == 0){
                                            System.out.println("Desea editar informacion de Proveedores s/n ?");
                                            String continuar = entrada.next().toUpperCase();
                                            if (continuar.equals("S")){
                                                //Escribir documento
                                                
                                                metodosProveedores.escribirArchivoProveedores(datosProveedores);
                                                banderaInfoProvee=1;
                                                //NOT Group
                                            }
                                            else if (continuar.equals("N")){
                                                banderaInfoProvee = 1;
                                            }
                                            else{
                                                System.out.println("Opcion no valida, vuelva a intentarlo");
                                            }
                                        }
                                        break;
    //INICIO OPCION 3
                                    case 3:opc = 3;
                                        System.out.println(
                                                "*******************************************************"+"\n"+
                                                "*                INFORMACION DE PAISES                *"+"\n"+
                                                "*-----------------------------------------------------*");
                                        for (Paises a : datosPaises){
                                            System.out.println(
                                                "  Codigo: "+a.getCodigo()+"   Nombre: "+a.getNombre()+"   Prefijo: "+a.getPrefijo()+"\n"+
                                                "*-----------------------------------------------------*");                                        
                                        }
                                        int banderaInfoPais= 0;
                                        while (banderaInfoPais == 0){
                                            System.out.println("Desea editar informacion de Pises s/n ?");
                                            String continuar = entrada.next().toUpperCase();
                                            if (continuar.equals("S")){
                                                //Escribir documento
                                                Paises escrituraPaises = new Paises();
                                                escrituraPaises.escribirArchivoPaises(datosPaises);
                                                banderaInfoPais=1;
                                                //NOT Group
                                            }
                                            else if (continuar.equals("N")){
                                                banderaInfoPais = 1;
                                            }
                                            else{
                                                System.out.println("Opcion no valida, vuelva a intentarlo");
                                            }
                                        }
                                        break;
        // INICIO OPCION 4
                                    case 4:opc = 4;
                                        metodosIps.menuIps(datosIps);
                                        break;
        //INICIO OPCION 5
                                    case 5:opc = 5;
                                        metodosTarifas.menuTarifas(datosTarifas);
                                        break;
                                    case 6:opc = 6;
                                    Facturar metodosFacturar = new Facturar();
                                    ArrayList<Facturar> listaLlamadas = metodosFacturar.leerArchivo();
                                    ArrayList<Ips> listaIps= leerIps();
                                    ArrayList<Tarifas> listaTarifas= leerTarifas();
                                    escribirArchivo(listaLlamadas,listaIps,listaTarifas);
                                        break;
                                }

                            }
                        }
                    }
                else{
                    System.out.println("Usuario o contrasena no existentes.");
                    }


            //inicio programacion administradores        
                    if(i.getNivel().equals("admin")){
                        System.out.println(
                                "********MENU ADMIN******"+"\n"+
                                "1. Detalle​ ​Factura​ ​Cliente"+"\n"+
                                "2. Reporte​ ​llamadas​ ​por​ ​Clientes​ ​por​ ​Mes"+"\n"+
                                "3. Reporte​ ​llamadas​ ​por​ ​Proveedor​ ​por​ ​Mes");
                        
                    }
                }
            }

        }
    }
    //opcion6


    
        public static void escribirArchivo(ArrayList<Facturar> listaLlamadas,ArrayList<Ips> listaIps,ArrayList<Tarifas> listaTarifas){
       
        
               
        final String NEXT_LINE = "\n"; //delimitador para salto de linea
        String delim =","; //separador de campos
        String csvFile = "llamadas_facturadas.csv";//nombre de archivo de salida
       
        try {
            FileWriter fw = new FileWriter(csvFile);//objeto filewriter
           
            for(Ips e: listaIps){ 
                for(Facturar p: listaLlamadas){
                    String dato1 = null;
                    String dato2=null;
                    if (p.getIpfuente().equals(e.getIp())){
                        dato1=e.getCodigo();
                     if(p.getIpdestino().equals(e.getIp())){
                        dato2=e.getCodigo();
                        
                     }   

                    }
                    
                    float costo_proveedor=p.estableceCostoProveedor();
                    float costo_cliente=p.estableceCostoCliente();
                    
                    
                      fw.append(p.getFecha()+ "," + p.getHora() + ","  +p.getIpfuente()+
                            ","  + p.getIpdestino() + ","  +p.getDNIS()+","+p.getANI()+","+
                            p.getDuracion()+","+dato1+","+dato2+","+costo_cliente+","+costo_proveedor).append(System.lineSeparator());
                            
    
                }
                
                        
              
            }


            fw.flush();
            fw.close();//cerrar archivo
	} catch (IOException e) {
            // Error al crear el archivo, por ejemplo, el archivo
            // estÃ¡ actualmente abierto.
            e.printStackTrace();
	}


    }
      
           public static ArrayList<Ips> leerIps() throws IOException{
         ArrayList<Ips> listaIps = new ArrayList<Ips>();


        String csvFile = "ips.csv";
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                //crea un objeto Profesor con esos datos
                Ips individuo = new Ips(datos[0],datos[1],datos[2]);
                //agrego el objeto a la lista
                listaIps.add(individuo);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
}
         return listaIps;
           }
 public static ArrayList<Tarifas> leerTarifas(){
         ArrayList<Tarifas> listaTarifas = new ArrayList<Tarifas>();


        String csvFile = "tarifas.csv";
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                Tarifas profesor = new Tarifas(datos[0],datos[1],datos[2],Float.parseFloat(datos[3]),datos[4]);
                //agrego el objeto a la lista
                listaTarifas.add(profesor);

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

         return listaTarifas;

    }  
}

	
    
    

