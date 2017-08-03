package meuroteiro12;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class Minicurso {

	private List<Participante> participantes;
	private int maxParticipantes;
	private String tituloMinicurso;
	
	public Minicurso(String titulo, int maxParticipantes){
		this.tituloMinicurso = titulo;
		this.maxParticipantes = maxParticipantes;
		this.participantes = new ArrayList<Participante>();
	}
	
	public void cadastraParticipante(Participante p){
		this.participantes.add(p);
	}
	
	public boolean existeParticipante(Participante part){
		boolean existe = false;
		for(Participante p: this.participantes){
			if(part.getEmail().equals(p.getEmail())){
				existe = true;
			}
		}
		return existe;
	}
	
	public List<Participante> getParticpantes(){
		return this.participantes;
	}
	
	public int getMaxParticipantes(){
		return this.maxParticipantes;
	}
	
	public String getTitulo(){
		return this.tituloMinicurso;
	}
}