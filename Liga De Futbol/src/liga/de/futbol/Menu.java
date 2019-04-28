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
import javax.swing.JOptionPane;
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
    private int Canti_eqp=0;
    private Lista lista_eqp1, lista_partidos;
    public Menu(){
        //Inicializar listas
        lista_eqp1 = new Lista(); // lista de los equipos de la liga
        lista_partidos = new Lista(); // lista con todos los partidos
        
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
        
        //CONFIGURACION "CANTIDAD DE EQUIPOS
        Configurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(Canti_eqp==0){
                   Canti_eqp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos equipos quiere en la liga"));
               }
               else{
                    JOptionPane.showMessageDialog(null,"El numero de discos debe ser distinto de 0","Error",JOptionPane.ERROR_MESSAGE);  
               }
            }
        });
          //fin boton
          
          Informacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(null,"1) Equipo ganador se le suma tres puntos \n"+"2) Al equipo que pierde no se le dan puntos\n"+"3) A los esquipos que empatan se les da un punto\n"+
                         "4) Cada equipo debe de enfrentarce con cada uno de los demas equipos"
                         ,"Informacion",JOptionPane.INFORMATION_MESSAGE); 
            }
        });
          
          //Ingresar equipos
          Ingreso_eqp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              IngresarEquipos();
            }
        });
          //fin de boton
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
    
    public void IngresarEquipos(){
        if(lista_eqp1.Vacia()&&Canti_eqp!=0){
            int conta = 1;
            while(conta<=Canti_eqp){
                String nombre_eqp = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo "+conta);
                Equipo nuevo_equipo = new Equipo();
                nuevo_equipo.setNombre(nombre_eqp);
                Nodo nuevo_nodo = new Nodo();
                nuevo_nodo.setEquipo(nuevo_equipo);
                lista_eqp1.InsertarFondo(nuevo_nodo);    
                conta++;
            }
        }
        else{
            if(Canti_eqp==0){
               JOptionPane.showMessageDialog(null,"Aun no se ha ingresado la cantidad de equipos","Error",JOptionPane.ERROR_MESSAGE);  
            }
            if(lista_eqp1.Vacia()==false){
           JOptionPane.showMessageDialog(null,"Ya se han ingresado los equipos","Error",JOptionPane.ERROR_MESSAGE); 
            }
        }
    }
}
