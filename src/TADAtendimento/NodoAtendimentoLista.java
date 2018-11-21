package TADAtendimento;

import model.Atendimento;

public class NodoAtendimentoLista {
    protected Atendimento dado;
    protected NodoAtendimentoLista proximo;
    protected NodoAtendimentoLista anterior;    
    
    public NodoAtendimentoLista(Atendimento dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
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
	}    
}

