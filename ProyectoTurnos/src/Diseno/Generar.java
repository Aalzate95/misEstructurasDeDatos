/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import Main.CargarSistema;
import Tdas.Paciente;
import Tdas.Sintoma;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author alexa
 */
public class Generar {
    private Pane root;
    private static Button btnRegresar,btnGenerar;
    private static Label lblCedula,lblNombre,lblApellido,lblGenero,lblEdad,lblSintoma;
    private static TextField txtCedula,txtNombre,txtApellido,txtEdad;
    private static ComboBox cmbGenero;
    private static ComboBox<Sintoma> cmbSintoma;
    Stage stg;
    Generar(Stage primary){
        root = new Pane();
        stg = primary;
        btnRegresar = new Button("Regresar");
        btnGenerar = new Button("Generar");
        lblCedula = new Label("CEDULA");
        lblNombre = new Label("NOMBRE");
        lblApellido = new Label("APELLIDO");
        lblGenero = new Label("GENERO");
        lblEdad = new Label("EDAD");
        lblSintoma = new Label("SINTOMA");
        txtCedula = new TextField();
        txtNombre =new TextField();
        txtApellido =new TextField();
        cmbGenero =new ComboBox();
        txtEdad = new TextField();
        cmbSintoma =new ComboBox();
        
        //botones
        btnRegresar.setOnAction(actionevent->{
                stg.setScene(new Scene(new Administrar(stg).getRoot(),900,640));
            });
        btnGenerar.setOnAction(e -> {
            //Se escribe en el archivo de texto el nuevo paciente que ha llegado
            try {
                if (txtNombre.getText().equals("") || txtApellido.getText().equals("")
                        || txtEdad.getText().equals("") || cmbGenero.getValue() == null
                        || txtCedula.getText().equals("") || cmbSintoma.getValue() == null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("No se ha llenado uno o mas campos!");
                    alert.showAndWait();
                } else {
                    Paciente p = new Paciente(txtCedula.getText(), txtNombre.getText(),
                            txtApellido.getText(), cmbGenero.getSelectionModel().getSelectedItem().toString(),
                            Integer.valueOf(txtEdad.getText()), cmbSintoma.getSelectionModel().getSelectedItem());
                    
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                    a1.setTitle("SISTEMA");
                    a1.setContentText("DATOS GUARDADOS CORRECTAMENTE");
                    a1.showAndWait();
                    
                    limpiarDatosForm();

                }
            }catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Ingrese valores numericos en la edad!");
                alert.showAndWait();
                limpiarDatosForm();
            }
            Administrar.getTbvDatos().setItems(FXCollections.observableArrayList(CargarSistema.getListPacientes()));
        });
        //diseno
        lblCedula.setLayoutX(50);
        lblCedula.setLayoutY(50);
        txtCedula.setLayoutX(50);
        txtCedula.setLayoutY(100);
        
        
        lblNombre.setLayoutY(150);
        lblNombre.setLayoutX(50);
        txtNombre.setLayoutX(50);
        txtNombre.setLayoutY(200);
        
        
        lblApellido.setLayoutY(250);
        lblApellido.setLayoutX(50);
        txtApellido.setLayoutY(300);
        txtApellido.setLayoutX(50);
        
        
        lblGenero.setLayoutY(50);
        lblGenero.setLayoutX(550);
        cmbGenero.setLayoutY(100);
        cmbGenero.setLayoutX(550);
        
        
        lblEdad.setLayoutY(150);
        lblEdad.setLayoutX(550);
        txtEdad.setLayoutY(200);
        txtEdad.setLayoutX(550);
        
        
        lblSintoma.setLayoutY(250);
        lblSintoma.setLayoutX(550);
        cmbSintoma.setLayoutY(300);
        cmbSintoma.setLayoutX(550);
        
        
        btnRegresar.setLayoutX(280);
        btnRegresar.setLayoutY(480);
        btnRegresar.setPrefSize(130, 20);
        btnGenerar.setLayoutX(480);
        btnGenerar.setLayoutY(480);
        btnGenerar.setPrefSize(130, 20);
        root.getChildren().addAll(btnRegresar,btnGenerar,lblCedula,lblNombre,lblApellido,lblGenero,lblEdad,lblSintoma,txtCedula,txtNombre,txtApellido,cmbGenero,txtEdad,cmbSintoma);
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

    public Button getBtnGenerar() {
        return btnGenerar;
    }

    public void setBtnGenerar(Button btnGenerar) {
        this.btnGenerar = btnGenerar;
    }

    public Stage getStg() {
        return stg;
    }

    public void setStg(Stage stg) {
        this.stg = stg;
    }
    private static void limpiarDatosForm() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        cmbGenero.setValue(null);
        cmbSintoma.setValue(null);
        
    }

    
}
