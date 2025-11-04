package Bol1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Teclee la cantidad de veces que quiere ver la palabra eco.");
		int numVecesEco = sc.nextInt();
		eco(numVecesEco);
		
		
		
		sc.close();
		
	}
	static void eco(int numVecesEco) {
		for (int i = 0; i < numVecesEco; i++) {
			System.out.println("eco");
		}
		
	}
}
