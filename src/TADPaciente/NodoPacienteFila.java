package TADPaciente;

import model.Paciente;

public class NodoPacienteFila {
    protected Paciente dado;
    protected NodoPacienteFila apos; 
    
    public NodoPacienteFila(Paciente dado){
        this.dado = dado;
        this.apos = null;
    }
    // GETTERS AND SETTERS
	public Paciente getDado() {
		return dado;
	}

	public void setDado(Paciente dado) {
		this.dado = dado;
	}

	public NodoPacienteFila getApos() {
		return apos;
	}

	public void setApos(NodoPacienteFila proximo) {
		this.apos = proximo;
	}
}

