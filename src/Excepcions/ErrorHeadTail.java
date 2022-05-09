package Excepcions;

public class ErrorHeadTail extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Excepci� pel cas de voler moure el PDI a l'inici, degut a un problema amb el node inicial.
	 */
	public ErrorHeadTail(){
		super("ERROR : No es pot moure el PDI, no s'ha trobat la primera posici�.");
	}
	
	/**
	 * Excepci� pel cas de voler moure el PDI al final, degut a un problema amb el darrer node.
	 * @param a Valor de control per diferenciar aquesta excepci� de la corresponent al problema amb el node inicial. El valor �s irrellevant.
	 */
	public ErrorHeadTail(int a){
		super("ERROR : No es pot moure el PDI, no s'ha trobat la darrera posici�.");
	}
}
