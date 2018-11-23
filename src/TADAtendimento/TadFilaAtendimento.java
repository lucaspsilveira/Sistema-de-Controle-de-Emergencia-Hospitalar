package TADAtendimento;

import model.Atendimento;

public class TadFilaAtendimento {
    NodoAtendimentoFila inicio;

    public TadFilaAtendimento() {
        this.inicio = null;
    }
    
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
    
    public Atendimento dequeue(){
        if (isEmpty()){
            return null;
        } else {
            Atendimento dado = inicio.dado;
            inicio = inicio.apos;
            return dado;         
        }
    }
    
    public Atendimento head(){
        return inicio.dado;
    }
    
    public int size() {
        NodoAtendimentoFila no = inicio;
        int cont = 0;
        while (no != null) {
            cont++;
            no = no.apos;
        }
        return cont;
    }
    
    public boolean isEmpty(){
       return inicio == null;
    }
    
    public void clear(){
        while (!isEmpty()){
            dequeue();
        }
    }
    
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
    
    