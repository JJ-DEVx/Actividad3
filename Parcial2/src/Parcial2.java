import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parcial2 {

    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Sistema de Gestión de Usuarios ===");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Mostrar usuarios registrados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1 -> {
                    System.out.print("Ingrese su nombre completo: ");
                    String name = scanner.nextLine();
                    System.out.print("Ingrese su correo electrónico: ");
                    String email = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String password = scanner.nextLine();

                    try {
                        userService.registerUser(name, email, password);
                        System.out.println("Usuario registrado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> userService.showUsers();
                case 3 -> {
                    exit = true;
                    System.out.println("¡Hasta luego!");
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}

class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Correo: " + email;
    }
}

class UserService {
    private List<User> users = new ArrayList<>();

    public void registerUser(String name, String email, String password) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("El nombre debe contener solo letras y espacios.");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres, incluir una letra mayúscula, una letra minúscula y un número.");
        }
        users.add(new User(name, email, password));
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados: (Las contraseñas no se muestran por seguridad)");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private boolean isValidName(String name) {
        return Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", name);
    }

    private boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,7}$", email);
    }

    private boolean isValidPassword(String password) {
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", password);
    }
}

