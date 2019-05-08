/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liga.de.futbol;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Usuario
 */
public class Menu {
    private boolean next_botones=false,next_boton2=false,EntradaListaEqp=false,conf_pts=false,Tabla_hecha=false;
    private JList lista, lista2, lista3;
    private JScrollPane scrollLista, scrollpane,scrollClasificacion;
    private JLabel fondo_panel;
    private JFrame ventana;
    private JDialog ResultadoJornada,ListaEquipos,ClasGeneral;
    private JPanel  panel2, panel_listaEqp,panel_clasificacion;
    private DefaultListModel modelo, modelo2, modelo3;//declaramos el Modelo
    private JButton Parametro_prog, Ingreso_eqp, Ingreso_resul,Mostrar_ClsG,Configurar, Generar_partidos, Otros,Lista_eqp,Gresultados, AsgPuntos,GresultadosA, guardar, cargar;
    private int Canti_eqp=0;
    private Lista lista_eqp1, lista_partidos;
    private Nodo auxiiar;
    private Arbol arbol;
    private Panel panel;
    private int jornada=1, PartidosPorJornada, ComPrt, jornada2, contador_jornadas=0,puntos_ganar,puntos_perder,puntos_empate;
    
    public Menu(){

        arbol = new Arbol();
        //ventana de las clasificaciones generales
        
        lista3 = new JList();
        lista3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        //inicializar scroll*
        scrollClasificacion = new JScrollPane();//es para hacer una barra que pueda bajar para hacer y ver la lista completa...
        scrollClasificacion.setBounds(0,30,600, 300);
        scrollClasificacion.setViewportView(lista3);  
        //inicializar el modelo
        modelo3 = new DefaultListModel();
        
        panel_clasificacion = new JPanel();
        panel_clasificacion.setBounds(0, 0,600,400);
        panel_clasificacion.setBackground(java.awt.Color.WHITE);
        panel_clasificacion.setLayout(null);
        panel_clasificacion.setVisible(true);
        panel_clasificacion.add(scrollClasificacion);
        
        ClasGeneral = new JDialog(ventana,"Resultado De Jornadas");
        ClasGeneral.setSize(600, 400);
        ClasGeneral.setLocationRelativeTo(null);
        ClasGeneral.setLayout(null);
        ClasGeneral.add(panel_clasificacion);
        ClasGeneral.setResizable(false);
        //scroll para un panel
        lista2 = new JList();
        lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        //inicializar scroll*
        scrollpane = new JScrollPane();//es para hacer una barra que pueda bajar para hacer y ver la lista completa...
        scrollpane.setBounds(0,30,600, 300);
        scrollpane.setViewportView(lista2);  
        //inicializar el modelo
        modelo2 = new DefaultListModel();
           
        //boton para generar los resultados de los partidos de cada jornada
        guardar  = new JButton("Guardar");
        guardar.setBounds(400, 390, 225,30 );
        
        cargar = new JButton("Cargar");
        cargar.setBounds(400,450,225,30);
        
        Gresultados = new JButton("Resultados automatico");
        Gresultados.setBounds(350,0, 170,30);
        
        GresultadosA = new JButton("Resultados manual");
        GresultadosA.setBounds(120, 0, 170, 30);
          //boton para ir a la ventana menu
        lista = new JList();
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        //inicializar scroll*
        scrollLista = new JScrollPane();//es para hacer una barra que pueda bajar para hacer y ver la lista completa...
        scrollLista.setBounds(0,30,600, 300 );
        scrollLista.setViewportView(lista);  
        //inicializar el modelo
        modelo = new DefaultListModel();
        //panel de la ventana secundaria que contiene a las jornadas
        panel2 = new JPanel();
        panel2.setBounds(0, 0,600,400);
        panel2.setBackground(java.awt.Color.WHITE);
        panel2.setLayout(null);
        panel2.setVisible(true);
        panel2.add(scrollLista);
        panel2.add(Gresultados);
        panel2.add(GresultadosA);
        
        ResultadoJornada = new JDialog(ventana,"Resultado De Jornadas");
        ResultadoJornada.setSize(600, 400);
        ResultadoJornada.setLocationRelativeTo(null);
        ResultadoJornada.setLayout(null);
        ResultadoJornada.add(panel2);
        ResultadoJornada.setResizable(false);
        
        
        //ventana de la lista de equipos
        panel_listaEqp = new JPanel();
        panel_listaEqp.setBounds(0, 0,400,400);
        panel_listaEqp.setBackground(java.awt.Color.WHITE);
        panel_listaEqp.setLayout(null);
        panel_listaEqp.setVisible(true);
        panel_listaEqp.add(scrollpane);
          
        ListaEquipos = new JDialog(ventana,"Lista De Equipos");
        ListaEquipos.setSize(400, 400);
       
        ListaEquipos.setLocationRelativeTo(null);
        ListaEquipos.setLayout(null);
        ListaEquipos.add(panel_listaEqp);
        
        
       
        //Inicializar listas
        lista_eqp1 = new Lista(); // lista de los equipos de la liga
        lista_partidos = new Lista(); // lista con todos los partidos
        
        //BOTONES DE DESPLIEGUE DE PARAMETROS DEL PROGRAMA
        Lista_eqp = new JButton("Lista De Los Equipos");
        Lista_eqp.setBounds(400, 330, 225, 30);
               
        Configurar = new JButton("Configurar 'Cantidad De Equipos'");
        Configurar.setBounds(300, 90, 225, 30);
         
        AsgPuntos = new JButton("Asignar puntos");
        AsgPuntos.setBounds(300, 210, 225, 30);
        
        Generar_partidos= new JButton("Generar Partios");
        Generar_partidos.setBounds(300, 150, 225, 30);
        
        Otros = new JButton("Otros");
        Otros.setBounds(300,270 ,225, 30);
        
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
        
        panel = new Panel();
        
        
        panel.setBounds(0, 0, 700, 720);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.add(Parametro_prog);
        panel.add(Ingreso_eqp);
        panel.add(Ingreso_resul);
        panel.add(Mostrar_ClsG);
       
        
        
        ventana = new JFrame("Liga De Futbol");
        ventana.setSize(700, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        //ventana.setLayout(null);
       // ventana.setResizable(false);
        
        Parametro_prog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(next_botones==false){
                   next_botones = true;
                   Ingreso_eqp.setBounds(200, 330, 225, 30);
                   Ingreso_resul.setBounds(200,390 , 225, 30);
                   Mostrar_ClsG.setBounds(200,450 , 225, 30);
                   
                     panel.add(Configurar);
                     panel.add(Generar_partidos);
                     panel.add(Otros);
                     panel.add(AsgPuntos);
                     panel.repaint();
                     
               }
               else{
                  
                   next_botones = false;
                   if(next_botones == false){
                       next_boton2 = true;
                   }
                   DesplegarBotonesOtros();
                   panel.remove(Configurar);
                   panel.remove(Generar_partidos);
                   panel.remove(Otros); 
                   panel.remove(AsgPuntos);
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
                   Canti_eqp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos equipos quiere en la liga")); // solicita la contidad de equipos
                   if(Canti_eqp>1){
                   ComPrt = (factorial(Canti_eqp))/((factorial(Canti_eqp-2))*(factorial(2))); // encontramos el numero de combinaciones 
                   if(Canti_eqp%2==0){
                       PartidosPorJornada = Canti_eqp/2;//encontramos el numero de partidos que se pueden llevar por jornada si el numero de rwuipos ingresados es par
                   }
                   else{
                       PartidosPorJornada = (Canti_eqp-1)/(2);//encontramos el numero de partidos que se pueden llevar por jornada si el numero de rwuipos ingresados es impar
                   }
                   jornada2 = ComPrt/PartidosPorJornada;//encontramos cuatas jornadas hay
                   JOptionPane.showMessageDialog(null,"Equipos: "+Canti_eqp+"\n"+
                           "Jornadas: "+jornada2+"\n"+
                           "Partidos Totales: "+ComPrt+"\n"+
                           "Partidos Por Jornada: "+PartidosPorJornada
                           ,"",JOptionPane.INFORMATION_MESSAGE);
               }
                   else{
                   JOptionPane.showMessageDialog(null,"La cantidad de partidos debe de ser mayor a uno","Error",JOptionPane.ERROR_MESSAGE);      
                   }
               }//fin de la primera condicion
               else{
                     JOptionPane.showMessageDialog(null,"Equipos: "+Canti_eqp+"\n"+
                           "Jornadas: "+jornada2+"\n"+
                           "Partidos Totales: "+ComPrt+"\n"+
                           "Partidos Por Jornada: "+PartidosPorJornada+""
                           ,"Datos De La Liga",JOptionPane.INFORMATION_MESSAGE);
               }
            }
        });
          //fin boton
         
          
          //Ingresar equipos
          Ingreso_eqp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              IngresarEquipos();
            }
        });
          //fin de boton
          //generar partidos sin resultados 
         Generar_partidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(lista_eqp1.Vacia()){
                  JOptionPane.showMessageDialog(null,"No se han creado aun los equipos","Error",JOptionPane.ERROR_MESSAGE);  
               }
               else{
                   
                   FormarPartidos();
               }
            }
        });
         
         AsgPuntos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(conf_pts==false){
             puntos_ganar = Integer.parseInt(JOptionPane.showInputDialog("Ingres los puntos del equipo ganador"));
	     puntos_perder = Integer.parseInt(JOptionPane.showInputDialog("Ingres los puntos del equipo perdedor"));
             puntos_empate = Integer.parseInt(JOptionPane.showInputDialog("Ingres los putos de empate"));
             conf_pts = true;
            }
                else{
                   JOptionPane.showMessageDialog(null,"Ya se han asignado los puntos para los partidos","Error",JOptionPane.ERROR_MESSAGE);   
                }
            }
        });
         //fin del boton de generar partidos 
           
         // lista de los equipos en el sistema
         
       Lista_eqp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ventana.setVisible(false);
               
                 if(lista_eqp1.Vacia()){
                   JOptionPane.showMessageDialog(null,"La lista de equipos esta vacia","Error",JOptionPane.ERROR_MESSAGE);   
                 }
                 else{
                    ListaEquipos.setVisible(true);
                    if(EntradaListaEqp==false){
                    Nodo aux = lista_eqp1.getTope();
                    String cadena;
                    while(aux!=null){
                        cadena = aux.getEquipo().getNombre();
                        modelo2.addElement(cadena);
                        aux = aux.getSig();
                    }
                     EntradaListaEqp = true;
                     lista2.setModel(modelo2);
                     panel_listaEqp.repaint();
                    
                 }
                     
                 }//fin else
               
            }
        });
       //Boton guardar
       guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Tabla_hecha){
                    System.out.println("entro");
                    Nodo aux = lista_eqp1.getTope();
                    File archivo;
                    FileWriter escribir;
                    PrintWriter linea;
                   String nombre_archivo = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo\n"+"Ejemplo: nombre.txt");
                    archivo = new File(nombre_archivo);
                    if(!archivo.exists()){ // si el archivo ingresado no existe 
                            
                        try {
                            archivo.createNewFile(); // se crea el acrchivo 
                            escribir = new FileWriter(archivo,true);
                            linea = new PrintWriter(escribir);
                            linea = arbol.Orndar_In2(linea);// se retorna la linea ya con las clasificaciones del arbol
                            JOptionPane.showMessageDialog(null,"Ya se ha creado el archivo: "+nombre_archivo,"Mensaje",JOptionPane.INFORMATION_MESSAGE);   
                            linea.close();
                            escribir.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            
                       
                    }
                    else{ // es para agregar mas dato en dado caso el archivo ingresado ya exista 
                         try {
                        // ya no se necesita crear un archivo 
                            escribir = new FileWriter(archivo,true);
                            linea = new PrintWriter(escribir);
                            linea = arbol.Orndar_In2(linea);// se retorna la linea ya con las clasificaciones del arbol
                            JOptionPane.showMessageDialog(null,"Ya se han agregado las modificaciones al archivo: "+nombre_archivo,"Mensaje",JOptionPane.INFORMATION_MESSAGE);   
                            linea.close();
                            escribir.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                    }// fin else
                    
                }
                else{
                JOptionPane.showMessageDialog(null,"No se han generado resultados","Error",JOptionPane.ERROR_MESSAGE); 
                }
               
            }
        });
       //fin boton guardar
       //boton cargar 
       cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int conta =1;
                File archivo;
                FileReader leer;
                String cadena,nombre = "",GolesA, GolesE, Diferencia, Puntos;
                String nombre_archivo = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo");
                BufferedReader almacenamiento;
                archivo = new File(nombre_archivo);
                try {
                    leer = new FileReader(archivo);
                    almacenamiento = new BufferedReader(leer);
                    cadena = "";
                    while(cadena!=null){
                        try {
                            cadena = almacenamiento.readLine();
                            nombre = cadena;
                            cadena = almacenamiento.readLine();
                            GolesA = cadena;
                            cadena = almacenamiento.readLine();
                            GolesE = cadena;
                            cadena = almacenamiento.readLine();
                            Diferencia = cadena;
                            cadena = almacenamiento.readLine();
                            Puntos = cadena;
                            cadena = almacenamiento.readLine();
                            if(cadena!=null){
                               JOptionPane.showMessageDialog(null,nombre+"\n"+GolesA+"\n"
                                       +GolesE+"\n"+Diferencia+"\n"+Puntos
                                       ,"Equipo: "+conta,JOptionPane.INFORMATION_MESSAGE);
                               conta++;
                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }// fin del while
                    try {
                        almacenamiento.close();
                        leer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                
            }
        });
       //fin del boton cargar
       Ingreso_resul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //ventana.setVisible(false);
              ResultadoJornada.setVisible(true);
            }
        });
       
       
      //boton que genera los resultados de los partidos por jornada    
       Gresultados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(auxiiar!=null){//verifica primero que la lista tenga nodos
                if(conf_pts){ // verifica que ya se hayan asignado puntos para cada caso ganer, perder, empate  
                int conta=1;
                modelo.addElement("Jornada "+(contador_jornadas+1));
                while(conta<=PartidosPorJornada){//el contador va a recorrer de uno hasta el numero de partidos que debe de tener cada jornada que se ha asignado a la variable PartidosPorJornada
                    auxiiar.getPartido().GenerarGolesAutomatico(puntos_ganar,puntos_perder,puntos_empate);//se generan los goles de cada partido
                    modelo.addElement(auxiiar.getPartido().getEqp1().getEquipo().getNombre()+"  -  "+auxiiar.getPartido().getGoles_eqp1()+"     "+" vs "+"    "+auxiiar.getPartido().getGoles_eqp2()+"  -  "+auxiiar.getPartido().getEqp2().getEquipo().getNombre());// se ingresa la cadena en el modelo 
                    auxiiar = auxiiar.getSig(); // se pasa al siguiente nodo
                    conta++;
                    
                }//fin del while
                contador_jornadas++;//lleva una sumatoria de las jornadas que se van creando
                lista.setModel(modelo);
                panel2.repaint();
                }//fin de la segunda condicioin
                 else{
                  JOptionPane.showMessageDialog(null,"Asigne antes los puntos para cada caso: Ganador, Perdedor y Empate","Error",JOptionPane.ERROR_MESSAGE);   
                 }
                }//fin del primer if
            }
        });
       //gnera los goles de cada partido de cada jornada de forma manual uno por uno
       GresultadosA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             if(auxiiar!=null){//verifica que la variable global no este vacia 
                 if(conf_pts){//con esta variable de tipo booleano se verifica si ya se han ingresado los tipos de punteo
                     int conta = 1;
                      modelo.addElement("Jornada "+(contador_jornadas+1));
                     while(conta<=PartidosPorJornada){//el contador debe de ir de uno al nuemro de partidos que debe de tener una jornada
                         int gol_eqp1 = Integer.parseInt(JOptionPane.showInputDialog("Jornada: "+(contador_jornadas+1)+"   -   Partido: "+conta+"   -  Ingrese goles del jugador: "+auxiiar.getPartido().getEqp1().getEquipo().getNombre()));
                         int gol_eqp2 = Integer.parseInt(JOptionPane.showInputDialog("Jornada: "+(contador_jornadas+1)+"   -   Partido: "+conta+"   -  Ingrese goles del jugador: "+auxiiar.getPartido().getEqp2().getEquipo().getNombre()));
                         auxiiar.getPartido().GenerarGolesManual(puntos_ganar,puntos_perder,puntos_empate, gol_eqp1, gol_eqp2);
                         modelo.addElement(auxiiar.getPartido().getEqp1().getEquipo().getNombre()+"  -  "+auxiiar.getPartido().getGoles_eqp1()+"     "+" vs "+"    "+auxiiar.getPartido().getGoles_eqp2()+"  -  "+auxiiar.getPartido().getEqp2().getEquipo().getNombre());
                         auxiiar = auxiiar.getSig();
                         conta++;
                     }
                     contador_jornadas++; // se aumenta el contador de jornadas
                     lista.setModel(modelo);// se ingresa el modelo en la lista que esta dentro del scroll
                     panel2.repaint();
                     
                 }
                 else{
                   JOptionPane.showMessageDialog(null,"Asigne antes los puntos para cada caso: Ganador, Perdedor y Empate","Error",JOptionPane.ERROR_MESSAGE);  
                 }
                 
             }
            }
        });
       // ingresar los equipos al arbol y luego de ingresarlos los muestra en un recorrido inorden en donde se recorre primero la rama derecha
       Mostrar_ClsG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lista_eqp1.Vacia()){
                    JOptionPane.showMessageDialog(null,"No hay equipos en el sistema","Error",JOptionPane.ERROR_MESSAGE);  
                }
                else{
                     ClasGeneral.setVisible(true); // se hace visible el dialog de la clasificacion general 
              
                    if(lista_partidos.Vacia()!=true){
                        if(contador_jornadas==jornada2&&Tabla_hecha==false){
                        Nodo aux = lista_eqp1.getTope(); // se pasa la lista de equipos a un nodo auxiliar 
                        while(aux!=null){ // el ciclo se repite hasta que el aux sea igual a null
                            aux.getEquipo().DiferenciaGoles(); // se acude al metodo Direncia de goles para encontrar este dato que se encuentra dentro la clase Equipo
                            arbol.Insertar(aux.getEquipo()); // se inserta el objeto equipo del nodo en el arbol, luego el arbol se encarga de ingresarlo en un nuevo nodo
                            aux = aux.getSig();// se pasa al nodo siguiente 
                        }
                      Tabla_hecha = true;
                      modelo3=arbol.Ordenar_In(modelo3);// se ingresan todos los datos en el modelo 
                      lista3.setModel(modelo3); // se ingresa el modelo en la lista 
                      panel_clasificacion.repaint();// se repinta el panel de la ventana de clasificacion
                        }
                     
                       
                    }//fin del primer if 
                }//fin del elese
                    

            }
            
        });
       
          //fin
        ventana.add(panel);
        ventana.setVisible(true);
    }// fin de la funcion constructor 
    
    public void DesplegarBotonesOtros(){
      if(next_boton2==false){
                   next_boton2 = true;
                   Ingreso_eqp.setBounds(200, 510, 225, 30);
                   Ingreso_resul.setBounds(200,570, 225, 30);
                   Mostrar_ClsG.setBounds(200,630 , 225, 30);
                   
                     panel.add(Lista_eqp);
                     panel.add(guardar);
                     panel.add(cargar);
                     panel.repaint();
                    
                }
                else{
                   next_boton2 = false;
                   
                   panel.remove(Lista_eqp);
                   panel.remove(guardar);
                   panel.remove(cargar);
                   Ingreso_eqp.setBounds(200, 330, 225, 30);
                   Ingreso_resul.setBounds(200, 390, 225, 30);
                   Mostrar_ClsG.setBounds(200, 450, 225, 30);
                   panel.repaint();
                    
                }   
    }
    //boton para ingresar los equipos
    public void IngresarEquipos(){
        if(lista_eqp1.Vacia()&&Canti_eqp!=0){//verifica que la lista este vacia y que ya se haya ingresado una cantidad de equipos al sistema
            int conta = 1;
            while(conta<=Canti_eqp){ // el ciclo ira de uno a la cantidad de equipos ingresados 
                String nombre_eqp = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo "+conta); // se despliega una ventana emergente que pide los nombre de cada equipo
                Equipo nuevo_equipo = new Equipo(); // se crea un nuevo objeto equipo
                nuevo_equipo.setNombre(nombre_eqp); // se ingresa el nombre del equipo al objeto equipo
                Nodo nuevo_nodo = new Nodo(); // se crea un nuevo nodo que servira para agregarlo a la lista equipos
                nuevo_nodo.setEquipo(nuevo_equipo);// se ingresa el equipo al nodo
                lista_eqp1.InsertarFondo(nuevo_nodo);    // se inserta el nodo a la lista equipos 
                conta++; // se aumenta el contador 1
                //esto se repite hasta que se acaba con la cantidad de equipos ingresados 
            }
          JOptionPane.showMessageDialog(null,"Ya se han ingresado los equipos al sistema","Informacion",JOptionPane.INFORMATION_MESSAGE); // mensaje de finalizacion de ciclo
        }
        else{
            if(Canti_eqp==0){ // en dado caso el usuario no a ingresado contidad de equipos no se podrian crear los equipos 
               JOptionPane.showMessageDialog(null,"Aun no se ha ingresado la cantidad de equipos","Error",JOptionPane.ERROR_MESSAGE);  
            }
            if(lista_eqp1.Vacia()==false){ // si la lista no esta vacia no se podran crear mas equipos 
           JOptionPane.showMessageDialog(null,"Ya se han ingresado los equipos","Error",JOptionPane.ERROR_MESSAGE); 
            }
        }
    }
   
    public void FormarPartidos(){//funcion que genera los partidos que se llevaran 
        if(lista_partidos.Vacia()){
        Nodo aux = lista_eqp1.getTope(), aux2; // se pasa la lista de partidos a un nodo auxiliar 
        while(aux!=null){ 
            aux2 = aux.getSig(); // se hace otro nodo axiliar para el nodo siguiente del nodo inicial aux 
            while(aux2!=null){ 
                Partido nuevo_partido = new Partido(); // se crea un nuevo objeto Partido para ingresar los equipos que van a juagar el partido 
                nuevo_partido.setEqp1(aux);// se ingresa el equipo pivote como equipo 1
                nuevo_partido.setEqp2(aux2); // y los siguiente equipos como equipo 2
                Nodo nodo_partido = new Nodo(); // creamos un nodo partido para ingresar el objeto partido 
                nodo_partido.setPartido(nuevo_partido); // ingresamos el objeto partido en el nodo
                lista_partidos.InsertarFondo(nodo_partido); // ingresamos el nodo en la lista de los partidos 
                aux2 = aux2.getSig(); // se pasa al siguinete nodo de aux2
                
                
            }
            aux = aux.getSig(); // se cambia de pivote que sera el siguiente elemento 
        }
     auxiiar = lista_partidos.getTope(); // ahora el auxiliar global va a hacer igual a la lista partidos ya que va hacer igual al tope de la lista 
     JOptionPane.showMessageDialog(null,"Partidos Generados","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
    }
        else{
           JOptionPane.showMessageDialog(null,"Ya se han generado los partidos","Error",JOptionPane.ERROR_MESSAGE); 
        }
        
    }
    // encontrar el factorial de un numero 
    public int  factorial (int numero) {
        int factorial =1;
  for(int i =1; i<=numero; i++){
      factorial = factorial*i;
  }
  return factorial;
  
}
}
