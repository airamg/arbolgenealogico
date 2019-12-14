package edu.uoc.arbolgenealogico.pojo;

public class Descendencia {

	private int id;
	private String tipoRama;
	
	public Descendencia() {
		setTipoRama("");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoRama() {
		return tipoRama;
	}
	public void setTipoRama(String tipoRama) {
		this.tipoRama = tipoRama;
	}
	
	
}
