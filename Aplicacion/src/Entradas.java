import java.util.Arrays;
import java.util.Scanner;

public class Entradas {
    public static void main(String[] args) {
        boolean[] asientos = new boolean[50];
        Scanner scanner = new Scanner(System.in);
        comprarEntradas(asientos, scanner);
    }

    public static void comprarEntradas(boolean[] asientos, Scanner scanner) {

        System.out.println("Lugares disponibles:");
        System.out.println("1. Platea Izquierda (Filas 1-9, Asientos 1-9)");
        System.out.println("2. Campo (Filas 10-25, Asientos 1-16)");
        System.out.println("3. Platea Derecha (Filas 26-34, Asientos 1-9)");
        System.out.println("4. Palco VIP (Filas 35-50, Asientos 1-16)");

        System.out.print("Ingrese el lugar deseado: ");
        int lugar = scanner.nextInt();

        int asientoInicial = 0;
        int asientoFinal = 0;
        String seccion = "";
        int filas = 0;
        int asientosPorFila = 0;

        switch (lugar) {
            case 1:
                asientoInicial = 0;
                asientoFinal = 8;
                seccion = "Platea Izquierda";
                filas = 3;
                asientosPorFila = 3;
                break;
            case 2:
                asientoInicial = 9;
                asientoFinal = 24;
                seccion = "Campo";
                filas = 4;
                asientosPorFila = 4;
                break;
            case 3:
                asientoInicial = 25;
                asientoFinal = 33;
                seccion = "Platea Derecha";
                filas = 3;
                asientosPorFila = 3;
                break;
            case 4:
                asientoInicial = 34;
                asientoFinal = 49;
                seccion = "Palco VIP";
                filas = 4;
                asientosPorFila = 4;
                break;
            default:
                System.out.println("Lugar inválido. La entrada no será comprada.");
                return;
        }

        System.out.println("Filas disponibles: 1-" + filas);
        System.out.println("Asientos disponibles: 1-" + asientosPorFila);

        System.out.print("Ingrese la fila deseada: ");
        int fila = scanner.nextInt();

        System.out.print("Ingrese el asiento deseado: ");
        int asiento = scanner.nextInt();

        int indiceAsiento = (fila - 1) * asientosPorFila + asientoInicial + (asiento - 1);

        if (fila < 1 || fila > filas || asiento < 1 || asiento > asientosPorFila) {
            System.out.println("Asiento o fila inválido. La entrada no será comprada.");
            return;
        }

        if (asientos[indiceAsiento]) {
            System.out.println("El asiento seleccionado está ocupado. La entrada no será comprada.");
        } else {
            asientos[indiceAsiento] = true;
            System.out.println(
                    "Se ha comprado la entrada en el asiento " + (indiceAsiento + 1) + " de la sección " + seccion);
        }

        System.out.println();
    }

}
