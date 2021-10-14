package model;

public class VentaCliente {
	private Float cedula_cliente;
	private String nombre_cliente;
	private double valor;
	
	public VentaCliente(Float cedula_cliente, String nombre_cliente, double valor) {
		this.cedula_cliente=cedula_cliente;
		this.nombre_cliente=nombre_cliente;
		this.valor=valor;
	}
	
	public Float getCedula_cliente() {
		return cedula_cliente;
	}
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	
	public double getValor() {
		return valor;
	}
}
