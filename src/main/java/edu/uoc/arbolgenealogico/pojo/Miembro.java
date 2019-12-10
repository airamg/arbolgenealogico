package edu.uoc.arbolgenealogico.pojo;

public class Miembro {
	
	private int id;
	private String nombre;
	private String apellido;
	private String rutaImagen;
	private int anioNacimiento;
	private int anioDefuncion;
	private String historialMedico;
	
	public Miembro() {
		setNombre("");
		setApellido("");
		setRutaImagen("resources/images/arbol/miembro.png");
		setAnioNacimiento(1900);
		setAnioDefuncion(1900);
		setHistorialMedico("");
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

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public int getAnioDefuncion() {
		return anioDefuncion;
	}

	public void setAnioDefuncion(int anioDefuncion) {
		this.anioDefuncion = anioDefuncion;
	}

	public String getHistorialMedico() {
		return historialMedico;
	}

	public void setHistorialMedico(String historialMedico) {
		this.historialMedico = historialMedico;
	}

}
