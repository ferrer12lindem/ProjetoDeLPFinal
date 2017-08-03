package meuroteiro12;
import java.util.List;

public interface SistemaInscricoes {

	public void cadastraParticipante(Participante p) throws ParticipanteJaCadastradoException;

	public void removerParticipante(String emailParticipante) throws  ParticipanteNaoExisteException;

	public List<Participante> pesquisaParticipanteDaInstituicao(String nomeInstituicao);

	public List<Participante> pesquisaParticipanteDoEstado(String estado);

	public Participante pesquisaParticipante(String emailParticipante) throws ParticipanteNaoExisteException;

	public void inscreveParticipanteEmMinicurso(String emailParticipante, String tituloMinicurso)
			throws ParticipanteJaCadastradoException, MinicursoNaoExisteException, ParticipanteNaoExisteException;

	public List<Participante> getListaTotaldeParticipantes();

	public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso)
			throws ParticipanteJaCadastradoException;

	public void cadastraMinicurso(Minicurso m) throws MinicursoJaExisteException;

	public Minicurso pesquisaMinicurso(String titulo) throws MinicursoNaoExisteException;
}
