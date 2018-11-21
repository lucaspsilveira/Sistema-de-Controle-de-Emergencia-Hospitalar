package TADAtendimento;
import java.util.Calendar;

import model.Atendimento;

public class TadListaAtendimento {
	private NodoAtendimentoLista primeiro;
	private NodoAtendimentoLista ultimo;

	public TadListaAtendimento() {
		this.primeiro = null;
		this.ultimo = null;
	}

	public void removePosicao(int posicao) {
		NodoAtendimentoLista remover = retornaNodoAtendimento(posicao);
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

	public NodoAtendimentoLista retornaNodoAtendimento(int posicao) {
		NodoAtendimentoLista aux = primeiro;
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
	// em uma determinada posi��o;
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
			return aux.getDado();
		}
	}

	public void removerPorOcorrencia(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (true) {
			if (aux.getDado().getPessoa().getCpf().equalsIgnoreCase(dado)) {
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
				// verifica se chegou ao final, sen�o chegou, passa
				// para o pr�ximo
			if (aux == ultimo) {
				break;
			} else {
				aux = aux.proximo;
			}
		} // fecha o while
	}

	public Atendimento retornaNodoAtendimento(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (aux!=null) {
			if (aux.getDado().getPessoa().getCpf().equalsIgnoreCase(dado)) {
				return aux.dado;
			}
		// fecha o if do caso onde encontrou o dado
			// verifica se chegou ao final, sen�o chegou, passa
			// para o pr�ximo
		if (aux == ultimo) {
			break;
		} else {
			aux = aux.proximo;
		}
	} // fecha o while
		return null;
	}
	
	public Atendimento liberarPacienteAtendimento(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (aux!=null) {
			if (aux.getDado().getPessoa().getCpf().equalsIgnoreCase(dado)) {
				aux.getDado().setHoraSaida(Calendar.getInstance());
				return aux.dado;
			}
		// fecha o if do caso onde encontrou o dado
			// verifica se chegou ao final, sen�o chegou, passa
			// para o pr�ximo
		if (aux == ultimo) {
			break;
		} else {
			aux = aux.proximo;
		}
	} // fecha o while
		return null;
	}

	public void imprimir2() {
		NodoAtendimentoLista aux = primeiro;
		while (true) {
			System.out.println(aux.dado);
			if (aux == ultimo) {
				break;
			}
			aux = aux.proximo;
		}
	}

	public void imprimirTrasPraFrente() {
		NodoAtendimentoLista aux = ultimo;
		while (true) {
			System.out.println(aux.dado);
			if (aux == primeiro) {
				break;
			}
			aux = aux.anterior;
		}
	}

	public void imprimir() {
		NodoAtendimentoLista aux = primeiro;
		if (aux != null) {
			while (aux != ultimo) {
				System.out.println(aux.dado.getPessoa().getNome());
				System.out.println(aux.dado.getPessoa().getCpf());
				System.out.println(aux.dado.getPessoa().getAnoNascimento());
				aux = aux.proximo;
			}

			System.out.println(ultimo.dado.getPessoa().getNome());
			System.out.println(ultimo.dado.getPessoa().getCpf());
			System.out.println(ultimo.dado.getPessoa().getAnoNascimento());
		} else {
			System.out.println("Lista Vazia!");
		}
		
	}

	public void adicionarNoFinal(Atendimento dado) {
		NodoAtendimentoLista novoNodoAtendimento = new NodoAtendimentoLista(dado);
		if (primeiro == null) {
			// lista est� vazia
			primeiro = novoNodoAtendimento;
			ultimo = novoNodoAtendimento;
		} else {
			ultimo.proximo = novoNodoAtendimento;
			novoNodoAtendimento.anterior = ultimo;
			ultimo = novoNodoAtendimento;
		}
	}

	public void adicionarNoComeco(Atendimento dado) {
		NodoAtendimentoLista novoNodoAtendimento = new NodoAtendimentoLista(dado);
		if (primeiro == null) {
			// lista est� vazia
			primeiro = novoNodoAtendimento;
			ultimo = novoNodoAtendimento;
		} else {
			primeiro.anterior = novoNodoAtendimento;
			novoNodoAtendimento.proximo = primeiro;
			primeiro = novoNodoAtendimento;
		}
	}

	public void adicionarNaPosicao(Atendimento dado, int posicao) {
		NodoAtendimentoLista NodoAtendimentoNaPosicao = retornaNodoAtendimento(posicao);
		NodoAtendimentoLista novoNodoAtendimento = new NodoAtendimentoLista(dado);
		if (primeiro == null) {
			// lista est� vazia
			primeiro = novoNodoAtendimento;
			ultimo = novoNodoAtendimento;
		} else {
			if (NodoAtendimentoNaPosicao == primeiro) {
				primeiro.anterior = novoNodoAtendimento;
				novoNodoAtendimento.proximo = primeiro;
				primeiro = novoNodoAtendimento;
			} else if (NodoAtendimentoNaPosicao == ultimo) {
				ultimo.proximo = novoNodoAtendimento;
				novoNodoAtendimento.anterior = ultimo;
				ultimo = novoNodoAtendimento;
			} else {
				novoNodoAtendimento.proximo = NodoAtendimentoNaPosicao;
				novoNodoAtendimento.anterior = NodoAtendimentoNaPosicao.anterior;
				NodoAtendimentoNaPosicao.anterior.proximo = novoNodoAtendimento;
				NodoAtendimentoNaPosicao.anterior = novoNodoAtendimento;
			}

		}
	}
}

