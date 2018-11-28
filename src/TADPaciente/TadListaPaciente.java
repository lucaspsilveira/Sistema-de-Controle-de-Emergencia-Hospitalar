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
	 * Método para inserir o paciente no final da lista
	 * @param dado
	 */
	public void adicionarNoFinal(Paciente dado) {
		NodoPacienteLista novoNodoPaciente = new NodoPacienteLista(dado);
		if (primeiro == null) {
			// lista está vazia
			primeiro = novoNodoPaciente;
			ultimo = novoNodoPaciente;
		} else {
			ultimo.proximo = novoNodoPaciente;
			novoNodoPaciente.anterior = ultimo;
			ultimo = novoNodoPaciente;
		}
	}
	/***
	 * Método para inserir o paciente no início da fila.
	 * @param dado
	 */
	public void adicionarNoComeco(Paciente dado) {
		NodoPacienteLista novoNodoPaciente = new NodoPacienteLista(dado);
		if (primeiro == null) {
			// lista está vazia
			primeiro = novoNodoPaciente;
			ultimo = novoNodoPaciente;
		} else {
			primeiro.anterior = novoNodoPaciente;
			novoNodoPaciente.proximo = primeiro;
			primeiro = novoNodoPaciente;
		}
	}
	/***
	 * Método que remove o elemento paciente contido em determinada posição da lista
	 * @param posicao
	 */
	
	public void removePosicao(int posicao) {
		NodoPacienteLista remover = retornaNodoPaciente(posicao);
		if (remover == primeiro) {
			primeiro.proximo.anterior = null;
			primeiro = primeiro.proximo;
		} else if (remover == ultimo) {
			ultimo.anterior.proximo = null;
			ultimo = ultimo.anterior;
		} else {
			remover.anterior.proximo = remover.proximo;
			remover.proximo.anterior = remover.anterior;
		}
	}
	/***
	 * Método que retorna o elemento paciente contido em determinada posição.
	 * @param posicao
	 * @return aux
	 */
	public NodoPacienteLista retornaNodoPaciente(int posicao) {
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
	 * @param dado
	 * @return nulo caso não exista paciente com o cpf informado.
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
	 * Método que busca o elemento da lista que se encontra em uma determinada posição.
	 * @param posicao
	 * @return nulo caso não exista paciente com o cpf informado.
	 */

	public Paciente retornaDado(int posicao) {
		NodoPacienteLista aux = primeiro;
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
	 * Método que remove o elemento da lista de pacientes
	 * @param dado
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
					// forma 1
					aux.anterior.proximo = aux.proximo;
					aux.proximo.anterior = aux.anterior;

					// forma 2
					/*
					 * NodoPaciente antes = aux.anterior; NodoPaciente depois = aux.proximo;
					 * antes.proximo = depois; depois.anterior = antes;
					 */
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
	 * Método para impressão da confirmação da inclusão do paciente, caso contrário, informa
	 * que a lista está vazia.
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

/* Não são usados nem pedidos. Remover?
	public void imprimir2() {
		NodoPacienteLista aux = primeiro;
		while (true) {
			System.out.println(aux.dado);
			if (aux == ultimo) {
				break;
			}
			aux = aux.proximo;
		}
	}

	public void imprimirTrasPraFrente() {
		NodoPacienteLista aux = ultimo;
		while (true) {
			System.out.println(aux.dado);
			if (aux == primeiro) {
				break;
			}
			aux = aux.anterior;
		}
	}
	
	public void adicionarNaPosicao(Paciente dado, int posicao) {
		NodoPacienteLista NodoPacienteNaPosicao = retornaNodoPaciente(posicao);
		NodoPacienteLista novoNodoPaciente = new NodoPacienteLista(dado);
		if (primeiro == null) {
			// lista está vazia
			primeiro = novoNodoPaciente;
			ultimo = novoNodoPaciente;
		} else {
			if (NodoPacienteNaPosicao == primeiro) {
				primeiro.anterior = novoNodoPaciente;
				novoNodoPaciente.proximo = primeiro;
				primeiro = novoNodoPaciente;
			} else if (NodoPacienteNaPosicao == ultimo) {
				ultimo.proximo = novoNodoPaciente;
				novoNodoPaciente.anterior = ultimo;
				ultimo = novoNodoPaciente;
			} else {
				novoNodoPaciente.proximo = NodoPacienteNaPosicao;
				novoNodoPaciente.anterior = NodoPacienteNaPosicao.anterior;
				NodoPacienteNaPosicao.anterior.proximo = novoNodoPaciente;
				NodoPacienteNaPosicao.anterior = novoNodoPaciente;
			}

		}
	}
}
*/
