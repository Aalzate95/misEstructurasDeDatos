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

public class inicializarSistema {
    
    
    public ArrayList leerArchivoUsuarios(){
        File usuarios = new File("usuarios.csv");
        ArrayList listaUsuarios;
        listaUsuarios = new ArrayList<Usuarios>();
        Scanner scanner;
        try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(usuarios);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Usuarios e = new Usuarios();
				e.setUsuario(delimitar.next());
				e.setContraseña(delimitar.next());
				e.setNombre(delimitar.next());
				e.setNivel(delimitar.next());
				listaUsuarios.add(e);
                                }
			//se cierra el ojeto scanner
			scanner.close();
                        } catch (FileNotFoundException e) {
			e.printStackTrace();
			}
        return listaUsuarios;
    }
    public ArrayList<Paises> leerArchivoPaises() {
        File paises = new File("paises.csv");
        ArrayList listaPaises= new ArrayList<Paises>();
        Scanner scanner;
        try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(paises);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Paises e = new Paises();
				e.setCodigo(delimitar.next());
				e.setNombre(delimitar.next());
				e.setPrefijo(delimitar.next());
				listaPaises.add(e);
                                }
			//se cierra el ojeto scanner
			scanner.close();
                        } catch (FileNotFoundException e) {
			e.printStackTrace();
			}
        return listaPaises;
    }

    public ArrayList leerArchivoProveedores(){
        File proveedores = new File("proveedores.csv");
        ArrayList listaProveedores;
        listaProveedores = new ArrayList<Proveedores>();
        Scanner scanner;
        try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(proveedores);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Proveedores e = new Proveedores();
				e.setCodigo(delimitar.next());
				e.setNombre(delimitar.next());
				e.setDireccion(delimitar.next());
                                e.setTelefono(delimitar.next());
				listaProveedores.add(e);
                                }
			//se cierra el ojeto scanner
			scanner.close();
                        } catch (FileNotFoundException e) {
			e.printStackTrace();
			}
        
        return listaProveedores;
    }
    public ArrayList leerArchivoClientes(){
        File clientes = new File("clientes.csv");
        ArrayList listaClientes;
        listaClientes = new ArrayList<Clientes>();
        Scanner scanner;
        try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(clientes);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Clientes e = new Clientes();
				e.setCodigo(delimitar.next());
				e.setNombre(delimitar.next());
				e.setDireccion(delimitar.next());
                                e.setTelefono(delimitar.next());
                                e.setTipoCliente(delimitar.next());
				listaClientes.add(e);
                                }
			//se cierra el ojeto scanner
			scanner.close();
                        } catch (FileNotFoundException e) {
			e.printStackTrace();
			}
        return listaClientes;
    }
    public ArrayList leerArchivoIps(){
         File ips = new File("ips.csv");
        ArrayList listaIps = new ArrayList<Ips>();
        Scanner scanner;
        try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(ips);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Ips e = new Ips();
				e.setIp(delimitar.next());
				e.setTipo(delimitar.next());
				e.setCodigo(delimitar.next());
				listaIps.add(e);
                                }
			//se cierra el ojeto scanner
			scanner.close();
                        } catch (FileNotFoundException e) {
			e.printStackTrace();
			}
        return listaIps;
    }
    public ArrayList leerArchivoTarifas(){
        File tarifas = new File("tarifas.csv");
        ArrayList listaTarifas = new ArrayList<Tarifas>();
        Scanner scanner;
        try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(tarifas);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Tarifas e = new Tarifas();
                                e.setCodigoProveedor(delimitar.next());
				e.setCodigoPais(delimitar.next());
				e.setNombreRegion(delimitar.next());
				e.setPrefijoRegion(delimitar.next());
                                String x = delimitar.next();
                                e.setTarifa(Float.parseFloat(x));
                                e.setCodigoTarifa(delimitar.next());
				listaTarifas.add(e);
                                }
			//se cierra el ojeto scanner
			scanner.close();
                        } catch (FileNotFoundException e) {
			e.printStackTrace();
			}
        return listaTarifas;
    }
    public ArrayList leerArchivoLlamadas(){
        File llamadas = new File("llamadas.csv");
        ArrayList listaLlamadas;
        listaLlamadas = new ArrayList<Llamadas>();
        Scanner scanner;
        try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(llamadas);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Llamadas e = new Llamadas();
				e.setFecha(delimitar.next());
				e.setHora(delimitar.next());
				e.setIpFuente(delimitar.next());
                                e.setIpDestino(delimitar.next());
                                e.setDnis(delimitar.next());
                                e.setAni(delimitar.next());
                                e.setEstado(delimitar.next());
                                e.setDuracion(delimitar.next());
				listaLlamadas.add(e);
                                }
			//se cierra el ojeto scanner
			scanner.close();
                        } catch (FileNotFoundException e) {
			e.printStackTrace();
			}
        return listaLlamadas;
    }
}