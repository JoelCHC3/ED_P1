package EstructuresDades;

import java.util.Random;
import Excepcions.*;

public class SkipList <T extends Comparable<T>> extends Llista<T>{
	
	//private Node<T> tail = new Node<T>(null);
	public Node<T> resultat;
	
    private int max_nivell = 0;
    private int accessos = 0;
    
    public Random random = new Random();
    
	public int getAccessos() {
		return accessos;
	}
	
	public void setAccessos(int accessos) {
		this.accessos = accessos;
	}
	
    /**
     * Constructor de la SkipList.
     * Crida a crea() per inicialitzar el node head.
     * Inicialitza també el node tail i crea les referències.
     */
	public SkipList() {
		crear();
	}
	
	/**
	 * Troba el node immediatament anterior (al nivell més inferior) al node que
	 *  conté valor. Si cap node conté el valor, el node trobat correspon al
	 *  què hauria de ser l'anterior al suposat node contenidor de valor.
	 * @param valor El valor de referència.
	 * @return El node trobat.
	 */
	public Node<T> cerca (T valor) {
		Node<T> aux = head;
		accessos = 0;
		while (aux.getInferior() != null) {
			aux = aux.getInferior();
			accessos++;
			
			while ((aux.getSeguent().getDades() != null) && (aux.getSeguent().getDades().compareTo(valor) < 0)) {
				aux = aux.getSeguent();
				accessos++;
			}
		}
		return aux;
	}
	
	/**
	 * Fa la cerca d'un valor donat a la llista, cridant a la funció {@link #cerca(valor)}.
	 * Si el valor és a la llista, el node següent al trobat contindrà valor.
	 * Retorna els accessos fets per arribar al node final.
	 * @return Nombre d'accessos.
	 * @throws ElementNoTrobat
	 */
	public int buscar (T valor) throws ElementNoTrobat {
		Node<T> aux = cerca(valor);
		resultat = aux;
		if ((aux.getSeguent().getDades() == null) || (aux.getSeguent().getDades().compareTo(valor)) != 0) {
			throw new ElementNoTrobat(accessos);
		}
		return accessos;
	}
	
	/**
	 * Insereix un node (que conté valor) al nivell més inferior.
	 * Si no existia cap node que contingués valor, fa el procediment per crear
	 *  nodes als nivells superiors (flipCoin).
	 * Si ja existia un node contenint valor, assigna com a superior d'aquest nou node
	 *  el node superior al node original.
	 * @param valor Valor que volem al nou node.
	 * @throws ErrorInsercio
	 */
	public void inserir(T valor) throws ErrorInsercio {
		Node<T> posicio = cerca(valor);
		Node<T> aux = new Node<T>(null);
		int nivell = -1;
		if (posicio != null) {
			if (posicio.getSeguent().getDades() != valor) {
				do {
					nivell++;
					if (nivell >= max_nivell) {
						max_nivell++;
						afegirNivell();
					}
					
					aux = posicio;
					
					while (posicio.getSuperior() == null) {posicio = posicio.getAnterior();}
					
					posicio = posicio.getSuperior();
					
					inserirNouNode(posicio, aux, valor);
				} while (random.nextBoolean() == true);
			} else {
				aux.setDades(posicio.getSeguent().getDades());
				aux.setSeguent(posicio.getSeguent());
				aux.setAnterior(posicio);
				aux.getSeguent().setAnterior(aux);
				posicio.setSeguent(aux);
				aux.setSuperior(aux.getSeguent().getSuperior());
			}
			elements++;
		} else throw new ErrorInsercio();
		
	}
	
	/**
	 * Insereix un nou node a un nivell donat, creant les referències als nodes anterior
	 *  i següent i, si s'escau, les corresponents al node immediatament inferior.
	 * @param posicio Node superior al node aux.
	 * @param aux Node anterior al node nou.
	 * @param valor Valor a inserir al nou node.
	 */
	private Node<T> inserirNouNode(Node<T> posicio, Node<T> aux, T valor) {
        Node<T> nou = new Node<T>(valor);
        Node<T> anterior = posicio.getInferior().getInferior();
        
        nou.setSeguent(aux.getSeguent());	
        nou.setAnterior(aux);
        aux.getSeguent().setAnterior(nou);
        aux.setSeguent(nou);

        if (anterior != null) {
            while (true) {
                if (anterior.getSeguent().getDades() != valor) {
                    anterior = anterior.getSeguent();
                } else {
                    break;
                }
            }

            nou.setInferior(anterior.getSeguent());
            anterior.getSeguent().setSuperior(nou);
        }

        return nou;
    }
	
	/**
	 * Esborra de la llista el node que conté el valor donat.
	 * Si hi ha més d'un node contenint el mateix valor, n'elimina una de les "rèpliques", no
	 *  el node original (que conté les referències als nodes superiors si s'han creat).
	 * @param valor Valor que conté el node que volem esborrar.
	 * @throws ElementNoTrobat
	 */
	public void esborrar(T valor) throws ElementNoTrobat {
		Node<T> aux = cerca(valor);
		
		if (aux != null) {
			if (aux.getSeguent().getDades().compareTo(valor) == 0) {
				
				aux = aux.getSeguent();
				aux.getAnterior().setSeguent(aux.getSeguent());
				aux.getSeguent().setAnterior(aux.getAnterior());
				
				if (aux.getSeguent().getDades() != valor) {
					while (aux != null) {
						aux.getAnterior().setSeguent(aux.getSeguent());
						aux.getSeguent().setAnterior(aux.getAnterior());
						
						if (aux.getSuperior() != null) {
							aux = aux.getSuperior();
							aux.getInferior().setSuperior(null);
							aux.setInferior(null);
						} else {
							break;
						}
					}
					netejarNivells();
					elements--;
				}			
			}
		} else throw new ElementNoTrobat();
	}
	
	/**
	 * Comprova que no hi hagi nivells irrellevants. Només n'ha d'existir un sense referències a
	 *  nodes diferents dels inicials i finals.
	 */
	public void netejarNivells () {
		Node <T> aux = head;
		
		while ((max_nivell > 0) && (aux.getSeguent().getDades() == null)) {
			if (aux.getInferior().getSeguent().getDades() == null) {
				aux = aux.getInferior();
				aux.getSuperior().setInferior(null);
				aux.setSuperior(null);
				
				aux = aux.getSeguent();
				aux.getSuperior().setInferior(null);
				aux.setSuperior(null);
				
				tail = aux;
				head = aux.getAnterior();
				aux = head;
				max_nivell--;
			} else {break;}
		}
	}
	
	/**
	 * Afegeix un nou nivell a la llista. L'inicialitza amb dos únics nodes (head i tail)
	 *  amb referències entre ells i als corresponents nodes inicial i final inferiors.
	 */
	public void afegirNivell() {
		Node<T> auxHead = new Node<T>(null);
		Node<T> auxTail = new Node<T>(null);
		
		auxHead.setSeguent(auxTail);
		auxHead.setInferior(head);
		auxTail.setAnterior(auxHead);
		auxTail.setInferior(tail);
		
		head.setSuperior(auxHead);
		tail.setSuperior(auxTail);
		
		head = auxHead;
		tail = auxTail;
	}
	
	/**
	 * Mostra per pantalla la llista per nivells.
	 */
	public void printSkipList() {
        StringBuilder sb = new StringBuilder();
        sb.append("===SkipList===");

        Node<T> recorregut = head;

        Node<T> inici = recorregut;
        int level = this.max_nivell;

        while (inici != null) {
            sb.append("\nNivell: " + level + "\n");

            while (recorregut != null) {
                sb.append(recorregut.getDades());

                if (recorregut.getSeguent() != null) {
                    sb.append(" : ");
                }

                recorregut = recorregut.getSeguent();
            }

            inici = inici.getInferior();
            recorregut = inici;
            level--;
        }

        System.out.println(sb.toString());
    }
}
