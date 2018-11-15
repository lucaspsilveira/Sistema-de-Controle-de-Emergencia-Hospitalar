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
            while (aux.getApos() != null) {
                aux = aux.getApos();
            }
            aux.setApos(new NodoPacienteFila(valor));        
        }
    }
    
    public void imprimir(){
        if (isEmpty()) {
            System.out.println("Lista Vazia");
        }
        NodoPacienteFila no = inicio;
        while (no != null){
            System.out.println(no.getDado());
            no = no.getApos();
        }
    }
    
    public Paciente dequeue(){
        if (isEmpty()){
            return null;
        } else {
            Paciente dado = inicio.getDado();
            inicio = inicio.getApos();
             return dado;
            
            
        }
    }
    public Paciente head(){
        return inicio.getDado();
    }
    public int size() {
        NodoPacienteFila no = inicio;
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
