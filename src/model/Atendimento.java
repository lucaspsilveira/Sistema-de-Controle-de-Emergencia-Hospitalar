package model;

import java.time.Duration;
import java.util.Calendar;

/***
 * 
 * @author lucas pacheco, guilherme negrini, dieineschiavon
 *
 */

public class Atendimento {
	private Paciente pessoa;
	private Calendar horaChegada;
	private Calendar horaAtendimento;
	private Calendar horaSaida;
	private double temperatura;
	private int prioridade;
	private String parecer;
		/***
		 * 
		 * @param pessoa - Objeto da classe Paciente
		 * @param horaChegada - Objeto da classe Calendar para registar hora de chegada
		 * @param horaAtendimento - Objeto da classe Calendar para registar hora de atendimento
		 * @param horaSaida - Objeto da classe Calendar para registar hora de saída
		 * @param temperatura - temperatura do paciente
		 * @param prioridade - prioridade de atendimento após a triagem
		 * @param parecer - relatório/parecer relevante
		 */
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
	
	//Getters e setters
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
	
	/***
	 * Método que retorna o tempo passado, em segundos, entre a chegada até o atendimento inicial do paciente.
	 * @return tempo que o paciente ficou aguardando atendimento.
	 */
	
	public long getDiffHorasChegadaAtendimento() {
		if (this.horaChegada != null && this.horaAtendimento != null) { //Confere se existem horários de chegada e atendimento
			Duration diferencaTempo = Duration.between(this.horaChegada.toInstant(), this.horaAtendimento.toInstant()); //Calcula a diferença entre dois objetos temporais (no nosso caso da Classe Calendar)
			return diferencaTempo.toMillis() / 1000; //transforma pra segundos
		} else {
			return 0; //Se não existem horários de chegada e atendimento, retorna 0
		}
		
	}
	
	/***
	 * Método que retorna o tempo passado, em segundos, entre o início do atendimento até a hora da saída do paciente.
	 * @return tempo que o paciente permaneceu em atendimento
	 */
	public long getDiffHorasAtendimentoSaida() {
		if (this.horaSaida != null && this.horaAtendimento != null) { //Confere se existem horários de saída e atendimento
			Duration diferencaTempo = Duration.between(this.horaAtendimento.toInstant(), this.horaSaida.toInstant()); //Calcula a diferença entre dois objetos temporais (no nosso caso da Classe Calendar)
			return diferencaTempo.toMillis() / 1000; //transforma pra segundos
		} else {
			return 0; //Se não existem horários de chegada e atendimento, retorna 0
		}
		
	}
	
	/**
     * Método que retorna o tempo passado, em segundos, entre a chegada para atendimento até a hora da saída do paciente do atendimento.
     * @return  tempo entre a chegada até a saída do atendimento
     */  
	
	public long getDiffHorasChegadaSaida() {
		if (this.horaChegada != null && this.horaSaida != null) { //Confere se existem horários de chegada e saída
			Duration diferencaTempo = Duration.between(this.horaChegada.toInstant(), this.horaSaida.toInstant()); //Calcula a diferença entre dois objetos temporais (no nosso caso da Classe Calendar)
			//System.out.println("Tempo de chegada até a saída: "+ timeElapsed.toMillis() / 1000);
			return diferencaTempo.toMillis() / 1000; //transforma pra segundos
		} else {
			return 0; //Se não existem horários de chegada e atendimento, retorna 0
		}
		
	}
	
	
}
