package Excepcions;

public class LimitPDI extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Excepci� pel cas de voler avan�ar el PDI quan aquest ja es troba a la darrera posici�.
	 * @param a Valor de control per diferenciar aquesta excepci� de la corresponent a quan el PDI es troba a l'inici. El valor �s irrellevant.
	 */
	public LimitPDI(int a){
		super("ERROR : No es pot avan�ar el PDI, ja que es troba a la darrera posici�.");
	}
	
	/**
	 * Excepci� pel cas de voler avan�ar el PDI quan aquest ja es troba a la primera posici�.
	 */
	public LimitPDI(){
		super("ERROR : No es pot retrocedir el PDI, ja que es troba a la primera posici�.");
	}
}
