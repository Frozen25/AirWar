package uncategorized;

public class NodoGenerico<T> {
	private T tipo;
	private NodoGenerico<T> next;
	 public NodoGenerico(){
		 this.next=null;
	 }
	public T getDato() {
			return tipo;
		}
		
		
		public void setData(T dato) {
			this.tipo = dato;
		}
		
		
		public NodoGenerico<T> getNext() {
			return next;
		}
		
		public void SetNext(NodoGenerico<T> siguiente) {
			this.next = siguiente;
		}
}
