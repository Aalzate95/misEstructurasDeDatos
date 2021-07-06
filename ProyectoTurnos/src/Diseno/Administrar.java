/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import Main.CargarSistema;
import Tdas.Paciente;
import Tdas.Sintoma;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author alexa
 */
public class Administrar {
    private Pane root;
    Stage stg;
    Button btnGenerar,btnModificar,btnEliminar;
    private static TableView<Paciente> tbvDatos;
    private static ObservableList<Paciente> datos;
    public Administrar(Stage primary){
        root = new Pane();
        CargarSistema.cargarDatos();
        //BOTONES
        btnGenerar= new Button("Generar Turno");
        btnModificar = new Button("Modificar Turno");
        btnEliminar = new Button("Eliminar turno");
        btnModificar.setOnAction(actionevent->{
                stg.setScene(new Scene(new Modificar(stg).getRoot(),940,730, Color.CORNSILK));
                });
        btnGenerar.setOnAction(actionevent->{
                stg.setScene(new Scene(new Generar(stg).getRoot(),900,640));
                });
        btnEliminar.setOnAction(actionevent->{
                stg.setScene(new Scene(new EliminarTurno(stg).getRoot(),900,640));
                });
        //TABLA DE DATOS
        tbvDatos = new TableView<>();
        tbvDatos.setPrefWidth(500);
        
        tbvDatos.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        tbvDatos.setPadding(new Insets(10, 5, 0, 5));
        datos = FXCollections.observableList(CargarSistema.getListPacientes());
        
        /*
        TableColumn<Turno, String> turno = new TableColumn("Turno");
        turno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        */
        TableColumn<Paciente, String> cedula = new TableColumn("Cedula");
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        
        TableColumn<Paciente, String> nombres = new TableColumn("Nombre");
        nombres.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        
        TableColumn<Paciente, String> apellidos = new TableColumn("Apellido");
        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        
        TableColumn<Paciente, Integer> edad = new TableColumn("Edad");
        edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        
        TableColumn<Paciente, String> sintoma = new TableColumn("Sintoma");
        
        sintoma.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Paciente, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Paciente, String> param) {
                return new SimpleObjectProperty<>(param.getValue().getSintoma().getNombre());
            }
        });
        
        tbvDatos.setItems(datos);
        
        tbvDatos.getColumns().addAll(cedula,nombres,apellidos,edad,sintoma);
        
        HBox hbTabla = new HBox(tbvDatos);
        hbTabla.setLayoutX(300);
        hbTabla.setLayoutY(150);
        //DISENO
        btnGenerar.setLayoutX(100);
        btnGenerar.setLayoutY(280);
        btnGenerar.setPrefSize(180, 20);
        btnModificar.setLayoutX(100);
        btnModificar.setLayoutY(330);
        btnModificar.setPrefSize(180, 20);
        btnEliminar.setLayoutX(100);
        btnEliminar.setLayoutY(380);
        btnEliminar.setPrefSize(180, 20);
        stg = primary;
        
        root.getChildren().addAll(btnGenerar,btnModificar,btnEliminar,hbTabla);
        
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public Stage getStg() {
        return stg;
    }

    public void setStg(Stage stg) {
        this.stg = stg;
    }

    public Button getBtnGenerar() {
        return btnGenerar;
    }

    public void setBtnGenerar(Button btnGenerar) {
        this.btnGenerar = btnGenerar;
    }

    public Button getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(Button btnModificar) {
        this.btnModificar = btnModificar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Button btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public static TableView<Paciente> getTbvDatos() {
        return tbvDatos;
    }

    public void setTbvDatos(TableView<Paciente> tbvDatos) {
        this.tbvDatos = tbvDatos;
    }

    public static ObservableList<Paciente> getDatos() {
        return datos;
    }

    public static void setDatos(ObservableList<Paciente> datos) {
        Administrar.datos = datos;
    }
    
}
