package meuroteiro12;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeParticipantes {

	public void gravaParticipantes(List<Participante> participantes, String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for(Participante s: participantes){
				gravador.write(s.toString2());
			}
		}finally{
			if(gravador != null){
				gravador.close();
			}
		}
	}

	public List<Participante> recuperaParticipantes(String arquivo) throws IOException {
		BufferedReader leitor = null;
		List<Participante> textoLido = new ArrayList<Participante>();
		try{
			leitor = new BufferedReader(new FileReader(arquivo));
			String linha = leitor.readLine();
			while(linha != null){
				String[] info = linha.split(":");
				Endereco endereco = new Endereco(info[3], info[4], info[5], info[6]);
				Participante participante = new Participante(info[0], info[1], info[2], endereco);
		        textoLido.add(participante);
		        linha = leitor.readLine();
			}
		}finally{
			if(leitor != null){
				leitor.close();
			}
		}
		return textoLido;
	}
}
