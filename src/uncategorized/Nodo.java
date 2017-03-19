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
    private Object Enemigo;
    public Nodo siguiente;

    public Nodo(Object Enemigo){
        this.siguiente = null;
        this.Enemigo = Enemigo;

    }
    public Object getEnemigo(){
        return this.Enemigo;

    }
    public void setEnemigo(Object Enemigo){
        this.Enemigo = Enemigo;
    }
}
