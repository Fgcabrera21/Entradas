import java.util.Arrays;
import java.util.Scanner;

public class MenuCliente {
    public static void main(String[] args) {
        boolean[] asientos = new boolean[50];
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("----- Sistema de Venta de Entradas -----");
            System.out.println("1. Consultar conciertos disponibles");
            System.out.println("2. Ver estado de los asientos");
            System.out.println("3. Comprar entrada");
            System.out.println("4. Deslogearse");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Conciertos consultarConciertos = new Conciertos();
                    consultarConciertos.verListaConciertos();
                    break;
                case 2:
                    Asientos verEstadoAsientos = new Asientos();
                    verEstadoAsientos.mostrarEstadoAsientos(asientos);
                    break;
                case 3:
                    Entradas comprarEntradas = new Entradas();
                    comprarEntradas.comprarEntradas(asientos, scanner);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Deslogeando...");

                    Aplicacion relogin = new Aplicacion();
                    relogin.main(args);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}