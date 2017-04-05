package uncategorized;


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
    public void insertarDEPrimero(int data){
        Nodo nuevoNodo = new Nodo(data);
        nuevoNodo.setSiguiente (this.Cabeza) ;
        this.Cabeza = nuevoNodo;
        this.Tamaño++;
    }
    public Nodo borrarPrimero(){
        if (this.Cabeza != null){
            Nodo temp = this.Cabeza;
            this.Cabeza = this.Cabeza.getSiguiente();
            this.Tamaño--;
            return temp;
        } else{
            return null;
        }
    }
}
