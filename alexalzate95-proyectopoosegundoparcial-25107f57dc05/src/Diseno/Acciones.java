/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
/**
 *
 * @author Alexander Alzate
 */
public class Acciones extends Thread {
    private int xa = 1,ya=1,x=0,y=0;
    private static final Duration TRANSLATE_DURATION = Duration.seconds(0.25);
    public Rectangle enemigo;
    public boolean tipo; //falso es para x y verdadero para y
    public Acciones(Rectangle enemigo, boolean tipo) {
        this.enemigo = enemigo;
        this.tipo = tipo;
    }
    
    
    public void run(){
        while(true){
            //movEnemigo(enemigo,tipo);
            
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        movEnemigo(enemigo,tipo);
                    }

                });
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
              
     
    void movEnemigo(Rectangle enemigo,boolean tipo) {
        if (tipo == false){
            if (enemigo.getLayoutX() + xa < 500)
                    xa = 1;
            if (enemigo.getLayoutX() + xa > 850)
                    xa = -1;

            x = (int)enemigo.getLayoutX() + xa;
            enemigo.setLayoutX(x);
            }
        else{
            if (enemigo.getLayoutY() + ya < 40)
                    ya = 1;
            if (enemigo.getLayoutY() + ya > 640)
                    ya = -1;

            y = (int)enemigo.getLayoutY() + ya;
            enemigo.setLayoutY(y);
        }
    }
    
}
