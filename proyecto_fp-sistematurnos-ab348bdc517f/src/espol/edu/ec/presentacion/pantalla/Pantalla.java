/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.presentacion.pantalla;

import espol.edu.ec.modelo.tdas.DoublyCircularList;
import espol.edu.ec.modelo.tdas.Puesto;
import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Charles
 */
public class Pantalla {

    private static MediaView mv;
    private static MediaPlayer mp;
    private static Stage ventanaPantalla;
    private static VBox root;
    private static Scene sc;
    private static DoublyCircularList<Media> lmedia;
    private static ListIterator<Media> lit;
    private static final int ANCHOTURNOS = 100;
    private static final Queue<HBox> colaTurno = new LinkedList<>();
    private static HBox next;
    private static final String ESTILOTURNOS = "-fx-border-color:black; -fx-font-family: Times New Roman 12";

    private Pantalla() {
    }

    public static Stage getVentanaPantalla() {
        return ventanaPantalla;
    }

    public static void setVentanaPantalla(Stage ventanaPantalla) {
        Pantalla.ventanaPantalla = ventanaPantalla;
    }

    public static void mostrar() {
        root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(15);

        root.getChildren().addAll(crearTop(), crearCentro(), crearBottom());

        sc = new Scene(root);
        ventanaPantalla = new Stage();
        ventanaPantalla.setTitle("PANTALLA DE ESPERA");
        ventanaPantalla.setScene(sc);
        ventanaPantalla.centerOnScreen();
//        ventanaPantalla.setAlwaysOnTop(true);
        ventanaPantalla.setOnCloseRequest((WindowEvent) -> {
            mp.stop();
        });

        ventanaPantalla.show();
    }

    public static void cerrar() {
        ventanaPantalla.close();
    }

    private static void Algo() {
        mp.setOnEndOfMedia(() -> {
            mp = new MediaPlayer(lit.next());
            mv.setMediaPlayer(mp);
            mp.play();

            Algo();

        });
    }

    private static Node crearCentro() {
        HBox hbCentro = new HBox();
        hbCentro.setSpacing(10);
        hbCentro.setPadding(new Insets(10, 0, 10, 0));

        hbCentro.getChildren().addAll(crearLeft(), crearRight());
        return hbCentro;
    }

    private static Node crearTop() {
        Label lblSticker = new Label("IESSPOL");
        lblSticker.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15));
        HBox hbTop = new HBox(lblSticker);
        return hbTop;
    }

    private static Node crearBottom() {
        Label lblPie = new Label("Horario de Atencion de Lunes a Viernes de 10 a 18 hrs");
        lblPie.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.ITALIC, 14));
        HBox hbBtm = new HBox(lblPie);
        hbBtm.setAlignment(Pos.CENTER);

        return hbBtm;
    }

    private static Node crearLeft() {
        VBox vbMedia = new VBox();
        lmedia = new DoublyCircularList();
        lmedia.addLast(new Media(new File("1.mp4").toURI().toString()));
        lmedia.addLast(new Media(new File("2.mp4").toURI().toString()));
//        lmedia.addLast(new Media(new File("3.mp4").toURI().toString()));
//        lmedia.addLast(new Media(new File("4.mp4").toURI().toString()));
        lit = lmedia.listIterator();

        Media primero = lit.next();
        mp = new MediaPlayer(primero);

        mv = new MediaView();
        mv.setMediaPlayer(mp);

        mv.setFitHeight(300.0);
        mv.setFitWidth(300.0);

        //Creacion de botones        
        Button btp = new Button("PLAY");
        Button btpa = new Button("PAUSE");
        Button btns = new Button("STOP");
        Button btnNext = new Button("NEXT");
        Button btnPrev = new Button("PREV");

        mp.play();

        //Controlar el evento para cuando cada video termine
        Algo();

        //Evento de los botones
        btp.setOnAction(e -> {
            mp.play();
        });
        //Evento de los botones
        btpa.setOnAction(e -> {
            mp.pause();
        });

        btns.setOnAction(e -> {
            mp.stop();
        });

        btnNext.setOnAction(e -> {
            mp.stop();
            mp = new MediaPlayer(lit.next());
            mv.setMediaPlayer(mp);
            Algo();
            mp.play();
        });

        btnPrev.setOnAction(e -> {
            mp.stop();
            mp = new MediaPlayer(lit.previous());
            mv.setMediaPlayer(mp);
            Algo();
            mp.play();
        });

        HBox hbBtns = new HBox(btp, btpa, btns, btnNext, btnPrev);
        hbBtns.setAlignment(Pos.CENTER);
        vbMedia.getChildren().addAll(mv, hbBtns);
        return vbMedia;
    }

    private static Node crearRight() {

        Label lblRotTurno = new Label("TURNO");
        Label lblRotPuesto = new Label("CONSULTORIO");
        HBox hbRotulo = new HBox(lblRotTurno, lblRotPuesto);
        hbRotulo.getChildren().stream().forEach(l -> ((Label) l).setStyle("-fx-font-family: Chalkduster 12"));
        hbRotulo.getChildren().stream().forEach(l -> setearLabelTurnos((Label) l));

        for (int i = 0; i < 4; i++) {
            Label lblTurno = new Label();
            Label lblPuesto = new Label();
            setearLabelTurnos(lblTurno);
            setearLabelTurnos(lblPuesto);

            colaTurno.add(new HBox(lblTurno, lblPuesto));
        }

        VBox vbcola = new VBox();
        vbcola.getChildren().addAll(colaTurno);

        VBox vbTurno = new VBox(hbRotulo, vbcola);
        return vbTurno;
    }

    private static void setearLabelTurnos(Label l) {
        l.setStyle(ESTILOTURNOS);
        l.setPadding(new Insets(10, 10, 10, 10));
        l.setPrefWidth(ANCHOTURNOS);
        l.setAlignment(Pos.CENTER);
    }

    public static void encolarTurnos(Puesto p) {
        next = colaTurno.poll();
        ((Label) next.getChildren().get(0)).setText(p.getPaciente().getTurno());
        ((Label) next.getChildren().get(1)).setText(String.valueOf(p.getId()));
        colaTurno.offer(next);
        Thread hiloLlamada = new Thread(new AnuncioSiguiente());
        hiloLlamada.start();
    }

    private static class AnuncioSiguiente implements Runnable {

        @Override
        public void run() {
            Platform.runLater(() -> {
                next.setStyle("-fx-background-color: RGB(255,200,255);");
            });
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
            Platform.runLater(() -> {
                next.setStyle(ESTILOTURNOS);
            });
        }

    }
}
