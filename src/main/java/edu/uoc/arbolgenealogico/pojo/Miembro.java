package edu.uoc.arbolgenealogico.pojo;

public class Miembro {
	
	private int id;
	private String nombre;
	private String apellido;
	private String rutaImagen;
	private String anioNacimiento;
	private String anioDefuncion;
	private String historialMedico;
	private String parentesco;
	private String descendencia;
	private int idParentesco;
	private int idDescendencia;
	
	public Miembro() {
		setNombre("");
		setApellido("");
		setRutaImagen("resources/images/arbol/miembro.png");
		setAnioNacimiento("");
		setAnioDefuncion("");
		setHistorialMedico("");
		setParentesco("");
		setDescendencia("");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(String anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public String getAnioDefuncion() {
		return anioDefuncion;
	}

	public void setAnioDefuncion(String anioDefuncion) {
		this.anioDefuncion = anioDefuncion;
	}

	public String getHistorialMedico() {
		return historialMedico;
	}

	public void setHistorialMedico(String historialMedico) {
		this.historialMedico = historialMedico;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getDescendencia() {
		return descendencia;
	}

	public void setDescendencia(String descendencia) {
		this.descendencia = descendencia;
	}

	public int getIdParentesco() {
		return idParentesco;
	}

	public void setIdParentesco(int idParentesco) {
		this.idParentesco = idParentesco;
	}

	public int getIdDescendencia() {
		return idDescendencia;
	}

	public void setIdDescendencia(int idDescendencia) {
		this.idDescendencia = idDescendencia;
	}
	

}
