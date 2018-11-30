package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import model.Atendimento;
import model.Paciente;

public class Tela {
	private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Método utilizado para mostrar o menu para o usuário
	 */
	public void mostarMenu() {
		System.out.println("\n========= Sistema de Controle de Emergência Hospitalar ==========");
		System.out.println(
				"Escolha uma das opções, digite: " + "\n 1 - Cadastrar novo Paciente " + "\n 2 - Pesquisar um Paciente "
						+ "\n 3 - Iniciar Atendimento de um paciente " + "\n 4 - Chamar Paciente para Triagem  "
						+ "\n 5 - Chamar Paciente para Consulta  " + "\n 6 - Realizar liberação do Paciente  "
						+ "\n 7 - Relatórios Adminsitrativos " + "\n 'Sair' - para Sair \n");
	}
	/**
	 * Método para preencher as informações de um paciente, 
	 * recebe como parâmetro o CPF, caso esse seja nulo, ele pede para inserir o CPF da pessoa. 
	 * Retorna um Paciente 
	 * @param String cpf
	 * @return Paciente
	 */
	public Paciente inserePaciente(String cpf) {
		Paciente paciente = new Paciente(); // instancia o paciente para preencher os dados
		paciente.setNome(realizaPerguntaSimples("Digite o nome do paciente:", "texto")); // preenche com o nome informado pelo usuário, que é retornado pela função realizaPerguntaSimples
		if (cpf == null) { // verifica se já está preenchido o CPF, caso não esteja o sistema pede para informar
			paciente.setCpf(realizaPerguntaSimples("Digite o CPF do paciente sem pontuação (pontuação irá ser desconsiderada):", "numero")); // preenche com o CPF informado pelo usuário, que é retornado pela função realizaPerguntaSimples
		} else {
			paciente.setCpf(cpf); // preenche o atributo do CPF
		}
		paciente.setAnoNascimento(Integer.parseInt(realizaPerguntaSimples("Digite o ano de nascimento: ", "numero"))); // preenche com o ano de nascimento informado pelo usuário, que é retornado pela função realizaPerguntaSimples
		System.out.println("Paciente " + paciente.getNome() + " cadastrado."); // retorno para o usuário de qual paciente foi inserido
		return paciente; // retorno da função de um objeto paciente para ser inserido nas filas/listas
	}
	/**
	 * Função para Preencher as informações do atendimento durante a realização da triagem e definir a prioridade do atendimento
	 * @param Atendimento atendimento
	 * @return Atendimento atendimento
	 */
	public Atendimento realizaTriagem(Atendimento atendimento) { // recebe o atendimento que irá ser alterado como parâmetro
		atendimento.setHoraAtendimento(Calendar.getInstance()); // aramazena a hora em que iniciou o atendimento
		System.out.println("Paciente " + atendimento.getPessoa().getNome() + " chamado para triagem."); // retorna para o usuário qual paciente foi chamado para a triagem
		atendimento.setTemperatura(Double.parseDouble(realizaPerguntaSimples("Qual a temperatura do paciente?", "numero"))); // preenche com temperatura informado pelo usuário, que é retornado pela função realizaPerguntaSimples
		boolean entubado = realizaPerguntaSimNao("Paciente encontra-se entubado/apenético? Está sem pulso/sem reação? (Sim ou não)");// preenche com verdadeiro ou falso informado pelo usuário, que é retornado pela função realizaPerguntaSimNao
		if (entubado) { // caso resposta da pergunta seja true ele já define a prioridade com 1
			atendimento.setPrioridade(1); // preenche a prioridade igual a um
			return atendimento; // retorna o atendimento editado
		} else {
			boolean altorisco = realizaPerguntaSimNao("Situação de alto risco? Está confuso/letárgico? Está desorientado ou dor/sofrimento agudo? (Sim ou não)"); // preenche com verdadeiro ou falso informado pelo usuário, que é retornado pela função realizaPerguntaSimNao
			if (altorisco) { // caso resposta da pergunta seja true ele já define a prioridade com 2
				atendimento.setPrioridade(2);// preenche a prioridade igual a dois
			} else {
				switch (realizaPerguntaNenhumaUmaMuitas("Quantas coisas diferentes são necessárias? "
						+ "Raio X, testes laboratoriais, injeções, procedimentos, consulta? (Nenhuma, uma ou muitas))")) { // preenche com o valor númérico retornado da função realizaPerguntaNenhumaUmaMuitas, que relaciona as respostas para números
					case 0: // caso a resposta for nenhuma
						atendimento.setPrioridade(5); // define prioridade igual a 5
						return atendimento; // retorna o atendimento editado
					case 1: // caso a resposta for uma
						atendimento.setPrioridade(4); // define prioridade igual a 4
						return atendimento;// retorna o atendimento editado
					case 2: // caso a resposta for muitas
						if (36 > atendimento.getTemperatura() || atendimento.getTemperatura() > 38) { // se a temperatura do paciente, informada previamente, for menor que 36 ou maior que 38
							atendimento.setPrioridade(2); // define prioridade igual a 2
							return atendimento;// retorna o atendimento editado
						} else {
							boolean apresenta = realizaPerguntaSimNao("Apresenta FC > 90 ou FR < 20 ou OP < 90% ou IPFR < 200? "); // preenche com verdadeiro ou falso informado pelo usuário, que é retornado pela função realizaPerguntaSimNao
							if (apresenta) { // caso a resposta do usuário for verdadeira
								atendimento.setPrioridade(2); // define prioriade igual a 2
							} else {
								atendimento.setPrioridade(3); // define prioridade igual a 3 caso seja negativa a resposta
							}
							return atendimento; // retorna o atendimento editado
						}
				}
			}
		}

		return atendimento; // retorna o atendimento editado
	}
	/**
	 * Função que recebe como parâmetro uma String, e que espera uma resposta do usuário, forçando que a resposta seja Sim ou Não.
	 * Para então retornar essa entrada em forma de boolean
	 * @param pergunta
	 * @return boolean
	 */
	public boolean realizaPerguntaSimNao(String pergunta) { // recebe como parâmetro a pergunta
		boolean passou = true; // define como passou true
		try {
			do { // realiza essa laço enquanto não houver uma resposta válida
				System.out.println(pergunta); // mostra a pergunta
				String resposta = this.bf.readLine(); // preenche com a resposta do usuário
				switch (resposta.toLowerCase()) { // valida a resposta do usuário, caso seja algum dos cases ele retorna o método, caso seja uma resposta não esperada ele pergunta novamente
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
					default: passou = false; // define como falso para perguntar novamente e ralizar outra leitura da resposta do usuário
				}
			} while (!passou); // enquanto a resposta não for válida segue executando
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Função que recebe como parâmetro uma String, e que espera uma resposta do usuário, forçando que a resposta seja Nenhuma, uma ou muitas.
	 * Para então retornar essa entrada em forma de inteiro
	 * @param String pergunta
	 * @return int
	 */
	public int realizaPerguntaNenhumaUmaMuitas(String pergunta) {  // recebe como parâmetro a pergunta
		boolean passou = true; // define como passou true
		try {
			do { // realiza essa laço enquanto não houver uma resposta válida
				System.out.println(pergunta); // mostra a pergunta
				String resposta = this.bf.readLine(); // preenche com a resposta do usuário
				switch (resposta.toLowerCase()) { // valida a resposta do usuário, caso seja algum dos cases ele retorna o método com seu respectivo identificador, caso seja uma resposta não esperada ele pergunta novamente
					case "nenhuma": 
						return 0;
					case "uma": 
						return 1;
					case "muitas": 
						return 2;
					default: passou = false; // define como falso para perguntar novamente e ralizar outra leitura da resposta do usuário
				}
			} while (!passou); // enquanto a resposta não for válida segue executando
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 4; // caso aconteça algo inesperado retorna 4 que é o identificador algo não ocorreu como o esperado
	}
	/**
	 * Função que recebe como parâmetro uma String pergunta e uma String tipo, e que espera uma resposta do usuário, forçando que a resposta seja conforme o tipo.
	 * Para então retornar essa entrada em forma de String
	 * @param String pergunta
	 * @param String tipo
	 * @return String
	 */
	public String realizaPerguntaSimples(String pergunta, String tipo) { // recebe a pergunta e o tipo como parâmetro
		boolean passou = true; // define passou como true
		try {
			do { // realiza essa laço enquanto não houver uma resposta válida
				System.out.println(pergunta);// mostra a pergunta
				String resposta = this.bf.readLine(); // preenche com a resposta do usuário
				switch (tipo.toLowerCase()) { // switch case para realizar as devidas validações conforme o tipo solicitado
					case "numero": // caso o solicitaco seja apenas números 
						resposta = resposta.replaceAll("[^0-9]", ""); // realiza a retirada de qualquer caracter que não seja número
						if (!resposta.equals("")) // se após remover todos os caractéres, isso não seja uma string vazia, retorna a resposta
							return resposta; // retorna o método com a resposta
					case "texto": // caso o solicitado seja um texto
						resposta = resposta.replaceAll("[^a-zA-Z]", ""); //retira caracteres que não sejam letras
						if (!resposta.trim().equals("")) // retira todos os espaços iniciais e finais, e caso isso não seja uma string vazia retorna a resposta
							return resposta; // retorna o me´todo com a resposta
					default: passou = false; // define como falso para perguntar novamente e ralizar outra leitura da resposta do usuário
				}
			} while (!passou); // enquanto a resposta não for válida segue executando
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Função para atualizar a consulta com um parecer caso desejado
	 * @param Atendimento consulta
	 */
	public void redigirParecer (Atendimento consulta) {
		if(this.realizaPerguntaSimNao("Gostaria de redigir um parecer?")) { // pergunta se o usuário quer realizar o parecer, retornando verdadeiro ou falso na condição
			System.out.println("Digite o parecer: "); // caso seja verdadeiro pergunta ao usuário
			try {
				consulta.setParecer(bf.readLine());  // preenche com o parecer do usuário
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
