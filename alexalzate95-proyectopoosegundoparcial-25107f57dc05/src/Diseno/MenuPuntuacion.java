/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Alexander Alzate
 */
public class MenuPuntuacion {
    public Pane root;
    Label lblTitulo;
    Button btnNombre,btnPuntaje,btnRegresar;
    HBox hbTitulo,hbBotones,hbTabla ;
    VBox PanelPuntuaciones;
    TreeSet<Player> Ranking;
    Stage stg;
    MenuPuntuacion (Stage Primary){
        lblTitulo = new Label("Ranking de Jugadores");
        stg = Primary;
        hbTitulo = new HBox(20,lblTitulo);
        lblTitulo.setTextFill(Color.DARKBLUE);
	lblTitulo.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
        hbTitulo.setAlignment(Pos.CENTER);
        btnNombre = new Button("Por Nombre");
        btnPuntaje = new Button("Por Puntaje");
        btnRegresar = new Button("Regresar");
        
        hbBotones =new HBox(20,btnNombre,btnPuntaje,btnRegresar);
        btnRegresar.setLayoutY(400);
        hbBotones.setAlignment(Pos.CENTER);
        VBox PanelPuntuaciones = new VBox();
        root = new VBox(10,hbTitulo,hbBotones,PanelPuntuaciones);
        PanelPuntuaciones.setSpacing(10);
        //PanelPuntuaciones.setMaxWidth(500);
        PanelPuntuaciones.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        /// Botones                                                                             ////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        btnRegresar.setOnAction(actionevent->{
                stg.setScene(new Scene(new MenuPrincipal(stg).getRoot(),900,640));
            });
        btnNombre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Ranking= new TreeSet<Player>();
                cargarDatosRanking();
                PanelPuntuaciones.getChildren().clear();
                GridPane gridpane = new GridPane();
                int fila = 0;
                ColumnConstraints c1 = new ColumnConstraints();
                c1.setPercentWidth(25);
                ColumnConstraints c2 = new ColumnConstraints();
                c2.setPercentWidth(25);
                ColumnConstraints c3 = new ColumnConstraints();
                c3.setPercentWidth(25);
        
                gridpane.getColumnConstraints().addAll(c1, c2, c3);
                for(Player jug:Ranking){
                   
                    gridpane.add(new Label(jug.getNombre()), 1, fila);
                    gridpane.add(new Label(String.valueOf(jug.getPuntaje())), 2, fila); 
                    gridpane.add(new Label(String.valueOf(jug.getTiempo())), 3, fila);  
                    fila++;
                }
                gridpane.setPadding(new Insets(10, 10, 10, 10)); 
                 
                PanelPuntuaciones.getChildren().add(gridpane);
                PanelPuntuaciones.setAlignment(Pos.CENTER); 
            }
        });
        btnPuntaje.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Ranking= new TreeSet<Player>(new OrdenPorPuntaje());
                cargarDatosRanking();
                PanelPuntuaciones.getChildren().clear();
                GridPane gridpane = new GridPane();
                int fila = 0;
                ColumnConstraints c1 = new ColumnConstraints();
                c1.setPercentWidth(25);
                ColumnConstraints c2 = new ColumnConstraints();
                c2.setPercentWidth(25);
                ColumnConstraints c3 = new ColumnConstraints();
                c3.setPercentWidth(25);
        
                gridpane.getColumnConstraints().addAll(c1, c2, c3);
                for(Player jug:Ranking){
                   
                    gridpane.add(new Label(jug.getNombre()), 1, fila);
                    gridpane.add(new Label(String.valueOf(jug.getPuntaje())), 2, fila); 
                    gridpane.add(new Label(String.valueOf(jug.getTiempo())), 3, fila);  
                    fila++;
                }
                gridpane.setPadding(new Insets(10, 10, 10, 10)); 
                 
                PanelPuntuaciones.getChildren().add(gridpane);
                PanelPuntuaciones.setAlignment(Pos.CENTER); 
            }
        });
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        root.getStylesheets().add(MenuPuntuacion.class.getResource("/Configuracion/EstiloMenu.css").toExternalForm());
        
        
    }
    public void  cargarDatosRanking(){
        try {
            BufferedReader br= new BufferedReader(new FileReader("Ranking.txt"));
            String linea;
            while ((linea=br.readLine())!=null){
                String[] datos=linea.split(",");
                Ranking.add(new Player(datos[0],Integer.parseInt(datos[1]),Integer.parseInt(datos[2])));
            }
            br.close();
        }catch (FileNotFoundException e){
            System.out.println("No existe el archivo que contiene los datos.  "+ e.getMessage());
        }catch (IOException e){
            System.out.println("Ha ocurrido un error al leer el archivo. "+ e.getMessage());
        }

    }
    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }
    
}
