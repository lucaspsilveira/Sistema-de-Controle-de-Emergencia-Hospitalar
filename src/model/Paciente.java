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
	private boolean emAtendimento;
	/***
	 * Cadastro com informações dos pacientes
	 * @param nome - Nome do paciente
	 * @param cpf - CPF do paciente
	 * @param anoNascimento - Ano de nascimento do paciente
	 * @param emAtendimento - Flag para saber se paciente ainda está em atendimento
	 */

	public Paciente(String nome, String cpf, int anoNascimento, boolean emAtendimento) { 
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.anoNascimento = anoNascimento;
		this.emAtendimento = emAtendimento;
	}
	public Paciente() {
	}
	
	//Getters e setters
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
	public boolean isEmAtendimento() {
		return emAtendimento;
	}
	public void setEmAtendimento(boolean emAtendimento) {
		this.emAtendimento = emAtendimento;
	}
	
	//Imprime dados cadastrais do paciente
	
	
	public void imprimePaciente() { 
		System.out.println("Nome: "+ this.getNome());
		System.out.println("CPF: "+ this.getCpf());
		System.out.println("Ano de nascimento: "+ this.getAnoNascimento());
	}
	
	
}
