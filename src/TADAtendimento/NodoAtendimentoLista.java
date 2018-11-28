package TADAtendimento;

import model.Atendimento;

public class NodoAtendimentoLista {
    protected Atendimento dado;
    protected NodoAtendimentoLista proximo;
    protected NodoAtendimentoLista anterior;  
    /***
     * 
     * @param dado
     */

	public NodoAtendimentoLista(Atendimento dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
	
	//Protected, então não precisa de getters e setters
	/*
	public Atendimento getDado() {
		return dado;
	}
	public void setDado(Atendimento dado) {
		this.dado = dado;
	}
	public NodoAtendimentoLista getProximo() {
		return proximo;
	}
	public void setProximo(NodoAtendimentoLista proximo) {
		this.proximo = proximo;
	}
	public NodoAtendimentoLista getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoAtendimentoLista anterior) {
		this.anterior = anterior;
	}    */
}

