package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberInputStream;

import TADPaciente.TadListaPaciente;
import model.Paciente;

public class Main {
	public static void main(String[] args) {
		TadListaPaciente listaPacientes = new TadListaPaciente();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			boolean sair = false;
			do {
				System.out.println("\n========= Sistema de Controle de Emergência Hospitalar ==========");
				System.out.println("Escolha uma das opções, digite: " + "\n 1 - Cadastrar novo Paciente "
						+ "\n 2 - Pesquisar um Paciente " + "\n 3 - Iniciar Atendimento de um paciente "
						+ "\n 4 - Chamar Paciente para Triagem  " + "\n 5 - Chamar Paciente para Consulta  "
						+ "\n 6 - Realizar liberação do Paciente  " + "\n 7 - Relatórios Adminsitrativos "
						+ "\n 'Sair' - para Sair \n");
				String res = bf.readLine();
				switch (res.toLowerCase()) {
				case "1":
					Paciente paciente = new Paciente();
					System.out.println("Digite o nome do paciente:");
					paciente.setNome(bf.readLine());
					System.out.println("Digite o CPF do paciente sem pontuação (pontuação irá ser desconsiderada):");
					paciente.setCpf(bf.readLine().replaceAll("[^0-9]", ""));
					System.out.println("Digite o ano de nascimento: ");
					paciente.setAnoNascimento(Integer.parseInt(bf.readLine().replaceAll("[^0-9]", "")));
					listaPacientes.adicionarNoComeco(paciente);
					break;
				case "2":
					System.out.println("Digite o CPF do paciente que desejas pesquisar: (pontuação irá ser desconsiderada) ");
					Paciente pacienteEncontrado = listaPacientes.retornaNodoPaciente(bf.readLine().replaceAll("[^0-9]", ""));
					if (pacienteEncontrado == null)
						System.out.println("Paciente não Encontrado");
					else
						pacienteEncontrado.imprimePaciente();
					
					break;
				case "3":
					System.out.println("Olá mundo!");
					System.out.println("oi");
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
