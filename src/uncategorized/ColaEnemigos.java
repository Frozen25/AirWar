
package uncategorized;


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
    
    public void encolar(int data){
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
    
    public Nodo desencolar()
    {
        if (size ==0)
        {
            return null;
        }

        else if (size ==1)
        {
            Nodo temp = First;
            First = null;
            size = 0;
            return temp;
        }
        else 
        {
            Nodo temp = First;
            First = First.getSiguiente();
            size--;
            return temp;            
        }
    }
    
    public Nodo ver()
    {
        return First;
    }

}
