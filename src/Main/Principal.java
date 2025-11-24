package Main;

import java.util.Scanner;

import Dominio.Computadoras;
import Implementacion.LogicaMetodos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner lectura = null;
		
		String marca;
		int ram;
		float precio;
		int stock, menuPrin, indice;
		
		Computadoras computadora = null;
		
		LogicaMetodos imp = new LogicaMetodos();
		
		System.out.println("Hola Mundo");
		System.out.println("Que tengan un buen dia "+10);
		
		do{
			System.out.println("BIENVENIDOS AL SISTEMA");
			System.out.println("1--ALTA");
			System.out.println("2--MOSTRAR");
			System.out.println("3--BUSCAR");
			System.out.println("4--EDITAR");
			System.out.println("5--ELIMINAR");
			System.out.println("6--BUSCAR POR MARCA");
			System.out.println("7--BEDITAR EL PRECIO BUSCANDO POR MARCA");
			System.out.println("8--ELIMINAR BUSCANDO POR MARCA");
			System.out.println("9--SALIR");
			
			lectura = new Scanner(System.in);
			menuPrin = lectura.nextInt();
			
			switch (menuPrin) {
			case 1:
				try {
					System.out.println("Ingrese la marca");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();
					
					System.out.println("Ingrese la memoria ram");
					lectura = new Scanner(System.in);
					ram = lectura.nextInt();
					
					System.out.println("Ingrese el precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();
					
					System.out.println("Ingrese el stock");
					lectura = new Scanner(System.in);
					stock = lectura.nextInt();
					
					//crear objeto
					computadora = new Computadoras(marca, ram, precio, stock);
					
					//guardar
					imp.guardar(computadora);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar " + e.getMessage());
				}
				break;
			case 2:
				if (imp.mostrar().size() > 0)
					System.out.println(imp.mostrar());
				else
					System.out.println("No hay registros");
				break;
			case 3:
				if (imp.mostrar().size() > 0) {
					try {
						System.out.println("Ingrese el indice del registro a buscar");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();
						
						//buscar
						computadora = imp.buscar(indice);
						System.out.println("Se encontro "+computadora);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else
					System.out.println("No hay registros");
				break;
			case 4:
				if (imp.mostrar().size() > 0) {
					try {
						System.out.println("Ingrese el indice del registro a editar");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();
						
						//buscar
						computadora = imp.buscar(indice);
						System.out.println("Se encontro "+computadora.getMarca() + "Para editar");
						
						//editar
						System.out.println("Ingrese la nueva memoria ram");
						lectura = new Scanner(System.in);
						ram = lectura.nextInt();
						
						//actualizar objeto
						computadora.setRam(ram);
						
						//actualizar en la lista
						imp.editar(indice, computadora);
						System.out.println("Se edito");
					
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else
					System.out.println("No hay registros");
				break;
			case 5:
				try {
					System.out.println("Ingrese el indice del registro a eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					//eliminar
					imp.eliminar(indice);
					System.out.println("Se elimino");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No existe ese registro");
				}
				break;
			case 6:
				System.out.println("Ingrese la marca a buscar");
				lectura = new Scanner(System.in);
				String marca1 = lectura.nextLine();
				
				Computadoras comp = imp.buscarXmarca(marca1);
				
				if (comp != null) {
					System.out.println("Se encontro " + comp);
				} else {
					System.out.println("No se encontro la marca");
				}
				break;
			case 7:
				if (imp.mostrar().size() > 0) {
			        try {
			            System.out.println("Ingrese la marca a buscar para editar el precio");
			            lectura = new Scanner(System.in);
			            marca = lectura.nextLine();

			            Computadoras comp1 = imp.buscarXmarca(marca);

			            if (comp1 != null) {
			                System.out.println("Se encontró: " + comp1.getMarca());
			                System.out.println("Precio actual: " + comp1.getPrecio());

			                System.out.println("Ingrese el nuevo precio");
			                float nuevoPrecio = lectura.nextFloat();
			                comp1.setPrecio(nuevoPrecio);

			                imp.editarBuscXmarca(marca, computadora);
			            } else {
			                System.out.println("No se encontró esa marca");
			            }

			        } catch (Exception e) {
			            System.out.println("Error al editar precio " + e.getMessage());
			        }

			    } else {
			        System.out.println("No hay registros");
			    }
				break;
			case 8:
				if (imp.mostrar().size() > 0) {
			        try {
			            System.out.println("Ingrese la marca del registro a eliminar");
			            lectura = new Scanner(System.in);
			            marca = lectura.nextLine();

			            // Buscar primero
			            Computadoras compEliminar = imp.buscarXmarca(marca);

			            if (compEliminar != null) {
			                System.out.println("Se encontró la marca: " + compEliminar.getMarca());
			                System.out.println("¿Está seguro que desea eliminarla? (1=Sí / 2=No)");

			                int confirmacion = lectura.nextInt();

			                if (confirmacion == 1) {
			                    imp.eliminarXmarca(marca);
			                    System.out.println("Registro eliminado correctamente");
			                } else {
			                    System.out.println("Operación cancelada.");
			                }
			            } else {
			                System.out.println("No se encontró un registro con esa marca.");
			            }

			        } catch (Exception e) {
			            System.out.println("Error al eliminar: " + e.getMessage());
			        }

			    } else {
			        System.out.println("No hay registros para eliminar.");
			    }
				break;
			case 9:
				break;
			}
		}while(menuPrin < 9);

	}

}
