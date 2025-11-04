package Bol1;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el primer entero.");
		int num1 = sc.nextInt();
		System.out.println("Ahora el segundo.");
		int num2 =sc.nextInt();
		System.out.println(mayor(num1, num2));//la llamada a la función vale lo que devuelve la función
		
		sc.close();
	}
	public static int mayor(int entero1, int entero2) {
		if (entero1 > entero2) {
			return entero1;
		} else {
			return entero2;
		}
	}
}
