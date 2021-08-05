/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.modelo.Sistema;
import espol.edu.ec.modelo.tdas.Paciente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author scmz2607
 */
public class GestionPaciente {
    private static Pane content;
    private static TableView<Paciente> tablePacientes;
    private static ObservableList<Paciente> oec;
    
    public static Pane getContenido(){
        content = crearContenido();
        return content;
    } 

    private static Pane crearContenido() {
        Gestion.btnPuestos.setDisable(false);
        Gestion.btnMedicos.setDisable(false);
        Gestion.btnPacientes.setDisable(true);
        VBox contenedor = new VBox();
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(10, 10, 10, 10));
        
        HBox hbnuevo = new HBox();
        Button btnNuevo = new Button("Nuevo Paciente");
        btnNuevo.setOnAction(e->{
            FormNuevoPaciente.mostrar();
            
        });
        hbnuevo.getChildren().add(btnNuevo);
        
        tablePacientes = new TableView<>();
        oec = FXCollections.observableArrayList(Sistema.getPacientes());
//        tablePacientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tablePacientes.setPrefWidth(500);
        tablePacientes.setPadding(new Insets(10, 5, 0, 5));
        tablePacientes.setItems(oec);
        
        TableColumn<Paciente, String> turno = new TableColumn("Turno");
        turno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        TableColumn<Paciente, String> cedula = new TableColumn("Cedula");
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        TableColumn<Paciente, String> nombres = new TableColumn("Nombres");
        nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        TableColumn<Paciente, String> apellidos = new TableColumn("Apellidos");
        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        TableColumn<Paciente, Integer> edad = new TableColumn("Edad");
        edad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        TableColumn<Paciente, String> sintoma = new TableColumn("Sintoma");
        sintoma.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Paciente, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Paciente, String> param) {
                return new SimpleObjectProperty<>(param.getValue().getSintoma().getTipo());
            }
        });
        tablePacientes.getColumns().addAll(turno,cedula,nombres,apellidos,edad,sintoma);
//        tablePacientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        contenedor.getChildren().addAll(hbnuevo,tablePacientes);
        return contenedor;
    }

    public static TableView<Paciente> getTablePacientes() {
        return tablePacientes;
    }

    public static void setTablePacientes(TableView<Paciente> tablePacientes) {
        GestionPaciente.tablePacientes = tablePacientes;
    }
   
}
