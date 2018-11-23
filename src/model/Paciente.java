package model;

public class Paciente {
	private String nome;
	private String cpf;
	private int anoNascimento;
	
	public Paciente(String nome, String cpf, int anoNascimento) { // construtor do paciente
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
	public void imprimePaciente() {
		System.out.println("Nome: "+ this.getNome());
		System.out.println("CPF: "+ this.getCpf());
		System.out.println("Ano de nascimento: "+ this.getAnoNascimento());
	}
	
	
}
