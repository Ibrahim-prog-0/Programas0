package Bol1;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Teclee el radio en cm.");
		int radio = sc.nextInt();
		System.out.println("Teclee la base en cm.");
		int base = sc.nextInt();
		System.out.println("Teclee la altura en cm.");
		int altura = sc.nextInt();
		
		System.out.println("Ahora, teclee 1 si desea saber el area, o 2 si desea saber el volumen.");
		int opcion = sc.nextInt();
		
		volumenOarea(altura, radio, base, opcion);
		
		sc.close();
	}
	public static void volumenOarea(int altura, int radio, int base, int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("El area es " + (float)(2*Math.PI*radio *(altura + radio)));
			break;
			
		case 2:
			System.out.println("El volumen es " + (float)(Math.PI* Math.pow(radio, 2)*altura));
			break;

		default:
			break;
		}
	}
}
