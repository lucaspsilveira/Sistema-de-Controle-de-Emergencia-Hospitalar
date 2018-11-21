package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberInputStream;
import java.util.Calendar;

import TADAtendimento.TadFilaAtendimento;
import TADPaciente.TadListaPaciente;
import model.Atendimento;
import model.Paciente;

public class Main {
	public static void main(String[] args) {
		Tela tela = new Tela();
		TadListaPaciente listaPacientes = new TadListaPaciente();
		TadFilaAtendimento filaAtendimentos = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos1 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos2 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos3 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos4 = new TadFilaAtendimento();
		TadFilaAtendimento filaAtendimentos5 = new TadFilaAtendimento();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			boolean sair = false;
			Paciente pacienteEncontrado = null;
			Paciente paciente = null;
			do {
				tela.mostarMenu();
				String res = bf.readLine();
				switch (res.toLowerCase()) {
				case "1":
					listaPacientes.adicionarNoComeco(tela.inserePaciente(null));
					break;
				case "2":
					pacienteEncontrado = listaPacientes.retornaNodoPaciente(tela.realizaPerguntaSimples("Digite o CPF do paciente que desejas pesquisar: (pontuação irá ser desconsiderada) ", "numero"));
					if (pacienteEncontrado == null)
						System.out.println("Paciente não Encontrado");
					else
						pacienteEncontrado.imprimePaciente();
					
					break;
				case "3":
					Atendimento atendimento = new Atendimento();
					String cpf = tela.realizaPerguntaSimples("Digite o CPF do paciente que desejas pesquisar: (pontuação irá ser desconsiderada) ", "numero");
					pacienteEncontrado = listaPacientes.retornaNodoPaciente(cpf);
					if (pacienteEncontrado == null) {
						paciente = new Paciente();
						System.out.println("Paciente não Encontrado");
						paciente = tela.inserePaciente(cpf);
						listaPacientes.adicionarNoComeco(paciente);
						pacienteEncontrado = paciente;
					}
					atendimento.setPessoa(pacienteEncontrado);
					atendimento.setHoraChegada(Calendar.getInstance());
					filaAtendimentos.enqueue(atendimento);
					System.out.println("Paciente "+ pacienteEncontrado.getNome()+ " adicionado na fila!");
					break;
				case "4":
					if (filaAtendimentos.isEmpty()) {
						System.out.println("Fila de atendimento vazia!");
					} else {
						Atendimento atendimentoTriagem = tela.realizaTriagem(filaAtendimentos.dequeue());
						System.out.println("Paciente " + atendimentoTriagem.getPessoa().getNome() + " vai pra fila de prioridade: "+ atendimentoTriagem.getPrioridade());
						switch (atendimentoTriagem.getPrioridade()) {
							case 1:
								filaAtendimentos1.enqueue(atendimentoTriagem);
								break;
							case 2:
								filaAtendimentos2.enqueue(atendimentoTriagem);
								break;
							case 3:
								filaAtendimentos3.enqueue(atendimentoTriagem);
								break;
							case 4:
								filaAtendimentos4.enqueue(atendimentoTriagem);
								break;
							case 5:
								filaAtendimentos5.enqueue(atendimentoTriagem);
								break;
						}
					}
		
					break;
				case "5":
					break;
				case "6":
					break;
				case "7":
					break;
				case "debug":
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
					break;
				case "sair":
					sair = true;
					break;
				default:
					System.out.println("Insira um valor válido meu querido :)");
				}
			} while (!sair);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Hasta la vista mi amor!");
	}
}
