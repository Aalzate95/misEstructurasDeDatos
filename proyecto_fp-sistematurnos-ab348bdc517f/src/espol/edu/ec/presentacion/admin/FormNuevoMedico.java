/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.modelo.Sistema;
import espol.edu.ec.modelo.tdas.Medico;
import espol.edu.ec.modelo.tdas.Puesto;
import espol.edu.ec.presentacion.SistemaTurnosG3;
import java.util.LinkedList;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author scmz2607
 */
public class FormNuevoMedico {

    private static BorderPane root;
    private static Stage ventanaForm;
    private static Scene sc;
    private static TextField tfcedu, tfnom, tfape, tfedad;
    private static ChoiceBox<Puesto> cbPuesto;

    public static void mostrar() {
        //Creacion de los labels 
        root = new BorderPane();
        root.setPrefSize(500, 500);
        root.setPadding(new Insets(10, 10, 10, 10));

        root.setTop(crearSeccionTitulo());
        root.setCenter(crearSeccionDatos());
        root.setBottom(crearSeccionPie());

        sc = new Scene(root);
        ventanaForm = new Stage();
        ventanaForm.setTitle("NUEVO MEDICO");
        ventanaForm.setScene(sc);
        ventanaForm.initModality(Modality.WINDOW_MODAL);
        ventanaForm.initOwner(SistemaTurnosG3.primaryStage);
        ventanaForm.show();

    }

    private static Node crearSeccionTitulo() {
        HBox titulo = new HBox();
        titulo.setMaxHeight(30);
        titulo.setAlignment(Pos.CENTER);

        Label lblNuevo = new Label("REGISTRO NUEVO MEDICO");
        titulo.getChildren().add(lblNuevo);

        return titulo;
    }

    private static Node crearSeccionDatos() {
        Group gp = new Group();
        gp.setLayoutY(0);

        Label cedu = new Label("CEDULA");
        cedu.setFont(new Font("Berlin Sans FB", 13));
        cedu.setLayoutX(50);
        cedu.setLayoutY(0);

        Label nom = new Label("NOMBRES");
        nom.setFont(new Font("Berlin Sans FB", 13));
        nom.setLayoutX(50);
        nom.setLayoutY(50);

        Label ape = new Label("APELLIDOS");
        ape.setFont(new Font("Berlin Sans FB", 13));
        ape.setLayoutX(50);
        ape.setLayoutY(100);

        Label edad = new Label("EDAD");
        edad.setFont(new Font("Berlin Sans FB", 13));
        edad.setLayoutX(50);
        edad.setLayoutY(150);

        Label puesto = new Label("PUESTO");
        puesto.setFont(new Font("Berlin Sans FB", 13));
        puesto.setLayoutX(50);
        puesto.setLayoutY(200);

        //Creacion de los campos de texto
        tfcedu = new TextField();
        tfcedu.setLayoutX(250);
        tfcedu.setLayoutY(0);

        tfnom = new TextField();
        tfnom.setLayoutX(250);
        tfnom.setLayoutY(50);

        tfape = new TextField();
        tfape.setLayoutX(250);
        tfape.setLayoutY(100);

        tfedad = new TextField();
        tfedad.setLayoutX(250);
        tfedad.setLayoutY(150);
        //Creacion de un ChoiceBox para elegir el tipo de sintoma
        cbPuesto = new ChoiceBox();
        //Se utiliza el metodo privado que devuelve la lista de sintomas 
        LinkedList<Puesto> ls = (LinkedList<Puesto>) Sistema.getPuestos();
        //Sw agregan los sintomas al ChoiceBox
        cbPuesto.getItems().addAll(ls);
        cbPuesto.setLayoutX(250);
        cbPuesto.setLayoutY(200);

        gp.getChildren().addAll(cedu, nom, ape, edad, puesto, tfcedu, tfnom,
                tfape, tfedad, cbPuesto);
        return gp;
    }

    private static Node crearSeccionPie() {
        HBox fondo = new HBox();
        fondo.setPrefHeight(30);
        fondo.setAlignment(Pos.CENTER);
        fondo.setSpacing(10);
        fondo.setPadding(new Insets(10, 0, 0, 0));

        Button btnGuardar = new Button("Guardar");
        Button btnCancelar = new Button("Cancelar");

        fondo.getChildren().addAll(btnGuardar, btnCancelar);

        btnGuardar.setOnAction(e -> {
            //Se escribe en el archivo de texto el nuevo paciente que ha llegado
            try {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                a1.setTitle("SISTEMA");
                a1.setContentText("DATOS GUARDADOS CORRECTAMENTE");
                if (tfnom.getText().equals("") || tfape.getText().equals("")
                        || tfedad.getText().equals("") || tfcedu.getText().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("No se ha llenado uno o mas campos!");
                    alert.showAndWait();
                } else {

                    Medico m = new Medico(tfcedu.getText(), tfnom.getText(),
                            tfape.getText(),
                            Integer.valueOf(tfedad.getText()));

                    if (cbPuesto.getValue() != null && cbPuesto.getValue().tieneEncargado()) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("PUESTO YA ASIGNADO");
                        alert.setContentText("Desea confirmar reasignacion a este medico?");
                        Optional<ButtonType> result = alert.showAndWait();

                        if (result.get() == OK) {
                            cbPuesto.getValue().getMedico().setPuesto(null);
                            m.setPuesto(cbPuesto.getValue());
                            Sistema.getMedicos().add(m);
                            a1.showAndWait();
                            ventanaForm.close();
                        } else if(result.get() == ButtonType.CANCEL){
                            cbPuesto.setValue(null);
                        }
                    } else {
                        m.setPuesto(cbPuesto.getValue());
                        Sistema.getMedicos().add(m);
//                        a1.showAndWait();
                        limpiarDatosForm();
                        ventanaForm.close();
                    }
                    
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Ingrese valores numericos en la edad!");
                alert.showAndWait();
            }
            GestionMedico.getTableMedicos().setItems(FXCollections.observableArrayList(Sistema.getMedicos()));
        }
        );

        btnCancelar.setOnAction(e
                -> {
                    limpiarDatosForm();
                    ventanaForm.close();
                }
        );

        return fondo;
    }

    ;

    

    private static void limpiarDatosForm() {
        tfnom.setText("");
        tfape.setText("");
        tfcedu.setText("");
        tfedad.setText("");
        cbPuesto.setValue(null);

    }
}
