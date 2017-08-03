package meuroteiro12;

public class Participante  {
	
	/**
	 * 
	 */
	private String nome;
	private String email;
	private String instituicao;
	private Endereco endereco;
	
	public Participante(){
		this(" ", " ", " ", new Endereco());
	}
	public Participante(String nome, String email, String instituicao, Endereco endereco){
		this.nome = nome;
		this.email = email;
		this.instituicao  = instituicao;
		this.endereco = endereco;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getInstituicao(){
		return this.instituicao;
	}
	
	public void setInstituicao(String instituicao){
		this.instituicao = instituicao;
	}
	
	public Endereco getEndereco(){
		return this.endereco;
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	
	public String toString(){
		return "Nome: "+this.nome+"\nEmail: "+this.email+"\nInstituição: "+this.instituicao+"\nEndereço: "+this.endereco;
	}
	
	public String toString2() {
		return nome+" : "+email+" : "+instituicao+" : "+endereco.getLogradouro()+" : "+endereco.getNumero()+" : "+endereco.getCidade()+" : "+endereco.getEstado()+"\n";
	}
}