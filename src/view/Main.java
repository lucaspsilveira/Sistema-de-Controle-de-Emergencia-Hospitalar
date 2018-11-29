package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

import TADAtendimento.TadFilaAtendimento;
import TADAtendimento.TadListaAtendimento;
import TADPaciente.TadListaPaciente;
import model.Atendimento;
import model.Paciente;

public class Main {
	public static void main(String[] args) { // inicializa o programa
		// Instancia a tela que irá ser utilizada para chamar os métodos de inteação com o usuário
		Tela tela = new Tela();
		// Instancia as Listas, de pacientes e de atendimento, respectivamente.
		TadListaPaciente listaPacientes = new TadListaPaciente();
		TadListaAtendimento listaAtendimentosEncerrados = new TadListaAtendimento();
		// Instancia as filas que irão armazenar os atendimentos.
		TadFilaAtendimento filaAtendimentos = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos1 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos2 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos3 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos4 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos5 = new TadFilaAtendimento();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // inicializa o motor utilizado para a leitura das informações do usuário
			boolean sair = false; // define a variável de sair do programa como falso
			// Declara os pacientes utilziados posteriormente
			Paciente pacienteEncontrado = null; 
			Paciente paciente = null;
			do { // realiza essa laço enquanto não houver uma resposta válida e o usuário não escolher a opção de sair
				tela.mostarMenu(); // mostra o menu para o usuário
				String res = bf.readLine(); // realiza a leitura da resposta do usuário
				switch (res.toLowerCase()) { // estruturação do menu em um switch case, caso não for nenhuma das opções requeridas ele define como padrão a opção sair como false
				case "1": // Opção de inserir um paciente
					Paciente pacienteinserindo = tela.inserePaciente(null); // instacia o paciente que está sendo inserido
					if (listaPacientes.retornaNodoPacienteCpf(pacienteinserindo.getCpf()) == null) // verifica se já não existe paciente com este cpf
						listaPacientes.adicionarNoComeco(pacienteinserindo); // insere o paciente na lista de pacientes
					else
						System.out.println("Já existe paciente cadastrado com este CPF"); // informa que já existe alguém com esse cpf
					break;
				case "2": // opção de procurar um paciente
					// pergunta ao usuário qual o paciente desejado para a pesquisa através do seu CPF, e realiza a busca no método retornaNodoPacienteCpf
					//caso ele não exista o sistema retorna dizendo que não o encontrou
					pacienteEncontrado = listaPacientes.retornaNodoPacienteCpf(tela.realizaPerguntaSimples("Digite o CPF do paciente que desejas pesquisar: (pontuação irá ser desconsiderada) ", "numero"));
					if (pacienteEncontrado == null)
						System.out.println("Paciente não encontrado");
					else {
						pacienteEncontrado.imprimePaciente(); // imprime o buscado caso encontre-o
					}
					
					break;
				case "3": // Inicia um atendimento
					Atendimento atendimento = new Atendimento(); // instancia um atendimento
					String cpf = tela.realizaPerguntaSimples("Digite o CPF do paciente que desejas iniciar o atendimento: (pontuação irá ser desconsiderada) ", "numero"); // preenche com o CPF digitado pelo usuário para iniciar um atedimento
					// pesquisa através do seu CPF, e realiza a busca no método retornaNodoPacienteCpf
					//caso ele não exista o sistema adiciona um novo paciente com o cpf pesquisado
					pacienteEncontrado = listaPacientes.retornaNodoPacienteCpf(cpf);
					if (pacienteEncontrado == null) { // se não encontrou
						paciente = new Paciente(); // define como novo paciente
						System.out.println("Paciente não encontrado");
						System.out.println("Criando o cadastro:");
						paciente = tela.inserePaciente(cpf); // chama tela para preencher dados do paciente
						listaPacientes.adicionarNoComeco(paciente); // insere paciente na lista de pacientes
						pacienteEncontrado = paciente;
					}
					if (pacienteEncontrado.isEmAtendimento()) { // verifica se paciente já não está sendo atendido
						System.out.println("Paciente já se encontra em atendimento!");
					} else { // caso paciente não esteja sendo atendido
						listaPacientes.defineAtendimento(pacienteEncontrado.getCpf(), true); // marca flag de que o paciente está em atendimento
						atendimento.setPessoa(pacienteEncontrado); // define a pessoa do atendimento
						atendimento.setHoraChegada(Calendar.getInstance()); // define a hora em que o atendimento começou
						filaAtendimentos.enqueue(atendimento); // coloca na fila de atendimentos
						System.out.println("Paciente "+ pacienteEncontrado.getNome()+ " adicionado na fila!"); // retorna qual paciente foi adicinoado a fila
					}
					
					break;
				case "4": // Inicia Triagem do paciente
					if (filaAtendimentos.isEmpty()) { // verifica se a fila não está vazia
						System.out.println("Fila de atendimento vazia!"); // caso esteja informa para o usuário
					} else { // caso não esteja vazia
						Atendimento atendimentoTriagem = tela.realizaTriagem(filaAtendimentos.dequeue()); // retira o atendimento da fila geral de atendimentos e realiza a triagem
						System.out.println("Paciente " + atendimentoTriagem.getPessoa().getNome() + " vai pra fila de prioridade: "+ atendimentoTriagem.getPrioridade()); // informa para qual fila de prioridade o paciente ficou classificado
						switch (atendimentoTriagem.getPrioridade()) { // pega a prioridade do atendimento e coloca na sua devida fila
							case 1:
								filaAtendimentos1.enqueue(atendimentoTriagem); // armazena na fila de prioridade 1
								break;
							case 2:
								filaAtendimentos2.enqueue(atendimentoTriagem);// armazena na fila de prioridade 2
								break;
							case 3:
								filaAtendimentos3.enqueue(atendimentoTriagem);// armazena na fila de prioridade 3
								break;
							case 4:
								filaAtendimentos4.enqueue(atendimentoTriagem);// armazena na fila de prioridade 4
								break;
							case 5:
								filaAtendimentos5.enqueue(atendimentoTriagem);// armazena na fila de prioridade 5
								break;
						}
					}
		
					break;
				case "5": // Chama o paciente para a consulta
					Atendimento consulta = new Atendimento(); // instancia o atendimento consulta
					// nas condições a seguir o programa verifica fila por fila de prioriadade, da 1 a 5, e vai retirando elas nessa ordem e adicionando na fila de atendimentos encerrados
					if(!filaAtendimentos1.isEmpty()) { // verifica se fila de atendimentos prioridade 1 está vazia
						consulta = filaAtendimentos1.dequeue(); // retira o atendimento da fila 1
						System.out.println("Paciente " + consulta.getPessoa().getNome() + " encaminhado para a consulta."); // informa que paciente foi encaminhado para a consulta
						tela.redigirParecer(consulta);// informa que paciente foi encaminhado para a consulta
						listaAtendimentosEncerrados.adicionarNoFinal(consulta); // adiciona o atendimento na lista de atendimentos encerrados
						
					}else if (!filaAtendimentos2.isEmpty()) {// verifica se fila de atendimentos prioridade 2 está vazia
						consulta = filaAtendimentos2.dequeue();// retira o atendimento da fila 2
						System.out.println("Paciente " + consulta.getPessoa().getNome() + " encaminhado para a consulta.");// informa que paciente foi encaminhado para a consulta
						tela.redigirParecer(consulta);// informa que paciente foi encaminhado para a consulta
						listaAtendimentosEncerrados.adicionarNoFinal(consulta);// adiciona o atendimento na lista de atendimentos encerrados
						
					}else if(!filaAtendimentos3.isEmpty()) {// verifica se fila de atendimentos prioridade 3 está vazia
						consulta = filaAtendimentos3.dequeue();// retira o atendimento da fila 3
						System.out.println("Paciente " + consulta.getPessoa().getNome() + " encaminhado para a consulta.");// informa que paciente foi encaminhado para a consulta
						tela.redigirParecer(consulta);// informa que paciente foi encaminhado para a consulta
						listaAtendimentosEncerrados.adicionarNoFinal(consulta);// adiciona o atendimento na lista de atendimentos encerrados
						
					}else if(!filaAtendimentos4.isEmpty()) {// verifica se fila de atendimentos prioridade 4 está vazia
						consulta = filaAtendimentos4.dequeue();// retira o atendimento da fila 4
						System.out.println("Paciente " + consulta.getPessoa().getNome() + " encaminhado para a consulta.");// informa que paciente foi encaminhado para a consulta
						tela.redigirParecer(consulta);// informa que paciente foi encaminhado para a consulta
						listaAtendimentosEncerrados.adicionarNoFinal(consulta);// adiciona o atendimento na lista de atendimentos encerrados
						
					}else if(!filaAtendimentos5.isEmpty()) {// verifica se fila de atendimentos prioridade 5 está vazia
						consulta = filaAtendimentos5.dequeue();// retira o atendimento da fila 5
						System.out.println("Paciente " + consulta.getPessoa().getNome() + " encaminhado para a consulta.");
						tela.redigirParecer(consulta); // pergunta se quer redigir um parecer
						listaAtendimentosEncerrados.adicionarNoFinal(consulta);// adiciona o atendimento na lista de atendimentos encerrados
						
					}else {
						System.out.println("Todas as filas estão vazias."); // informa que todas as filas estão vazias
					}
					break;
				case "6": // Realiza a liberação do paciente
					Atendimento liberacao = new Atendimento(); // isntancia o atendimento de liberacao
					// recebe o cpf do paciente informado pelo usuário e chama o método de liberar o paciente, caso ele não seja encontrado ou liberado informa para o usuário
					liberacao = listaAtendimentosEncerrados.liberarPacienteAtendimento(tela.realizaPerguntaSimples("Digite o CPF do paciente que desejas liberar: (pontuação irá ser desconsiderada) ", "numero"));
					if (liberacao == null) // verifica se paciente não foi encontrado ou já foi liberado
						System.out.println("Não foi possível liberar o paciente. O mesmo já foi liberado ou não está cadastrado com este CPF no sistema."); // informa o usuário
					else { // caso tenha encontrado o paciente e liberado
						listaPacientes.defineAtendimento(pacienteEncontrado.getCpf(), false); // define como paciente que já está liberado e não está em atendimento
						if(tela.realizaPerguntaSimNao("Gostaria de consultar o parecer antes da liberação?")) { // realiza pergunta se deseja consultar parecer
							if(liberacao.getParecer() != null) { // se existir parecer
								System.out.println("Parecer: ");
								System.out.println(liberacao.getParecer()); // informa o parecer para o usuário
							}else {
								System.out.println("Não há parecer para esse paciente."); // informa que não encotrou parecer
							}
						}
						System.out.println("Paciente " + liberacao.getPessoa().getNome() + " liberado as " 
						+ liberacao.getHoraSaida().getTime().getHours() + " horas e " + liberacao.getHoraSaida().getTime().getMinutes() + " minutos."); // informa para o usuário a hora que o paciente foi liberado
					}
					break;
				case "7": // Informa os relatórios do sistema
					// Informa o Tempo médio de espera para atendimento (hora chegada até hora atendimento) em segundos aproximadamente 
					System.out.println("Tempo médio de espera para atendimento em segundos aproximadamente:  "+ listaAtendimentosEncerrados.calculaMediaChegadaAtendimento()); 
					// Informa o Tempo de espera para atendimento (hora chegada até hora saída) em segundos aproximadamente 
					System.out.println("Tempo médio de atendimento em segundos aproximadamente:  "+ listaAtendimentosEncerrados.calculaMediaAtendimentoSaida());
					// Informa o Tempo de espera para atendimento (hora chegada até hora saída) em segundos aproximadamente para cada fila de prioridade 
					System.out.println("Tempo médio de atendimento em cada fila: ");
					long[] mediaFilas = listaAtendimentosEncerrados.calculaMediaAtendimentoCadaFila(); // vetor para armazenar as médias de tempo de atendimento de cada fila
					for (int i = 0; i < mediaFilas.length; i++) { // laço para mostrar o tempo de cada fila
						System.out.println("Tempo médio de atendimento na fila "+ (i + 1)+ " : "+ mediaFilas[i]+ " segundos.");
					}
					break;
				case "debug": // opção realizada apenas para rápida visualização de todas as filas e listas
					System.out.println("Lista de Pacientes");
					listaPacientes.imprimir();
					System.out.println("");
					System.out.println("Fila de Atendimentos");
					filaAtendimentos.imprimir();
					System.out.println("Fila de atendimentos prioridade 1");
					filaAtendimentos1.imprimir();
					System.out.println("Fila de atendimentos prioridade 2");
					filaAtendimentos2.imprimir();
					System.out.println("Fila de atendimentos prioridade 3");
					filaAtendimentos3.imprimir();
					System.out.println("Fila de atendimentos prioridade 4");
					filaAtendimentos4.imprimir();
					System.out.println("Fila de atendimentos prioridade 5");
					filaAtendimentos5.imprimir();
					System.out.println("Lista de atendimentos encerrados");
					listaAtendimentosEncerrados.imprimir();
					break;
				case "sair": // encerra o sistema
					sair = true; // define como verdadeiro para sair do laço de repetição
					break;
				default:
					System.out.println("Insira um valor válido."); // caso o usuário não tenha entrado nenhuma resposta válida, informa-o para fazer isso
				}
			} while (!sair); // termina a execução do laço apenas quando o usuário escolher a opção sair
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Sistema encerrado."); // Informa que o sistema encerrou
	}
}
