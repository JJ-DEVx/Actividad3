import java.util.Scanner;

public class Actividad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Es el visitante un residente? (true/false): ");
        boolean isResident = scanner.nextBoolean();

        System.out.print("Ingrese el nombre del visitante: ");
        char Name = scanner.next().charAt(0);

        System.out.print("Ingrese la edad del visitante: ");
        byte age = scanner.nextByte();

        System.out.print("Ingrese el número de piso que visita: ");
        short floor = scanner.nextShort();

        System.out.print("Ingrese el número de departamento que visita: ");
        int apartment = scanner.nextInt();

        System.out.print("Ingrese el número de teléfono del visitante: ");
        long phoneNumber = scanner.nextLong();

        System.out.print("Ingrese la altura del visitante (en metros): ");
        float height = scanner.nextFloat();

        System.out.print("Ingrese el peso del visitante (en kilogramos): ");
        double weight = scanner.nextDouble();

        System.out.println("\nInformación del Visitante:");
        System.out.println("¿Es residente? " + isResident);
        System.out.println("Nombre del visitante: " + Name);
        System.out.println("Edad: " + age);
        System.out.println("Piso: " + floor);
        System.out.println("Departamento: " + apartment);
        System.out.println("Número de teléfono: " + phoneNumber);
        System.out.println("Altura: " + height + " metros");
        System.out.println("Peso: " + weight + " kilogramos");
    }
}