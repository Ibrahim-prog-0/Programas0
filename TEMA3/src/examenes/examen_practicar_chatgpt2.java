package examenes;

import java.util.Scanner;

public class examen_practicar_chatgpt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] nombreProd = new String [30];
		String[] ciudadPedRealizado = new String [30];
		int[] unidadesCompradas = new int[30];
		double[] precioTotal = new double[30];
		int contadorPedidos = 0;
		System.out.println("1- Introducir pedido.\r\n"
						+ "2- Mostrar todos los pedidos.\r\n"
						+ "3- Mostrar la ciudad que más dinero ha generado.\r\n"
						+ "4- Mostrar el producto más vendido de toda la campaña.\r\n"
						+ "5- Introducir un producto y mostrar cuántos pedidos tiene y cuánto dinero ha generado.\r\n"
						+ "6- Fin.\r\n");
		int opcion = sc.nextInt();
		while (opcion != 6) {
			switch (opcion) {
			case 1:
				System.out.println("Nombre del producto.");
				nombreProd[contadorPedidos] = sc.next();
				System.out.println("Ciudad donde se ha realizado el pedido.");
				ciudadPedRealizado[contadorPedidos] = sc.next();
				System.out.println("Cantidad de unidades compradas");
				unidadesCompradas[contadorPedidos] = sc.nextInt();
				System.out.println("Precio total(€)");
				precioTotal[contadorPedidos] = sc.nextDouble();
				contadorPedidos++;
				break;
				
			case 2:
				for (int i = 0; i < contadorPedidos; i++) {
					System.out.println("Producto: " + nombreProd[i] + " | Ciudad: " + ciudadPedRealizado[i] + " | Unidades: " + unidadesCompradas[i] + " | Precio: " + precioTotal[i]);
				}
				break;
			
			case 3:
			    String[] ciudad = new String[30];
			    double[] precio = new double[30];
			    int contadorCiudades = 0;

			    for (int i = 0; i < contadorPedidos; i++) {

			        boolean existeCiudad = false;
			        int pos = -1;

			        // Buscar si la ciudad YA está
			        for (int j = 0; j < contadorCiudades; j++) {
			            if (ciudad[j].equals(ciudadPedRealizado[i])) {
			                existeCiudad = true;
			                pos = j;
			            }
			        }

			        // Si NO está, la añadimos
			        if (existeCiudad == false) {
			            ciudad[contadorCiudades] = ciudadPedRealizado[i];
			            precio[contadorCiudades] = 0;   // empezar en 0€
			            pos = contadorCiudades;
			            contadorCiudades++;
			        }

			        // Sumar el dinero de este pedido
			        precio[pos] = precio[pos] + precioTotal[i];
			    }

			    // Buscar la ciudad que más dinero ha generado
			    double max = -1;
			    String ciudadMax = "";

			    for (int k = 0; k < contadorCiudades; k++) {
			        if (precio[k] > max) {
			            max = precio[k];
			            ciudadMax = ciudad[k];
			        }
			    }

			    System.out.println("La ciudad que más dinero ha generado es " 
			                       + ciudadMax + " con " + max + "€.");

			    break;


			default:
				break;
			}
			System.out.println("1- Introducir pedido.\r\n"
					+ "2- Mostrar todos los pedidos.\r\n"
					+ "3- Mostrar la ciudad que más dinero ha generado.\r\n"
					+ "4- Mostrar el producto más vendido de toda la campaña.\r\n"
					+ "5- Introducir un producto y mostrar cuántos pedidos tiene y cuánto dinero ha generado.\r\n"
					+ "6- Fin.\r\n");
			opcion = sc.nextInt();
			
		}
		sc.close();
	}
}
