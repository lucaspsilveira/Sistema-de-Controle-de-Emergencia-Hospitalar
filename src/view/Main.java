package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
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

					break;
				case "2":

					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					break;
				case "6":
					break;
				case "7":
					break;
				case "sair":
					sair = true;
					break;
				default:
					System.out.println("Insira um valor válido meu querido :)");
				}
			} while (!sair);
		} catch (Exception ex) {

		}
		System.out.println("Hasta la vista mi amor!");
	}
}
