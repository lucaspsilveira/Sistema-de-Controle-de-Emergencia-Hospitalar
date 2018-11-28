package model;
/***
 * 
 * @author lucas pacheco, guilherme negrini, dieine schiavon
 *
 */

public class Paciente {
	private String nome;
	private String cpf;
	private int anoNascimento;
	/***
	 * Cadastro com informações dos pacientes
	 * @param nome
	 * @param cpf
	 * @param anoNascimento
	 */

	public Paciente(String nome, String cpf, int anoNascimento) { 
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.anoNascimento = anoNascimento;
	}
	public Paciente() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	
	//Imprime dados cadastrais do paciente
	
	public void imprimePaciente() { 
		System.out.println("Nome: "+ this.getNome());
		System.out.println("CPF: "+ this.getCpf());
		System.out.println("Ano de nascimento: "+ this.getAnoNascimento());
	}
	
	
}
