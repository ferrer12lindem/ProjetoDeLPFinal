package meuroteiro12;
import java.util.List;
import java.util.ArrayList;

public class SistemaInscricoesList implements SistemaInscricoes {
	private List<Participante> participantes;
	private List<Minicurso> minicurso;

	public SistemaInscricoesList() {
		this.participantes = new ArrayList<Participante>();
		this.minicurso = new ArrayList<Minicurso>();
	}

	public void cadastraParticipante(Participante part) throws ParticipanteJaCadastradoException {
		for(Participante p: this.participantes){
			if(p.getEmail().equals(part.getEmail())){
				throw new ParticipanteJaCadastradoException("Já existe um usuário com este e-mail: "+part.getEmail());
			}
		}
		this.participantes.add(part);
	}

	public void removerParticipante(String emailParticipante) throws ParticipanteNaoExisteException{
		for(Participante p: this.participantes){
			if(p.getEmail().equals(emailParticipante)){
				this.participantes.remove(p);
				return;
			}
		}
		throw new ParticipanteNaoExisteException("Participante não existe");
	}

	public List<Participante> pesquisaParticipanteDaInstituicao(String nomeInstituicao) {
		List<Participante> lista = new ArrayList<Participante>();
		for (Participante p : this.participantes) {
			if (p.getInstituicao().equals(nomeInstituicao)) {
				lista.add(p);
			}
		}
		return lista;
	}

	public List<Participante> pesquisaParticipanteDoEstado(String estado) {
		List<Participante> lista = new ArrayList<Participante>();
		for (Participante p : this.participantes) {
			if (p.getEndereco().getEstado().equals(estado)) {
				lista.add(p);
			}
		}
		return lista;
	}

	public Participante pesquisaParticipante(String emailParticipante) throws ParticipanteNaoExisteException{
		for(Participante p: this.participantes){
			if (emailParticipante.equalsIgnoreCase(p.getEmail())) {
				return p;
			}
		}
		throw new ParticipanteNaoExisteException("Não existe o participante procurado!");		
	}

	public void inscreveParticipanteEmMinicurso(String emailParticipante, String tituloMinicurso) throws ParticipanteJaCadastradoException, ParticipanteNaoExisteException, MinicursoNaoExisteException {
		Participante p = pesquisaParticipante(emailParticipante);
		Minicurso m = pesquisaMinicurso(tituloMinicurso);
		if(m.existeParticipante(p)){
			throw new ParticipanteJaCadastradoException("Participante já cadastrado");
		}
		m.cadastraParticipante(p);
	
	}

	public List<Participante> getListaTotaldeParticipantes() {
		return this.participantes;		
	}

	public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso) {
		List<Participante> lista = new ArrayList<Participante>();
		for (Minicurso p : this.minicurso) {
			if (p.getTitulo().equals(tituloMinicurso)) {
				lista = p.getParticpantes();
				break;
			}
		}
		return lista;
	}

	public void cadastraMinicurso(Minicurso m) throws MinicursoJaExisteException {
		for(Minicurso mm: this.minicurso){
			if(mm.getTitulo().equals(m.getTitulo())){
				throw new MinicursoJaExisteException("Minicurso já existe");
			}
		}
		this.minicurso.add(m);
	}

	public Minicurso pesquisaMinicurso(String titulo) throws MinicursoNaoExisteException {
		for(Minicurso m: this.minicurso){
			if(m.getTitulo().equals(titulo)){
				return m;
			}
		}
		throw new MinicursoNaoExisteException("Não existe minicurso");
	}
}
