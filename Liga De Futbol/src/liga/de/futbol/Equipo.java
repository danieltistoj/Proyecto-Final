/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liga.de.futbol;

/**
 *
 * @author Usuario
 */
public class Equipo {
   private int puntos = 0, GolesAfavor = 0, GolesEncontra = 0, Diferenci_goles = 0;
   private String nombre;

    public int getDiferenci_goles() {
        return Diferenci_goles;
    }

    public void setDiferenci_goles(int Diferenci_goles) {
        this.Diferenci_goles = Diferenci_goles;
    }
 
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getGolesAfavor() {
        return GolesAfavor;
    }

    public void setGolesAfavor(int GolesAfavor) {
        this.GolesAfavor += GolesAfavor;
    }

    public int getGolesEncontra() {
        return GolesEncontra;
    }

    public void setGolesEncontra(int GolesEncontra) {
        this.GolesEncontra += GolesEncontra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   public void DiferenciaGoles(){
       setDiferenci_goles(GolesAfavor-GolesEncontra);
   }
   
}
