/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopilas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Memoria {
    private String direccion;
    private int valor;

    public Memoria(String direccion, int valor) {
        this.direccion = direccion;
        this.valor = valor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    public static List<Memoria> readFromFile(String file){
        List<Memoria> lista = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String direccion = temp[0];
                int valor = Integer.parseInt(temp[1]);
                Memoria element = new Memoria(direccion,valor);
                lista.add(element);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public String toString(){
        return direccion+" "+valor;
    } 
    public static void escribirMemoria(Memoria m) 
        throws IOException {
            String str = m.getDireccion()+"|"+m.getValor();
            BufferedWriter writer = new BufferedWriter(new FileWriter("memoria.txt", true));
            writer.append("\n");
            writer.append(str);
            writer.close();
        }   
    
}
