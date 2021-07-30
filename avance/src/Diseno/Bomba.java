package Diseno;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan Camilo
 */
public class Bomba {
    public Rectangle Bomba;
    private int alto = 60,ancho=60;
    Personaje personaje;
    Juego juego;
    public Rectangle Bomba(){
        Image cargarBomba = new Image("/Images/bm-bomba.png");
        ImagePattern ipBomba = new ImagePattern(cargarBomba);
        Bomba = new Rectangle(alto,ancho);
        Bomba.setLayoutX(-100);
        Bomba.setFill(ipBomba);
        return Bomba;
    }
    public void ubicacionBomba (Pane scene,Rectangle Personaje){
      
            Rectangle Bomba = new Rectangle();
            Bomba = Bomba();
            Bomba.setLayoutX(Personaje.getLayoutX());
            Bomba.setLayoutY(Personaje.getLayoutY());
            scene.getChildren().add(Bomba);
        
    }
    public void Explosion ( Pane scene,final Rectangle Bomba){
        Image exp = new Image("/Images/bm-explosion.png");
        ImagePattern explosion = new ImagePattern(exp);
        Bomba.setFill( explosion);
        Timeline timeline = new Timeline(new KeyFrame(
        Duration.seconds(1),
        ae -> {
                //scene.getChildren().remove(Bomba);
                scene.getChildren().remove(Bomba);
            }));
        timeline.play();
    }
    
    public void ponerBomba(Pane scene,Rectangle Personaje){
            scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.A) {
            final Rectangle Bomba;
            //Bomba = new Rectangle();
            Bomba = Bomba();
            Double x = Personaje.getLayoutX(),y=Personaje.getLayoutY();
            Bomba.setLayoutX(Personaje.getLayoutX());
            Bomba.setLayoutY(Personaje.getLayoutY());
            scene.getChildren().add(Bomba);
            Timeline timeline = new Timeline(new KeyFrame(
        Duration.seconds(3),
        ae -> {
                //scene.getChildren().remove(Bomba);
                Explosion(scene,Bomba);
            }));
        timeline.play();
        
            }
        });
            }
       
       /*scene.setOnKeyReleased(e -> {
        if (e.getCode() == KeyCode.A) {
            Rectangle Bomba = new Rectangle();
            Bomba = Bomba();
            Bomba.setLayoutX(Personaje.getLayoutX());
            Bomba.setLayoutY(Personaje.getLayoutY());
            scene.getChildren().add(Bomba);
        }
        });*/
   
    
}
