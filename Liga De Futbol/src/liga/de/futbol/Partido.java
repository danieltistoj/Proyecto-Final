/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liga.de.futbol;

import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class Partido {
  private Nodo Eqp1, Eqp2;
  private int goles_eqp1, goles_eqp2;

    public Nodo getEqp1() {
        return Eqp1;
    }

    public void setEqp1(Nodo Eqp1) {
        this.Eqp1 = Eqp1;
    }

    public Nodo getEqp2() {
        return Eqp2;
    }

    public void setEqp2(Nodo Eqp2) {
        this.Eqp2 = Eqp2;
    }

    public int getGoles_eqp1() {
        return goles_eqp1;
    }

    public void setGoles_eqp1(int goles_eqp1) {
        this.goles_eqp1 = goles_eqp1;
    }

    public int getGoles_eqp2() {
        return goles_eqp2;
    }

    public void setGoles_eqp2(int goles_eqp2) {
        this.goles_eqp2 = goles_eqp2;
    }

    
   
}
