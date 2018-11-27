package model;

import java.time.Duration;
import java.util.Calendar;

/**
 * @author lucas pacheco, guilherme negrini, dieine Schiavon
 *
 * Criação da classe Atendimento
 * @param dado a ser adicionado: temperatura corporal, classificação da prioridade do atendimento e parecer do profissional
 * da saúde.
 * @return pessoa
 * @return hora de chegada
 * @return hora do atendimento
 * @return hora da saída
 * @return double: temperatura
 * @return int: prioridade
 * @return String: parecer
 */


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
	public Atendimento() {
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
	
	/**
     * Método que retorna o tempo passado entre a chegada até o atendimento inicial do paciente.
     * @param dado a ser encontrado: tempo que o paciente ficou aguardando atendimento.
     * @return a diferença entre a hora da chegada até a hora do atendimento inicial.
     */  
	
	public long getDiffHorasChegadaAtendimento() {
		if (this.horaChegada != null && this.horaAtendimento != null) {
			Duration diferencaTempo = Duration.between(this.horaChegada.toInstant(), this.horaAtendimento.toInstant());
			//System.out.println("Tempo de chegada até o atendimento: "+ timeElapsed.toMillis() / 1000);
			return diferencaTempo.toMillis() / 1000;
		} else {
			return 0;
		}
		
	}
	
	/**
     * Método que retorna o tempo passado entre o início  do atendimento até a hora da saída do paciente.
     * @param a ser encontrado: tempo que o paciente permaneceu em atendimento
     * @return a diferença entre a hora que o paciente entrou em atendimento até a hora da finalização do atendimento.
     */  
	public long getDiffHorasAtendimentoSaida() {
		if (this.horaSaida != null && this.horaAtendimento != null) {
			Duration diferencaTempo = Duration.between(this.horaAtendimento.toInstant(), this.horaSaida.toInstant());
			//System.out.println("Tempo do atendimento até a saída: "+ timeElapsed.toMillis() / 1000);
			return diferencaTempo.toMillis() / 1000;
		} else {
			return 0;
		}
		
	}
	
	/**
     * Método que retorna o tempo passado entre a chegada para atendimento até a hora da saída do paciente do atendimento.
     * @param a ser encontrado: tempo entre a chegada até a saída do atendimento
     * @return a diferença entre a hora que o paciente chegou para aguardar atendimento até a hora da finalização do atendimento.
     */  
	
	public long getDiffHorasChegadaSaida() {
		if (this.horaChegada != null && this.horaSaida != null) {
			Duration diferencaTempo = Duration.between(this.horaChegada.toInstant(), this.horaSaida.toInstant());
			//System.out.println("Tempo de chegada até a saída: "+ timeElapsed.toMillis() / 1000);
			return diferencaTempo.toMillis() / 1000;
		} else {
			return 0;
		}
		
	}
	
	
}
