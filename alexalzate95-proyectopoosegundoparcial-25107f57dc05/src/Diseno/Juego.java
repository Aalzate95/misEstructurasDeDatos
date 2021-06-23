/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;
import javafx.scene.shape.Rectangle;
import javafx.animation.TranslateTransition;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;


/**
 *
 * @author Alexander Alzate
 */
public class Juego{
    private static final int      KEYBOARD_MOVEMENT_DELTA = 5;
    private static final Duration TRANSLATE_DURATION = Duration.seconds(0.25);
    Rectangle Personaje = new Rectangle();
    private Rectangle Bomba = new Rectangle();
    private Rectangle Enemigo1 = new Rectangle();
    private Rectangle Enemigo2 = new Rectangle();
    private Pane root = new Pane();
    Rectangle muroSuperior,muroInferior,muroDerecha,muroIzquierda;
    Rectangle block1, block2, block3, block4, block5, block6, block7;
    Rectangle block8, block9, block10, block11,block12,block13, block14;
    Rectangle block15, block16, block17, block18, block19, block20, block21;
    Rectangle block22, block23, block24, block25, block26, block27, block28;
    Rectangle block29, block30, block31, block32 ,block33, block34, block35;
    Button btnNuevaPartida,btnSalir;
    Stage stg ;
    Personaje player = new Personaje();
    Bomba bomba = new Bomba();
    Nivel1 bloques = new Nivel1();
    Enemigo enemigo = new Enemigo();
    Acciones enemigo1,enemigo2;
    
    BloqueFijo bloqueFijo = new BloqueFijo();
    public Juego (){
        
    }
    public Juego(Stage primary){
        
        stg = primary;
//Barra de menu superior
        btnNuevaPartida = new Button("Nueva Partida");
        btnSalir = new Button("Salir");
        btnSalir.setLayoutX(90);
        HBox hbBotones = new HBox(btnNuevaPartida,btnSalir);
        hbBotones.setAlignment(Pos.TOP_LEFT);
//ACCIONES DE BOTONES
        btnNuevaPartida.setOnAction(actionevent->{
                stg.setScene(new Scene(new MenuPrincipal(stg).getRoot(),900,640));
                stg.setScene(new Scene(new Juego(stg).getRoot(),940,730));
                });
        btnSalir.setOnAction(actionevent->{
                stg.setScene(new Scene(new MenuPrincipal(stg).getRoot(),900,640));
            });
      
        
//Personaje movimiento
        Bomba =bomba.Bomba();
        Personaje = player.PersonajeDiseno();
       // Enemigo = enemigo.enemigo();
        final TranslateTransition transition = player.createTranslateTransition(Personaje);
        player.MoverPersonaje(root, Personaje);
        Enemigo1 = enemigo.enemigo();
        Enemigo2 = enemigo.enemigo();
        bomba.ponerBomba(root, Personaje);
        bloques.crearPuerta(root);
        bloques.bombaOculta(root);
        bloques.crearBloques(root);
        
          //////////////////////////////////////////////////
        //enemigo.movEnemigo(Enemigo);
         enemigo1 = new Acciones(Enemigo1,true);
        enemigo1.start();
        enemigo2 = new Acciones(Enemigo2,false);
        enemigo2.start();
        
        ///////////////////////////////////////////////////
//Creacion mapa
       
        muroSuperior = new Rectangle(940,40);
        muroInferior = new Rectangle(940,30);
        muroIzquierda = new Rectangle(20,720);
        muroDerecha = new Rectangle(20,720);
        muroDerecha.setLayoutX(920);
        muroInferior.setLayoutY(700);
        muroSuperior.setFill(Color.DIMGRAY);
        muroInferior.setFill(Color.DIMGRAY);
        muroIzquierda.setFill(Color.DIMGRAY);
        muroDerecha.setFill(Color.DIMGRAY);
        //FILA 1
        block1 = bloqueFijo.crearBloqueFijo(80, 100);
        block2 = bloqueFijo.crearBloqueFijo(200, 100);
        block3 = bloqueFijo.crearBloqueFijo(320, 100);
        block4 = bloqueFijo.crearBloqueFijo(440, 100);
        block5 = bloqueFijo.crearBloqueFijo(560, 100);
        block6 = bloqueFijo.crearBloqueFijo(680, 100);
        block7 = bloqueFijo.crearBloqueFijo(800, 100);
        //FILA 2
        block8 = bloqueFijo.crearBloqueFijo(80, 220);
        block9 = bloqueFijo.crearBloqueFijo(200, 220);
        block10 = bloqueFijo.crearBloqueFijo(320, 220);
        block11 = bloqueFijo.crearBloqueFijo(440, 220);
        block12 = bloqueFijo.crearBloqueFijo(560, 220);
        block13 = bloqueFijo.crearBloqueFijo(680, 220);
        block14 = bloqueFijo.crearBloqueFijo(800, 220);
        //FILA 3
        block15 = bloqueFijo.crearBloqueFijo(80, 340);
        block16 = bloqueFijo.crearBloqueFijo(200, 340);
        block17 = bloqueFijo.crearBloqueFijo(320, 340);
        block18 = bloqueFijo.crearBloqueFijo(440, 340);
        block19 = bloqueFijo.crearBloqueFijo(560, 340);
        block20 = bloqueFijo.crearBloqueFijo(680, 340);
        block21 = bloqueFijo.crearBloqueFijo(800, 340);
        //FILA 4
        block22 = bloqueFijo.crearBloqueFijo(80, 460);
        block23 = bloqueFijo.crearBloqueFijo(200, 460);
        block24 = bloqueFijo.crearBloqueFijo(320, 460);
        block25 = bloqueFijo.crearBloqueFijo(440, 460);
        block27 = bloqueFijo.crearBloqueFijo(680, 460);
        block26 = bloqueFijo.crearBloqueFijo(560, 460);
        block28 = bloqueFijo.crearBloqueFijo(800, 460);
        //FILA 5
        block29 = bloqueFijo.crearBloqueFijo(80, 580);
        block30 = bloqueFijo.crearBloqueFijo(200, 580);
        block31 = bloqueFijo.crearBloqueFijo(320, 580);
        block32 = bloqueFijo.crearBloqueFijo(440, 580);
        block33 = bloqueFijo.crearBloqueFijo(560, 580);
        block34 = bloqueFijo.crearBloqueFijo(680, 580);
        block35 = bloqueFijo.crearBloqueFijo(800, 580);
        
        
        
        //block.setLayoutX(0);
        //block.setLayoutY(0);
        
//Manejo de stage y escena
        //
        root.getStylesheets().add(Juego.class.getResource("/Configuracion/EstiloJuego.css").toExternalForm());
        root.getChildren().addAll(muroSuperior,muroInferior,muroIzquierda,muroDerecha,hbBotones);
        root.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7);
        root.getChildren().addAll(block8, block9, block10, block11,block12,block13, block14);
        root.getChildren().addAll(block15, block16, block17, block18, block19, block20, block21);
        root.getChildren().addAll(block22, block23, block24, block25, block26, block27, block28);
        root.getChildren().addAll(block29, block30, block31, block32 ,block33, block34, block35);
        root.getChildren().addAll(Personaje,Enemigo1,Enemigo2);
        
       
    }
    
    
    
    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }
    
    
    

    
}