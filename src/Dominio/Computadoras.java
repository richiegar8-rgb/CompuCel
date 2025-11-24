package Dominio;

public class Computadoras {
	
	private String marca;
	private int ram;
	private float precio;
	private int stock;
	
	public Computadoras(String marca, int ram, float precio, int stock) {
		this.marca = marca;
		this.ram = ram;
		this.precio = precio;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Computadoras [marca=" + marca + ", ram=" + ram + ", precio=" + precio + ", stock=" + stock + "]\n";
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
