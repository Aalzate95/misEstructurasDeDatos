/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;
import java.awt.Graphics2D;
import javafx.scene.shape.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
/**
 *
 * @author Juan Camilo
 */
public class Bloques {
	private static final int ancho = 60;
	private static final int alto = 60;
	Random random = new Random();
	private Juego juego;
        private int[ ] posicionesX = { 380,560,260,380,500,140,200,320,380,500,560,620,260,740,380,140,320,620,260,500,740,260,380,620,800,80,20,140,200,260,320,440,500,560,620,680,740};
        private int[ ] posicionesY = { 40,40,100,100,100,160,160,160,160,160,160,160,220,220,280,280,340,340,400,400,400,520,520,520,520,640,640,640,640,640,640,640,640,640,640,640,640};
        

	public void crearBloque(Pane scene) {
                Image carga = new Image("/Images/bm-rock.png");
                ImagePattern ipBloque = new ImagePattern(carga);
                for (int i = 0; i <= posicionesX.length-1; i++) {
                    Rectangle bloque = new Rectangle(ancho,alto);
                    bloque.setLayoutX(posicionesX[i]);
                    bloque.setLayoutY( posicionesY[i]);
                    bloque.setFill(ipBloque);
                    scene.getChildren().add(bloque);
                }
    }
	

	public Rectangle getBounds() {
		return new Rectangle(ancho, alto);
	}
        
}
