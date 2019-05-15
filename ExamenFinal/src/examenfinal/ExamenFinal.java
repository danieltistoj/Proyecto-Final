/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ExamenFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
         Scanner entrada3 = new Scanner(System.in);
          Scanner entrada4 = new Scanner(System.in);
           Scanner entrada5 = new Scanner(System.in);
           Arbol arbol = new Arbol();
           int opc =0;
          
           do{
             opc = Integer.parseInt(JOptionPane.showInputDialog("1-Crear archivo\n"+"2-Mostrar Archivo\n"+"3-Salir"));
               switch(opc){
                   case 1:
                       String nombre_archivo = JOptionPane.showInputDialog(null, "Nombre archivo\n"+"Ejemplo: nombre.txt");
                       String letra = JOptionPane.showInputDialog(null, "Ingrese la primera letra");
                       int tamano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamano")); 
                       Scanner sc = new Scanner(letra); 
                       char c = sc.next().charAt(0);
                    
                    int  i = (int) c;
                    System.out.println(i);
                    File archivo;
                    FileWriter escribir;
                    PrintWriter linea;
                   
                    
                       Datos  dato = new Datos();
                       dato.setNombre(nombre_archivo);
                       dato.setTamano(tamano);
                       dato.setSize(i);
                       arbol.Insertar(dato);
                       archivo = new File(nombre_archivo);
                        if(!archivo.exists()){ 
                            try {
                            
                            archivo.createNewFile();
                            escribir = new FileWriter(archivo,true);
                            linea = new PrintWriter(escribir);
                            String contenido = JOptionPane.showInputDialog(null, "Ingrese contenido del archivo");
                            linea.println(contenido);
                            JOptionPane.showMessageDialog(null,"Ya se han agregado las modificaciones al archivo: "+nombre_archivo,"Mensaje",JOptionPane.INFORMATION_MESSAGE);   
                            linea.close();
                            escribir.close();
                 } catch (IOException ex) {
                     Logger.getLogger(ExamenFinal.class.getName()).log(Level.SEVERE, null, ex);
                 }
                            
                       
                    }

                       
                       break;
                   case 2:
                       String cadena = arbol.Ordenar_In();
                       JOptionPane.showMessageDialog(null,cadena,"",JOptionPane.INFORMATION_MESSAGE);
                       break;
                   case 3:
                       break;
                   default:
                       System.out.println("La opcion es icorrecto");
                       break;
               }
           }while(opc!=3);
    }
    
}
