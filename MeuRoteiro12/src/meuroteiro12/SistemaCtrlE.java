package meuroteiro12;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaCtrlE {

	public static void main(String[] args) {

		SistemaInscricoes sistema = new SistemaInscricoesList();
		GravadorDeParticipantes gravador = new GravadorDeParticipantes();

		Participante p = null;
		String emailAPesquisar = "";
		String titulo = null;

		boolean acabou = false;
		String opcao = null;

		do {
			opcao = JOptionPane.showInputDialog("Digite uma opção:\n\n" 
		            + "1 - Recupera Participante\n"
					+ "2 - Cadastrar Participante\n"
		            + "3 - Pesquisa Participante\n"
					+ "4 - Pesquisa Participante de Instituição\n"
		            + "5 - Pesquisa Participante do Estado\n"
					+ "6 - Remover Participante\n"
		            + "7 - Total de Participantes\n"
					+ "8 - Cadastrar Minicurso\n"
					+ "9 - Inscrever Participante em Minicurso\n"
					+ "10 - Total de Participantes de Minicurso\n"
					+ "11 - Pesquisar Minicurso\n"
					+ "12 - Gravar Participantes\n"
					+ "13 - Sair do Menu");

			switch (opcao) {

			case "1":

				List<Participante> participantes = new ArrayList<Participante>();
				try {
					JOptionPane.showMessageDialog(null, "Recuperar Participante...");
					participantes = gravador.recuperaParticipantes("Arquivo");
					JOptionPane.showMessageDialog(null, "Recuperado com sucesso!");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				break;

			case "2":

				JOptionPane.showMessageDialog(null, "Cadastrando Participante!");
				String nome = JOptionPane.showInputDialog(null, "Qual o nome?");
				String email = JOptionPane.showInputDialog(null, "Qual o email?");
				String instituicao = JOptionPane.showInputDialog(null, "Qual a instituição?");
				String logradouro = JOptionPane.showInputDialog(null, "Qual o logradouro?");
				String numero = JOptionPane.showInputDialog(null, "Qual o número?");
				String cidade = JOptionPane.showInputDialog(null, "Qual a cidade?");
				String estado = JOptionPane.showInputDialog(null, "Qual o estado?");

				Endereco end = new Endereco(logradouro, numero, cidade, estado);
				p = new Participante(nome, email, instituicao, end);
				try {
					sistema.cadastraParticipante(p);
				} catch (ParticipanteJaCadastradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case "3":

				try {
					emailAPesquisar = JOptionPane.showInputDialog(null, "Qual o email à pesquisar?");
					Participante p2 = sistema.pesquisaParticipante(emailAPesquisar);
					JOptionPane.showMessageDialog(null, "Participante encontrado:\n\n" + p2.toString());

				} catch (ParticipanteNaoExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				break;

			case "4":

				JOptionPane.showMessageDialog(null, "Pesquisando participante de Instituição!");
				instituicao = JOptionPane.showInputDialog("Informe a instituição");
				List<Participante> list = sistema.pesquisaParticipanteDaInstituicao(instituicao);
				if (list.size() != 0) {
					for (Participante part : list) {
						JOptionPane.showMessageDialog(null, "Existe participante desta instituição!");
						JOptionPane.showMessageDialog(null, "Nome dele: " + part.getNome());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não existe participante da: " + instituicao);
				}
				break;

			case "5":

				estado = JOptionPane.showInputDialog("Informe o estado");
				List<Participante> lista = sistema.pesquisaParticipanteDoEstado(estado);
				if (lista.size() != 0) {
					for (Participante participante : lista) {
						JOptionPane.showMessageDialog(null,
								"Existe participante desse estado de nome: " + participante.getNome());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não existe participantes do Estado");
				}
				break;

			case "6":
				JOptionPane.showMessageDialog(null, "Removendo Participantes...");
				emailAPesquisar = JOptionPane.showInputDialog("Informe um email à pesquisar");
				try {
					sistema.removerParticipante(emailAPesquisar);
					JOptionPane.showMessageDialog(null, "Participante removido com sucesso ");
				} catch (ParticipanteNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				break;

			case "7":

				JOptionPane.showMessageDialog(null, "Total de participantes: " + sistema.getListaTotaldeParticipantes().size());
				break;

			case "8":
				String tituloMinicurso = null;
				tituloMinicurso = JOptionPane.showInputDialog(null, "Qual o nome do minicurso?");
				int quant = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a quantidade de Participantes?"));
				Minicurso m = new Minicurso(tituloMinicurso, quant);
				try {
					sistema.cadastraMinicurso(m);
					JOptionPane.showMessageDialog(null, "minicurso cadastrado com sucesso: " + tituloMinicurso);
				} catch (MinicursoJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case "9":

				String emailParticipante = JOptionPane.showInputDialog("Qual o email?");
				titulo = JOptionPane.showInputDialog("Qual o título?");
				try {
					sistema.inscreveParticipanteEmMinicurso(emailParticipante, titulo);
					JOptionPane.showMessageDialog(null, "Participante cadastrado com sucesso no Minicurso!");
				} catch (ParticipanteJaCadastradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (MinicursoNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ParticipanteNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case "10":

				try {
					JOptionPane.showMessageDialog(null, "Participantes do Minicurso: "+titulo+": "+sistema.getParticipantesDoMinicurso(titulo).size());
				} catch (ParticipanteJaCadastradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				break;

			case "11":

				try {
					titulo = JOptionPane.showInputDialog("Informe o título à pesquisar: ");
					Minicurso minicurso = sistema.pesquisaMinicurso(titulo);
					JOptionPane.showMessageDialog(null, "O título de Minicurso: " + titulo +"! Existe");
				} catch (MinicursoNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case "12":

				try {
					JOptionPane.showMessageDialog(null, "Gravando participante...");
					gravador.gravaParticipantes(sistema.getListaTotaldeParticipantes(), "Arquivo");
					JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case "13":
				JOptionPane.showMessageDialog(null, "Saindo do Menu...");
				acabou = true;
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida! ");
				JOptionPane.showMessageDialog(null, "Digite uma opção de 1 à 13!");

			}
		} while (!acabou);
	}
}
