package examenes;

import java.util.Scanner;

public class examen17_18 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] ciudades = new String[30];
		int[] mes = new int[30];
		double[] lluvia = new double[30];
		int contador = 0;

		int opcion = 0;

		while (opcion != 6) {

			System.out.println("1- Introducir dato.");
			System.out.println("2- Listar todos los datos.");
			System.out.println("3- Mostrar media anual de una ciudad.");
			System.out.println("4- Listado alfabético por ciudades y su lluvia anual.");
			System.out.println("5- Listado por mes de ciudades y sus lluvias.");
			System.out.println("6- Fin.");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1:
				System.out.println("Nombre de la ciudad:");
				ciudades[contador] = sc.nextLine();

				System.out.println("Mes (1 a 12):");
				mes[contador] = sc.nextInt();

				System.out.println("Litros de lluvia en ese mes:");
				lluvia[contador] = sc.nextDouble();
				sc.nextLine();

				contador++;
				break;

			case 2:
				// ordenar alfabeticamente y por mes dentro de cada ciudad
				for (int i = 0; i < contador - 1; i++) {
					for (int j = 0; j < contador - 1 - i; j++) {
						if (ciudades[j].compareTo(ciudades[j + 1]) > 0 ||
						   (ciudades[j].equals(ciudades[j + 1]) && mes[j] > mes[j + 1])) {

							String auxC = ciudades[j];
							ciudades[j] = ciudades[j + 1];
							ciudades[j + 1] = auxC;

							int auxM = mes[j];
							mes[j] = mes[j + 1];
							mes[j + 1] = auxM;

							double auxL = lluvia[j];
							lluvia[j] = lluvia[j + 1];
							lluvia[j + 1] = auxL;
						}
					}
				}

				for (int i = 0; i < contador; i++) {
					System.out.println(ciudades[i] + ": mes " + mes[i] + " litros: " + lluvia[i]);
				}
				break;

			case 3:
				System.out.println("Ciudad para calcular la media anual:");
				String buscada = sc.nextLine();

				double suma = 0;
				int contadorMeses = 0;

				for (int i = 0; i < contador; i++) {
					if (ciudades[i].equals(buscada)) {
						suma += lluvia[i];
						contadorMeses++;
					}
				}

				if (contadorMeses == 0) {
					System.out.println("Esa ciudad no existe.");
				} else {
					double media = suma / contadorMeses;
					System.out.println("Para " + buscada + ": Media de lluvias anual: " + media);
				}

				break;

			case 4:
				// calcular lluvia total por ciudad
				String[] ciudadesUnicas = new String[30];
				double[] totalCiudad = new double[30];
				int contadorUnicas = 0;

				for (int i = 0; i < contador; i++) {

					boolean existe = false;
					int pos = -1;

					for (int j = 0; j < contadorUnicas; j++) {
						if (ciudadesUnicas[j].equals(ciudades[i])) {
							existe = true;
							pos = j;
						}
					}

					if (existe == false) {
						ciudadesUnicas[contadorUnicas] = ciudades[i];
						totalCiudad[contadorUnicas] = lluvia[i];
						contadorUnicas++;
					} else {
						totalCiudad[pos] += lluvia[i];
					}
				}

				// ordenar alfabéticamente
				for (int i = 0; i < contadorUnicas - 1; i++) {
					for (int j = 0; j < contadorUnicas - 1 - i; j++) {
						if (ciudadesUnicas[j].compareTo(ciudadesUnicas[j + 1]) > 0) {

							String auxC = ciudadesUnicas[j];
							ciudadesUnicas[j] = ciudadesUnicas[j + 1];
							ciudadesUnicas[j + 1] = auxC;

							double auxT = totalCiudad[j];
							totalCiudad[j] = totalCiudad[j + 1];
							totalCiudad[j + 1] = auxT;
						}
					}
				}

				for (int i = 0; i < contadorUnicas; i++) {
					System.out.println(ciudadesUnicas[i] + " litros......: " + totalCiudad[i]);
				}

				break;

			case 5:
				System.out.println("Introduce un mes (1 a 12):");
				int mesBuscado = sc.nextInt();
				sc.nextLine();

				// recoger ciudades y lluvias del mes
				String[] ciuMes = new String[30];
				double[] lluMes = new double[30];
				int contMes = 0;

				for (int i = 0; i < contador; i++) {
					if (mes[i] == mesBuscado) {
						ciuMes[contMes] = ciudades[i];
						lluMes[contMes] = lluvia[i];
						contMes++;
					}
				}

				// ordenar por cantidad de lluvia creciente
				for (int i = 0; i < contMes - 1; i++) {
					for (int j = 0; j < contMes - 1 - i; j++) {
						if (lluMes[j] > lluMes[j + 1]) {

							double auxL = lluMes[j];
							lluMes[j] = lluMes[j + 1];
							lluMes[j + 1] = auxL;

							String auxC = ciuMes[j];
							ciuMes[j] = ciuMes[j + 1];
							ciuMes[j + 1] = auxC;
						}
					}
				}

				System.out.println("Para el mes " + mesBuscado + ":");
				for (int i = 0; i < contMes; i++) {
					System.out.println(ciuMes[i] + " lluvias en el mes: " + lluMes[i]);
				}

				break;

			case 6:
				System.out.println("Fin del programa.");
				break;
			}
		}

		sc.close();
	}
}

