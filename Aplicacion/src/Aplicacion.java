import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contraseña = scanner.nextLine();

        if (usuario.equals("admin") && contraseña.equals("admin")) {
            System.out.println("Inicio de sesión exitoso.\n");
            MenuAdmin admin = new MenuAdmin();
            admin.main(args);
            
        } else if (usuario.equals("cliente") && contraseña.equals("cliente")) {
            System.out.println("Inicio de sesión exitoso.\n");
            MenuCliente cliente = new MenuCliente();
            cliente.main(args);
            
        } else {
            System.out.println("Error en el inicio de sesión.\n");
        }
    }

}
