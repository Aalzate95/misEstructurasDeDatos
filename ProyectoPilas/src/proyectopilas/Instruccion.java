/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopilas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Instruccion {
    private String instruccion;
    private String operando;
    private int prioridad;

    public Instruccion(String instruccion, String operando, int prioridad) {
        this.instruccion = instruccion;
        this.operando = operando;
        this.prioridad = prioridad;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getOperando() {
        return operando;
    }

    public void setOperando(String operando) {
        this.operando = operando;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
    public static List<Instruccion> readFromFile(String file){
        List<Instruccion> lista = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String inst = temp[0];
                String operando = temp[1];
                int prioridad = Integer.parseInt(temp[2]);
                Instruccion element = new Instruccion(inst, operando,prioridad);
                lista.add(element);
                
                
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public String toString(){
        return instruccion+" "+operando+" "+prioridad;
    }

    
}
