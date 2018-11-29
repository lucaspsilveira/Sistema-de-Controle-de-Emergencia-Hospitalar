package TADPaciente;

import model.Paciente;

public class NodoPacienteFila {
    protected Paciente dado;
    protected NodoPacienteFila apos; 
    
    public NodoPacienteFila(Paciente dado){
        this.dado = dado;
        this.apos = null;
    }
    // Protected, então não precisa de getters e setters
}

