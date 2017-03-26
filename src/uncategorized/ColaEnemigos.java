/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uncategorized;

/**
 *
 * @author Alexis
 */
public class ColaEnemigos {
    private Nodo First = null;
    private Nodo Last = null;
    private int size = 0; 
    
    
    public ColaEnemigos(){

    }
    public boolean isEmpty(){
       return (size == 0);
    }
    
    public int getSize(){
        return size;
    }
    
    public void insert(int data){
        if (size != 0)
        {
            Nodo nuevoNodo = new Nodo(data);
            Last.setSiguiente(nuevoNodo);
            Last = nuevoNodo;
            size++;
        }
        else
        {
            Nodo nuevoNodo = new Nodo(data);
            First = nuevoNodo;
            Last = nuevoNodo;
            size++;
        }
    }
    
    public Nodo take()
    {
        if (size ==0)
        {
            return First;
        }
        if (size !=1)
        {
            Nodo temp = First;
            First = First.getSiguiente();
            size--;
            return temp;
            
        }
        else
        {
            Nodo temp = First;
            First = null;
            size = 0;
            return temp;
        }
    }
    
    public Nodo getFirst()
    {
        return First;
    }
    public Nodo getLast()
    {
        return Last;
    }
    
}
