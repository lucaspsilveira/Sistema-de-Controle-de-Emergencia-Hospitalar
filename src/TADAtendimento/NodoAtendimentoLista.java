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
    
    //getters e setters serão feitos depois/algum dia/talvez   
}

