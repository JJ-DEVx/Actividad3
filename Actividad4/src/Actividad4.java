import java.util.Scanner;

public class Actividad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos generales del visitante
        System.out.print("Ingrese el nombre completo del visitante: ");
        String name = scanner.nextLine();

        System.out.print("¿Es el visitante un residente? (true/false): ");
        boolean isResident = scanner.nextBoolean();

        System.out.print("Ingrese la edad del visitante: ");
        byte age = scanner.nextByte();

        System.out.print("Ingrese el número de teléfono del visitante: ");
        long phoneNumber = scanner.nextLong();

        System.out.print("Ingrese la altura del visitante (en metros): ");
        float height = scanner.nextFloat();

        System.out.print("Ingrese el peso del visitante (en kilogramos): ");
        double weight = scanner.nextDouble();

        int totalVisits = 0;
        int totalDuration = 0;  // Total de minutos acumulados

        for (int i = 1; i <= 7; i++) {  // Registro de visitas durante 7 días
            System.out.println("\n--- Día " + i + " ---");
            System.out.print("Ingrese el número de piso que visita: ");
            short floor = scanner.nextShort();

            System.out.print("Ingrese el número de departamento que visita: ");
            int apartment = scanner.nextInt();

            System.out.print("Ingrese la duración de la visita en minutos: ");
            int duration = scanner.nextInt();

            totalVisits++;  // Incrementa el conteo de visitas
            totalDuration += duration;  // Suma la duración de cada visita
        }

        // Calcular promedio de estadía
        double averageDuration = totalVisits > 0 ? (double) totalDuration / totalVisits : 0;

        // Convertir el promedio a horas y minutos
        int averageHours = (int) averageDuration / 60;
        int averageMinutes = (int) averageDuration % 60;

        // Mostrar resultados finales
        System.out.println("\n--- Resumen de la semana ---");
        System.out.println("Nombre del visitante: " + name);
        System.out.println("¿Es residente? " + isResident);
        System.out.println("Edad: " + age + " años (" + (age >= 18 ? "Mayor de edad" : "Menor de edad") + ")");
        System.out.println("Número de teléfono: " + phoneNumber);
        System.out.println("Altura: " + height + " metros");
        System.out.println("Peso: " + weight + " kilogramos");
        System.out.println("Total de visitas realizadas: " + totalVisits);
        System.out.println("Tiempo promedio de estadía por visita: " + averageHours + " horas y " + averageMinutes + " minutos");
    }
}
