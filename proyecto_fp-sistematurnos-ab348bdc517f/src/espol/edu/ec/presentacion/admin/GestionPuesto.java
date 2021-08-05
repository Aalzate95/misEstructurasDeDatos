/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.modelo.Sistema;
import espol.edu.ec.modelo.tdas.Medico;
import espol.edu.ec.modelo.tdas.Puesto;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author scmz2607
 */
public class GestionPuesto {

    private static Pane content;
    private static TableView<Puesto> tablePuestos;
    private static ObservableList<Puesto> oec;
    private static ComboBox<Puesto> cbPuestos;
    private static ComboBox<Medico> cbMedicos;

    public static ComboBox<Puesto> getCbPuestos() {
        return cbPuestos;
    }

    public static Pane getContenido() {
        content = crearContenido();
        return content;
    }

    private static Pane crearContenido() {
        Gestion.btnPuestos.setDisable(true);
        Gestion.btnMedicos.setDisable(false);
        Gestion.btnPacientes.setDisable(false);
        
        VBox contenedor = new VBox();
        contenedor.setSpacing(15);
        contenedor.setPadding(new Insets(10, 10, 10, 10));

        Button btnCrear = new Button("Crear Nuevo");
        HBox hbBtnCrea = new HBox(btnCrear);
        centraEspacia(hbBtnCrea);
        Button btnAsignar = new Button("Asignar Medico");
        HBox hbBtnAsigna = new HBox(btnAsignar);
        centraEspacia(hbBtnAsigna);
        
        Label lblConsultorio = new Label("Consultorio a crear");
        TextField tfCreado = new TextField();
        tfCreado.setEditable(false);
        HBox hbConsultorio = new HBox(lblConsultorio, tfCreado);
        centraEspacia(hbConsultorio);
        Button btnConfirmaCreacion = new Button("Confirmar");
        Button btnCancelaCreacion = new Button("Cancelar");
        HBox hbConfirma = new HBox(btnConfirmaCreacion, btnCancelaCreacion);
        centraEspacia(hbConfirma);
        VBox vbConfirmaCreacion = new VBox(hbConsultorio, hbConfirma);
        centraEspacia(vbConfirmaCreacion);

        cbMedicos = new ComboBox<>(FXCollections.observableList(Sistema.getMedicos()));
        Label lblMedico = new Label("Elija Responsable");
        HBox hbMedico = new HBox(lblMedico, cbMedicos);
        centraEspacia(hbMedico);
        cbPuestos = new ComboBox<>(FXCollections.observableList(Sistema.getPuestos()));
        Label lblPuesto = new Label("Elija Consultorio");
        HBox hbPuesto = new HBox(lblPuesto, cbPuestos);
        centraEspacia(hbPuesto);

        Button btnGuardaAsigna = new Button("Guardar");
        Button btnCancelaAsigna = new Button("Cancelar");
        HBox hbGuardaCancela = new HBox(btnGuardaAsigna, btnCancelaAsigna);
        centraEspacia(hbGuardaCancela);
        VBox vbGuardaMedico = new VBox(hbPuesto, hbMedico, hbGuardaCancela);
        centraEspacia(vbGuardaMedico);

        btnCrear.setOnAction(e -> {
            tfCreado.setText(String.valueOf(Puesto.contadorPuesto + 1));
            btnCrear.setDisable(true);
            btnAsignar.setDisable(true);
            contenedor.getChildren().add(1, vbConfirmaCreacion);
        });

        btnConfirmaCreacion.setOnAction(e -> {
            Sistema.getPuestos().add(new Puesto());
            tfCreado.setText("");
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Se ha creado consultorio sin medico responsable");
            a.showAndWait();
            btnCrear.setDisable(false);
            btnAsignar.setDisable(false);
            contenedor.getChildren().remove(1);
        });

        btnCancelaCreacion.setOnAction(e -> {
            tfCreado.setText("");
            btnCrear.setDisable(false);
            btnAsignar.setDisable(false);
            contenedor.getChildren().remove(1);
        });

        btnGuardaAsigna.setOnAction(e -> {
            if (cbPuestos.getValue() == null && cbMedicos.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Elija Puesto!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Esta seguro de asignar nuevo responsable?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == OK) {
                    Medico m = cbMedicos.getValue();
                    Puesto p = cbPuestos.getValue();
                    alert.close();
                    m.setPuestoDeCambio(p);
                    if (!m.tieneConsultorio()) 
                        m.ejecutarCambio();
                    else{
                        alert.setContentText("Cambio a realizar una vez que el paciente en atencion desocupe el consultorio");
                    }
                    alert.setHeaderText("Operacion exitosa");
                    alert.showAndWait();
                    btnCrear.setDisable(false);
                    btnAsignar.setDisable(false);
                    contenedor.getChildren().remove(1);
                }
            }
            cbPuestos.setValue(null);
            cbMedicos.setValue(null);
        });

        btnCancelaAsigna.setOnAction(e -> {
            cbPuestos.setValue(null);
            cbMedicos.setValue(null);
            btnCrear.setDisable(false);
            btnAsignar.setDisable(false);
            contenedor.getChildren().remove(3);
        });

        btnAsignar.setOnAction(e -> {
            btnCrear.setDisable(true);
            btnAsignar.setDisable(true);
            contenedor.getChildren().add(3, vbGuardaMedico);
        });

        tablePuestos = new TableView<>();
        oec = FXCollections.observableList(Sistema.getPuestos());
        tablePuestos.setPrefWidth(370);
        tablePuestos.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        tablePuestos.setPadding(new Insets(10, 5, 0, 5));
        tablePuestos.setItems(oec);

        TableColumn<Puesto, Integer> id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Puesto, Medico> doctor = new TableColumn("Medico Encargado");
        doctor.setCellValueFactory(new PropertyValueFactory<>("medico"));
        tablePuestos.getColumns().addAll(id, doctor);

        Label lblRotTabla = new Label("CONSULTORIOS");
        lblRotTabla.setStyle("-fx-font-family: Chalkduster 12;");
        HBox rotTbl = new HBox(lblRotTabla);
        HBox hbTabla = new HBox(tablePuestos);
        contenedor.getChildren().addAll(hbBtnCrea, hbBtnAsigna, rotTbl, hbTabla);

        return contenedor;
    }

    public static TableView<Puesto> getTablePuestos() {
        return tablePuestos;
    }
    
    private static void centraEspacia(Node n){
        if (n instanceof HBox){
            ((HBox)n).setSpacing(10);
            ((HBox)n).setAlignment(Pos.CENTER);
        }
        if (n instanceof VBox){
            ((VBox)n).setSpacing(10);
            ((VBox)n).setAlignment(Pos.CENTER);
        }
            
    }
}
