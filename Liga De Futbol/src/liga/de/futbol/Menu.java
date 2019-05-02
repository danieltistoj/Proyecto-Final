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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Usuario
 */
public class Menu {
    private boolean next_botones=false,next_boton2=false,EntradaListaEqp=false,conf_pts=false,Tabla_hecha=false;
    private JList lista, lista2, lista3;
    private JScrollPane scrollLista, scrollpane,scrollClasificacion;
    private JFrame ventana;
    private JDialog ResultadoJornada,ListaEquipos,ClasGeneral;
    private JPanel panel, panel2, panel_listaEqp,panel_clasificacion;
    private DefaultListModel modelo, modelo2, modelo3;//declaramos el Modelo
    private JButton Parametro_prog, Ingreso_eqp, Ingreso_resul,Mostrar_ClsG,Configurar, Generar_partidos, Otros,Lista_eqp,Gresultados, AsgPuntos,GresultadosA;
    private int Canti_eqp=0;
    private Lista lista_eqp1, lista_partidos;
    private Nodo auxiiar;
    private Arbol arbol;
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
                String cadena, cadena2;
                cadena2 = "Jornada "+jornada;
                modelo.addElement(cadena2);
                while(conta<=PartidosPorJornada){//el contador va a recorrer de uno hasta el numero de partidos que debe de tener cada jornada que se ha asignado a la variable PartidosPorJornada
                    auxiiar.getPartido().GenerarGoles(puntos_ganar,puntos_perder,puntos_empate);//se generan los goles de cada partido
                    cadena2 = "Jornada "+jornada;//numero de la cadena
                    cadena = auxiiar.getPartido().getEqp1().getEquipo().getNombre()+"  -  "+auxiiar.getPartido().getGoles_eqp1()+"     "+" vs "+"    "+auxiiar.getPartido().getGoles_eqp2()+"    "+auxiiar.getPartido().getEqp2().getEquipo().getNombre();
                    modelo.addElement(cadena);// se ingresa la cadena en el modelo 
                    auxiiar = auxiiar.getSig(); // se pasa al siguiente nodo
                    conta++;
                    
                }//fin del while
                contador_jornadas++;//lleva una sumatoria de las jornadas que se van creando
                jornada++;//es solo para que indicar en la ventana por que jornada va 
                lista.setModel(modelo);
                panel2.repaint();
                }//fin de la segunda condicioin
                 else{
                  JOptionPane.showMessageDialog(null,"Asigne antes los puntos para cada caso: Ganador, Perdedor y Empate","Error",JOptionPane.ERROR_MESSAGE);   
                 }
                }//fin del primer if
            }
        });
       
       Mostrar_ClsG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lista_eqp1.Vacia()){
                    JOptionPane.showMessageDialog(null,"No hay equipos en el sistema","Error",JOptionPane.ERROR_MESSAGE);  
                }
                else{
                     ClasGeneral.setVisible(true);
              
                    if(lista_partidos.Vacia()!=true){
                        if(contador_jornadas==jornada2&&Tabla_hecha==false){
                        Nodo aux = lista_eqp1.getTope();
                        while(aux!=null){
                            arbol.Insertar(aux.getEquipo());
                            aux = aux.getSig();
                        }
                      Tabla_hecha = true;
                      modelo3=arbol.Ordenar_In(modelo3);
                      lista3.setModel(modelo3);
                      panel_clasificacion.repaint();
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
                   Ingreso_eqp.setBounds(200, 390, 225, 30);
                   Ingreso_resul.setBounds(200, 450, 225, 30);
                   Mostrar_ClsG.setBounds(200,510 , 225, 30);
                   
                     panel.add(Lista_eqp);
                     panel.repaint();
                    
                }
                else{
                   next_boton2 = false;
                   
                   panel.remove(Lista_eqp);  
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
    
    public void FormarPartidos(){
        Nodo aux = lista_eqp1.getTope(), aux2;
        while(aux!=null){
            aux2 = aux.getSig();
            while(aux2!=null){
                Partido nuevo_partido = new Partido();
                nuevo_partido.setEqp1(aux);
                nuevo_partido.setEqp2(aux2);
                Nodo nodo_partido = new Nodo();
                nodo_partido.setPartido(nuevo_partido);
                lista_partidos.InsertarFondo(nodo_partido);
                aux2 = aux2.getSig();
                
                
            }
            aux = aux.getSig();
            
        }
     auxiiar = lista_partidos.getTope();
     JOptionPane.showMessageDialog(null,"Ya se han generado los partidos","Error",JOptionPane.INFORMATION_MESSAGE); 
        
    }
    public int  factorial (int numero) {
        int factorial =1;
  for(int i =1; i<=numero; i++){
      factorial = factorial*i;
  }
  return factorial;
  
}
}
