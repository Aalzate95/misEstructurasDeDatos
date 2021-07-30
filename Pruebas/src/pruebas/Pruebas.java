/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author alexa
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> array = new ArrayList<>();
        array.addFirst(20);
        array.addFirst(10);
        array.addFirst(30);
        array.addFirst(4);
        array.addFirst(6);
        
        System.out.println(array.toString());
        System.out.println(array.slicing(0, 3));
        
        
    }
    
}
