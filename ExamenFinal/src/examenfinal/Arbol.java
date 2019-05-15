/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinal;

/**
 *
 * @author Usuario
 */
public class Arbol {
      private Nodo raiz;
    private String cadena = "";
    private int conta, altura;
  
    
    public void Insertar(Datos dato){
        raiz = Agregar(raiz,dato);
    }

    
    public Nodo Agregar(Nodo nodo, Datos dato){
        if(nodo==null){
            nodo = new Nodo();
            nodo.setDato(dato);
            nodo.setHijo_der(null);
            nodo.setHijo_izq(null);
            nodo.setAltura(nodo.getAltura()+1);
            
            
        }
        else{
            if(dato.getSize()<nodo.getDato().getSize()){
                nodo.setHijo_izq(Agregar(nodo.getHijo_izq(), dato));
                nodo.setAltura(nodo.getAltura()+1);
        
            }
            if(dato.getSize()>nodo.getDato().getSize()){
                nodo.setHijo_der(Agregar(nodo.getHijo_der(), dato));
                nodo.setAltura(nodo.getAltura()+1);
            }
            
        }
        //Factor de equilibio
      int izq = getAltura(nodo.getHijo_izq()); // altura izquierda
      int der = getAltura(nodo.getHijo_der()); // altura derecha
      int eqb = der - izq; // diferencia / factor de equilibrio
      nodo.setEquilibrio(eqb);
        
      
      //Rotacion simple
      
      if(nodo.getEquilibrio()>1||nodo.getEquilibrio()<(-1)){
         
          if(izq>der){
             
                if(getAltura(nodo.getHijo_izq().getHijo_der())>getAltura(nodo.getHijo_izq().getHijo_izq())){
                    Nodo n1 = nodo.getHijo_izq();
                    Nodo n2 = n1.getHijo_der();
                    
                    n1.setHijo_der(n2.getHijo_izq());//n1.der = n2.izq
                    int altura1 = getAltura(n1); // encontramos la nueva altura del nodo n1
                    n1.setAltura(altura1); // insertamos la nueva altura del nodo n1
                    FactorEquilibrio(n1); // encontramos el nuevo factor de equilibrio del nodo
                    n2.setHijo_izq(n1);//n2.izq = n1;
                    nodo.setHijo_izq(n2.getHijo_der());//n.izq = n2.der
                    int altura2 = getAltura(nodo);// encontramos la nueva altura del nodo padre o raiz 
                    nodo.setAltura(altura2); //ingresamos la nueva altura del arbol nodo  raiz 
                    FactorEquilibrio(nodo); // buscamos el factor de equilibri nuevo de este arbol
                    n2.setHijo_der(nodo);// n2.der = n
                    int altura3 = getAltura(n2); // encontramos la altura del nodo n2 
                    n2.setAltura(altura3); // ingresamos la nueva altura del nodo n2
                    FactorEquilibrio(n2);
                    nodo = n2;//n = n2 // ahora el nodo n2 sera el nodo raiz o padre 
                }
                
                else{
               
              Nodo n1 = nodo.getHijo_izq();
              nodo.setHijo_izq(n1.getHijo_der());
              int  altura1 = getAltura(nodo);
              nodo.setAltura(altura1);
              n1.setHijo_der(nodo);
              nodo = n1;
                }
             
          }
          
          else{
              if(getAltura(nodo.getHijo_der().getHijo_izq())>getAltura(nodo.getHijo_der().getHijo_der())){
                  Nodo n1 = nodo.getHijo_der();
                  Nodo n2 = n1.getHijo_izq();
                  
                  n1.setHijo_izq(n2.getHijo_der());
                  int altura1 = getAltura(n1);
                  n1.setAltura(altura1);
                  FactorEquilibrio(n1);
                  n2.setHijo_der(n1);
                  nodo.setHijo_der(n2.getHijo_izq());
                  int altura2 = getAltura(nodo);
                  nodo.setAltura(altura2);
                  FactorEquilibrio(nodo);
                  n2.setHijo_izq(nodo);
                  int altura3 = getAltura(n2);
                  n2.setAltura(altura3);
                  FactorEquilibrio(n2);
                  nodo = n2;
                  
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
          

      }

        
        return nodo;
    }
    public void FactorEquilibrio(Nodo nodo){
        int altura_izq = getAltura(nodo.getHijo_izq());
        int altura_der = getAltura(nodo.getHijo_der());
        
        int FacEql = altura_der-altura_izq;
        nodo.setEquilibrio(FacEql);
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
            cadena+=nodo_raiz.getDato()+" ";
            Preorden(nodo_raiz.getHijo_izq());
            Preorden(nodo_raiz.getHijo_der());
        }
        
    }
    private void Posorden(Nodo nodo_raiz){
        if(nodo_raiz!=null){
            Posorden(nodo_raiz.getHijo_izq());
            Posorden(nodo_raiz.getHijo_der());
            cadena+=nodo_raiz.getDato()+" ";
        }
        
    }
    private void Inorden(Nodo nodo_raiz){
        if(nodo_raiz!=null){
            Inorden(nodo_raiz.getHijo_izq());
            cadena += "Dato: "+nodo_raiz.getDato().getNombre()+"-";
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
