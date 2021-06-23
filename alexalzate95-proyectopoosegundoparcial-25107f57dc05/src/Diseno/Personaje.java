package Diseno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

/**
 * Esta clase se usa para definir todo con respecto al personaje
 * @author Alexander Alzate
 */
public class Personaje {

    private static final int KEYBOARD_MOVEMENT_DELTA = 5;
    private static final Duration TRANSLATE_DURATION = Duration.seconds(0.25);
    public Rectangle Personaje;
    //private Bloques bloque = new Bloques();
    private Juego juego;
    private int alto = 60, ancho = 60, x = 20, y = 40, xa = 0, ya = 0;
    Bomba bomba = new Bomba();

    public Rectangle PersonajeDiseno() {
        Rectangle Personaje = new Rectangle(ancho, alto);
        Image cargarPersonaje = new Image("/Images/bm-caminando.gif");
        ImagePattern Prueba = new ImagePattern(cargarPersonaje);
        Personaje.setFill(Prueba);
        Personaje.setLayoutY(y);
        Personaje.setLayoutX(x);
        return Personaje;
    }

    public TranslateTransition createTranslateTransition(final Rectangle Personaje) {
        final TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, Personaje);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Personaje.setX(Personaje.getTranslateX() + Personaje.getX());
                Personaje.setY(Personaje.getTranslateY() + Personaje.getY());
                Personaje.setTranslateX(0);
                Personaje.setTranslateY(0);

            }
        });
        return transition;
    }

    public void MoverPersonaje(Pane scene, final Rectangle Personaje) {
        scene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        if (!comprobarLimitesBloquesY((int) Personaje.getLayoutX()) && !(Personaje.getLayoutY() <= 40))/**/ {
                            Personaje.setLayoutY(Personaje.getLayoutY() - KEYBOARD_MOVEMENT_DELTA);
                           
                        }
                        /*if (getBounds().intersects(300, 300, 60, 60)) {
                            Personaje.setLayoutY(Personaje.getLayoutY() + KEYBOARD_MOVEMENT_DELTA);
                            
                        }*/
                        
                        break;
                    case RIGHT:
                        if (!comprobarLimitesBloquesX((int) Personaje.getLayoutY()) &&!(Personaje.getLayoutX() >= 860)) {
                            Personaje.setLayoutX(Personaje.getLayoutX() + KEYBOARD_MOVEMENT_DELTA);
                            
                        }
                        break;
                    case DOWN:
                        if (!comprobarLimitesBloquesY((int) Personaje.getLayoutX()) && !(Personaje.getLayoutY() >= 640))/*!*/ {

                            Personaje.setLayoutY(Personaje.getLayoutY() + KEYBOARD_MOVEMENT_DELTA);
                            
                            //scene.setConstraints(Personaje,1,2);
                        }
                        break;
                    case LEFT:
                        if (!comprobarLimitesBloquesX((int) Personaje.getLayoutY()) && !(Personaje.getLayoutX() <= 20)) {
                            Personaje.setLayoutX(Personaje.getLayoutX() - KEYBOARD_MOVEMENT_DELTA);
                            
                            
                        }
                        break;
                }
            }
        });
    }

    public boolean comprobarLimitesBloquesY(int PosicionX) {
        int[] limitesX = {80, 200, 320, 440, 560, 680, 800};
        for (int i = 0; i < limitesX.length; i++) {
            if (PosicionX == limitesX[i]){
                return true;
            }
            for (int j = 0; j <= 55; j = j + 5) {
                if ((PosicionX == limitesX[i]+j) || (PosicionX == limitesX[i]-j) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean comprobarLimitesBloquesX(int PosicionY) {
        int[] limitesY = {100, 220, 340, 460, 580};
        for (int i = 0; i < limitesY.length; i++) {
            if (PosicionY == limitesY[i]){
                return true;
            }
            for (int j = 0; j <= 55; j = j + 5) {
                if ((PosicionY == limitesY[i]+j) || (PosicionY == limitesY[i]-j) ) {
                    return true;
                }
            }
            
        }
        return false;
    }

    /*public Rectangle getBounds() {
		return new Rectangle(Personaje.getLayoutX(), Personaje.getLayoutY(), alto=60, ancho =60);
	}*/
     
    
    public Rectangle getPersonaje() {
        return Personaje;
    }

    public void setPersonaje(Rectangle Personaje) {
        this.Personaje = Personaje;
    }

}
