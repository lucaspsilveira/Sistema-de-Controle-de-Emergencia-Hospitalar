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
            while (aux.getApos() != null) {
                aux = aux.getApos();
            }
            aux.setApos(new NodoAtendimentoFila(valor));        
        }
    }
    
    public void imprimir(){
        if (isEmpty()) {
            System.out.println("Fila Vazia");
        }
        NodoAtendimentoFila no = inicio;
        while (no != null){
            System.out.println("Paciente: " + no.getDado().getPessoa().getNome());
            System.out.println("Prioridade: " + no.getDado().getPrioridade());
            System.out.println("Data/hora chegada: " + no.getDado().getHoraChegada().getTime());
            no = no.getApos();
        }
    }
    
    public Atendimento dequeue(){
        if (isEmpty()){
            return null;
        } else {
            Atendimento dado = inicio.getDado();
            inicio = inicio.getApos();
             return dado;
            
            
        }
    }
    public Atendimento head(){
        return inicio.getDado();
    }
    public int size() {
        NodoAtendimentoFila no = inicio;
        int cont = 0;
        while (no != null) {
            cont++;
            no = no.getApos();
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
}
