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
		System.out.println("Escolha uma das opções, digite: " + "\n 1 - Cadastrar novo Paciente "
				+ "\n 2 - Pesquisar um Paciente " + "\n 3 - Iniciar Atendimento de um paciente "
				+ "\n 4 - Chamar Paciente para Triagem  " + "\n 5 - Chamar Paciente para Consulta  "
				+ "\n 6 - Realizar liberação do Paciente  " + "\n 7 - Relatórios Adminsitrativos "
				+ "\n 'Sair' - para Sair \n");
	}
	
	public Paciente inserePaciente(String cpf) {
		Paciente paciente = new Paciente();
		try {
			System.out.println("Digite o nome do paciente:");
			paciente.setNome(this.bf.readLine());
			if (cpf == null) {
				System.out.println("Digite o CPF do paciente sem pontuação (pontuação irá ser desconsiderada):");
				paciente.setCpf(this.bf.readLine().replaceAll("[^0-9]", ""));
			} else {
				paciente.setCpf(cpf);
			}
			System.out.println("Digite o ano de nascimento: ");
			paciente.setAnoNascimento(Integer.parseInt(this.bf.readLine().replaceAll("[^0-9]", "")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public Atendimento insereAtendimento() {
		return null;
	}
}
