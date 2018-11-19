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
					System.out.println("Digite o CPF do paciente que desejas pesquisar: (pontuação irá ser desconsiderada) ");
					pacienteEncontrado = listaPacientes.retornaNodoPaciente(bf.readLine().replaceAll("[^0-9]", ""));
					if (pacienteEncontrado == null)
						System.out.println("Paciente não Encontrado");
					else
						pacienteEncontrado.imprimePaciente();
					
					break;
				case "3":
					Atendimento atendimento = new Atendimento();
					System.out.println("Digite o CPF do paciente que desejas iniciar o antendimento: (pontuação irá ser desconsiderada) ");
					String cpf = bf.readLine().replaceAll("[^0-9]", "");
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
					System.out.println("Fila de Atendimentos");
					filaAtendimentos.imprimir();
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
