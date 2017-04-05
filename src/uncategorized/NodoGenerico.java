package uncategorized;

public class NodoGenerico {
	private GameObject tipo;
	private NodoGenerico next;
	 public NodoGenerico(){
		 this.next=null;
	 }
	public GameObject getDato() {
			return tipo;
		}	
		
		public void setData(GameObject dato) {
			this.tipo = dato;
		}
		
		
		public NodoGenerico getNext() {
			return next;
		}
		
		public void SetNext(NodoGenerico siguiente) {
			this.next = siguiente;
		}
}
