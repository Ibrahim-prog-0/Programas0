package examenes;

import java.util.Scanner;

public class examen20_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		float [][] transferencias = new float [20][20];
		System.out.println("1-Introducir transferencia de una sucursal a otra.\r\n"
							+"2-Mostrar datos introducidos.\r\n"
							+"3-Mostrar sucursal que ha recibido mas dinero.\r\n"
							+"4-Mostrar en cuantas sucursales el total de lo enviado supera 10.000€.\r\n");
		int opcion = sc.nextInt();
		switch (opcion) {
		
			case '1':
				
				break;
			case '2':
				
				break;
			case '3':
				
				break;
			case '4':
				
				break;
			case '5':
				
				break;
			
	
			default:
				System.out.println("Escribe un numero entre 1 y 4, o 5 para finalizar");
				break;
		}
		
		sc.close();
	}
}
