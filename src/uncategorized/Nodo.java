/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uncategorized;

/**
 *
 * @author Daniel Badilla Lobo
 */
class Nodo {
    private int Data;
    private Nodo siguiente;

    public Nodo(int Enemigo){
        siguiente = null;
        this.Data = Enemigo;

    }
    public int getData(){
        return Data;

    }
    public void setEnemigo(int Enemigo){
        Data = Enemigo;
    }
    public Nodo getSiguiente()
    {
        return siguiente;
    }
    public void setSiguiente(Nodo next)
    {
        siguiente = next;
    }
}
