package main.model;

import java.util.ArrayList;

public class Estudiante {
	
	private String nombre;
	private String apellido;
	private String gitUser;
	private String legajo;
	private ArrayList<Asignacion> tareas;
	
	public Estudiante(String nombre, String apellido, String gitUser, String legajo, ArrayList<Asignacion> tareas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.gitUser = gitUser;
		this.legajo = legajo;
		this.tareas = tareas;
	}

	public Estudiante() {

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

	public String getGitUser() {
		return gitUser;
	}

	public void setGitUser(String gitUser) {
		this.gitUser = gitUser;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public ArrayList<Asignacion> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Asignacion> tareas) {
		this.tareas = tareas;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", gitUser=" + gitUser + ", legajo=" + legajo
				+ ", tareas=" + tareas + "]";
	}
	
	public static Estudiante fromServerMessage(ServerMessage serverMessage)
	{
	    return new Estudiante(
		    serverMessage.getStringFromKey("first_name"), 
		    serverMessage.getStringFromKey("last_name"),
		    serverMessage.getStringFromKey("code"),
		    serverMessage.getStringFromKey("github_user"),
		    new ArrayList<Asignacion>());
	}
}
