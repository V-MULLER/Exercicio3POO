package excessoes;

public class DadosAbertosException extends Exception{
	private static final long serialVersionUID = 1L;
	
	
	public DadosAbertosException() {
		super("Falha nos dados abertos.");
	}
}
