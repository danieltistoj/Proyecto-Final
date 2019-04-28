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
    private boolean next_botones=false,next_boton2=false;
    private JFrame ventana;
    private JPanel panel;
    private JButton Parametro_prog, Ingreso_eqp, Ingreso_resul,Mostrar_ClsG,Configurar, Puntos_asg, Otros,Lista_eqp,Informacion;
    private int Canti_eqp;
    public Menu(){
        
        //BOTONES DE DESPLIEGUE DE PARAMETROS DEL PROGRAMA
        Lista_eqp = new JButton("Lista De Los Equipos");
        Lista_eqp.setBounds(400, 270, 225, 30);
        
        Informacion = new JButton("Informacion");
        Informacion.setBounds(400, 330, 225, 30);
        
        Configurar = new JButton("Configurar 'Cantidad De Equipos'");
        Configurar.setBounds(300, 90, 225, 30);
         
        Puntos_asg = new JButton("Puntos Asignados");
        Puntos_asg.setBounds(300, 150, 225, 30);
        
        Otros = new JButton("Otros");
        Otros.setBounds(300,210 ,225, 30);
        
        //BOTONE PRINCIPALES
        
        Parametro_prog = new JButton("Parametros Del Programa");
        Parametro_prog.setBounds(200, 30, 225, 30);
        
        Ingreso_eqp = new JButton("Ingreso De Los Equipos");
        Ingreso_eqp.setBounds(200, 90, 225, 30);
        
        Ingreso_resul =  new JButton("Ingreso De Resultados");
        Ingreso_resul.setBounds(200, 150, 225, 30);
        
        Mostrar_ClsG = new JButton("Mostrar Clasificacion General");
        Mostrar_ClsG.setBounds(200, 210, 225, 30);
        
        // FIN BOTOS PRINCIPALES
        
        panel = new JPanel();
        panel.setBounds(0, 0, 700, 600);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.add(Parametro_prog);
        panel.add(Ingreso_eqp);
        panel.add(Ingreso_resul);
        panel.add(Mostrar_ClsG);
       
        
        ventana = new JFrame("Liga De Futbol");
        ventana.setSize(700, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setResizable(false);
        
        Parametro_prog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(next_botones==false){
                   next_botones = true;
                   Ingreso_eqp.setBounds(200, 270, 225, 30);
                   Ingreso_resul.setBounds(200,330 , 225, 30);
                   Mostrar_ClsG.setBounds(200,390 , 225, 30);
                   
                     panel.add(Configurar);
                     panel.add(Puntos_asg);
                     panel.add(Otros);
                     panel.repaint();
                     
               }
               else{
                  
                   next_botones = false;
                   if(next_botones == false){
                       next_boton2 = true;
                   }
                   DesplegarBotonesOtros();
                   panel.remove(Configurar);
                   panel.remove(Puntos_asg);
                   panel.remove(Otros);
                   Ingreso_eqp.setBounds(200, 90, 225, 30);
                   Ingreso_resul.setBounds(200, 150, 225, 30);
                   Mostrar_ClsG.setBounds(200, 210, 225, 30);
                   panel.repaint();
                   
               }
            }
        });
        
        Otros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    DesplegarBotonesOtros();
            }
        });
          
        ventana.add(panel);
        ventana.setVisible(true);
    }
    
    public void DesplegarBotonesOtros(){
      if(next_boton2==false){
                    next_boton2 = true;
                   Ingreso_eqp.setBounds(200, 390, 225, 30);
                   Ingreso_resul.setBounds(200,450 , 225, 30);
                   Mostrar_ClsG.setBounds(200,510 , 225, 30);
                   
                     panel.add(Lista_eqp);
                     panel.add(Informacion);
                     panel.repaint();
                    
                }
                else{
                   next_boton2 = false;
                   
                   panel.remove(Lista_eqp);
                   panel.remove(Informacion);  
                   Ingreso_eqp.setBounds(200, 270, 225, 30);
                   Ingreso_resul.setBounds(200, 330, 225, 30);
                   Mostrar_ClsG.setBounds(200, 390, 225, 30);
                   panel.repaint();
                    
                }   
    }
}
