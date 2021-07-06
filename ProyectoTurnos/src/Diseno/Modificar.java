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
public class Modificar {
    private Pane root;
    Button btnRegresar,btnModificar;
    Stage stg;

    Modificar(Stage primary){
        root = new Pane();
        stg = primary;
        btnRegresar = new Button("Regresar");
        btnModificar = new Button("Modificar");
        //botones
        btnRegresar.setOnAction(actionevent->{
                stg.setScene(new Scene(new Administrar(stg).getRoot(),900,640));
            });
        //diseno
        btnRegresar.setLayoutX(280);
        btnRegresar.setLayoutY(480);
        btnRegresar.setPrefSize(130, 20);
        btnModificar.setLayoutX(480);
        btnModificar.setLayoutY(480);
        btnModificar.setPrefSize(130, 20);
        root.getChildren().addAll(btnRegresar,btnModificar);
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

    public Stage getStg() {
        return stg;
    }

    public void setStg(Stage stg) {
        this.stg = stg;
    }
    
}
