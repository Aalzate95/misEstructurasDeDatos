/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Juan Camilo
 */
public class Mapa {
    Rectangle muroSuperior,muroInferior,muroDerecha,muroIzquierda;
    public Group CrearMapa(){
        Group mapa1 = new Group(muroSuperior);
        muroSuperior = new Rectangle(900,40);
        muroInferior = new Rectangle(640,10);
        muroIzquierda = new Rectangle(10,900);
        muroDerecha = new Rectangle(10,900);
        return mapa1;
    }
}
