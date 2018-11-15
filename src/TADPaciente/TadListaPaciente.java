package TADPaciente;

import model.Paciente;

public class TadListaPaciente {
	private NodoPacienteLista primeiro;
	private NodoPacienteLista ultimo;

	public TadListaPaciente(){
        this.primeiro = null;
        this.ultimo = null;        
    }

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

	// buscar o elemento da lista que se encontra
	// em uma determinada posição;
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

	public void imprimir() {
		NodoPacienteLista aux = primeiro;
		while (aux != ultimo) {
			System.out.println(aux.dado.getNome());
			System.out.println(aux.dado.getCpf());
			System.out.println(aux.dado.getAnoNascimento());
			aux = aux.proximo;
		}

		System.out.println(ultimo.dado.getNome());
		System.out.println(ultimo.dado.getCpf());
		System.out.println(ultimo.dado.getAnoNascimento());
	}

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
