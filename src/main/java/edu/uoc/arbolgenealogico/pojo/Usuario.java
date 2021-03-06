package edu.uoc.arbolgenealogico.pojo;

import java.util.Date;
import java.util.Calendar;

public class Usuario  {
	
	private int id;
	private String username;
	private String pass;
	private String nombre;
	private String apellidos;
	private String ruta_imagen;
	private Date ultima_conexion;
	private String anio_nacimiento;
	private int online; // 1: conectado - 0: desconectado
	
	public Usuario() {		
		setUsername("");
		setPass("");
		setNombre("");
		setApellidos("");
		setAnio_nacimiento("");
		setRuta_imagen("resources/images/usuario/default.png");
		setUltima_conexion(new Date(Calendar.getInstance().getTime().getTime()));
		setOnline(0);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username=username;		
	}		
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass=pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	public Date getUltima_conexion() {
		return ultima_conexion;
	}

	public void setUltima_conexion(Date ultima_conexion) {
		this.ultima_conexion = ultima_conexion;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public String getAnio_nacimiento() {
		return anio_nacimiento;
	}

	public void setAnio_nacimiento(String anio_nacimiento) {
		this.anio_nacimiento = anio_nacimiento;
	}

}
