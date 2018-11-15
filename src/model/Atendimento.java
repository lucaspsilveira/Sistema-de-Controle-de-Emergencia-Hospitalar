package model;

import java.util.Calendar;

public class Atendimento {
	private Paciente pessoa;
	private Calendar horaChegada;
	private Calendar horaAtendimento;
	private Calendar horaSaida;
	private double temperatura;
	private int prioridade;
	private String parecer;
		
	public Atendimento(Paciente pessoa, Calendar horaChegada, Calendar horaAtendimento, Calendar horaSaida,
			double temperatura, int prioridade, String parecer) {
		super();
		this.pessoa = pessoa;
		this.horaChegada = horaChegada;
		this.horaAtendimento = horaAtendimento;
		this.horaSaida = horaSaida;
		this.temperatura = temperatura;
		this.prioridade = prioridade;
		this.parecer = parecer;
	}
	public Paciente getPessoa() {
		return pessoa;
	}
	public void setPessoa(Paciente pessoa) {
		this.pessoa = pessoa;
	}
	public Calendar getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(Calendar horaChegada) {
		this.horaChegada = horaChegada;
	}
	public Calendar getHoraAtendimento() {
		return horaAtendimento;
	}
	public void setHoraAtendimento(Calendar horaAtendimento) {
		this.horaAtendimento = horaAtendimento;
	}
	public Calendar getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Calendar horaSaida) {
		this.horaSaida = horaSaida;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public String getParecer() {
		return parecer;
	}
	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	
	
}
