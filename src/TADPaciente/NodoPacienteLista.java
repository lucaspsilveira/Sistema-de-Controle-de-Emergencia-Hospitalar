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
    /* Protected, então não precisa de getters e setters
	public Paciente getDado() {
		return dado;
	}

	public void setDado(Paciente dado) {
		this.dado = dado;
	}

	public NodoPacienteLista getProximo() {
		return proximo;
	}

	public void setProximo(NodoPacienteLista proximo) {
		this.proximo = proximo;
	}

	public NodoPacienteLista getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoPacienteLista anterior) {
		this.anterior = anterior;
	} */
}

