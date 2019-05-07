/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liga.de.futbol;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Panel extends JPanel{
    public Image imagen;
    public URL fondo;
    public Panel(){
        fondo = this.getClass().getResource("balon1.jpg");
        imagen = new ImageIcon(fondo).getImage();
    }
    public void paintComponent(Graphics g){
        g.drawImage(imagen,0,0,getWidth(),getHeight(),null);
        
    }
}
