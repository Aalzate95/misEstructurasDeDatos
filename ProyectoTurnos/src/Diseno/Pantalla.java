/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import Tdas.Paciente;
import java.util.List;
import java.util.ListIterator;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author alexa
 */
public class Pantalla {
    private Pane root;
    private static MediaView mv;
    private static MediaPlayer mp;
    private static List<Media> lmedia;
    private static ListIterator<Media> lit;
    Stage stg;
    public Pantalla(Stage primary){
        root = new Pane();
        
    }
        
    
}
