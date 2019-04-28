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
public class Lista {
    private Nodo tope, fondo;
    private int size;
    
     public void InsertarTope(Nodo nuevo){
        
        if(Vacia()){
            tope = nuevo;
            fondo = nuevo;
            
            tope.setSig(null);
            tope.setAnt(null);
            
            fondo.setAnt(null);
            fondo.setSig(null);
            
            
        }
        else{
            Nodo aux = tope;
            aux.setAnt(nuevo);
            nuevo.setSig(aux);
            nuevo.setAnt(null);
            tope = nuevo;
            
        }
        size++;
    }
    
    public void InsertarFondo(Nodo nuevo){
   
        if(Vacia()){
            tope = nuevo;
            fondo = nuevo;
            
            tope.setSig(null);
            tope.setAnt(null);
            
            fondo.setAnt(null);
            fondo.setSig(null);
            
        }
        else{
            Nodo fin = fondo;
            fin.setSig(nuevo);
            nuevo.setAnt(fin);
            nuevo.setSig(null);
            fondo = nuevo;
            
        }
        size++;
    }
    /*
    public void Eliminar(int dato){
        if(size==1){
            tope=null;
            fondo=null;
        }
        else{
        if(dato==tope.getDato()){
            Nodo aux = tope;
            tope = aux.getSig();
            aux=null;
            
        }
        if(dato==fondo.getDato()){
            Nodo aux = fondo;
            fondo = aux.getAnt();
            fondo.setSig(null);
            aux = null;    
           
        }
        if(dato!=fondo.getDato()&&dato!=tope.getDato()){
            Nodo aux = tope;
            while(aux.getSig()!=null){
                if(dato==aux.getDato()){
                    Nodo anterior = aux.getAnt();
                    anterior.setSig(aux.getSig());
                    aux = null;
                    break;
                }
                aux = aux.getSig();
            }
        }
        }
        size--;
        
    }
    */
    /*
  
    public Nodo Buscar(int dato){
        Nodo aux = tope, nodo=null;
        
        boolean existe=false;
        while(aux!=null){
            if(dato==aux.getDato()){
                nodo=aux;
            }
            aux = aux.getSig();
        }
        return nodo;
        
    }
    
    public void Mostrar(){
        Nodo aux = tope;
        while(aux!=null){
            System.out.print(aux.getDato()+" ");
            aux = aux.getSig();
        }
    }
    */
    
    
    public boolean Vacia(){
        return(fondo==null)?true:false;
    }
    
}
