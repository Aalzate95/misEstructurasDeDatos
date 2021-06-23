/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
/**
 *
 * @author Alexander Alzate
 */
public class BloqueFijo {
        private static final int Y = 100;
        private static final int X = 100;
	private static final int ancho = 60;
	private static final int alto = 60;
	
	private Juego juego;

	public Rectangle crearBloqueFijo(int x , int y) {
		Rectangle bloque = new Rectangle(ancho,alto);
                bloque.setLayoutX(x);
                bloque.setLayoutY(y);
                bloque.setFill(Color.DARKSLATEGREY);
                return bloque ;
	}
	

	public Rectangle getBounds() {
		return new Rectangle(X, Y, ancho, alto);
	}
        
}
