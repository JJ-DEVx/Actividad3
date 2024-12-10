import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Actividad9 {

    // Clase interna para validar contraseñas en un hilo
    static class PasswordValidatorThread extends Thread {
        private final String password;

        public PasswordValidatorThread(String password) {
            this.password = password;
        }

        @Override
        public void run() {
            String validationMessage = validatePassword(password);
            System.out.println("Contraseña: \"" + password + "\" -> " + validationMessage);
        }

        // Método que use para validar la contraseña y detallar qué requisitos faltan
        private String validatePassword(String password) {
            if (password == null) return "Contraseña no puede ser nula.";

            List<String> errors = new ArrayList<>();

            // Validar longitud mínima
            if (password.length() < 8) {
                errors.add("Debe tener al menos 8 caracteres.");
            }

            // Validar al menos un número
            if (!Pattern.compile("\\d").matcher(password).find()) {
                errors.add("Debe contener al menos un número.");
            }

            // Validar al menos dos letras mayúsculas
            if (Pattern.compile("[A-Z]").matcher(password).results().count() < 2) {
                errors.add("Debe contener al menos dos letras mayúsculas.");
            }

            // Validar al menos tres letras minúsculas
            if (Pattern.compile("[a-z]").matcher(password).results().count() < 3) {
                errors.add("Debe contener al menos tres letras minúsculas.");
            }

            // Validar al menos un carácter especial
            if (!Pattern.compile("[!@#$%^&*()\\-_=+{}\\[\\]|:;\"'<>,.?/]").matcher(password).find()) {
                errors.add("Debe contener al menos un carácter especial.");
            }

            // Si no hay errores, la contraseña es válida
            if (errors.isEmpty()) {
                return "Es válida.";
            }

            // Combinar errores en un solo mensaje
            return "NO es válida. Faltan: " + String.join(", ", errors);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Thread> threads = new ArrayList<>();

        System.out.println("Ingrese contraseñas separadas por comas (ejemplo: Pass123!,Abc#Def2,xyz):");
        String input = scanner.nextLine();

        // Dividir las contraseñas ingresadas por el usuario
        String[] passwords = input.split(",");

        // Crear y lanzar un hilo por cada contraseña
        for (String password : passwords) {
            Thread thread = new PasswordValidatorThread(password.trim());
            threads.add(thread);
            thread.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar un hilo: " + e.getMessage());
            }
        }

        System.out.println("Validación completada.");
        scanner.close();
    }
}

