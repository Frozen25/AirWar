package uncategorized;

public class ListaGenerica <T> {
    private NodoGenerico<T> First = null;
    private NodoGenerico<T> Last = null;
    private int size = 0;
    
    public boolean isEmpty(){
        return (size == 0);
     }
     
     public int getSize(){
         return size;
     }
     public ListaGenerica(){
     	this.size = 0;
     	this.First = null;
     	this.Last = null;}
     
     public void Add(T data){
         if (size != 0)
         {
        	 NodoGenerico<T> nuevoNodo = new NodoGenerico<T>();
        	 nuevoNodo.setData(data);
             Last.SetNext(nuevoNodo);
             Last = nuevoNodo;
             size++;
         }
         else
         {
        	 NodoGenerico<T> nuevoNodo = new NodoGenerico<T>();
        	 nuevoNodo.setData(data);
             First = nuevoNodo;
             Last = nuevoNodo;
             size++;
         }
     }
     
     public void removeFirst()
     {
    	 First.SetNext(First.getNext());
         
     }
     public void print(){
    	 NodoGenerico<T> temp = First;
    	 while(temp.getNext()!= null){
    		 System.out.println(temp.getDato()+",");
    		 temp=temp.getNext();
    	 }System.out.println(temp.getDato()+",");
     }
     
     public static void main(String[] args){
    	 ListaGenerica<String> l1 =new ListaGenerica<String>();
    	 l1.Add("bums");
    	 l1.Add("datlof");
    	 l1.Add("sgfklg");
    	 l1.print();
     }

}
