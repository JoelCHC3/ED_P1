package EstructuresDades;

public abstract class Llista <T extends Comparable<T>> implements TADLlista<T> {
	
	Node<T> head;
	Node<T> tail;
	int elements;
	
	public void crear() {
		this.head = new Node<T>(null);
		this.tail = new Node<T>(null);
		this.head.setAnterior(null);		
		this.head.setSeguent(this.tail);		
		this.tail.setAnterior(this.head);
		this.tail.setSeguent(null);
	}
	
	public int longitud () {
		return elements;
	}
	
}
