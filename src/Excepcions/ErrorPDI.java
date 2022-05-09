package Excepcions;

public class ErrorPDI extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Hi ha hagut un problema amb el PDI.
	 */
	public ErrorPDI(){
		super("ERROR : El PDI és nul.");
	}
}
