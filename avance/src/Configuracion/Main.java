/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import Diseno.MenuPrincipal;
import Diseno.MenuPrincipal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author
 */
public class Main extends Application{

    /**Aqui es donde se ejecutara todo el codigo
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
               
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
                
        MenuPrincipal Inicio = new MenuPrincipal(primaryStage);
        Scene scene = new Scene(Inicio.getRoot(),900,640);    
        //root.getRoot().getStylesheets().add(Main.class.getResource("/Configuracion/Estilo.css").toExternalForm());
        
        primaryStage.getIcons().add(new Image("/Images/icon.png")); 
        primaryStage.setTitle("Bomberman");
        //primaryStage.setOnCloseRequest(e->{Platform.exit();System.exit(0);});
        primaryStage.setScene(scene);
        primaryStage.show();
        Utilidades.reproducirSonido("Intro.mp3");
        
    }
}
    
