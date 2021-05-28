/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;
import ec.edu.espol.tdas.ArrayList;

/**
 *
 * @author Alexander Alzate
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> a = new ArrayList<>();
        a.addFirst(2);
        a.addLast(8);
        a.addLast(10);
        a.addLast(12);
        a.addLast(24);
        System.out.println(a.toString());
        a.remove(1);
        System.out.println(a.toString());
        System.out.println(a.reverse());
        System.out.println(a.slicing(1, 3));
    }
    
}
