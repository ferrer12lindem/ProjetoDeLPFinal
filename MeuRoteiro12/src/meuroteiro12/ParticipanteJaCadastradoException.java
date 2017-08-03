package meuroteiro12;


public class ParticipanteJaCadastradoException extends Exception {
	/**
	 * @param msgErro
	 */
	private static final long serialVersionUID = 1L;
	
	public ParticipanteJaCadastradoException(String msgErro){
		super(msgErro);
	}
}