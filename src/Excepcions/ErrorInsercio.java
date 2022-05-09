package Excepcions;

public class ErrorInsercio extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * No s'ha pogut realitzar la inserció correctament.
	 */
	public ErrorInsercio() {
		super("Error en la inserció.");
	}
}
