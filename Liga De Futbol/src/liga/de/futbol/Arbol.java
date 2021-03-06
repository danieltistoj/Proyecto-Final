/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liga.de.futbol;

import java.io.PrintWriter;
import javax.swing.DefaultListModel;

/**
 *
 * @author Usuario
 */
public class Arbol {
    private Nodo raiz;
    private String cadena = "";
    private int conta, altura;
  
    
    public void Insertar(Equipo equipo){
        raiz = Agregar(raiz,equipo);
    }

    
    public Nodo Agregar(Nodo nodo, Equipo equipo){
        if(nodo==null){
            nodo = new Nodo();
            nodo.setEquipo(equipo);
            nodo.setHijo_der(null);
            nodo.setHijo_izq(null);
            nodo.setAltura(nodo.getAltura()+1);
            
            
        }
        else{
            //equipo entrante igual al nodo actual
            if(equipo.getPuntos()==nodo.getEquipo().getPuntos()){
             
                if(equipo.getDiferenci_goles()>nodo.getEquipo().getDiferenci_goles()){//si la diferencia de goles es mayor al nodo actual entra como mayor se le da "prioridad"
                nodo.setHijo_der(Agregar(nodo.getHijo_der(), equipo));
                nodo.setAltura(nodo.getAltura()+1);
                }
                if(equipo.getDiferenci_goles()<nodo.getEquipo().getDiferenci_goles()){//si la diferencia de goles es menor al nodo actual entra como menor
                nodo.setHijo_izq(Agregar(nodo.getHijo_izq(),equipo));
                nodo.setAltura(nodo.getAltura()+1);
                }
                if(equipo.getDiferenci_goles()==nodo.getEquipo().getDiferenci_goles()){// si la diferencia de goles es igual se coloca como un numero menor o se ingresa como menor 
                nodo.setHijo_izq(Agregar(nodo.getHijo_izq(),equipo));
                nodo.setAltura(nodo.getAltura()+1);

                }
            }
            //equipo entrante menor al nodo actual
            if(equipo.getPuntos()<nodo.getEquipo().getPuntos()){
                nodo.setHijo_izq(Agregar(nodo.getHijo_izq(),equipo));
                nodo.setAltura(nodo.getAltura()+1);
        
            }
            //equipo entrnate mayor al nodo actual
            if(equipo.getPuntos()>nodo.getEquipo().getPuntos()){
                nodo.setHijo_der(Agregar(nodo.getHijo_der(), equipo));
                nodo.setAltura(nodo.getAltura()+1);
            }
            
        }
        //Factor de equilibio
      int izq = getAltura(nodo.getHijo_izq()); // altura izquierda
      int der = getAltura(nodo.getHijo_der()); // altura derecha
      int eqb = der - izq; // diferencia / factor de equilibrio
      nodo.setEquilibrio(eqb);
        
      
      //Rotacion simple
      
      if(nodo.getEquilibrio()>1||nodo.getEquilibrio()<-1){
         
          if(izq>der){
              Nodo n1 = nodo.getHijo_izq();
              nodo.setHijo_izq(n1.getHijo_der());
             int  altura1 = getAltura(nodo);
              nodo.setAltura(altura);
              n1.setHijo_der(nodo);
              nodo = n1;
             // System.out.println("entro");
          }
          
          else{
              Nodo n1 = nodo.getHijo_der();
              nodo.setHijo_der(n1.getHijo_izq());
            int  altura1 = getAltura(nodo);
              nodo.setAltura(altura1);
              n1.setHijo_izq(nodo);
              nodo = n1;
              
          }
          

      }

        
        return nodo;
    }
    
   public Nodo Buscar(Equipo equipo){
   Nodo aux = raiz;
   conta=0;
       while(aux.getEquipo().getPuntos()!=equipo.getPuntos()){
           if(aux.getEquipo().getPuntos()>equipo.getPuntos()){
               aux = aux.getHijo_izq();
               conta++;
           }
           else{
               aux = aux.getHijo_der();
               conta++;
           }
           if(aux==null){
            break;
           }
          
       }
      
      return aux; 
   }
   
   
    public int getConta() {
        return conta;
    }
   
    
    public Nodo getRaiz() {
        return raiz;
    }
    
    public String Ordenar_Pos(){
        cadena = "";
        Nodo aux = raiz;
        Posorden(aux);
        return cadena;
        
    }
    public String Ordenar_Pre(){
        cadena ="";
        Nodo aux = raiz;
        Preorden(aux);
        return cadena;
        
    }
    public DefaultListModel Ordenar_In(DefaultListModel modelo){
        Nodo aux = raiz;
        Inorden(aux, modelo);
       return modelo;
    }
    
    public  PrintWriter Orndar_In2( PrintWriter linea){ // esta fucion se utiliza para guardar los datos de la clasificacion en un archivo txt
        Nodo aux = raiz;
        Inorden2(aux,linea);
        return linea;
    }
    
    private void Preorden(Nodo nodo_raiz){
        if(nodo_raiz!=null){
            cadena+=nodo_raiz.getEquipo().getNombre()+" ";
            Preorden(nodo_raiz.getHijo_izq());
            Preorden(nodo_raiz.getHijo_der());
        }
        
    }
    private void Posorden(Nodo nodo_raiz){
        if(nodo_raiz!=null){
            Posorden(nodo_raiz.getHijo_izq());
            Posorden(nodo_raiz.getHijo_der());
            cadena+=nodo_raiz.getEquipo().getNombre()+" ";
        }
        
    }
    private void Inorden(Nodo nodo_raiz,DefaultListModel modelo){
        if(nodo_raiz!=null){
            Inorden(nodo_raiz.getHijo_der(),modelo);
            modelo.addElement("Nombre: "+nodo_raiz.getEquipo().getNombre());
            modelo.addElement("Goles a favor: "+nodo_raiz.getEquipo().getGolesAfavor());
            modelo.addElement("Goles en contra: "+nodo_raiz.getEquipo().getGolesEncontra());
            modelo.addElement("Diferencia de goles: "+nodo_raiz.getEquipo().getDiferenci_goles());
            modelo.addElement("Puntos: "+nodo_raiz.getEquipo().getPuntos());
            modelo.addElement("...................................................................");
            Inorden(nodo_raiz.getHijo_izq(),modelo);
        }
        
    }
    
    private void Inorden2(Nodo nodo_raiz, PrintWriter linea){// metodo para agregar a cada linea del archivo cada dato 
          if(nodo_raiz!=null){
            Inorden2(nodo_raiz.getHijo_der(),linea);
            linea.println("Nombre: "+nodo_raiz.getEquipo().getNombre());
            linea.println("Goles a favor: "+nodo_raiz.getEquipo().getGolesAfavor());
            linea.println("Goles en contra: "+nodo_raiz.getEquipo().getGolesEncontra());
            linea.println("Diferencia de goles: "+nodo_raiz.getEquipo().getDiferenci_goles());
            linea.println("Puntos: "+nodo_raiz.getEquipo().getPuntos());
            linea.println("...................................................................");
            Inorden2(nodo_raiz.getHijo_izq(),linea);
        }
    }
    
    
    public void Altura(Nodo actual, int altura){
        if(actual!=null){
            Altura(actual.getHijo_izq(), altura+1);
            if(altura>this.altura){
                this.altura = altura;
            }
            Altura(actual.getHijo_der(), altura+1);
        }
    }
    
    public int getAltura(Nodo nodo){
        altura=0;
        Altura(nodo,1);
        return altura;
       
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
 
}
