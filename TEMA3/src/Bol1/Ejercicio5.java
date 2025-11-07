package Bol1;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Escriba el primer numero.");
		int num1 = sc.nextInt();

		System.out.println("Ahora el segundo.");
		int num2 = sc.nextInt();

		System.out.println("Por ultimo, el tercero.");
		int num3 = sc.nextInt();
		
		if (Ejercicio4.mayor(num1, num2) > num3) {
			System.out.println("El numero mayor es " + Ejercicio4.mayor(num1, num2) + ".");
		} else {
			System.out.println("El numero mayor es " + num3 + ".");
		}
		sc.close();

	}

}
