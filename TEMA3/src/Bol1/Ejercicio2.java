package Bol1;


import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int mayor = 0;
		int menor = 0;
		
		System.out.println("Teclee el primer entero.");
		int primEntero = sc.nextInt();
		
		System.out.println("Ahora el segundo.");
		int segEntero = sc.nextInt();
		
		if (primEntero > segEntero) {
			mayor = primEntero;
			menor = segEntero;
		} else {
			mayor = segEntero;
			menor = primEntero;
		}
		numsComprendidos(mayor, menor);
		
		sc.close();
	}
	static void numsComprendidos(int mayor, int menor) {
		for (int i = menor + 1; i < mayor; i++) {
			System.out.println(i);
		}
		
	}
}
