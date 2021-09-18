package model;

public class Usuarios {
	
	private Float cedula_usuario;
	private String email_usuario;
	private String nombre_usuario;
	private String password;
	private String usuario;
	
	public Usuarios(Float cedula_usuario, String email_usuario, String nombre_usuario, String password,
			String usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.usuario = usuario;
	}
	
	public Usuarios(Float cedula_usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
	}
	

	public Usuarios(String password, String usuario) {
		super();
		this.password = password;
		this.usuario = usuario;
	}

	public Float getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Float cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword_usuario(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
