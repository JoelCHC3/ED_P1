package EstructuresDades;

import java.util.Iterator;
import Excepcions.*;

public class NodeIterator <T extends Comparable<T>> implements Iterator<T>{
	private LinkedList<T> copiaLlista;
	
	/**
	 * Constructor de NodeIterator. Fa una còpia de la llista original a partir del PDI.
	 * @param ll Llista original.
	 */
	public NodeIterator(LinkedList<T> ll) {
		copiaLlista = new LinkedList<T>();
		boolean error=false;
		Node <T> pdiCopia = new Node<T>(null);
		pdiCopia = ll.pdi;
		
		for (int i=0;i<ll.longitud();i++) {
			
			try {
				copiaLlista.inserir(ll.actual());
				if (ll.pdi == ll.tail.getAnterior()) {
					try {
						ll.Principi();
					} catch (ErrorPDI exc) {
						System.out.println(""+exc.getMessage());
					} catch (ErrorHeadTail exc) {
						System.out.println(""+exc.getMessage());
					}
				} else {ll.Avancar();}
			} catch (ErrorInsercio exc) {
				System.out.println(""+exc.getMessage());
				System.out.println("No s'ha pogut fer la còpia de la llista per iterar.");
				error = true;
				break;
			} catch (LimitPDI exc) {
				System.out.println(""+exc.getMessage());
				break;
			} catch (ErrorPDI exc) {
				System.out.println(""+exc.getMessage());
			}
		}
		if (!error) {
			ll.pdi=pdiCopia;
			copiaLlista.pdi=copiaLlista.head;			
		}
		
	}
	
	/**
	 * Comprova si l'element actual té un element a continuació que no sigui null.
	 */
	@Override
	public boolean hasNext() {
		boolean resposta = false;
	
		if ((copiaLlista.pdi.getSeguent().getDades())!=null) {
			resposta=true;
		}
		
		return(resposta);
	}
	
	/**
	 * Retorna el valor del següent element i avança el PDI.
	 */
	@Override
	public T next() {
		T aux = null;
		
		aux = copiaLlista.pdi.getSeguent().getDades();
		
		if (copiaLlista.pdi != copiaLlista.tail) {
			try {
				copiaLlista.Avancar();
			} catch (LimitPDI exc) {
				System.out.println(""+exc.getMessage());
				aux = null;
			} catch (ErrorPDI exc) {
				System.out.println(""+exc.getMessage());
			}
		}
		
		return aux;
	}
	
	
}
