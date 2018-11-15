package TADPaciente;

import model.Paciente;

public class TadListaPaciente {
	private NodoPaciente primeiro;
	private NodoPaciente ultimo;

	public TadListaPaciente(){
        this.primeiro = null;
        this.ultimo = null;        
    }

	public void removePosicao(int posicao) {
		NodoPaciente remover = retornaNodoPaciente(posicao);
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

	public NodoPaciente retornaNodoPaciente(int posicao) {
		NodoPaciente aux = primeiro;
		for (int i = 0; i < posicao; i++) {
			if (aux != null) {
				aux = aux.proximo;
			} else {
				break;
			}
		}
		return aux;
	}

	// buscar o elemento da lista que se encontra
	// em uma determinada posição;
	public Paciente retornaDado(int posicao) {
		NodoPaciente aux = primeiro;
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

	public void removerPorOcorrencia(String dado) {
		NodoPaciente aux = primeiro;
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
					 * NodoPaciente antes = aux.anterior; NodoPaciente depois = aux.proximo; antes.proximo = depois;
					 * depois.anterior = antes;
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

	public void imprimir2() {
		NodoPaciente aux = primeiro;
		while (true) {
			System.out.println(aux.dado);
			if (aux == ultimo) {
				break;
			}
			aux = aux.proximo;
		}
	}
	public void imprimirTrasPraFrente() {
		NodoPaciente aux = ultimo;
		while (true) {
			System.out.println(aux.dado);
			if (aux == primeiro) {
				break;
			}
			aux = aux.anterior;
		}
	}

	public void imprimir() {
		NodoPaciente aux = primeiro;
		while (aux != ultimo) {
			System.out.println(aux.dado);
			aux = aux.proximo;
		}
		System.out.println(ultimo.dado);
	}

	public void adicionarNoFinal(Paciente dado) {
		NodoPaciente novoNodoPaciente = new NodoPaciente(dado);
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
	public void adicionarNoComeco(Paciente dado) {
		NodoPaciente novoNodoPaciente = new NodoPaciente(dado);
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
	public void adicionarNaPosicao(Paciente dado, int posicao) {
		NodoPaciente NodoPacienteNaPosicao = retornaNodoPaciente(posicao);
		NodoPaciente novoNodoPaciente = new NodoPaciente(dado);
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
