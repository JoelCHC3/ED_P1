package Excepcions;

public class ElementNoTrobat extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Excepció pel cas de voler esborrar un element que no existeix.
	 */
	public ElementNoTrobat(){
		super("No s'ha trobat l'element a esborrar.");
	}
	
	/**
	 * Excepció pel cas de no trobar un element sol·licitat a la llista.
	 * @param a Nombre d'accessos realitzats.
	 */
	public ElementNoTrobat(int a) {
		super("No s'ha trobat l'element a la llista. S'han accedit "+a+" elements.");
	}
}
