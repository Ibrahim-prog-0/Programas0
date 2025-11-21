package examenes;

import java.util.Scanner;

public class examen16_17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] cursos = new String[50];
        String[] profesores = new String[50];

        String[] cursoAlumno = new String[200];
        String[] alumnos = new String[200];
        int[] notas = new int[200];

        int contadorCursos = 0;
        int contadorAlumnos = 0;

        int opcion;

        do {
            System.out.println("\n1- Introducir datos de un curso.");
            System.out.println("2- Introducir dato de la nota de un alumno en un curso.");
            System.out.println("3- Listado de todos los datos introducidos, alfabéticamente por curso.");
            System.out.println("4- Listado alfabético de profesores con más de 10 alumnos en total.");
            System.out.println("5- Listado de cursos con su nota media, ordenado por media.");
            System.out.println("6- Listado de alumnos y cursos en los que se supera una nota dada.");
            System.out.println("7- Fin.");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

            // Opción 1: introducir curso + profesor
            case 1:
                System.out.println("Nombre del profesor:");
                profesores[contadorCursos] = sc.nextLine();

                System.out.println("Nombre del curso:");
                cursos[contadorCursos] = sc.nextLine();

                contadorCursos++;
                break;

            // Opción 2: introducir nota alumno-curso
            case 2:
                System.out.println("Nombre del alumno:");
                alumnos[contadorAlumnos] = sc.nextLine();

                System.out.println("Nombre del curso realizado:");
                cursoAlumno[contadorAlumnos] = sc.nextLine();

                System.out.println("Nota del alumno:");
                notas[contadorAlumnos] = sc.nextInt();

                contadorAlumnos++;
                break;

            // Opción 3: listado alfabético por curso
            case 3:
                for (int i = 0; i < contadorCursos; i++) {

                    // imprimir curso con su profesor
                    System.out.println("Curso: " + cursos[i] + " Profesor: " + profesores[i]);

                    // y todos los alumnos de ese curso
                    for (int j = 0; j < contadorAlumnos; j++) {
                        if (cursoAlumno[j].equalsIgnoreCase(cursos[i])) {
                            System.out.println(" Alumno: " + alumnos[j] + " Nota: " + notas[j]);
                        }
                    }
                }
                break;

            // Opción 4: profesores con >10 alumnos
            case 4:
                for (int i = 0; i < contadorCursos; i++) {

                    int contador = 0;

                    for (int j = 0; j < contadorAlumnos; j++) {
                        if (cursoAlumno[j].equalsIgnoreCase(cursos[i])) {
                            contador++;
                        }
                    }

                    if (contador > 10) {
                        System.out.println(profesores[i]);
                    }
                }
                break;

            // Opción 5: cursos ordenados por media
            case 5:
                double[] medias = new double[contadorCursos];

                for (int i = 0; i < contadorCursos; i++) {
                    int suma = 0;
                    int cuenta = 0;

                    for (int j = 0; j < contadorAlumnos; j++) {
                        if (cursoAlumno[j].equalsIgnoreCase(cursos[i])) {
                            suma += notas[j];
                            cuenta++;
                        }
                    }

                    if (cuenta > 0) {
                        medias[i] = (double) suma / cuenta;
                    } else {
                        medias[i] = 0;
                    }
                }

                // ordenar por media (burbuja)
                for (int i = 0; i < contadorCursos - 1; i++) {
                    for (int j = i + 1; j < contadorCursos; j++) {
                        if (medias[i] > medias[j]) {

                            double auxMedia = medias[i];
                            medias[i] = medias[j];
                            medias[j] = auxMedia;

                            String auxCurso = cursos[i];
                            cursos[i] = cursos[j];
                            cursos[j] = auxCurso;

                            String auxProf = profesores[i];
                            profesores[i] = profesores[j];
                            profesores[j] = auxProf;
                        }
                    }
                }

                for (int i = 0; i < contadorCursos; i++) {
                    System.out.println("Curso: " + cursos[i] + " media: " + medias[i]);
                }
                break;

            // Opción 6: alumnos con nota mínima
            case 6:
                System.out.println("Nota mínima:");
                int min = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < contadorAlumnos; i++) {
                    if (notas[i] >= min) {
                        System.out.println("Curso: " + cursoAlumno[i] + " alumno: " + alumnos[i] + " nota: " + notas[i]);
                    }
                }
                break;

            }

        } while (opcion != 7);

        sc.close();
    }
}
