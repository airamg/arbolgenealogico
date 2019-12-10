package edu.uoc.arbolgenealogico.pojo;

public class Parentesco {
	
	private int id;
	private String descripcion;
	private int rama;
	
	public Parentesco() {		
		setDescripcion("");
		setRama(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getRama() {
		return rama;
	}

	public void setRama(int rama) {
		this.rama = rama;
	}

}
