/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author alexa
 */
public class EliminarTurno {
    private Pane root;
    Button btnRegresar,btnEliminar;
    Stage stg;
    EliminarTurno(Stage primary){
        root = new Pane();
        stg = primary;
        //BOTONES
        btnRegresar = new Button("Regresar");
        btnEliminar = new Button("Eliminar");
        btnRegresar.setOnAction(actionevent->{
                stg.setScene(new Scene(new Administrar(stg).getRoot(),900,640));
            });
        
        //diseno
        btnRegresar.setLayoutX(280);
        btnRegresar.setLayoutY(480);
        btnRegresar.setPrefSize(130, 20);
        btnEliminar.setLayoutX(480);
        btnEliminar.setLayoutY(480);
        btnEliminar.setPrefSize(130, 20);
        
        
        root.getChildren().addAll(btnRegresar,btnEliminar);
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public Button getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(Button btnRegresar) {
        this.btnRegresar = btnRegresar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Button btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public Stage getStg() {
        return stg;
    }

    public void setStg(Stage stg) {
        this.stg = stg;
    }
    
}
