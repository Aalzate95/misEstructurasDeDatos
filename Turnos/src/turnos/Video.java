/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Video {
    private String url;

    public Video(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public static List<Video> leerVideos(String file){
           
        List<Video> lista = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String url = temp[0];
                Video element = new Video(url);
                lista.add(element);
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
