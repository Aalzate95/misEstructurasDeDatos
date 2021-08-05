/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.utilitarios.CONSTANTES;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author scmz2607
 */
public class Gestion {
    private static Pane content;
    public static Button btnPacientes;
    public static Button btnMedicos;
    public static Button btnPuestos;
            
    public Gestion() {
        content = crearContenido();
        ((BorderPane)content).getCenter().setStyle("-fx-border-color: darkblue;");
    }
    
    public Pane getContent() {
        return content;
    }
    
    private Pane crearContenido() {
        BorderPane contenedor = new BorderPane();
        contenedor.setPadding(new Insets(10,10,10,10));
        contenedor.setLeft(crearLeft());
        BorderPane centro = new BorderPane();
        centro.setPrefWidth(CONSTANTES.ANCHO_MENUADMIN - 80);
        contenedor.setCenter(centro);
        return contenedor;
    }

    private static Pane crearLeft() {
        VBox vbLeftGestion = new VBox();
        
        btnPacientes = new Button("Pacientes");
        btnPacientes.setPrefWidth(150);
        btnMedicos = new Button("Medicos");
        btnMedicos.setPrefWidth(150);
        btnPuestos = new Button("Puestos Medicos");
        btnPuestos.setPrefWidth(150);
        
        GridPane gp = new GridPane();
        gp.add(btnPacientes, 0, 0);
        gp.add(btnMedicos, 0, 1);
        gp.add(btnPuestos, 0, 2);
        gp.autosize();
        gp.setGridLinesVisible(true);
        gp.setStyle("-fx-opcity: 0.5; -fx-background-color: RGB(255,200,255);");
        gp.setPadding(new Insets(10,10,10,10));
        
        vbLeftGestion.getChildren().addAll(gp);
        
        btnPacientes.setOnAction(e->{
            ((BorderPane)content).setCenter(GestionPaciente.getContenido());
        });
        
        btnMedicos.setOnAction(e->{
            ((BorderPane)content).setCenter(GestionMedico.getContenido());
        });
        
        btnPuestos.setOnAction(e->{
            ((BorderPane)content).setCenter(GestionPuesto.getContenido());
        });
        
        return vbLeftGestion;
    }
}
    
    
    
