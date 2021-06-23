/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.net.URISyntaxException;
import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author Alexander Alzate
 */
public  class Utilidades {
    public static void reproducirSonido(String fileName) {
        Media m = new Media(Main.class.getResource("/resources/"+ fileName).toString());
        MediaPlayer player = new MediaPlayer(m);
        player.setOnEndOfMedia(new Runnable() {
            public void run() {
                player.seek(Duration.ZERO);
            }
        });
        player.play();
    }
    
}
