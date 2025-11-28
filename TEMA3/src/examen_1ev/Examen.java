package examen_1ev;

import java.util.Scanner;

public class Examen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] codSucursal = new String[21];
		int[] añoSucursal = new int[21];
		int[] clientesAño = new int[21];
		int contadorSucursales = 0;
		int contadorAños = 0;
		System.out.println("1- Introducir dato.\r\n" 
				+ "2- Listar todos los datos.\r\n"
				+ "3- Sucursal con más clientes en un año concreto.\r\n"
				+ "4- Listado de sucursales y años con menos de 1000 clientes.\r\n"
				+ "5- Listado ordenado de sucursales con más de 2000 clientes de media.\r\n" 
				+ "6- Fin.\r\n");
		int opcion = sc.nextInt();
		while (opcion != 6) {
			switch (opcion) {
			case 1:
				System.out.println("Introduce el año al que se le quieren asociar la cantidad de clientes.");
				añoSucursal[contadorSucursales] = sc.nextInt();
				System.out.println("Introduce el codigo de sucursal.");
				codSucursal[contadorSucursales] = sc.next();
				System.out.println("Introduzca la clientela de ese año.");
				clientesAño[contadorSucursales] = sc.nextInt();
				contadorSucursales++;
				contadorAños++;
				break;
			case 2:
				for (int filas = 0; filas < contadorAños; filas++) {
					System.out.println(añoSucursal[filas] + ":");
					
					for (int columnas = 0; columnas < contadorSucursales; columnas++) {
						System.out.println(codSucursal[columnas] + ":" + clientesAño[columnas]);
					}
				}
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;

			default:
				break;
			}

			System.out.println("1- Introducir dato.\r\n" 
					+ "2- Listar todos los datos.\r\n"
					+ "3- Sucursal con más clientes en un año concreto.\r\n"
					+ "4- Listado de sucursales y años con menos de 1000 clientes.\r\n"
					+ "5- Listado ordenado de sucursales con más de 2000 clientes de media.\r\n" 
					+ "6- Fin.\r\n");
			opcion = sc.nextInt();
		}
		System.out.println("Programa finalizado.");
		sc.close();
	}

}

