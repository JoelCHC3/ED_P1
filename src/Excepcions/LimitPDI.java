package Excepcions;

public class LimitPDI extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Excepció pel cas de voler avançar el PDI quan aquest ja es troba a la darrera posició.
	 * @param a Valor de control per diferenciar aquesta excepció de la corresponent a quan el PDI es troba a l'inici. El valor és irrellevant.
	 */
	public LimitPDI(int a){
		super("ERROR : No es pot avançar el PDI, ja que es troba a la darrera posició.");
	}
	
	/**
	 * Excepció pel cas de voler avançar el PDI quan aquest ja es troba a la primera posició.
	 */
	public LimitPDI(){
		super("ERROR : No es pot retrocedir el PDI, ja que es troba a la primera posició.");
	}
}
