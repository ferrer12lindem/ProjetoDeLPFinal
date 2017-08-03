package meuroteiro12;
public class ParticipanteNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ParticipanteNaoExisteException(String msgErro){
	    super(msgErro);
	}
}
