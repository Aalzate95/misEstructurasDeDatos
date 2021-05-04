/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopilas;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author alexa
 */
public class Operaciones {
    public static void suma(Deque<Integer> p1){
        int val1 = p1.pop();
        int val2 = p1.pop();
        int suma = val1+val2;
        p1.push(suma);
    }
}
