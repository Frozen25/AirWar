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
class ListaEnlazada {
    private Nodo Cabeza;
    private int Tamaño;

    public ListaEnlazada(){
        this.Cabeza = null;
        this.Tamaño = 0;
    }

    public boolean estaVacia(){
        return this.Cabeza == null;
    }

    public int Tamaño(){
        return this.Tamaño;
    }
    public void insertarDEPrimero(Object data){
        Nodo nuevoNodo = new Nodo(data);
        nuevoNodo.siguiente = this.Cabeza;
        this.Cabeza = nuevoNodo;
        this.Tamaño++;
    }
    public Nodo borrarPrimero(){
        if (this.Cabeza != null){
            Nodo temp = this.Cabeza;
            this.Cabeza = this.Cabeza.siguiente;
            this.Tamaño--;
            return temp;
        } else{
            return null;
        }
    }
}
