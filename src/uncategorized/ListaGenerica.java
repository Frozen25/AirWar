package uncategorized;

public class ListaGenerica  {
    
    private NodoGenerico First;
    private NodoGenerico Last;
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
     
     public void Add(GameObject data){
         if (size != 0)
         {
        	 NodoGenerico n1 = new NodoGenerico();
        	 n1.setData(data);
        	 Last.SetNext(n1);
        	 Last = n1;
             size++;
         }
         else
         {
        	 NodoGenerico nuevoNodo = new NodoGenerico();
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
    	 NodoGenerico temp = First;
    	 while(temp!= null){
    		 System.out.println(temp.getDato()+",");
    		 temp=temp.getNext();
    	 }
    	
    
     }
     public void updatelis(){
    	 NodoGenerico temp = First;
    	 while(temp!= null){
    		 temp.getDato().update();
    		 temp=temp.getNext();
    	 }
     }
     public void renderList(){
    	 NodoGenerico temp = First;
    	 while(temp!= null){
    		 temp.getDato().render();
    		 temp=temp.getNext();
    	 }
     }
     

}
