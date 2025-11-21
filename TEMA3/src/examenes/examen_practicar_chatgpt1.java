package examenes;

import java.util.Scanner;

public class examen_practicar_chatgpt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] ciudadEnvio = new String [30];
		String[] ciudadRecibe = new String [30];
		double[] pesoPaquete = new double [30];
		double[] precioCobrado = new double [30];
		int contadorEnvios = 0;
		System.out.println("1- Introducir envío.\r\n"
							+ "2- Listar todos los datos.\r\n"
							+ "3- Mostrar la ciudad con mayor peso total enviado.\r\n"
							+ "4- Listado alfabético por ciudades y su facturación total.\r\n"
							+ "5- Introducir una ciudad y mostrar envíos enviados y recibidos.\r\n"
							+ "6- Fin.\r\n");
		int opcion = sc.nextInt();
		while (opcion != 6) {
			switch (opcion) {
			case 1:
				System.out.println("Introduce la ciudad de origen.");
				ciudadEnvio [contadorEnvios] = sc.next();
				System.out.println("Introduce la ciudad de destino.");
				ciudadRecibe [contadorEnvios] = sc.next();
				System.out.println("Introduce el peso del paquete(en kg)");
				pesoPaquete [contadorEnvios] = sc.nextDouble();
				System.out.println("Ahora el precio cobrado(en €)");
				precioCobrado [contadorEnvios] = sc.nextDouble();
				System.out.println("Dato almacenado.");
				contadorEnvios++;
				
				break;
			case 2:
				for (int i = 0; i < contadorEnvios; i++) {
					System.out.println("Se ha enviado de la ciudad de " + ciudadEnvio[i] + " a la ciudad de " + ciudadRecibe[i] + " un paquete de " + pesoPaquete[i] + "kg, y un precio de " + precioCobrado[i] + ".");
				}			
				break;
			case 3:
				String[] ciudades = new String[30];
				double[] totalPeso = new double[30];
				int contadorCiudades = 0;
				
				for (int i = 0; i < contadorEnvios; i++) {
					boolean existe = false;
					int pos = -1;
					//buscar si existe ciudad
					for (int j = 0; j < contadorCiudades; j++) {
						if (ciudades[j].equals(ciudadEnvio[i])) {
							existe = true;
							pos = j;
						}
					}
					if (existe == false) {
						ciudades[contadorCiudades] = ciudadEnvio[i];
						totalPeso[contadorCiudades] = 0;
						pos = contadorCiudades;
						contadorCiudades++;
					}
					totalPeso[pos] = totalPeso[pos] + pesoPaquete[i];
				}
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			
			default:
				break;
			}
			System.out.println("1- Introducir envío.\r\n"
					+ "2- Listar todos los datos.\r\n"
					+ "3- Mostrar la ciudad con mayor peso total enviado.\r\n"
					+ "4- Listado alfabético por ciudades y su facturación total.\r\n"
					+ "5- Introducir una ciudad y mostrar envíos enviados y recibidos.\r\n"
					+ "6- Fin.\r\n");
			opcion = sc.nextInt();
			
		}
		System.out.println("Programa finalizado.");
		sc.close();
	}

}

