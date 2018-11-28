package TADAtendimento;

import model.Atendimento;
/***
 * 
 * @author lucas pacheco, guilherme negrini, dieine schiavon
 *
 */

public class TadFilaAtendimento {
    NodoAtendimentoFila inicio;

    public TadFilaAtendimento() {
        this.inicio = null;
    }
    
    /***
     * Método que insere o elemento atendimento no final da fila
     * @param valor
     */
    public void enqueue(Atendimento valor){
        if (inicio == null){
            inicio = new NodoAtendimentoFila(valor);
        } else {
            NodoAtendimentoFila aux = inicio;
            while (aux.apos != null) {
                aux = aux.apos;
            }
            aux.apos = new NodoAtendimentoFila(valor);        
        }
    }
    /***
     * Método que remove e retorna o elemento atendimento do início da fila e dá erro se a fila estiver vazia
     * @return nulo
     */
    public Atendimento dequeue(){
        if (isEmpty()){ 
            return null;
        } else {
            Atendimento dado = inicio.dado;
            inicio = inicio.apos;
            return dado;         
        }
    }
   /**
    * Método que retorna, mas não remove, o primeiro elemento da fila, e dá erro se a fila estiver vazia
    *
    */
    public Atendimento head(){
        return inicio.dado;
    }
    
    /**
     * Método que informa a quantidade de atendimentos na fila, enquanto não for nulo, acresce o atendimento
     * ao contador e  retorna o número de elementos da fila.
     */
    public int size() {
        NodoAtendimentoFila no = inicio;
        int cont = 0;
        while (no != null) {
            cont++;
            no = no.apos;
        }
        return cont;
    }
    
    // retorna true se a fila estiver vazia, e false caso contrário
     
    public boolean isEmpty(){
       return inicio == null;
    }
    
    // esvazia a fila
    
    public void clear(){
        while (!isEmpty()){
            dequeue();
        }
    }
    /**
     * Imprime informações se a fila estiver vazia ou, caso contrário, as informações do paciente para
     * atendimento.
     */
    public void imprimir(){
        if (isEmpty()) {
            System.out.println("Fila Vazia");
        }
        NodoAtendimentoFila no = inicio;
        while (no != null){
            System.out.println("Paciente: " + no.dado.getPessoa().getNome());
            System.out.println("Prioridade: " + no.dado.getPrioridade());
            System.out.println("Data/hora chegada: " + no.dado.getHoraChegada().getTime());
            no = no.apos;
        }
    }
}
    
    