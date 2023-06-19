import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
    private static ArrayList<Concierto> conciertos = new ArrayList<>();
    static boolean[] asientos = new boolean[50];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        // consultar asientos, menú de concierto y estadísticas y registros...
        while (!salir) {
            System.out.println("----- Menú de Administrador -----");
            System.out.println("1. Menú de asientos");
            System.out.println("2. Menú de conciertos");
            System.out.println("3. Menú de entradas");
            System.out.println("4. Deslogearse");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                
                    Asientos switchAsientos = new Asientos();
                    switchAsientos.switchEstadoAsientos(asientos);
                    break;
                case 2:
                    Conciertos conciertos = new Conciertos();
                    conciertos.main(args);
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
