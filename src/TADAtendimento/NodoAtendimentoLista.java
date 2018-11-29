package TADAtendimento;

import model.Atendimento;

public class NodoAtendimentoLista {
    protected Atendimento dado;
    protected NodoAtendimentoLista proximo;
    protected NodoAtendimentoLista anterior;  
    /***
     * 
     * @param dado - Objeto da classe Atendimento
     */

	public NodoAtendimentoLista(Atendimento dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
	
	//Protected, então não precisa de getters e setters
}

