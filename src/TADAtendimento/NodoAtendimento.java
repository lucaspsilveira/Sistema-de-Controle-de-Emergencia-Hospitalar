package TADAtendimento;

import model.Atendimento;

public class NodoAtendimento {
    protected Atendimento dado;
    protected NodoAtendimento proximo;
    protected NodoAtendimento anterior;    
    
    public NodoAtendimento(Atendimento dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    } 
    
    //getters e setters serão feitos depois/algum dia/talvez   
}

