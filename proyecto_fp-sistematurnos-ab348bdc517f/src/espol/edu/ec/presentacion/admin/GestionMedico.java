/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.modelo.Sistema;
import espol.edu.ec.modelo.tdas.Medico;
import javafx.beans.property.SimpleObjectProperty;
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

/**
 *
 * @author scmz2607
 */
public class GestionMedico {
    private static Pane content;
    private static TableView<Medico> tableMedicos;
    private static ObservableList<Medico> oec;
    
    public static Pane getContenido(){
        content = crearContenido();
        return content;
    } 

    private static Pane crearContenido() {
        Gestion.btnPuestos.setDisable(false);
        Gestion.btnMedicos.setDisable(true);
        Gestion.btnPacientes.setDisable(false);
        VBox contenedor = new VBox();
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(10, 10, 10, 10));
        
        HBox hbnuevo = new HBox();
        Button btnNuevo = new Button("Nuevo Medico");
        btnNuevo.setOnAction(e->{
            FormNuevoMedico.mostrar();
            
        });
        hbnuevo.getChildren().add(btnNuevo);
        
        tableMedicos = new TableView<>();
        oec = FXCollections.observableArrayList(Sistema.getMedicos());
//        tablePacientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableMedicos.setPrefWidth(400);
        tableMedicos.setPadding(new Insets(10, 5, 0, 5));
        tableMedicos.setItems(oec);
        
        TableColumn<Medico, String> cedula = new TableColumn("Cedula");
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        TableColumn<Medico, String> nombres = new TableColumn("Nombres");
        nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        TableColumn<Medico, String> apellidos = new TableColumn("Apellidos");
        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        TableColumn<Medico, Integer> edad = new TableColumn("Edad");
        edad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        TableColumn<Medico, Integer> puesto = new TableColumn("Puesto");
        puesto.setCellValueFactory((TableColumn.CellDataFeatures<Medico, Integer> param) -> {
            if(param.getValue().getPuesto()!=null)
                return new SimpleObjectProperty<>(param.getValue().getPuesto().getId());
            else
                return null;
        });
        tableMedicos.getColumns().addAll(cedula,nombres,apellidos,edad,puesto);
        tableMedicos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        contenedor.getChildren().addAll(hbnuevo,tableMedicos);
        return contenedor;
    }

    public static TableView<Medico> getTableMedicos() {
        return tableMedicos;
    }

    public static void setTableMedicos(TableView<Medico> tableMedicos) {
        GestionMedico.tableMedicos = tableMedicos;
    }
   
}
