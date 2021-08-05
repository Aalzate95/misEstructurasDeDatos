/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion;


import espol.edu.ec.utilitarios.CONSTANTES;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *Clase que permite manejar las imagenes generales de la interfaz
 * @author grupoArmada
 */
public class Logos {
    /**
     * Metodo que trabaja la imagen de fondo de la aplicacion
     * @return imageView (el fondo)
     */
    public static ImageView fondo(){
        ImageView fondo=new ImageView();
        try{
            Image image3 = new Image(SistemaTurnosG3.class.getResourceAsStream(
                            CONSTANTES.RUTA_IMAGENES+"2.jpg"));
            fondo.setImage(image3);
            fondo.setX(0);
            fondo.setY(0);
            fondo.toBack();
            fondo.setSmooth(true);
            fondo.setCache(true);
            fondo.setFitWidth(400);
            fondo.setFitHeight(350);
        }catch(Exception e){
            System.out.println("no se encontro la foto");
        }
        return fondo;
    }
    
    /**
     * Metodo que trabaja la imagen usada en ventana de autenticacion
     * @return ImageView (imagen de una llave)
     */
    public static ImageView llave(){
        ImageView logous=new ImageView();
        try{
            Image image2 = new Image(SistemaTurnosG3.class.getResourceAsStream(
                            CONSTANTES.RUTA_IMAGENES+"llave.png"));
            logous.setImage(image2);
            logous.setX(50);
            logous.setY(30);
            logous.setFitWidth(100);
            logous.setFitHeight(100);
            logous.setPreserveRatio(true);
            logous.setSmooth(true);
            logous.setCache(true);
        }catch(Exception e){
            System.out.println("no se encontro la foto");
        }
        return logous;
    }
    
    /**
     * Metodo que trabaja la imagen central de la aplicacion
     * @return ImageView (imagen de un imgService)
     */
    public static ImageView imgService(){
        ImageView logoe=new ImageView();
        try{
            Image image = new Image(SistemaTurnosG3.class.getResourceAsStream(
                            CONSTANTES.RUTA_IMAGENES+"logo.png"));
            logoe.setImage(image);
            logoe.setX(200);
            logoe.setY(15);
            logoe.setFitWidth(150);
            logoe.setFitHeight(150);
            logoe.setPreserveRatio(true);
            logoe.setSmooth(true);
            logoe.setCache(true);
        }catch(Exception e){
            System.out.println("no se encontro la foto");
        }
        return logoe;
    }
    
    /**
     * Metodo que trabaja la imagen por default de un chofer
     * @param nomFoto
     * @return ImageView (icono de chofer)
     */
    public static ImageView chofer(String nomFoto){
        ImageView logoCh=new ImageView();
        try{
            Image image3 = new Image(SistemaTurnosG3.class.getResourceAsStream(
                            CONSTANTES.RUTA_IMAGENES+nomFoto));
            logoCh.setImage(image3);
            logoCh.setX(20);
            logoCh.setY(20);
            logoCh.setFitWidth(100);
            logoCh.setFitHeight(100);
            logoCh.setPreserveRatio(true);
            logoCh.setSmooth(true);
            logoCh.setCache(true);
        }catch(Exception e){
            System.out.println("no se encontro la foto");
        }
        return logoCh;
    }
   
}
