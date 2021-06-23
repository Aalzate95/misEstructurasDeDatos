/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseno;

import java.util.Comparator;

/**
 *
 * @author Alexander Alzate
 */
public class OrdenPorPuntaje implements Comparator<Player> {


    public int compare(Player o1, Player o2) {
        return o2.getPuntaje() - o1.getPuntaje() ;
    }
}
