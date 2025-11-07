package Bol1;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la letra para saber si se trata de una vocal.");
		char letra = sc.next().charAt(0);
		char letraEnMayus = Character.toUpperCase(letra);
		if (vocal(letraEnMayus) ==true) {
			System.out.println("La letra es una vocal");
		} else {
			System.out.println("La letra es consonante");
		}
		
		sc.close();
	}
	public static boolean vocal(char vocalSiNo) {
		switch (vocalSiNo) {
		case 'A', 'E', 'I', 'O', 'U':
			return true;
			

		default:
			return false;
			
		}
		
		
	}
}
