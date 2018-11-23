package TADPaciente;

import model.Paciente;

public class TadFilaPaciente {
    NodoPacienteFila inicio;

    public TadFilaPaciente() {
        this.inicio = null;
    }
    
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
        
    public Paciente dequeue(){
        if (isEmpty()){
            return null;
        } else {
            Paciente dado = inicio.dado;
            inicio = inicio.apos;
            return dado;         
        }
    }
    
    public Paciente head(){
        return inicio.dado;
    }
    
    public int size() {
        NodoPacienteFila no = inicio;
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
            System.out.println("Lista Vazia");
        }
        NodoPacienteFila no = inicio;
        while (no != null){
            System.out.println(no.dado);
            no = no.apos;
        }
    }
}
