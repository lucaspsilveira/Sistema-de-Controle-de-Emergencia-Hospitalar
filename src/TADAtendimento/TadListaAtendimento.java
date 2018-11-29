package TADAtendimento;
import java.util.Calendar;

import TADPaciente.NodoPacienteFila;
import model.Atendimento;
/***
 * 
 * @author lucas pacheco guilherme negrini, dieine schiavon
 *
 */
public class TadListaAtendimento {
	private NodoAtendimentoLista primeiro;
	private NodoAtendimentoLista ultimo;
	

	public TadListaAtendimento() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	/***
	 * Método para inserir o atendimento no final da lista.
	 * @param dado - Objeto da classe Atendimento
	 */
	public void adicionarNoFinal(Atendimento dado) {
		NodoAtendimentoLista novoNodoAtendimento = new NodoAtendimentoLista(dado);
		if (primeiro == null) {
			// Se lista está vazia o elemento será o primeiro e último
			primeiro = novoNodoAtendimento;
			ultimo = novoNodoAtendimento;
		} else { 
			ultimo.proximo = novoNodoAtendimento; //Senão, o último atendimento passa a apontar para o novo elemento
			novoNodoAtendimento.anterior = ultimo; //O novo aponta para o último
			ultimo = novoNodoAtendimento; //E o último é atualizado para o novo elemento adicionado
		}
	}
	/***
	 * Método para inserir o atendimento no início da lista.
	 * @param dado - Objeto da classe Atendimento
	 */
	
	public void adicionarNoComeco(Atendimento dado) {
		NodoAtendimentoLista novoNodoAtendimento = new NodoAtendimentoLista(dado);
		if (primeiro == null) {
			// Se lista está vazia o elemento será o primeiro e último
			primeiro = novoNodoAtendimento;
			ultimo = novoNodoAtendimento;
		} else {
			primeiro.anterior = novoNodoAtendimento; //Senão, o anterior do primeiro atendimento passa a apontar para o novo elemento
			novoNodoAtendimento.proximo = primeiro; //O novo aponta para o primeiro
			primeiro = novoNodoAtendimento; //E o primeiro é atualizado para o novo elemento adicionado
		}
	}
	/***
	 * Método que remove o elemento atendimento contido em determinada posição da lista.
	 * @param posicao a ser removida
	 */
	public void removePosicao(int posicao) {
		NodoAtendimentoLista remover = retornaNodoAtendimento(posicao); //Busca qual o nodo está na posição informada
		if (remover == primeiro) { //Se for o primeiro, atualiza o segundo elemento como novo primeiro
			primeiro.proximo.anterior = null;
			primeiro = primeiro.proximo;
		} else if (remover == ultimo) { //Se for o último, atualiza o penúltimo como novo último
			ultimo.anterior.proximo = null;
			ultimo = ultimo.anterior;
		} else { //Se não for nem primeiro nem último, o nodo anterior à posição informada aponta para o nodo posterior à posição e vice-versa
			remover.anterior.proximo = remover.proximo;
			remover.proximo.anterior = remover.anterior;
		}
	}
	/***
	 * Método que retorna o elemento atendimento contido em determinada posição.
	 * @param posicao a ser encontrada
	 * @return aux - Nodo da lista de atendimentos
	 */
	public NodoAtendimentoLista retornaNodoAtendimento(int posicao) {
		NodoAtendimentoLista aux = primeiro;
		for (int i = 0; i < posicao; i++) { //Percorre a lista até chegar na posição anterior à informada
			if (aux != null) {
				aux = aux.proximo;
			} else {
				break;
			}
		}
		return aux;
	}
	
	/***
	 * Método que realiza a busca do paciente pelo cpf
	 * @param dado - CPF informado
	 * @return Atendimento do paciente com o CPF informado
	 */
	public Atendimento retornaNodoAtendimentoCpf(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (aux!=null) {
			if (aux.dado.getPessoa().getCpf().equalsIgnoreCase(dado)) {
				return aux.dado;
			}
		// fecha o if do caso onde encontrou o dado
			// verifica se chegou ao final, senão chegou, passa
			// para o próximo
			if (aux == ultimo) {
				break;
			} else {
				aux = aux.proximo;
			}
		} // fecha o while
		return null;
	}
	/***
	 * Método que realiza a busca do elemento na lista que se encontra em determinada posição, finaliza 
	 * a busca se o elemento for encontrado, caso contrário, retorna nulo.
	 * @param posicao
	 */
	
	public Atendimento retornaDado(int posicao) {
		NodoAtendimentoLista aux = primeiro;
		for (int i = 0; i < posicao; i++) {
			if (aux != null) {
				aux = aux.proximo;
			} else {
				break;
			}
		}
		if (aux == null) {
			return null;
		} else {
			return aux.dado;
		}
	}
	/***
	 * Método que finaliza o atendimento e libera o paciente, pesquisa o registro na lista de atendimentos
	 * e registra a hora da saída do paciente
	 * @param dado - CPF do paciente a ser liberado
	 * @return Atendimento
	 */
	public Atendimento liberarPacienteAtendimento(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (aux!=null) { //Percorre a lista até encontrar um paciente cujo CPF seja igual ao informado
			if (aux.dado.getPessoa().getCpf().equalsIgnoreCase(dado)) {
				if (aux.dado.getHoraSaida() == null)
					aux.dado.setHoraSaida(Calendar.getInstance()); //Registra a hora de saída com a hora atual
				else
					return null;
				return aux.dado;
			}
		// fecha o if do caso onde encontrou o dado
			// verifica se chegou ao final, senão chegou, passa
			// para o próximo
		if (aux == ultimo) {
			break;
		} else {
			aux = aux.proximo;
		}
	} // fecha o while
		return null;
	}
	
	/***
	 * Método que retorna o número de elementos da fila
	 * @return contador que indica quantos atendimentos estão na fila.
	 */
	 public int size() {
	        NodoAtendimentoLista no = primeiro;
	        int cont = 0;
	        while (no != null) {
	            cont++;
	            no = no.proximo;
	        }
	        return cont;
	 }
	 
	 /**
	  * Método que calcula o tempo médio de espera do paciente para atendimento
	  * @return tempo entre a chegada do paciente e a chamada para atendimento.
	  */
	 
	 public long calculaMediaChegadaAtendimento() {
		 NodoAtendimentoLista aux = primeiro;
		 long somatorio = 0;
		 int cont = 0;
			while (aux!=null) { // percorre todos os atendimentos e soma a diferença de horas
				if (aux.dado.getHoraAtendimento() != null && aux.dado.getHoraChegada() != null) {
					somatorio += aux.dado.getDiffHorasChegadaAtendimento();
					cont++;
				}
				
				if (aux == ultimo) {
					break;
				} else {
					aux = aux.proximo;
				}
			}
			try { //trata as exceções
				return somatorio / cont; // divide o total pelo número de atendimentos
			} catch (ArithmeticException e) { // Se o tamanho da lista for 0 vai lançar execeção, retorna média como 0
				return 0;
			}
	 }
	 /***
	  * Método para calcular o tempo médio de atendimento
	  * @return tempo entre a chamada para atendimento e a saída do paciente
	  */
	 public long calculaMediaAtendimentoSaida() { 
		 NodoAtendimentoLista aux = primeiro;
		 long somatorio = 0;
		 int cont = 0;
			while (aux!=null) { // percorre todos os atendimentos e soma a diferença de horas
				if (aux.dado.getHoraAtendimento() != null && aux.dado.getHoraSaida() != null) {
					somatorio += aux.dado.getDiffHorasAtendimentoSaida();
					cont++;
				}
					
				if (aux == ultimo) {
					break;
				} else {
					aux = aux.proximo;
				}
			}
			
			try {
				return somatorio / cont; // divide o total pelo número de atendimentos
			} catch (ArithmeticException e) { // Se o tamanho da lista for 0 vai lançar execeção, retorna média como 0
				return 0;			
			}
	 }
	 /***
	  * Método para calcular o tempo médio de atendimento em cada fila.
	  * @return tempo entre a chegada e a saída de cada fila.
	  */
	  
	 public long[] calculaMediaAtendimentoCadaFila() {
		 NodoAtendimentoLista aux = primeiro;
		 long somatorioFila1 = 0;
		 long somatorioFila2 = 0;
		 long somatorioFila3 = 0;
		 long somatorioFila4 = 0;
		 long somatorioFila5 = 0;
		 int contFila1 = 0;
		 int contFila2 = 0;
		 int contFila3 = 0;
		 int contFila4 = 0;
		 int contFila5 = 0;
		 
			while (aux!=null) {  // percorre todos os atendimentos, checa qual a fila de prioridade e soma a diferença de horas
				if (aux.dado.getHoraChegada() != null && aux.dado.getHoraSaida() != null) {
					switch (aux.dado.getPrioridade()) { // swicth case pra somar em cada prioridade
						case 1:
							somatorioFila1 += aux.dado.getDiffHorasChegadaSaida();
							contFila1++;
							break;
						case 2:
							somatorioFila2 += aux.dado.getDiffHorasChegadaSaida();
							contFila2++;
							break;
						case 3:
							somatorioFila3 += aux.dado.getDiffHorasChegadaSaida();
							contFila3++;
							break;
						case 4:
							somatorioFila4 += aux.dado.getDiffHorasChegadaSaida();
							contFila4++;
							break;
						case 5:
							somatorioFila5 += aux.dado.getDiffHorasChegadaSaida();
							contFila5++;
							break;
					}
				}
					
				if (aux == ultimo) {
					break;
				} else {
					aux = aux.proximo;
				}
			}
			// realiza verificação se está 0, para não ocorrer divisão por 0
			if (contFila1 == 0)
				contFila1 = 1;
			if (contFila2 == 0)
				contFila2 = 1;
			if (contFila3 == 0)
				contFila3 = 1;
			if (contFila4 == 0)
				contFila4 = 1;
			if (contFila5 == 0)
				contFila5 = 1;
			//Calcula as médias
			long vetorSomatorios[] = {(somatorioFila1 / contFila1),(somatorioFila2 / contFila2), (somatorioFila3 / contFila3), (somatorioFila4 / contFila4), (somatorioFila5 / contFila5)};
			return vetorSomatorios;
	 }
	 
	 
	 /***
	  * Método que remove o elemento da lista de atendimento
	  * @param dado
	  */
	public void removerPorOcorrencia(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (true) {
			if (aux.dado.getPessoa().getCpf().equalsIgnoreCase(dado)) {
				if (aux == primeiro) {
					primeiro.proximo.anterior = null;
					primeiro = primeiro.proximo;
					break;
				} else if (aux == ultimo) {
					ultimo.anterior.proximo = null;
					ultimo = ultimo.anterior;
					break;
				} else {
					aux.anterior.proximo = aux.proximo;
					aux.proximo.anterior = aux.anterior;
					break;
				}
			} // fecha o if do caso onde encontrou o dado
				// verifica se chegou ao final, senão chegou, passa
				// para o próximo
			if (aux == ultimo) {
				break;
			} else {
				aux = aux.proximo;
			}
		} // fecha o while
	}
	
	/**
	 * Método para impressão dos dados dos atendimentos
	 */
	public void imprimir() {
		NodoAtendimentoLista aux = primeiro;
		if (aux != null) {
			while (aux != ultimo) {
				System.out.println(aux.dado.getPessoa().getNome());
				System.out.println(aux.dado.getPessoa().getCpf());
				System.out.println(aux.dado.getPessoa().getAnoNascimento());
				System.out.println("Chegada ao atendimento: "+ aux.dado.getDiffHorasChegadaAtendimento());
				System.out.println("Atendimento até a saída: "+ aux.dado.getDiffHorasAtendimentoSaida());
				System.out.println("Chegada até a saída: "+ aux.dado.getDiffHorasChegadaSaida());
				aux = aux.proximo;
			}

			System.out.println(ultimo.dado.getPessoa().getNome());
			System.out.println(ultimo.dado.getPessoa().getCpf());
			System.out.println(ultimo.dado.getPessoa().getAnoNascimento());
			System.out.println("Chegada ao atendimento: "+ aux.dado.getDiffHorasChegadaAtendimento());
			System.out.println("Atendimento até a saída: "+ aux.dado.getDiffHorasAtendimentoSaida());
			System.out.println("Chegada até a saída: "+ aux.dado.getDiffHorasChegadaSaida());
		} else {
			System.out.println("Lista Vazia!");
		}
		
	}
}

