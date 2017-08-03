package meuroteiro12;
public class Endereco {

	private String logradouro;
	private String numero;
	private String cidade;
	private String estado;
	
	public Endereco(){
		this(" ", "", " ", " ");
	}
	
	public Endereco(String logradouro, String numero, String cidade, String estado){
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro(){
		return this.logradouro;
	}
	
	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}
	
	public String getNumero(){
		return this.numero;
	}
	
	public void setNumero(String numero){
		this.numero = numero;
	}
	
	public String getCidade(){
		return this.cidade;
	}
	
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	
	public String getEstado(){
		return this.estado;
	}
	
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	public String toString(){
		return "Logradouro: "+this.logradouro+"\nNúmero: "+this.numero+"\nCidade: "+this.cidade+"\nEstado: "+this.estado;
	}
}