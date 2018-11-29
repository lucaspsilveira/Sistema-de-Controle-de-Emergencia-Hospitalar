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
     * @param valor - Objeto da Classe Atendimento
     */
    public void enqueue(Atendimento valor){
        if (inicio == null){	//Se é o primeiro, então início aponta para o novo Atendimento
            inicio = new NodoAtendimentoFila(valor);
        } else {
            NodoAtendimentoFila aux = inicio; 
            while (aux.apos != null) { //Senão, percorre a fila até o final e adiciona o Atendimento no final da fila
                aux = aux.apos;
            }
            aux.apos = new NodoAtendimentoFila(valor);        
        }
    }
    /***
     * Método que remove e retorna o elemento atendimento do início da fila
     * @return primeiro Atendimento da fila
     */
    public Atendimento dequeue(){
        if (isEmpty()){ 	//Se a fila está vazia retorna null
            return null;
        } else {			//Senão retorna o inicio (primeiro Atendimento) e aponta define o próximo como novo início da fila
            Atendimento dado = inicio.dado;
            inicio = inicio.apos;
            return dado;         
        }
    }
   /**
    * Método que retorna, mas não remove, o primeiro elemento da fila
    *@return primeiro Atendimento da fila
    */
    public Atendimento head(){
        return inicio.dado; 
    }
    
    /**
     * Método que informa a quantidade de atendimentos na fila
     * @return número de elementos na fila
     */
    public int size() {
        NodoAtendimentoFila no = inicio;
        int cont = 0;
        while (no != null) { //enquanto não chegar ao fim da fila, acresce o uma unidade de atendimento ao contador 
            cont++;
            no = no.apos;
        }
        return cont;
    }
    
    
    /**
     * Retorna se a fila está vazia
     * @return boolean - estado da fila vazia (true ou false)
     */
    public boolean isEmpty(){
       return inicio == null; // retorna true se a fila estiver vazia, e false caso contrário
    }
    
    
    /**
     * Esvazia a fila
     */
    public void clear(){
        while (!isEmpty()){
            dequeue(); // esvazia a fila (enquanto não estiver vazia, remove os elementos)
        }
    }
    /**
     * Imprime informações dos pacientes na fila
     */
    public void imprimir(){
        if (isEmpty()) {
            System.out.println("Fila Vazia");
        }
        NodoAtendimentoFila no = inicio; 
        while (no != null){ //Imprime as informações de cada elemento (Atendimento) da fila
            System.out.println("Paciente: " + no.dado.getPessoa().getNome());
            System.out.println("Prioridade: " + no.dado.getPrioridade());
            System.out.println("Data/hora chegada: " + no.dado.getHoraChegada().getTime());
            no = no.apos;
        }
    }
}
    
    