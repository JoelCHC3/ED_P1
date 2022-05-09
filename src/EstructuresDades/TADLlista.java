package EstructuresDades;
import Excepcions.*;

/**
 * Interfície per definir mètodes de les llistes.
 */
public interface TADLlista<T> {
	/**
	 * Constructor per inicialitzar la llista.
	 */
	void crear();
	
	/**
	 * Funció per inserir un element a la llista.
	 * @param data Valor a inserir.
	 * @throws ErrorInsercio
	 */
	void inserir(T data) throws ErrorInsercio;
	
	/**
	 * Funció per esborrar un element concret de la llista.
	 * @param data Valor a esborrar
	 * @throws ElementNoTrobat
	 */
	void esborrar(T data) throws ElementNoTrobat;
	
	/**
	 * Retorna el nombre d'elements de la llista.
	 * @return Elements de la llista.
	 */
	int longitud();
	
	/**
	 * Comprova si un element està a la llista i retorna els accessos realitzats.
	 * @param data Element a buscar.
	 * @return Nombre d'accessos.
	 * @throws ElementNoTrobat
	 */
	int buscar (T data) throws ElementNoTrobat;
}
