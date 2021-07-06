/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Diseno.Administrar;
import Diseno.Pantalla;
import Tdas.Paciente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author alexa
 */
public class ProyectoTurnos extends Application {
    Stage ventanaPantalla;
    @Override
    public void start(Stage primaryStage) {
        ventanaPantalla = new Stage();
        Administrar Inicio = new Administrar(primaryStage);
        //Pantalla pantalla = new Pantalla(ventanaPantalla);
        Scene scene1 = new Scene(Inicio.getRoot(),900,640);
        
        //Scene scene2 = new Scene(Inicio.getRoot(),900,640);
        CargarSistema.cargarDatos();
        
        primaryStage.setScene(scene1);
        
        //ventanaPantalla.setScene(scene2);
        primaryStage.show();
        //ventanaPantalla.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
