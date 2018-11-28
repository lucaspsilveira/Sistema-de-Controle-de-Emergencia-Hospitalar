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
     * Método que insere o elemento paciente no final da fila
     * @param valor
     */
    public void enqueue(Paciente valor){
        if (inicio == null){
            inicio = new NodoPacienteFila(valor);
        } else {
            NodoPacienteFila aux = inicio;
            while (aux.apos != null) {
                aux = aux.apos;
            }
            aux.apos = new NodoPacienteFila(valor);        
        }
    }
    /***
     * Método que remove e retorna o elemento paciente do início da fila, e dá erro se a fila estiver vazia
     * @return dado ou nulo
     */
    public Paciente dequeue(){
        if (isEmpty()){
            return null;
        } else {
            Paciente dado = inicio.dado;
            inicio = inicio.apos;
            return dado;         
        }
    }
    /**
     * Método que retorna, mas não remove, o primeiro elemento da fila
     */
    public Paciente head(){
        return inicio.dado;
    }
    
    /**
     * Método que retorna o número de elementos da fila, enquanto não nulo
     */
    public int size() {
        NodoPacienteFila no = inicio;
        int cont = 0;
        while (no != null) {
            cont++;
            no = no.apos;
        }
        return cont;
    }
    /**
     * retorna true se a fila estiver vazia, e false caso contrário
     */
    public boolean isEmpty(){
       return inicio == null;
    }
    /**
     * Método para esvaziar a lista
     */
    public void clear(){
        while (!isEmpty()){
            dequeue();
        }
    }
    /**
     * Método que informa se a Lista está vazia ou próximo paciente, se for o caso.
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
