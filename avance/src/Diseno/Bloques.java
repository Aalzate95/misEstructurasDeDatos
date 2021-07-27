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

	public void crearBloque(Pane scene) {
                Image carga = new Image("/Images/bm-rock.png");
                ImagePattern ipBloque = new ImagePattern(carga);
                int[ ] posicionesX = { 140, 260, 380, 500, 620, 740 };
                int[ ] posicionesY = { 160, 280, 400, 520, 640 };
                for (int i = 0; i < 11; i++) {
                    Rectangle bloque = new Rectangle(ancho,alto);
                    bloque.setLayoutX(posicionesX[random.nextInt(5)]);
                    bloque.setLayoutY(posicionesY[random.nextInt(5)]);
                    bloque.setFill(ipBloque);
                    scene.getChildren().add(bloque);
                }
	}
	

	public Rectangle getBounds() {
		return new Rectangle(ancho, alto);
	}
        
}
