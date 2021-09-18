package model;

public class Clientes {
	
	private Float cedula_cliente;
	private String direccion_cliente;
	private String email_cliente;
	private String nombre_usuario;
	private String telefono_cliente;
	
	public Clientes(Float cedula_cliente, String direccion_cliente, String email_cliente, String nombre_usuario,
			String telefono_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.direccion_cliente = direccion_cliente;
		this.email_cliente = email_cliente;
		this.nombre_usuario = nombre_usuario;
		this.telefono_cliente = telefono_cliente;
	}

	public Clientes(Float cedula_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
	}

	public Float getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Float cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
}
