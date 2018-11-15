package TADPaciente;

import model.Paciente;

public class NodoPaciente {
    protected Paciente dado;
    protected NodoPaciente proximo;
    protected NodoPaciente anterior;    
    
    public NodoPaciente(Paciente dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    } 
    
    //getters e setters serão feitos depois/algum dia/talvez   
}

