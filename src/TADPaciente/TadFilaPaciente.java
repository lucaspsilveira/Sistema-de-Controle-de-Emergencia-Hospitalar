package TADPaciente;

import model.Paciente;
/***
 * 
 * @author lucas pacheco, guilherme negrini, dieine schiavon
 *
 */

public class TadFilaPaciente {
    NodoPacienteFila inicio;
    
    public TadFilaPaciente() {
        this.inicio = null;
    }
    /***
     * Método que insere o elemento atendimento no final da fila
     * @param valor - Objeto da Classe Paciente
     */
    public void enqueue(Paciente valor){
        if (inicio == null){ //Se é o primeiro, então início aponta para o novo Paciente
            inicio = new NodoPacienteFila(valor);
        } else {
            NodoPacienteFila aux = inicio;
            while (aux.apos != null) { //Senão, percorre a fila até o final e adiciona o Paciente no final da fila
                aux = aux.apos;
            }
            aux.apos = new NodoPacienteFila(valor);        
        }
    }
    /***
     * Método que remove e retorna o elemento do início da fila
     * @return primeiro Paciente da fila
     */
    public Paciente dequeue(){
        if (isEmpty()){ //Se a fila está vazia retorna null
            return null;
        } else {//Senão retorna o inicio (primeiro Paciente) e aponta define o próximo como novo início da fila
            Paciente dado = inicio.dado;
            inicio = inicio.apos;
            return dado;         
        }
    }
    /**
     * Método que retorna, mas não remove, o primeiro elemento da fila
     * @return primeiro Paciente da fila
     */
    public Paciente head(){
        return inicio.dado;
    }
    
    /**
     * Método que informa a quantidade de Pacientes na fila
     * @return número de elementos na fila
     */
    public int size() {
        NodoPacienteFila no = inicio;
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
     * Método para esvaziar a lista
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
            System.out.println("Lista Vazia");
        }
        NodoPacienteFila no = inicio;
        while (no != null){
            System.out.println(no.dado);
            no = no.apos;
        }
    }
}
