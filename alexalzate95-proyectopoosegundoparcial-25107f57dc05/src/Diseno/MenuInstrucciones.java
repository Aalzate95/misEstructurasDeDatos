/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 *
 * @author Alexander Alzate
 */
public class MenuInstrucciones {
    
    private Pane root;
    Button btnRegresar;
    Stage stg;
    ImageView Arriba,Abajo,Derecha,Izquierda,Tecla;
    Image cargarArriba = new Image("/Images/arriba.png");
    Image cargarAbajo = new Image("/Images/abajo.png");
    Image cargarDerecha = new Image("/Images/derecha.png");
    Image cargarIzquierda = new Image("/Images/izquierda.png");
    Image cargarTecla = new Image("/Images/tecla.png");
    Label lblDesplazamiento,lblBomba;
    MenuInstrucciones(Stage primary){
        root = new Pane();
        Arriba = new ImageView();
        Abajo = new ImageView();
        Derecha = new ImageView();
        Izquierda = new ImageView();
        Tecla = new ImageView();
        lblDesplazamiento = new Label("Desplazamiento");
        lblBomba = new Label("Colocar Bomba");
        
//BOTONES        
        btnRegresar = new Button("Regresar");
        btnRegresar.setOnAction(actionevent->{
                stg.setScene(new Scene(new MenuPrincipal(stg).getRoot(),900,640));
            });
        stg = primary;
        
        
        
 //IMAGENES
        Arriba.setFitHeight(50);
        Arriba.setFitWidth(50);
        Arriba.setImage(cargarArriba);
        Abajo.setFitHeight(50);
        Abajo.setFitWidth(50);
        Abajo.setImage(cargarAbajo);
        Derecha.setFitHeight(50);
        Derecha.setFitWidth(50);
        Derecha.setImage(cargarDerecha);
        Izquierda.setFitHeight(50);
        Izquierda.setFitWidth(50);
        Izquierda.setImage(cargarIzquierda);
        Tecla.setFitHeight(50);
        Tecla.setFitWidth(50);
        Tecla.setImage(cargarTecla);
        
//DISENO ESCENA        
        root.getStylesheets().add(MenuInstrucciones.class.getResource("/Configuracion/EstiloMenu.css").toExternalForm());
        btnRegresar.setLayoutX(380);
        btnRegresar.setLayoutY(480);
        btnRegresar.setPrefSize(130, 20);
        Arriba.setLayoutX(200);
        Arriba.setLayoutY(90);
        Abajo.setLayoutX(200);
        Abajo.setLayoutY(180);
        Derecha.setLayoutX(250);
        Derecha.setLayoutY(135);
        Izquierda.setLayoutX(150);
        Izquierda.setLayoutY(135);
        Tecla.setLayoutX(200);
        Tecla.setLayoutY(310);
        lblDesplazamiento.setLayoutX(350);
        lblDesplazamiento.setLayoutY(145);
        lblBomba.setLayoutX(350);
        lblBomba.setLayoutY(320);
        lblBomba.setTextFill(Color.LIGHTGREY);
        lblDesplazamiento.setTextFill(Color.LIGHTGREY);
        lblBomba.setFont(Font.font("Arial Black",30));
        lblDesplazamiento.setFont(Font.font("Arial Black",30));
        root.getChildren().addAll(btnRegresar,Arriba,Abajo,Derecha,Tecla,Izquierda,lblDesplazamiento,lblBomba);
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    

}
