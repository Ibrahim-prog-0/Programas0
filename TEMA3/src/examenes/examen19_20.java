package examenes;

import java.util.Scanner;

public class examen19_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] eqLocal = new String[20];
		String[] eqVisitante = new String[20];
		int[] golesLocal = new int[20];
		int[] golesVisitante = new int[20];
		int contadorPartidos = 0;
		System.out.println("1-Introducir resultados de un partido.\r\n"
				+ "2-Mostrar todos los partidos introducidos.\r\n" + "3-Mostrar el equipo ganador de la liga.\r\n"
				+ "4-Mostrar el porcentaje de partidos en los que perdio el equipo local.\r\n"
				+ "5-Introducir nombre de equipo y mostrar los resultados de todos sus partidos.\r\n"
				+ "6-Finalizar programa.\r\n");

		int opcion = sc.nextInt();
		while (opcion != 6) {
			switch (opcion) {
			case 1:
				sc.nextLine();

				System.out.println("Introduzca el equipo local:");
				eqLocal[contadorPartidos] = sc.nextLine();

				System.out.println("Introduzca el equipo visitante:");
				eqVisitante[contadorPartidos] = sc.nextLine();

				System.out.println("Goles del equipo local:");
				golesLocal[contadorPartidos] = sc.nextInt();

				System.out.println("Goles del equipo visitante:");
				golesVisitante[contadorPartidos] = sc.nextInt();

				contadorPartidos++;
				System.out.println("Partido registrado.");
				break;

			case 2:
				for (int i = 0; i < contadorPartidos; i++) {
					System.out.println(eqLocal[i] + "-" + eqVisitante[i] + " (" + golesLocal[i] + "-" + golesVisitante[i] + ")");
				}
				break;
			case 3:

				// Arrays para equipos y sus puntos
				String[] equipos = new String[40];
				int[] puntos = new int[40];
				int contadorEquipos = 0;

				// DESCUBRIR EQUIPOS
				for (int i = 0; i < contadorPartidos; i++) {

					// AÑADIR EQUIPO LOCAL SI NO ESTÁ
					boolean existeLocal = false;
					for (int j = 0; j < contadorEquipos; j++) {
						if (equipos[j].equals(eqLocal[i])) {
							existeLocal = true;
							break;
						}
					}
					if (existeLocal == false) { // <-- cambiado
						equipos[contadorEquipos] = eqLocal[i];
						puntos[contadorEquipos] = 0;
						contadorEquipos++;
					}

					// AÑADIR EQUIPO VISITANTE SI NO ESTÁ
					boolean existeVisitante = false;
					for (int j = 0; j < contadorEquipos; j++) {
						if (equipos[j].equals(eqVisitante[i])) {
							existeVisitante = true;
							
						}
					}
					if (existeVisitante == false) { // <-- cambiado
						equipos[contadorEquipos] = eqVisitante[i];
						puntos[contadorEquipos] = 0;
						contadorEquipos++;
					}

					// SUMAR PUNTOS DEL PARTIDO i
					if (golesLocal[i] > golesVisitante[i]) {
						// gana local
						for (int j = 0; j < contadorEquipos; j++) {
							if (equipos[j].equals(eqLocal[i])) {
								puntos[j] = puntos[j] + 3;
							}
						}
					}

					if (golesLocal[i] < golesVisitante[i]) {
						// gana visitante
						for (int j = 0; j < contadorEquipos; j++) {
							if (equipos[j].equals(eqVisitante[i])) {
								puntos[j] = puntos[j] + 3;
							}
						}
					}

					if (golesLocal[i] == golesVisitante[i]) {
						// empate
						for (int j = 0; j < contadorEquipos; j++) {
							if (equipos[j].equals(eqLocal[i]) || equipos[j].equals(eqVisitante[i])) {
								puntos[j] = puntos[j] + 1;
							}
						}
					}
				}

				// BUSCAR EL GANADOR
				int maxPuntos = -1;
				String ganador = "";

				for (int i = 0; i < contadorEquipos; i++) {
					if (puntos[i] > maxPuntos) {
						maxPuntos = puntos[i];
						ganador = equipos[i];
					}
				}

				System.out.println("El equipo ganador es " + ganador + " con " + maxPuntos + " puntos.");
				break;

			case 4:
			    // Si no hay partidos, no podemos calcular nada
			    if (contadorPartidos == 0) {
			        System.out.println("No hay partidos introducidos.");
			        break;
			    }

			    int partidosPerdidosLocal = 0;

			    // Recorremos TODOS los partidos introducidos
			    for (int i = 0; i < contadorPartidos; i++) {

			        // Si el local tiene menos goles => ha perdido
			        if (golesLocal[i] < golesVisitante[i]) {
			            partidosPerdidosLocal++;
			        }
			    }

			    // Cálculo del porcentaje
			    double porcentaje = (partidosPerdidosLocal * 100.0) / contadorPartidos;

			    System.out.println("El equipo local perdió el " + porcentaje + "% de los partidos.");
			    break;

			case 5:
			    sc.nextLine(); // limpiar buffer

			    System.out.println("Introduzca el nombre del equipo:");
			    String equipoBuscado = sc.nextLine();

			    boolean encontrado = false;

			    // Buscar partidos donde fue LOCAL
			    System.out.println("Partidos donde fue LOCAL:");
			    for (int i = 0; i < contadorPartidos; i++) {
			        if (eqLocal[i].equals(equipoBuscado)) {
			            encontrado = true;
			            System.out.println(eqLocal[i] + " " + golesLocal[i] + " - " 
			                               + golesVisitante[i] + " " + eqVisitante[i]);
			        }
			    }

			    // Buscar partidos donde fue VISITANTE
			    System.out.println("Partidos donde fue VISITANTE:");
			    for (int i = 0; i < contadorPartidos; i++) {
			        if (eqVisitante[i].equals(equipoBuscado)) {
			            encontrado = true;
			            System.out.println(eqLocal[i] + " " + golesLocal[i] + " - "
			                               + golesVisitante[i] + " " + eqVisitante[i]);
			        }
			    }

			    // Si nunca apareció
			    if (encontrado == false) {
			        System.out.println("Ese equipo no ha jugado ningún partido.");
			    }

			    break;

			

			default:
				break;
			}

			System.out.println("1-Introducir resultados de un partido.\r\n"
					+ "2-Mostrar todos los partidos introducidos.\r\n" + "3-Mostrar el equipo ganador de la liga.\r\n"
					+ "4-Mostrar el porcentaje de partidos en los que perdio el equipo local.\r\n"
					+ "5-Introducir nombre de equipo y mostrar los resultados de todos sus partidos.\r\n"
					+ "6-Finalizar programa.\r\n");
			opcion = sc.nextInt();
		}
		sc.close();
	}

}
