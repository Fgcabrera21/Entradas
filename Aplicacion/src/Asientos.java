import java.util.Arrays;
import java.util.Scanner;

public class Asientos {
    public static void main(String[] args) {
        boolean[] asientos = new boolean[50];
        Scanner scanner = new Scanner(System.in);

    }

    public static void switchEstadoAsientos(boolean[] asientos) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        while (!salir) {
            System.out.println("----- Sistema de Venta de Entradas -----");
            System.out.println("1. Ver estado de los asientos");
            System.out.println("2. Recuento de asientos");
            System.out.println("3. Salir");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarEstadoAsientos(asientos);
                    break;
                case 2:
                    mostrarRecuentoAsientos(asientos);
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    public static void mostrarEstadoAsientos(boolean[] asientos) {
        System.out.println("----- Estado de los Asientos -----");
        for (int i = 0; i < asientos.length; i++) {
            System.out.println("Asiento " + (i + 1) + ": " + (asientos[i] ? "Ocupado" : "Disponible"));
        }
        System.out.println();
    }

    public static void mostrarRecuentoAsientos(boolean[] asientos) {
        int plateaIzquierdaDisponibles = 0;
        int campoDisponibles = 0;
        int plateaDerechaDisponibles = 0;
        int palcoVIPDisponibles = 0;
        int asientosOcupados = 0;

        for (int i = 0; i < asientos.length; i++) {
            if (!asientos[i]) {
                if (i >= 0 && i <= 8) {
                    plateaIzquierdaDisponibles++;
                } else if (i >= 9 && i <= 24) {
                    campoDisponibles++;
                } else if (i >= 25 && i <= 33) {
                    plateaDerechaDisponibles++;
                } else {
                    palcoVIPDisponibles++;
                }
            } else {
                asientosOcupados++;
            }
        }

        System.out.println("----- Recuento de Asientos -----");
        System.out.println("Asientos Disponibles:");
        System.out.println("Platea Izquierda (3x3): " + plateaIzquierdaDisponibles);
        System.out.println("Campo (4x4): " + campoDisponibles);
        System.out.println("Platea Derecha (3x3): " + plateaDerechaDisponibles);
        System.out.println("Palco VIP (4x4): " + palcoVIPDisponibles);
        System.out.println("Asientos Ocupados: " + asientosOcupados);
        System.out.println("Total de Asientos: " + asientos.length);
        System.out.println();
    }
}
