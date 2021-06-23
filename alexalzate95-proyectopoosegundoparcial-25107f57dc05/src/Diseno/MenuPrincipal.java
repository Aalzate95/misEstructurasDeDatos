/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;
//https://stackoverflow.com/questions/21073941/creating-multiple-stages-in-javafx 
//http://www.learningaboutelectronics.com/Articles/How-to-create-multiple-scenes-and-switch-between-scenes-in-JavaFX.php
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Alexander Alzate
 */
public class MenuPrincipal  {
    private Pane root;
    Scene NuevoJuego,Instrucciones,TablaPosiciones;
    Stage stg;
    
    Button btnNuevo, btnInstrucciones,btnPuntuacion;
    Image CargarTitulo = new Image("/Images/bm-titulo.png");
    Image CargarFiec = new Image("/Images/logo-fiec.png");
    
    public MenuPrincipal(Stage primary){
        root = new Pane();
        ImageView imageTitulo = new ImageView();
        ImageView imageFiec = new ImageView();
        Group grpTitulo = new Group(imageTitulo,imageFiec);
        
//BOTONES        
        btnNuevo = new Button("Nuevo juego");
        btnInstrucciones = new Button("Instrucciones");
        btnPuntuacion=new Button("Tabla Puntuaciones");
        /*btnNuevo.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            new Juego();
            primary.close();
        }
        });*/
        btnNuevo.setOnAction(actionevent->{
                stg.setScene(new Scene(new Juego(stg).getRoot(),940,730, Color.CORNSILK));
                });
        btnInstrucciones.setOnAction(actionevent->{
                stg.setScene(new Scene(new MenuInstrucciones(stg).getRoot(),900,640));
                });
        btnPuntuacion.setOnAction(actionevent->{
                stg.setScene(new Scene(new MenuPuntuacion(stg).getRoot(),900,640));
                });
        stg = primary;
        
//DISENO ESCENA
        root.getStylesheets().add(MenuPrincipal.class.getResource("/Configuracion/EstiloMenu.css").toExternalForm());
        btnNuevo.setLayoutX(360);
        btnNuevo.setLayoutY(280);
        btnNuevo.setPrefSize(180, 20);
        btnInstrucciones.setLayoutX(360);
        btnInstrucciones.setLayoutY(330);
        btnInstrucciones.setPrefSize(180, 20);
        btnPuntuacion.setLayoutX(360);
        btnPuntuacion.setLayoutY(380);
        btnPuntuacion.setPrefSize(180, 20);
        imageTitulo.setImage(CargarTitulo);
        imageTitulo.setFitHeight(250);
        imageTitulo.setFitWidth(480);
        imageTitulo.setLayoutX(180);
        imageTitulo.setLayoutY(10);
        imageFiec.setImage(CargarFiec);
        imageFiec.setFitHeight(150);
        imageFiec.setFitWidth(400);
        imageFiec.setLayoutY(500);
        
        root.getChildren().addAll(btnNuevo,btnInstrucciones,btnPuntuacion,grpTitulo);
    }
    
    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }



    
    
}
    
    
   
        

