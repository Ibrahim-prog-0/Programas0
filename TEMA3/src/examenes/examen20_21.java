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
							+"4-Mostrar en cuantas sucursales el total de lo enviado supera 10.000€.\r\n"
							+"5-Finalizar programa.\r\n");
		int opcion = sc.nextInt();
		while (opcion != 5) {
			switch (opcion) {
			case 1:
				System.out.println("Introduce numero de sucursal que envia.");
				int sucEnvia = sc.nextInt();
				System.out.println("Introduce numero de sucursal que recibe.");
				int sucRecibe = sc.nextInt();
				System.out.println("Introduce dinero que se envia.");
				float dineroTransferido = sc.nextFloat();
				transferencias [sucEnvia][sucRecibe]=dineroTransferido;
				System.out.println("Transferencia registrada.");
					 

				break;
			case 2:
				for (int filas = 0; filas < 20; filas++) {
					boolean haEnviado = false;
					for (int columnas = 0; columnas < 20; columnas++) {
						if (transferencias[filas][columnas] > 0) {
							haEnviado = true;
						}
					}
					
					if (haEnviado == true) {
						System.out.println("La sucursal " + filas + " ha enviado:");
						
						for (int columnas = 0; columnas < 20; columnas++) {
							if (transferencias[filas][columnas] > 0) {
								System.out.println("a la sucursal " + columnas + ": " + transferencias[filas][columnas] + "€");
							}
						}
					}
					
				}
				break; 

			case 3:
				int sucMasDineroRecibido = -1;
				float cantDineroRecSucMasDinero = 0;
				for (int columnas = 0; columnas < 20; columnas++) {
					float sumaRecibida = 0;
					for (int filas = 0; filas < 20; filas++) {
						sumaRecibida += transferencias[filas][columnas];
					}
					if (sumaRecibida > cantDineroRecSucMasDinero) {
						cantDineroRecSucMasDinero = sumaRecibida;
						sucMasDineroRecibido = columnas;
					}
				}
				System.out.println("La sucursal que mas dinero ha recibido es " + sucMasDineroRecibido + " con " + cantDineroRecSucMasDinero + "€.");
				break;
			case 4:
				int contadorSucursalesEnvMas10K = 0;
				
				for (int filas = 0; filas < 20; filas++) {
					
					float cantidadTotalEnvSucursal = 0;
					
					for (int columnas = 0; columnas < 20; columnas++) {
						cantidadTotalEnvSucursal += transferencias[filas][columnas];
					}
					if (cantidadTotalEnvSucursal > 10000) {
						contadorSucursalesEnvMas10K++;
					}
				}
				if (contadorSucursalesEnvMas10K > 0) {
					System.out.println("Han enviado mas de 10000€ en total" + contadorSucursalesEnvMas10K + "sucursales.");
				} else {
					System.out.println("Ninguna sucursal ha enviado mas de 10000€.");
				}
				break;

			default:
				System.out.println("Debes introducir un numero entre 1 y 4, o 5 para salir del programa");
				break;
			}
			
			System.out.println("1-Introducir transferencia de una sucursal a otra.\r\n"
					+"2-Mostrar datos introducidos.\r\n"
					+"3-Mostrar sucursal que ha recibido mas dinero.\r\n"
					+"4-Mostrar en cuantas sucursales el total de lo enviado supera 10.000€.\r\n"
					+"5-Finalizar programa.\r\n");
			opcion = sc.nextInt();
		}
		System.out.println("Programa finalizado");
		sc.close();
	}
}
