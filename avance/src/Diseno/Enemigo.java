/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Asus
 */
public class Enemigo {
    private static final int KEYBOARD_MOVEMENT_DELTA = 5;
    public Pane scene;
    int altura=60, ancho=60;
    Rectangle enemigo;
    int x = 60,y= 60, xa=10,ya=10;
    Random random = new Random();
    public Enemigo() {
    }
    public Rectangle enemigo(){
        int[ ] posicionesX = { 140, 260, 380, 500, 620, 740 };
        int[ ] posicionesY = { 160, 280, 400, 520, 640 };
        Image cargarEnemigo = new Image("/Images/bm-enemigo.png");
        ImagePattern ipEnemigo = new ImagePattern(cargarEnemigo);
        final Rectangle enemigo = new Rectangle(altura,ancho);
        enemigo.setLayoutY(posicionesY[random.nextInt(5)]);
        enemigo.setLayoutX(posicionesX[random.nextInt(5)]);
        enemigo.setFill(ipEnemigo);
        return enemigo;
        
    }
    
		
	
     
}
