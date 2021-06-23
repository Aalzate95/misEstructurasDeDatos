/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
/**
 *
 * @author Alexander Alzate
 */
public class Nivel1 {
	private static int ancho = 60,x=0,y=0;
	private static  int alto = 60;
	Random random = new Random();
        Bomba MetodosBomba = new Bomba();
	private Juego juego;
        public int prueba; 
        private ArrayList<Integer> posicionesAleatoriasX;
        private ArrayList<Integer> posicionesAleatoriasY;
        private int[ ] posicionesX = { 380,560,260,380,500,140,200,320,380,500,560,620,260,740,380,140,320,620,260,500,740,260,380,620,800,80,20,140,200,260,320,440,500,560,620,680,740};
        private int[ ] posicionesY = { 40,40,100,100,100,160,160,160,160,160,160,160,220,220,280,280,340,340,400,400,400,520,520,520,520,640,640,640,640,640,640,640,640,640,640,640,640};
        public Nivel1() {
            posicionesAleatoriasX = new ArrayList<Integer>();
            posicionesAleatoriasY = new ArrayList<Integer>();
        }
	public void crearBloques(Pane scene) {
                Image carga = new Image("/Images/bm-rock.png");
                ImagePattern ipBloque = new ImagePattern(carga);
                for (int i = 0; i <= posicionesX.length-1; i++) {
                    final Rectangle bloque = new Rectangle(ancho,alto);
                    int posicionesXAlt = posicionesX[i];
                    bloque.setLayoutX(posicionesXAlt);
                    posicionesAleatoriasX.add(posicionesXAlt);
                    int posicionesYAlt = posicionesY[i];
                    bloque.setLayoutY( posicionesYAlt);
                    posicionesAleatoriasY.add(posicionesYAlt);
                    bloque.setFill(ipBloque);
                    scene.getChildren().add(bloque);
                }
	}
	
       
        public Rectangle getBounds() {
		return new Rectangle(x, y, alto=60, ancho =60);
	}
        public void crearPuerta(Pane scene){
            Image carga = new Image("/Images/bm-door.jpg");
            ImagePattern ipPuerta = new ImagePattern(carga);
            Rectangle puerta = new Rectangle(ancho,alto);
            int x = random.nextInt(posicionesX.length-1);
            puerta.setLayoutX(posicionesX[x]);
            puerta.setLayoutY(posicionesY[x]);
            puerta.setFill(ipPuerta);
            scene.getChildren().add(puerta);
        }
        public void bombaOculta(Pane scene){
            Image carga = new Image("/Images/bm-bomba.png");
            ImagePattern ipBomba = new ImagePattern(carga);
            Rectangle bomba = new Rectangle(ancho,alto);
            int x = random.nextInt(posicionesX.length-1);
            bomba.setLayoutX(posicionesX[x]);
            bomba.setLayoutY(posicionesY[x]);
            bomba.setFill(ipBomba);
            scene.getChildren().add(bomba);
        }
}
