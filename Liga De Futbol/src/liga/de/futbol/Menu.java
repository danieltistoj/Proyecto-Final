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
    private boolean next_botones=false,next_boton2=false,EntradaListaEqp=false;
    private JList lista, lista2;
    private JScrollPane scrollLista, scrollpane;
    private JFrame ventana,ResultadoJornada,ListaEquipos;
    private JPanel panel, panel2, panel_listaEqp;
    private DefaultListModel modelo, modelo2;//declaramos el Modelo
    private JButton Parametro_prog, Ingreso_eqp, Ingreso_resul,Mostrar_ClsG,Configurar, Generar_partidos, Otros,Lista_eqp,Informacion,Atras,Gresultados, Atras2;
    private int Canti_eqp=0;
    private Lista lista_eqp1, lista_partidos;
    private Nodo auxiiar;
    private int jornada=1, PartidosPorJornada;
    
    public Menu(){
        
        //scroll para un panel
        lista2 = new JList();
        lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        //inicializar scroll*
        scrollpane = new JScrollPane();//es para hacer una barra que pueda bajar para hacer y ver la lista completa...
        scrollpane.setBounds(0,30,600, 370);
        scrollpane.setViewportView(lista2);  
        //inicializar el modelo
        modelo2 = new DefaultListModel();
        
        Atras2 = new JButton("Atras");
        Atras2.setBounds(0,0,70,30);
        
        //boton para generar los resultados de los partidos de cada jornada
        Gresultados = new JButton("Generar Resultados");
        Gresultados.setBounds(450,0, 150,30);
          //boton para ir a la ventana menu
        Atras = new JButton("Atras");
        Atras.setBounds(0,0, 70,30);
        
        lista = new JList();
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        //inicializar scroll*
        scrollLista = new JScrollPane();//es para hacer una barra que pueda bajar para hacer y ver la lista completa...
        scrollLista.setBounds(0,30,600, 370);
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
        panel2.add(Atras);
        panel2.add(Gresultados);
        
        ResultadoJornada = new JFrame();
        ResultadoJornada.setSize(600, 400);
        ResultadoJornada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        panel_listaEqp.add(Atras2);
        
        ListaEquipos = new JFrame();
        ListaEquipos.setSize(400, 400);
        ListaEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ListaEquipos.setLocationRelativeTo(null);
        ListaEquipos.setLayout(null);
        ListaEquipos.add(panel_listaEqp);
        
        
       
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
         
        Generar_partidos= new JButton("Generar Partios");
        Generar_partidos.setBounds(300, 150, 225, 30);
        
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
                     panel.add(Generar_partidos);
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
                   panel.remove(Generar_partidos);
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
                   Canti_eqp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos equipos quiere en la liga")); // solicita la contidad de equipos
                   if(Canti_eqp%2==0){
                       PartidosPorJornada = Canti_eqp/2;
                   }
                   else{
                       PartidosPorJornada = (Canti_eqp-1)/(2);
                   }
               }
               else{
                    JOptionPane.showMessageDialog(null,"Ya se han ingresado la cantidad de equipos","Error",JOptionPane.ERROR_MESSAGE);  
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
         //fin del boton de generar partidos 
           
         // lista de los equipos en el sistema
         
       Lista_eqp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(false);
                ListaEquipos.setVisible(true);
                 if(lista_eqp1.Vacia()){
                   JOptionPane.showMessageDialog(null,"La lista de equipos esta vacia","Error",JOptionPane.ERROR_MESSAGE);   
                 }
                 else{
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

       
       Atras2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(true);
                ListaEquipos.setVisible(false);
            }
        });
       
       Atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoJornada.setVisible(false);
                ventana.setVisible(true);
            }
        });
       
       Ingreso_resul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              ventana.setVisible(false);
              ResultadoJornada.setVisible(true);
            }
        });
          
       Gresultados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(auxiiar!=null){
                int conta=1;
                String cadena, cadena2;
                cadena2 = "Jornada "+jornada;
                modelo.addElement(cadena2);
                while(conta<=PartidosPorJornada){
                    auxiiar.getPartido().GenerarGoles();
                    cadena2 = "Jornada "+jornada;
                    cadena = auxiiar.getPartido().getEqp1().getEquipo().getNombre()+"  -  "+auxiiar.getPartido().getGoles_eqp1()+"     "+" vs "+"    "+auxiiar.getPartido().getGoles_eqp2()+"    "+auxiiar.getPartido().getEqp2().getEquipo().getNombre();
                    modelo.addElement(cadena);
                    auxiiar = auxiiar.getSig();
                    conta++;
                    
                }
                jornada++;
                lista.setModel(modelo);
                panel2.repaint();
                }
            }
        });
       
       Mostrar_ClsG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lista_eqp1.Vacia()){
                    JOptionPane.showMessageDialog(null,"No hay equipos en el sistema","Error",JOptionPane.ERROR_MESSAGE);  
                }
                else{
                    Nodo aux = lista_eqp1.getTope();
                    while(aux!=null){
                        System.out.println("Nombre: "+aux.getEquipo().getNombre());
                        System.out.println("Goles a favor: "+aux.getEquipo().getGolesAfavor());
                        System.out.println("Goles en contra: "+aux.getEquipo().getGolesEncontra());
                        System.out.println("Puntos: "+aux.getEquipo().getPuntos());
                        System.out.println("................................................");
                        aux = aux.getSig();
                    }
                }
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
     JOptionPane.showMessageDialog(null,"Ya se han generado los partidos","Error",JOptionPane.ERROR_MESSAGE); 
        
    }
}
