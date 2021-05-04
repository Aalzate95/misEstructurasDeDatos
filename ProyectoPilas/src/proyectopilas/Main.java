/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopilas;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author alexa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Deque<Integer> pila = new LinkedList<>();
        
        List<Instruccion> instrucciones = Instruccion.readFromFile("instrucciones.txt");
        List<Memoria> memoria = Memoria.readFromFile("memoria.txt");
        
        PriorityQueue<Instruccion> colaIns = new PriorityQueue<>((Instruccion i1, Instruccion i2)->i1.getPrioridad()-i2.getPrioridad());
        colaIns.addAll(instrucciones);
        while(!colaIns.isEmpty()){
            Instruccion instruccion = colaIns.poll();
            if ( instruccion.getInstruccion().equals("PUSH")){
                for(Memoria i:memoria){
                    if(instruccion.getOperando().equals(i.getDireccion())){
                        pila.push(i.getValor());
                        System.out.println(i);
                        
                    }
                }
            }
            else if (instruccion.getInstruccion().equals("POP")){
                int valor = pila.pop();
                Memoria.escribirMemoria(new Memoria(instruccion.getOperando(),valor));
                memoria = Memoria.readFromFile("memoria.txt");
            }
            else if (instruccion.getInstruccion().equals("ADD")){
                int val1 = pila.pop();
                int val2 = pila.pop();
                int suma = val1+val2;
                pila.push(suma);
            }
            else if (instruccion.getInstruccion().equals("MUL")){
                int val1 = pila.pop();
                int val2 = pila.pop();
                int mul = val1*val2;
                pila.push(mul);
            }
            else if (instruccion.getInstruccion().equals("SUB")){
                int val1 = pila.pop();
                int val2 = pila.pop();
                int sub = val1-val2;
                pila.push(sub);
            }
            else if (instruccion.getInstruccion().equals("DIV")){
                int val1 = pila.pop();
                int val2 = pila.pop();
                int div = val1/val2;
                pila.push(div);
            }
            else{
                System.out.println("ERROR");
            }
            
        }
        System.out.println("-----");
        for(Integer i :pila){
            System.out.println(i);
        }
        
    }
    
}
