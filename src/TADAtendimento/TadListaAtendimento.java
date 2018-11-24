package TADAtendimento;
import java.util.Calendar;

import TADPaciente.NodoPacienteFila;
import model.Atendimento;

public class TadListaAtendimento {
	private NodoAtendimentoLista primeiro;
	private NodoAtendimentoLista ultimo;

	public TadListaAtendimento() {
		this.primeiro = null;
		this.ultimo = null;
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
	
	public Atendimento retornaNodoAtendimentoCpf(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (aux!=null) {
			if (aux.dado.getPessoa().getCpf().equalsIgnoreCase(dado)) {
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
			return aux.dado;
		}
	}
	
	public Atendimento liberarPacienteAtendimento(String dado) {
		NodoAtendimentoLista aux = primeiro;
		while (aux!=null) {
			if (aux.dado.getPessoa().getCpf().equalsIgnoreCase(dado)) {
				aux.dado.setHoraSaida(Calendar.getInstance());
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
	
	 public int size() {
	        NodoAtendimentoLista no = primeiro;
	        int cont = 0;
	        while (no != null) {
	            cont++;
	            no = no.proximo;
	        }
	        return cont;
	 }
	 
	 
	 public long calculaMediaChegadaAtendimento() {// percorre todos os atendimentos e soma a diferença de horas
		 NodoAtendimentoLista aux = primeiro;
		 long somatorio = 0;
		 int cont = 0;
			while (aux!=null) {
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
			return somatorio / this.size();
	 }
	 public long calculaMediaAtendimentoSaida() { // percorre todos os atendimentos e soma a diferença de horas
		 NodoAtendimentoLista aux = primeiro;
		 long somatorio = 0;
		 int cont = 0;
			while (aux!=null) {
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
			return somatorio / cont;
	 }
	 
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
		 
			while (aux!=null) {
				if (aux.dado.getHoraChegada() != null && aux.dado.getHoraSaida() != null) {
					switch (aux.dado.getPrioridade()) { // swicth case pra somar emc cada prioridade
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
			// realiza verficiação se está 0, para não ocorrer divisão por 0 na divisão na mensagem de retorno
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
			long vetorSomatorios[] = {(somatorioFila1 / contFila1),(somatorioFila2 / contFila2), (somatorioFila3 / contFila3), (somatorioFila4 / contFila4), (somatorioFila5 / contFila5)};
			return vetorSomatorios;
	 }
	 
	 

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

/* Não são usados nem pedidos. Remover?
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
}*/

