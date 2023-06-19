import java.util.ArrayList;
import java.util.Scanner;

public class Conciertos {
    private static ArrayList<Concierto> conciertos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        // consultar asientos, menú de concierto y estadísticas y registros...
        while (!salir) {
            System.out.println("----- Menú de Conciertos -----");
            System.out.println("1. Ver lista de conciertos");
            System.out.println("2. Agregar concierto");
            System.out.println("3. Eliminar concierto");
            System.out.println("4. Editar concierto");
            System.out.println("5. Salir");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    Conciertos ver = new Conciertos();
                    ver.verListaConciertos();
                    break;
                case 2:
                    Conciertos agregar = new Conciertos();
                    agregar.agregarConcierto();
                    break;
                case 3:
                    Conciertos eliminar = new Conciertos();
                    eliminar.eliminarConcierto();
                    break;
                case 4:
                    Conciertos editar = new Conciertos();
                    editar.editarConcierto();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    public static void verListaConciertos() {
        if (conciertos.isEmpty()) {
            System.out.println("No hay conciertos registrados.");
        } else {
            System.out.println("----- Lista de Conciertos -----");
            for (int i = 0; i < conciertos.size(); i++) {
                System.out.println("Concierto " + (i + 1) + ": " + conciertos.get(i));
            }
        }
        System.out.println();
    }

    public static void agregarConcierto() {
        System.out.print("Ingrese la fecha del concierto (dd/mm/aaaa): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora del concierto (hh:mm): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el nombre del artista: ");
        String artista = scanner.nextLine();

        Concierto concierto = new Concierto(fecha, hora, artista);
        conciertos.add(concierto);

        System.out.println("Concierto agregado exitosamente.");
        System.out.println();
    }

    public static void eliminarConcierto() {
        if (conciertos.isEmpty()) {
            System.out.println("No hay conciertos registrados.");
        } else {
            System.out.print("Ingrese el número del concierto a eliminar: ");
            int numeroConcierto = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            if (numeroConcierto >= 1 && numeroConcierto <= conciertos.size()) {
                conciertos.remove(numeroConcierto - 1);
                System.out.println("Concierto eliminado exitosamente.");
            } else {
                System.out.println("Número de concierto inválido.");
            }
        }
        System.out.println();
    }

    public static void editarConcierto() {
        if (conciertos.isEmpty()) {
            System.out.println("No hay conciertos registrados.");
        } else {
            System.out.print("Ingrese el número del concierto a editar: ");
            int numeroConcierto = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            if (numeroConcierto >= 1 && numeroConcierto <= conciertos.size()) {
                Concierto concierto = conciertos.get(numeroConcierto - 1);

                System.out.print("Ingrese la nueva fecha del concierto (dd/mm/aaaa): ");
                String nuevaFecha = scanner.nextLine();

                System.out.print("Ingrese la nueva hora del concierto (hh:mm): ");
                String nuevaHora = scanner.nextLine();

                System.out.print("Ingrese el nuevo nombre del artista: ");
                String nuevoArtista = scanner.nextLine();

                concierto.setFecha(nuevaFecha);
                concierto.setHora(nuevaHora);
                concierto.setArtista(nuevoArtista);

                System.out.println("Concierto editado exitosamente.");
            } else {
                System.out.println("Número de concierto inválido.");
            }
        }
        System.out.println();
    }

}

class Concierto {
    private String fecha;
    private String hora;
    private String artista;

    public Concierto(String fecha, String hora, String artista) {
        this.fecha = fecha;
        this.hora = hora;
        this.artista = artista;
    }

    public Concierto(String fecha2, String hora2, String artista2, int filas, int asientosPorFila) {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Hora: " + hora + ", Artista: " + artista;
    }
}
