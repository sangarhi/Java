package constructores;

public class ConstructoresVarios {
	private int miDato;
	private Integer miObjeto;
	
	
	
	public ConstructoresVarios(int miDato) {
		super();
		this.miDato = miDato;
	}

	public ConstructoresVarios(int miDato, Integer miObjeto) {
		super();
		this.miDato = miDato;
		this.miObjeto = miObjeto;
	}
	
	public int getMiDato() {
		return miDato;
	}
	public void setMiDato(int miDato) {
		this.miDato = miDato;
	}
	public Integer getMiObjeto() {
		return miObjeto;
	}
	public void setMiObjeto(Integer miObjeto) {
		this.miObjeto = miObjeto;
	}
}
