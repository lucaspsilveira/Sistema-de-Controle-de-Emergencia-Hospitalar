package TADPaciente;

import model.Paciente;

public class NodoPacienteLista {
    protected Paciente dado;
    protected NodoPacienteLista proximo;
    protected NodoPacienteLista anterior;    
    
    public NodoPacienteLista(Paciente dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
    //Protected, então não precisa de getters e setters
}

