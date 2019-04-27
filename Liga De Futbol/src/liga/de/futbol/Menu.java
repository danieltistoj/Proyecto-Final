/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liga.de.futbol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Usuario
 */
public class Menu {
    boolean next_botones=false;
    JFrame ventana;
    JPanel panel;
    JButton Parametro_prog, Ingreso_eqp, Ingreso_resul,Mostrar_ClsG,Configurar, Puntos_asg, Otros;
    public Menu(){
        //BOTONES DE DESPLIEGUE DE PARAMETROS DEL PROGRAMA
        Configurar = new JButton("Configurar 'Cantidad De Equipos'");
        Configurar.setBounds(300, 90, 225, 30);
         
        Puntos_asg = new JButton("Mostrar Clasificacion general");
        Puntos_asg.setBounds(300, 150, 225, 30);
        
        //BOTONE PRINCIPALES
        
        Parametro_prog = new JButton("Parametros Del Programa");
        Parametro_prog.setBounds(200, 30, 225, 30);
        
        Ingreso_eqp = new JButton("Ingreso De Los Equipos");
        Ingreso_eqp.setBounds(200, 90, 225, 30);
        
        Ingreso_resul =  new JButton("Ingrese De Resultados");
        Ingreso_resul.setBounds(200, 150, 225, 30);
        
        Mostrar_ClsG = new JButton("Mostrar Clasificacion General");
        Mostrar_ClsG.setBounds(200, 210, 225, 30);
        
        // FIN BOTOS PRINCIPALES
        
        panel = new JPanel();
        panel.setBounds(0, 0, 600, 500);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.add(Parametro_prog);
        panel.add(Ingreso_eqp);
        panel.add(Ingreso_resul);
        panel.add(Mostrar_ClsG);
       
        
        ventana = new JFrame("Liga De Futbol");
        ventana.setSize(600, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setResizable(false);
        
        Parametro_prog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(next_botones==false){
                   next_botones = true;
                   Ingreso_eqp.setBounds(200, 210, 225, 30);
                   Ingreso_resul.setBounds(200, 270, 225, 30);
                   Mostrar_ClsG.setBounds(200, 330, 225, 30);
                   
                     panel.add(Configurar);
                     panel.add(Puntos_asg);
                     panel.repaint();
                     
               }
               else{
                   next_botones = false;
                   panel.remove(Configurar);
                   panel.remove(Puntos_asg);
                   Ingreso_eqp.setBounds(200, 90, 225, 30);
                   Ingreso_resul.setBounds(200, 150, 225, 30);
                   Mostrar_ClsG.setBounds(200, 210, 225, 30);
                   panel.repaint();
               }
            }
        });
        
          
        ventana.add(panel);
        ventana.setVisible(true);
    }
    
}
