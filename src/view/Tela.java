package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Atendimento;
import model.Paciente;

public class Tela {
	private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public void mostarMenu() {
		System.out.println("\n========= Sistema de Controle de Emergência Hospitalar ==========");
		System.out.println(
				"Escolha uma das opções, digite: " + "\n 1 - Cadastrar novo Paciente " + "\n 2 - Pesquisar um Paciente "
						+ "\n 3 - Iniciar Atendimento de um paciente " + "\n 4 - Chamar Paciente para Triagem  "
						+ "\n 5 - Chamar Paciente para Consulta  " + "\n 6 - Realizar liberação do Paciente  "
						+ "\n 7 - Relatórios Adminsitrativos " + "\n 'Sair' - para Sair \n");
	}

	public Paciente inserePaciente(String cpf) {
		Paciente paciente = new Paciente();
		paciente.setNome(realizaPerguntaSimples("Digite o nome do paciente:", "texto"));
		if (cpf == null) {
			paciente.setCpf(realizaPerguntaSimples("Digite o CPF do paciente sem pontuação (pontuação irá ser desconsiderada):", "numero"));
		} else {
			paciente.setCpf(cpf);
		}
		paciente.setAnoNascimento(Integer.parseInt(realizaPerguntaSimples("Digite o ano de nascimento: ", "numero")));
		System.out.println("Paciente " + paciente.getNome() + " cadastrado.");
		return paciente;
	}

	public Atendimento realizaTriagem(Atendimento atendimento) {
		System.out.println("Paciente " + atendimento.getPessoa().getNome() + " chamado para triagem.");
		atendimento.setTemperatura(Double.parseDouble(realizaPerguntaSimples("Qual a temperatura do paciente?", "numero")));
		boolean entubado = realizaPerguntaSimNao("Paciente encontra-se entubado/apenético? Está sem pulso/sem reação? (Sim ou não)");
		if (entubado) {
			atendimento.setPrioridade(1);
			return atendimento;
		} else {
			boolean altorisco = realizaPerguntaSimNao("Situação de alto risco? Está confuso/letárgico? Está desorientado ou dor/sofrimento agudo? (Sim ou não)");
			if (altorisco) {
				atendimento.setPrioridade(2);
			} else {
				switch (realizaPerguntaNenhumaUmaMuitas("Quantas coisas diferentes são necessárias? "
						+ "Raio X, testes laboratoriais, injeções, procedimentos, consulta? (Nenhuma, uma ou muitas))")) {
					case 0:
						atendimento.setPrioridade(5);
						return atendimento;
					case 1:
						atendimento.setPrioridade(4);
						return atendimento;
					case 2:
						if (36 > atendimento.getTemperatura() || atendimento.getTemperatura() > 38) {
							atendimento.setPrioridade(2);
							return atendimento;
						} else {
							boolean apresenta = realizaPerguntaSimNao("Apresenta FC > 90 ou FR < 20 ou OP < 90% ou IPFR < 200? ");
							if (apresenta) {
								atendimento.setPrioridade(2);
							} else {
								atendimento.setPrioridade(3);
							}
							return atendimento;
						}
				}
			}
		}

		return atendimento;
	}

	public boolean realizaPerguntaSimNao(String pergunta) {
		boolean passou = true;
		try {
			do {
				System.out.println(pergunta);
				String resposta = this.bf.readLine();
				switch (resposta.toLowerCase()) {
					case "sim": 
						return true;
					case "s": 
						return true;
					case "não": 
						return false;
					case "nao": 
						return false;
					case "n": 
						return false;
					default: passou = false;
				}
			} while (!passou);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public int realizaPerguntaNenhumaUmaMuitas(String pergunta) {
		boolean passou = true;
		try {
			do {
				System.out.println(pergunta);
				String resposta = this.bf.readLine();
				switch (resposta.toLowerCase()) {
					case "nenhuma": 
						return 0;
					case "uma": 
						return 1;
					case "muitas": 
						return 2;
					default: passou = false;
				}
			} while (!passou);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 4;
	}
	
	public String realizaPerguntaSimples(String pergunta, String tipo) {
		boolean passou = true;
		try {
			do {
				System.out.println(pergunta);
				String resposta = this.bf.readLine();
				switch (tipo.toLowerCase()) {
					case "numero":
						resposta = resposta.replaceAll("[^0-9]", "");
						if (!resposta.equals(""))
							return resposta;
					case "texto": 
						if (!resposta.trim().equals(""))
							return resposta;
					default: passou = false;
				}
			} while (!passou);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void redigirParecer (Atendimento consulta) {
		if(this.realizaPerguntaSimNao("Gostaria de redigir um parecer?")) {
			System.out.println("Digite o parecer: ");
			try {
				consulta.setParecer(bf.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
