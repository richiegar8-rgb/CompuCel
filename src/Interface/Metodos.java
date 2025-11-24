package Interface;

import java.util.List;

import Dominio.Computadoras;

public interface Metodos {
	
	public void guardar(Computadoras computadora);
	
	public List<Computadoras> mostrar();
	
	public Computadoras buscar(int indice);
	
	public void editar(int indice, Computadoras computadora);
	
	public void eliminar();

	public void eliminar(int indice);

}
