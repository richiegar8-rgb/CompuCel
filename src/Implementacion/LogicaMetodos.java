package Implementacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Dominio.Computadoras;
import Interface.Metodos;
import Interface.Metodos2;

public class LogicaMetodos implements Metodos, Metodos2 {
	
	private List<Computadoras> lista = new ArrayList<Computadoras>();

	@Override
	public void guardar(Computadoras computadora) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		
		for (Computadoras c: lista) {
			if (c.getMarca().equals(computadora.getMarca())) {
				bandera = true;
				System.out.println("Esa marca ya existe no se puede guardar");
				break;
			}
		}
		if (bandera == false) {
			lista.add(computadora);
			System.out.println("Se guardo");
		}
	}

	@Override
	public List<Computadoras> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Computadoras buscar(int indice) {
		// TODO Auto-generated method stub
		return lista.get(indice);
	}

	@Override
	public void editar(int indice, Computadoras computadora) {
		// TODO Auto-generated method stub
		lista.set(indice, computadora);
	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		lista.remove(indice);
	}

	@Override
	public Computadoras buscarXmarca(String marca) {
		// TODO Auto-generated method stub
		for (Computadoras c : lista) {
	        if (c.getMarca().equalsIgnoreCase(marca)) {
	            return c;
	        }
	        
	    }
	    return null;
	    }

	@Override
	public void editarBuscXmarca(String marca, Computadoras computadora) {
		// TODO Auto-generated method stub
		for (int i=0; i < lista.size(); i++) {
			if (lista.get(i).getMarca().equalsIgnoreCase(marca)) {
			lista.get(i).setPrecio(i);
			System.out.println("Precio actualizado");
			return;
		}
		
	}
		System.out.println("No se encontro la marca");
	}

	@Override
	public void eliminarXmarca(String marca) {
		// TODO Auto-generated method stub
		 for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i).getMarca().equalsIgnoreCase(marca)) {
	                lista.remove(i);
	                
	                System.out.println("Registro eliminado por marca");
	                return;
	                
	            }
	        }
	        System.out.println("No se encontró la marca");
	    }

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		lista.clear();
	}

}
