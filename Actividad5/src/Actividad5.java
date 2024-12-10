import java.util.Scanner;

public class Actividad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Calculadora Geométrica ---");
            System.out.println("Seleccione la figura geométrica:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("0. Salir");

            int figura = scanner.nextInt();

            if (figura == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.println("Seleccione la operación:");
            System.out.println("1. Área");
            System.out.println("2. Perímetro");

            int operacion = scanner.nextInt();

            switch (figura) {
                case 1: // Círculo
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    if (operacion == 1) {
                        double area = Math.PI * Math.pow(radio, 2);
                        System.out.println("El área del círculo es: " + String.format("%.2f", area));
                    } else if (operacion == 2) {
                        double perimetro = 2 * Math.PI * radio;
                        System.out.println("El perímetro del círculo es: " + String.format("%.2f", perimetro));
                    }
                    break;

                case 2: // Cuadrado
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double ladoCuadrado = scanner.nextDouble();
                    if (operacion == 1) {
                        double area = ladoCuadrado * ladoCuadrado;
                        System.out.println("El área del cuadrado es: " + String.format("%.2f", area));
                    } else if (operacion == 2) {
                        double perimetro = 4 * ladoCuadrado;
                        System.out.println("El perímetro del cuadrado es: " + String.format("%.2f", perimetro));
                    }
                    break;

                case 3: // Triángulo
                    System.out.print("Ingrese la base del triángulo: ");
                    double baseTriangulo = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double alturaTriangulo = scanner.nextDouble();
                    if (operacion == 1) {
                        double area = (baseTriangulo * alturaTriangulo) / 2;
                        System.out.println("El área del triángulo es: " + String.format("%.2f", area));
                    } else if (operacion == 2) {
                        System.out.print("Ingrese los otros dos lados del triángulo: ");
                        double lado1 = scanner.nextDouble();
                        double lado2 = scanner.nextDouble();
                        double perimetro = baseTriangulo + lado1 + lado2;
                        System.out.println("El perímetro del triángulo es: " + String.format("%.2f", perimetro));
                    }
                    break;

                case 4: // Rectángulo
                    System.out.print("Ingrese la base del rectángulo: ");
                    double baseRectangulo = scanner.nextDouble();
                    System.out.print("Ingrese la altura del rectángulo: ");
                    double alturaRectangulo = scanner.nextDouble();
                    if (operacion == 1) {
                        double area = baseRectangulo * alturaRectangulo;
                        System.out.println("El área del rectángulo es: " + String.format("%.2f", area));
                    } else if (operacion == 2) {
                        double perimetro = 2 * (baseRectangulo + alturaRectangulo);
                        System.out.println("El perímetro del rectángulo es: " + String.format("%.2f", perimetro));
                    }
                    break;

                case 5: // Pentágono
                    System.out.print("Ingrese el lado del pentágono: ");
                    double ladoPentagono = scanner.nextDouble();
                    if (operacion == 1) {
                        System.out.print("Ingrese la apotema del pentágono: ");
                        double apotema = scanner.nextDouble();
                        double area = (5 * ladoPentagono * apotema) / 2;
                        System.out.println("El área del pentágono es: " + String.format("%.2f", area));
                    } else if (operacion == 2) {
                        double perimetro = 5 * ladoPentagono;
                        System.out.println("El perímetro del pentágono es: " + String.format("%.2f", perimetro));
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}
