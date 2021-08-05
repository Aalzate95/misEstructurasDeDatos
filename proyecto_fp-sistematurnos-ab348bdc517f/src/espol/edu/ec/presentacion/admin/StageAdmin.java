/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.admin;

import espol.edu.ec.presentacion.SistemaTurnosG3;
import espol.edu.ec.presentacion.pantalla.Pantalla;
import espol.edu.ec.utilitarios.CONSTANTES;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author scmz2607
 */
public class StageAdmin {
    
    private static BorderPane root;
    private static Scene scAdmin;
    private static Gestion leftGestion;
    private static Atencion leftAtencion;
    public static Button btnGestion;
    
    public static Scene crearMA() {
        Pantalla.mostrar();
        root = new BorderPane();
        root.setStyle("-fx-border-color: black;");
        try {
            Image img = new Image(SistemaTurnosG3.class.getResourceAsStream(
                    CONSTANTES.RUTA_IMAGENES + "2.jpg"));
            Image image = new Image(SistemaTurnosG3.class.getResourceAsStream(
                    CONSTANTES.RUTA_IMAGENES + "logo.png"));
            ImageView im = new ImageView(image);
            Background Bg = new Background(new BackgroundImage(img,
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    new BackgroundSize(563, 352, false, false, true, true)));
            root.setBackground(Bg);
            root.setTop(crearTop(im));
        } catch (Exception e) {
            System.out.println("no hay imagen");
        }
        scAdmin = new Scene(root, CONSTANTES.ANCHO_MENUADMIN, CONSTANTES.ALTO_MENUADMIN);
        return scAdmin;
    }
    
    private static Pane crearTop(ImageView imv) {
        VBox vbTop = new VBox();
        vbTop.setSpacing(10);
        
        HBox hbMenu = new HBox();
        hbMenu.setStyle("-fx-background-color: gray; -fx-backgroun-opacity: 0.5;");
        HBox hbPrimero = new HBox();
        hbPrimero.setSpacing(10);
        
        imv.setFitHeight(100);
        imv.setFitWidth(100);
        imv.setLayoutX(10);
        imv.setLayoutY(10);
        Label lblMenuAdmin = new Label("MENU DE AMINISTRADOR");
        lblMenuAdmin.setLayoutX(CONSTANTES.ANCHO_MENUADMIN / 4.0);
        lblMenuAdmin.setLayoutY(30);
        lblMenuAdmin.setFont(new Font("sans-serif bold", 20));
        lblMenuAdmin.setStyle("-fx-text-fill: gray;");
        
        hbPrimero.getChildren().addAll(imv, lblMenuAdmin);
        btnGestion = new Button("Gestion");
        btnGestion.setPadding(new Insets(10, 20, 10, 20));
        Button btnAtencion = new Button("Atencion");
        btnAtencion.setPadding(new Insets(10, 20, 10, 20));
        hbMenu.getChildren().addAll(btnGestion, btnAtencion);
        
//Eventos del Menu
        btnGestion.setOnAction(e -> {
            btnAtencion.setDisable(false);
            btnGestion.setDisable(true);
            leftGestion = new Gestion();
            root.setCenter(leftGestion.getContent());
        });
        
        btnAtencion.setOnAction(e -> {
            btnAtencion.setDisable(true);
            btnGestion.setDisable(false);
            leftAtencion = new Atencion();
            root.setCenter(leftAtencion.getContent());
        });
        
        vbTop.getChildren().addAll(hbPrimero, hbMenu);
        
        return vbTop;
    }
    
}
