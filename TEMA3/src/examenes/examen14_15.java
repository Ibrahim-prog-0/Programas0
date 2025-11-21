package examenes;

import java.util.Scanner;

public class examen14_15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] nombres = new String[30];
		double[] notaControl = new double[30];
		double[] notaFinal = new double[30];
		int[] positivos = new int[30];
		int contador = 0;

		int opcion = 0;

		while (opcion != 5) {

			System.out.println("1- Introducir alumno, nota del control y nota del examen final.");
			System.out.println("2- Poner un positivo a un alumno.");
			System.out.println("3- Listar alumnos con su nota final ordenados por nota.");
			System.out.println("4- Mostrar estadísticas de la evaluación.");
			System.out.println("5- Fin.");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1:
				System.out.println("Nombre del alumno:");
				nombres[contador] = sc.nextLine();

				System.out.println("Nota del control:");
				notaControl[contador] = sc.nextDouble();

				System.out.println("Nota examen final:");
				notaFinal[contador] = sc.nextDouble();
				sc.nextLine();

				positivos[contador] = 0;

				contador++;
				break;

			case 2:
				System.out.println("Nombre del alumno al que añadir un positivo:");
				String nombrePos = sc.nextLine();

				for (int i = 0; i < contador; i++) {
					if (nombres[i].equals(nombrePos)) {
						positivos[i] = positivos[i] + 1;
					}
				}
				break;

			case 3:
				// calcular nota final de evaluación: 30% control + 60% final + 10% positivos
				double[] notaEvaluacion = new double[contador];
				for (int i = 0; i < contador; i++) {
					notaEvaluacion[i] = notaControl[i] * 0.30 + notaFinal[i] * 0.60 + positivos[i] * 0.10;
				}

				// ordenar por notaEvaluacion (burbuja y arrastramos los demás arrays)
				for (int i = 0; i < contador - 1; i++) {
					for (int j = 0; j < contador - 1 - i; j++) {
						if (notaEvaluacion[j] > notaEvaluacion[j + 1]) {

							double auxN = notaEvaluacion[j];
							notaEvaluacion[j] = notaEvaluacion[j + 1];
							notaEvaluacion[j + 1] = auxN;

							String auxNom = nombres[j];
							nombres[j] = nombres[j + 1];
							nombres[j + 1] = auxNom;

							double auxC = notaControl[j];
							notaControl[j] = notaControl[j + 1];
							notaControl[j + 1] = auxC;

							double auxF = notaFinal[j];
							notaFinal[j] = notaFinal[j + 1];
							notaFinal[j + 1] = auxF;

							int auxP = positivos[j];
							positivos[j] = positivos[j + 1];
							positivos[j + 1] = auxP;
						}
					}
				}

				// mostrar
				for (int i = 0; i < contador; i++) {
					System.out.println(nombres[i] + " --> Nota final evaluación: " + notaEvaluacion[i]);
				}

				break;

			case 4:
				if (contador == 0) {
					System.out.println("No hay alumnos.");
					break;
				}

				// porcentaje suspensos en examen final
				int suspensos = 0;
				for (int i = 0; i < contador; i++) {
					if (notaFinal[i] < 5) {
						suspensos++;
					}
				}
				double porcentaje = (suspensos * 100.0) / contador;

				// nota media del grupo
				double suma = 0;
				for (int i = 0; i < contador; i++) {
					suma += (notaControl[i] * 0.30 + notaFinal[i] * 0.60 + positivos[i] * 0.10);
				}
				double media = suma / contador;

				// alumno con nota máxima en el control
				double maxControl = -1;
				String mejor = "";
				for (int i = 0; i < contador; i++) {
					if (notaControl[i] > maxControl) {
						maxControl = notaControl[i];
						mejor = nombres[i];
					}
				}

				System.out.println("Porcentaje suspensos examen final: " + porcentaje + "%");
				System.out.println("Nota media evaluación del grupo: " + media);
				System.out.println("Alumno con mejor nota en el control: " + mejor + " (" + maxControl + ")");
				break;

			case 5:
				System.out.println("Fin del programa.");
				break;
			}
		}

		sc.close();
	}
}
