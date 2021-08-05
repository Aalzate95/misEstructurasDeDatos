/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.modelo.Sistema;
import espol.edu.ec.modelo.tdas.Puesto;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author scmz2607
 */
public class Atencion {

    private static Pane content;
    private static ComboBox<Puesto> cbPuestosEnAtencion;

    public Atencion() {
        content = crearContenido();
        ((VBox) content).setStyle("-fx-border-color: darkblue;");
    }

    public Pane getContent() {
        return content;
    }

    private Pane crearContenido() {
        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(10, 10, 10, 10));
        contenedor.setSpacing(10);

        Label lblSel = new Label("Seleccione consultorio");
        lblSel.setStyle("-fx-font-family: Arial Rounded MT Bold 12;");
        cbPuestosEnAtencion = new ComboBox<>(FXCollections.observableList(Sistema.getConPaciente()));
        HBox hbSeleccion = new HBox(lblSel, cbPuestosEnAtencion);
        centraEspacia(hbSeleccion);

        cbPuestosEnAtencion.setOnAction(e -> {
            cbPuestosEnAtencion.setDisable(true);
            contenedor.getChildren().add(crearConsulta(cbPuestosEnAtencion.getValue()));

        });
        cbPuestosEnAtencion.getSelectionModel().select(null);

        contenedor.getChildren().addAll(hbSeleccion);
        return contenedor;
    }

    private static void centraEspacia(Node n) {
        if (n instanceof HBox) {
            ((HBox) n).setSpacing(10);
            ((HBox) n).setAlignment(Pos.CENTER);
        }
        if (n instanceof VBox) {
            ((VBox) n).setSpacing(10);
            ((VBox) n).setAlignment(Pos.CENTER);
        }

    }

    private static Pane crearConsulta(Puesto p) {
        VBox vbConsulta = new VBox();
        centraEspacia(vbConsulta);

        Label lblRotPaciente = new Label("DATOS PACIENTE");
        HBox hbRotDatos = new HBox(lblRotPaciente);
        centraEspacia(hbRotDatos);

        Label lblNomPaciente = new Label("Nombre: " + p.getPaciente().getNombres() + " "
                + p.getPaciente().getApellidos() + " \\| Edad: "
                + String.valueOf(p.getPaciente().getEdad()));
        lblNomPaciente.setText(lblNomPaciente.getText().toUpperCase());
        HBox hbNomPaciente = new HBox(lblNomPaciente);

        Label lblSintomas = new Label("Sintomas: " + p.getPaciente().getSintoma().toString());
        lblSintomas.setText(lblSintomas.getText().toUpperCase());
        HBox hbSintomas = new HBox(lblSintomas);

        Label lblPrescrip = new Label("PRESCRIPCION");
        HBox hbRotPrescrip = new HBox(lblPrescrip);
        centraEspacia(hbRotPrescrip);

        TextArea txtPrescrip = new TextArea();
        HBox hbPrescrip = new HBox(txtPrescrip);
        centraEspacia(hbPrescrip);

        Button btnGuardar = new Button("Guardar");
        Button btnCancelar = new Button("Cancelar");
        HBox hbBotones = new HBox(btnGuardar, btnCancelar);
        centraEspacia(hbBotones);

        btnGuardar.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            if (txtPrescrip.getText().trim().equals("")) {
                alert.setHeaderText("Registre Prescripcion!");
                alert.showAndWait();
            } else if (!p.getMedico().ejecutarCambio()) {
                Sistema.liberarConsultorio(p);
                alert.setHeaderText("Operacion Exitosa");
                alert.showAndWait();
                cbPuestosEnAtencion.setItems(FXCollections.observableList(Sistema.getConPaciente()));
            }

            cbPuestosEnAtencion.setDisable(false);
            vbConsulta.getChildren().clear();
        });

        btnCancelar.setOnAction(e -> {
            cbPuestosEnAtencion.setDisable(false);
            vbConsulta.getChildren().clear();
        });

        vbConsulta.getChildren().addAll(hbRotDatos, hbNomPaciente, hbSintomas, hbRotPrescrip, hbPrescrip, hbBotones);
        return vbConsulta;
    }
}
