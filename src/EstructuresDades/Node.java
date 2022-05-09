package EstructuresDades;

public class Node <T extends Comparable<T>> implements Comparable<T> {
	private T dades;
	private Node<T> seguent;
	private Node<T> anterior;
	private Node<T> superior;
	private Node<T> inferior;
		
	public Node<T> getSuperior() {
		return superior;
	}

	public void setSuperior(Node<T> superior) {
		this.superior = superior;
	}

	public Node<T> getInferior() {
		return inferior;
	}

	public void setInferior(Node<T> inferior) {
		this.inferior = inferior;
	}
	/**
	 * Constructor del node.
	 * @param dades Valor a inserir al node.
	 */
	public Node (T dades) {
		this.dades = dades;
		this.setAnterior(null);	
		this.setSeguent(null);
		this.setSuperior(null);
		this.setInferior(null);
	}

	public Node<T> getSeguent() {
		return seguent;
	}

	public void setSeguent(Node<T> seguent) {
		this.seguent = seguent;
	}

	public Node<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Node<T> anterior) {
		this.anterior = anterior;
	}
	
	
	public T getDades() {
		return dades;
	}

	public void setDades(T dades) {
		this.dades = dades;
	}

	@Override
	public String toString() {
		return "" + dades + "";
	}
	/**
	 * Compara el valor del camp dades d'un node amb el valor passat a l'argument.
	 * @param dades Valor amb què es vol comparar el valor del node.
	 */
	public int compareTo(T dades) {
		int retorn;
		if (this.getDades().compareTo(dades) == 0) {
			retorn = 0;	//igual
		}
		else if (this.getDades().compareTo(dades) < 0) {
			retorn = -1;	//més petit que l'argument
		}
		else retorn = 1;	//més gran que l'argument
		
		return retorn;
	}	
}
