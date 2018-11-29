package TADPaciente;

import model.Paciente;
/***
 * 
 * @author lucas pacheco, guilherme negrini, dieine schiavon
 *
 */

public class TadListaPaciente {
	private NodoPacienteLista primeiro;
	private NodoPacienteLista ultimo;

	public TadListaPaciente() {
		this.primeiro = null;
		this.ultimo = null;
	}
	/***
	 * Método para inserir o atendimento no final da lista.
	 * @param dado - Objeto da classe Paciente
	 */
	public void adicionarNoFinal(Paciente dado) {
		NodoPacienteLista novoNodoPaciente = new NodoPacienteLista(dado);
		if (primeiro == null) {
			// Se lista está vazia o elemento será o primeiro e último
			primeiro = novoNodoPaciente;
			ultimo = novoNodoPaciente;
		} else {
			ultimo.proximo = novoNodoPaciente; //Senão, o último Paciente passa a apontar para o novo elemento
			novoNodoPaciente.anterior = ultimo; //O novo aponta para o último
			ultimo = novoNodoPaciente; //E o último é atualizado para o novo elemento adicionado
		}
	}
	/***
	 * Método para inserir o atendimento no início da lista.
	 * @param dado - Objeto da classe Paciente
	 */
	public void adicionarNoComeco(Paciente dado) {
		NodoPacienteLista novoNodoPaciente = new NodoPacienteLista(dado);
		if (primeiro == null) {
			// Se lista está vazia o elemento será o primeiro e último
			primeiro = novoNodoPaciente;
			ultimo = novoNodoPaciente;
		} else {
			primeiro.anterior = novoNodoPaciente;//Senão, o anterior do primeiro paciente passa a apontar para o novo elemento
			novoNodoPaciente.proximo = primeiro; //O novo aponta para o primeiro
			primeiro = novoNodoPaciente; //E o primeiro é atualizado para o novo elemento adicionado
		}
	}
	/***
	 * Método que remove o elemento paciente contido em determinada posição da lista
	 * @param posicao a ser removida
	 */
	
	public void removePosicao(int posicao) {
		NodoPacienteLista remover = retornaNodoPaciente(posicao); //Busca qual o nodo está na posição informada
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
	 * Método que retorna o elemento paciente contido em determinada posição.
	 * @param posicao a ser encontrada
	 * @return aux - Nodo da lista de pacientes
	 */
	public NodoPacienteLista retornaNodoPaciente(int posicao) { //Percorre a lista até chegar na posição anterior à informada
		NodoPacienteLista aux = primeiro;
		for (int i = 0; i < posicao; i++) {
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
	 * @return Paciente
	 */
	public Paciente retornaNodoPacienteCpf(String dado) {
		NodoPacienteLista aux = primeiro;
		while (aux!=null) {
			if (aux.dado.getCpf().equalsIgnoreCase(dado)) {
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
	 * Método que atuliza a situação do paciente
	 * @param emAtendimento - Se está em atendimento ou não
	 * @param cpf - CPF do paciente
	 * 
	 */
	public void defineAtendimento(String cpf, boolean emAtendimento) {
		NodoPacienteLista aux = primeiro;
		while (aux!=null) {
			if (aux.dado.getCpf().equalsIgnoreCase(cpf)) {
				aux.dado.setEmAtendimento(emAtendimento);
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
	}
	/***
	 * Método que busca o elemento da lista que se encontra em uma determinada posição.
	 * @param posicao
	 * @return Paciente
	 */

	public Paciente retornaDado(int posicao) {
		NodoPacienteLista aux = primeiro;
		for (int i = 0; i < posicao; i++) { //Percorre a lista até o elemento anterior à posição buscada
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
	  * Método que remove o elemento da lista de atendimento por ocorrência do CPF
	  * @param dado - CPF do paciente
	 */
	public void removerPorOcorrencia(String dado) {
		NodoPacienteLista aux = primeiro;
		while (true) {
			if (aux.dado.getCpf().equalsIgnoreCase(dado)) {
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
	 * Método para impressão dos dados dos pacientes
	 */
	public void imprimir() {
		NodoPacienteLista aux = primeiro;
		if (aux != null) {
			while (aux != ultimo) {
				System.out.println(aux.dado.getNome());
				System.out.println(aux.dado.getCpf());
				System.out.println(aux.dado.getAnoNascimento());
				aux = aux.proximo;
			}

			System.out.println(ultimo.dado.getNome());
			System.out.println(ultimo.dado.getCpf());
			System.out.println(ultimo.dado.getAnoNascimento());
		} else {
			System.out.println("Lista Vazia!");
		}
		
	}

}
