/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.taller2;



/**
 *
 * @author Administrador
 */

//EJERCICIO 1
public class Operaciones {
    public static int multiplicacion (int numero) throws Exception {
        if (numero < 1)
            throw new Exception ("Operacion no permitida");
        else if (numero == 1)
            return numero; 
        return numero * multiplicacion( numero -1);
            
    }
//EJERCICIO 2    
    public static int binarios (int numero)  {
         String binario = "";
        if (numero > 0) {
            while (numero > 0) {
                if (numero % 2 == 0) {
                    binario = "0" + binario;
                } else {
                    binario = "1" + binario;
                }
                numero = (int) numero / 2;
            }
        } else if (numero == 0) {
            binario = "0";
        } else {
            binario = "No se pudo convertir el numero. Ingrese solo números positivos";
        }
        System.out.println("El número convertido a binario es: " + binario);
        return 0;
     }
    
//EJERCICIO 3
    public static int suma(int n){
        if(n==2)
            return 2;
        return n+suma(n-2);
    }
   
// EJERCICIO 4
    private static Object[] invertir_int;
    public static int sumMedios (int [] array ){
        invertir_int = new Object[array.length];
        int maximo = array.length;
 
        for (int i = 0; i<array.length; i++) {
            invertir_int[maximo - 1] = array[i];
            maximo--;
        }
        return 0;
     }
//EJERCICIO 5
     public static int multVector(int []array){
        return  multVector(array, array.length-1);
    }
    private static int multVector( int []array, int pos){
        if ( pos== 0)
            return array[0];
        return array[pos]* multVector(array, pos-1);
}
}

     

        

  



