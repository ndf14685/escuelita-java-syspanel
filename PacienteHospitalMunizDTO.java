package escuelita.java.DTO;

public class PacienteHospitalMunizDTO {
	
	public String id;
	public String fechaAlta;
	public String [] antecendente;
	public String notasDoctor;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String[] getAntecendente() {
		return antecendente;
	}
	public void setAntecendente(String[] antecendente) {
		this.antecendente = antecendente;
	}
	public String getNotasDoctor() {
		return notasDoctor;
	}
	public void setNotasDoctor(String notasDoctor) {
		this.notasDoctor = notasDoctor;
	}
	

}
