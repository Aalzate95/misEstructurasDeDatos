/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tdas;
/**
 *
 * @author alexa
 */
public class Vector {
    private float coordX,coordY;

    public float getCoordX() {
        return coordX;
    }

    public void setCoordX(float coordX) {
        this.coordX = coordX;
    }

    public float getCoordY() {
        return coordY;
    }

    public void setCoordY(float coordY) {
        this.coordY = coordY;
    }
    
    public static float magnitud (Vector vector){
        float oX = 0;
        float oY = 0;
        float magnitud = (float)Math.sqrt(((oX+vector.getCoordX())*2)+((oY+vector.getCoordY())*2));
        return magnitud;
    }
    public static float direccion (Vector vector){
        float angulo = (float)Math.atan2(vector.getCoordY(),vector.getCoordX());
        return angulo;
    }
    public static void sumarVector(Vector vector1,Vector vector2){
        float nuevaCoordX = vector1.getCoordX()+vector2.getCoordX();
        float nuevaCoordY = vector1.getCoordY()+vector2.getCoordY();
        System.out.println(nuevaCoordX+" + "+nuevaCoordY);
    }
    public static void restarVector(Vector vector1, Vector vector2){
        float nuevaCoordX = vector1.getCoordX()-vector2.getCoordX();
        float nuevaCoordY = vector1.getCoordY()-vector2.getCoordY();
        System.out.println(nuevaCoordX+" + "+nuevaCoordY);
    }
    public static void escalarVector(Vector vector, int escalar){
        float nuevaCoorX = vector.getCoordX()*escalar;
        float nuevaCoorY = vector.getCoordY()*escalar;
        System.out.println(nuevaCoorX+" + "+nuevaCoorY);
    }
    public static float productoPunto(Vector vector1,Vector vector2){
        float escalar = ((vector1.getCoordX()*vector2.getCoordX())+(vector1.getCoordY()*vector2.getCoordY()));
        return escalar;
    }
    public static void tostring(Vector vector){
        System.out.println(" ( "+vector.getCoordX()+" , "+vector.getCoordY()+" ) ");
    }
    public static void equals(Vector vector1, Vector vector2){
        if ((vector1.getCoordX() == vector2.getCoordX())&&(vector1.getCoordY()== vector2.getCoordY())){
            System.out.println("Iguales");
     
        }
        else{
            System.out.println("Diferente");
        }
    }
}
