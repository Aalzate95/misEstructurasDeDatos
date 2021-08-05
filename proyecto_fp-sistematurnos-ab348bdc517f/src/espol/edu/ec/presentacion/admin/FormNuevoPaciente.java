/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.modelo.Sistema;
import espol.edu.ec.presentacion.SistemaTurnosG3;
import espol.edu.ec.modelo.tdas.Paciente;
import espol.edu.ec.modelo.tdas.Sintoma;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormNuevoPaciente {

    private static BorderPane root;
    private static Stage ventanaForm;
    private static Scene sc;
    private static TextField tfcedu, tfnom, tfape, tfedad;
    private static ChoiceBox<Sintoma> cbsin;
    private static ChoiceBox cb;

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
        ventanaForm.setTitle("NUEVO PACIENTE");
        ventanaForm.setScene(sc);
        ventanaForm.initModality(Modality.WINDOW_MODAL);
        ventanaForm.initOwner(SistemaTurnosG3.primaryStage);
        ventanaForm.show();

    }

    private static Node crearSeccionTitulo() {
        HBox titulo = new HBox();
        titulo.setMaxHeight(30);
        titulo.setAlignment(Pos.CENTER);

        Label lblNuevo = new Label("REGISTRO NUEVO PACIENTE");
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

        Label gen = new Label("SEXO");
        gen.setFont(new Font("Berlin Sans FB", 13));
        gen.setLayoutX(50);
        gen.setLayoutY(150);

        Label edad = new Label("EDAD");
        edad.setFont(new Font("Berlin Sans FB", 13));
        edad.setLayoutX(50);
        edad.setLayoutY(200);

        Label sintoma = new Label("SINTOMA");
        sintoma.setFont(new Font("Berlin Sans FB", 13));
        sintoma.setLayoutX(50);
        sintoma.setLayoutY(250);

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
        tfedad.setLayoutY(200);
        //Creacion de un ChoiceBox para elegir el tipo de sintoma
        cbsin = new ChoiceBox();
        //Se utiliza el metodo privado que devuelve la lista de sintomas 
        LinkedList<Sintoma> ls = (LinkedList<Sintoma>) Sistema.getSintomas();
        //Sw agregan los sintomas al ChoiceBox
        cbsin.getItems().addAll(ls);
        cbsin.setLayoutX(250);
        cbsin.setLayoutY(250);

        //Creacion de un ChoiceBox para elegir entre masculino y femenino
        cb = new ChoiceBox();
        cb.getItems().addAll("M", "F");
        cb.setLayoutX(250);
        cb.setLayoutY(150);

        gp.getChildren().addAll(cedu, nom, ape, gen, edad, sintoma, tfcedu, tfnom,
                tfape, tfedad, cbsin, cb);
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
                if (tfnom.getText().equals("") || tfape.getText().equals("")
                        || tfedad.getText().equals("") || cb.getValue() == null
                        || tfcedu.getText().equals("") || cbsin.getValue() == null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("No se ha llenado uno o mas campos!");
                    alert.showAndWait();
                } else {
                    Paciente p = new Paciente(tfcedu.getText(), tfnom.getText(),
                            tfape.getText(), cb.getSelectionModel().getSelectedItem().toString(),
                            Integer.valueOf(tfedad.getText()), cbsin.getSelectionModel().getSelectedItem());
                    
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
            GestionPaciente.getTablePacientes().setItems(FXCollections.observableArrayList(Sistema.getPacientes()));
        });

        btnCancelar.setOnAction(e -> {
            limpiarDatosForm();
            ventanaForm.close();
        });

        return fondo;
    }

    private static void limpiarDatosForm() {
        tfnom.setText("");
        tfape.setText("");
        tfcedu.setText("");
        tfedad.setText("");
        cb.setValue(null);
        cbsin.setValue(null);
        
    }
}
