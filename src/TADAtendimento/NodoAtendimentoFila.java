package TADAtendimento;
import model.Atendimento;

public class NodoAtendimentoFila {
    protected Atendimento dado;
    protected NodoAtendimentoFila apos;  
    
    /***
     * 
     * @param dado - Objeto da classe Atendimento
     */
    
    public NodoAtendimentoFila(Atendimento dado){
        this.dado = dado;
        this.apos = null;
    }
    
    //Protected, então não precisa de getters e setters
    
}

