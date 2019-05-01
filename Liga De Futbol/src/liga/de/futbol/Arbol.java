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
            if(equipo.getPuntos()<nodo.getEquipo().getPuntos()){
                nodo.setHijo_izq(Agregar(nodo.getHijo_izq(),equipo));
                nodo.setAltura(nodo.getAltura()+1);
        
            }
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
             int  altura = getAltura(nodo);
              nodo.setAltura(altura);
              n1.setHijo_der(nodo);
              nodo = n1;
              System.out.println("entro");
          }
          
          else{
              Nodo n1 = nodo.getHijo_der();
              nodo.setHijo_der(n1.getHijo_izq());
              int  altura = getAltura(nodo);
              nodo.setAltura(altura);
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
    public String Ordenar_In(){
        cadena = "";
        Nodo aux = raiz;
        Inorden(aux);
        return cadena;
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
    private void Inorden(Nodo nodo_raiz){
        if(nodo_raiz!=null){
            Inorden(nodo_raiz.getHijo_izq());
            cadena += "Dato: "+nodo_raiz.getEquipo().getNombre();
            Inorden(nodo_raiz.getHijo_der());
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
    
}
