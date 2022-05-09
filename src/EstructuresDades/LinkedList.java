package EstructuresDades;

import java.util.Iterator;
import Excepcions.*;
public class LinkedList<T extends Comparable<T>> extends Llista<T> implements Iterable<T> {

	Node<T> pdi = new Node<T>(null);
	
	/**
	 * Constructor de la LinkedList
	 * Crida a crea() per inicialitzar el node head i hi situa el PDI, amb tail com a següent node.
	 */
	public LinkedList() {
		crear();
		pdi = head;
	}
	
	/**
	 * Insereix un node que conté el valor donat.
	 * @param dades Valor a inserir.
	 * @throws ErrorInsercio
	 */
	public void inserir (T dades) throws ErrorInsercio {
		
		if ((pdi != null) && (tail != null) && (head != null)) {
			Node<T> nou = new Node<T>(dades);
			nou.setAnterior(pdi);
			nou.setSeguent(pdi.getSeguent());
			nou.getSeguent().setAnterior(nou);
			pdi.setSeguent(nou);
			pdi=nou;
			
			elements++;
		} else throw new ErrorInsercio();
	}
	
	public void esborrar (T dades) {}
	
	/**
	 * Esborra de la llista el node referenciat pel pdi situa aquest al següent node.
	 * En cas que el pdi estigués a l'últim element de la llista, serà situat al node
	 *  anterior (que serà ara l'últim).
	 * @throws ElementNoTrobat
	 */
	public void esborrar () throws ElementNoTrobat{
		if (pdi == head) throw new ElementNoTrobat();
		else {
			if(pdi.getSeguent() != tail) {
				pdi.getSeguent().setAnterior(pdi.getAnterior());
				pdi.getAnterior().setSeguent(pdi.getSeguent());
				pdi=pdi.getSeguent();
			}
			else {
				pdi=pdi.getAnterior();
				pdi.setSeguent(tail);
				tail.setAnterior(pdi);
			}
			elements--;
		};
	}
	
	/**
	 * Retorna el nombre d'elements de la llista.
	 */
	public int longitud () {
		return elements;
	}
	
	/**
	 * Comprova si un element es troba a la llista.
	 * Retorna el nombre de nodes accedits al final de la cerca.
	 * @param dades Valor a buscar.
	 * @return Nombre d'accessos.
	 * @throws ElementNoTrobat
	 */
	public int buscar (T dades) throws ElementNoTrobat {
		int accedits=0;
		boolean trobat=false;
		Node<T> cerca = new Node<T>(null);
		cerca=head;
		while((accedits<elements) && (!trobat)) {
			cerca=cerca.getSeguent();
			if (cerca.compareTo(dades)==0) {
				//System.out.println("L'element es troba a la llista!");
				trobat=true;
			}
			accedits++;
		}
		if (!trobat) {
			throw new ElementNoTrobat(accedits);
		}
		return accedits;
	}
	
	/**
	 * Retorna el valor del node apuntat pel PDI.
	 * @return Valor al node del PDI.
	 * @throws ErrorPDI
	 */
	public T actual () throws ErrorPDI {
		if (pdi == null) throw new ErrorPDI();
		return pdi.getDades();
	}
	
	/**
	 * Situa el PDI a l'inici de la llista.
	 * @throws ErrorPDI
	 * @throws ErrorHeadTail
	 */
	public void Principi () throws ErrorPDI, ErrorHeadTail{
		if (pdi == null) throw new ErrorPDI();
		else {
			if (head != null) {
				if (head.getSeguent().getDades() != null) {
					pdi = head.getSeguent();
				} else {pdi = head;}
				
			}
			else {
				throw new ErrorHeadTail();
			}
		}
	}
	
	/**
	 * Situa el PDI al final de la llista.
	 * @throws ErrorPDI
	 * @throws ErrorHeadTail
	 */
	public void Final () throws ErrorPDI, ErrorHeadTail{
		if (pdi == null) throw new ErrorPDI();
		else {
			if (tail != null) {pdi=tail.getAnterior();}
			else {
				throw new ErrorHeadTail(1);
			}
		}
	}
	
	/**
	 * Situa el PDI al node següent a on es troba ara.
	 * @throws ErrorPDI
	 * @throws LimitPDI
	 */
	public void Avancar () throws LimitPDI, ErrorPDI {
		if (pdi == null) throw new ErrorPDI();
		else {
			if ((pdi.getSeguent() != null) && (pdi.getSeguent() != tail)){pdi=pdi.getSeguent();}
			else {
				throw new LimitPDI(0);
			}
		}		
	}
	
	/**
	 * Situa el PDI al node anterior a on es troba ara.
	 * @throws ErrorPDI
	 * @throws LimitPDI
	 */
	public void Retrocedir () throws LimitPDI, ErrorPDI {
		if (pdi == null) throw new ErrorPDI();
		else {
			if (pdi.getAnterior() != null) {pdi=pdi.getAnterior();}
			else {
				throw new LimitPDI();
			}
		}		
	}
	
	/**
	 * Mètode per iterar els nodes de la llista.
	 */
	@Override
	public Iterator<T> iterator() {
		NodeIterator<T> nI = new NodeIterator<T>(this);
		return nI;
	}
	
	/**
	 * Mostra per pantalla la llista.
	 */
	public void printLinkedList() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("===LinkedList===\n");
		Node<T> inici = head;
		sb.append(inici.getDades());
		inici = inici.getSeguent();
		while (inici != null) {
			sb.append(" : ");
			sb.append(inici.getDades());
			inici = inici.getSeguent();
		}
		
		System.out.println(sb.toString());
		
	}
	
}
