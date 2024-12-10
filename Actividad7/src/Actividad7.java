import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultados = new ArrayList<>();  // Lista para almacenar los resultados

        while (true) {
            try {
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
                    System.out.println("\nSaliendo del programa...");
                    mostrarResultados(resultados);
                    break;
                }

                System.out.println("Seleccione la operación:");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.println("3. Potencia");

                int operacion = scanner.nextInt();

                switch (figura) {
                    case 1: // Círculo
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        if (operacion == 1) {
                            double area = Math.PI * Math.pow(radio, 2);
                            String resultado = "Área del círculo: " + String.format("%.2f", area);
                            System.out.println(resultado);
                            resultados.add("Círculo - Área: " + String.format("%.2f", area));
                        } else if (operacion == 2) {
                            double perimetro = 2 * Math.PI * radio;
                            String resultado = "Perímetro del círculo: " + String.format("%.2f", perimetro);
                            System.out.println(resultado);
                            resultados.add("Círculo - Perímetro: " + String.format("%.2f", perimetro));
                        } else if (operacion == 3) {
                            System.out.print("Ingrese el exponente para la potencia: ");
                            double exponente = scanner.nextDouble();
                            double potencia = Math.pow(radio, exponente);
                            String resultado = "Potencia del radio del círculo (" + radio + "^" + exponente + "): " + String.format("%.2f", potencia);
                            System.out.println(resultado);
                            resultados.add("Círculo - Potencia: " + String.format("%.2f", potencia));
                        }
                        break;

                    case 2: // Cuadrado
                        System.out.print("Ingrese el lado del cuadrado: ");
                        double ladoCuadrado = scanner.nextDouble();
                        if (operacion == 1) {
                            double area = ladoCuadrado * ladoCuadrado;
                            String resultado = "Área del cuadrado: " + String.format("%.2f", area);
                            System.out.println(resultado);
                            resultados.add("Cuadrado - Área: " + String.format("%.2f", area));
                        } else if (operacion == 2) {
                            double perimetro = 4 * ladoCuadrado;
                            String resultado = "Perímetro del cuadrado: " + String.format("%.2f", perimetro);
                            System.out.println(resultado);
                            resultados.add("Cuadrado - Perímetro: " + String.format("%.2f", perimetro));
                        } else if (operacion == 3) {
                            System.out.print("Ingrese el exponente para la potencia: ");
                            double exponente = scanner.nextDouble();
                            double potencia = Math.pow(ladoCuadrado, exponente);
                            String resultado = "Potencia del lado del cuadrado (" + ladoCuadrado + "^" + exponente + "): " + String.format("%.2f", potencia);
                            System.out.println(resultado);
                            resultados.add("Cuadrado - Potencia: " + String.format("%.2f", potencia));
                        }
                        break;

                    case 3: // Triángulo
                        System.out.print("Ingrese la base del triángulo: ");
                        double baseTriangulo = scanner.nextDouble();
                        System.out.print("Ingrese la altura del triángulo: ");
                        double alturaTriangulo = scanner.nextDouble();
                        if (operacion == 1) {
                            double area = (baseTriangulo * alturaTriangulo) / 2;
                            String resultado = "Área del triángulo: " + String.format("%.2f", area);
                            System.out.println(resultado);
                            resultados.add("Triángulo - Área: " + String.format("%.2f", area));
                        } else if (operacion == 2) {
                            System.out.print("Ingrese los otros dos lados del triángulo: ");
                            double lado1 = scanner.nextDouble();
                            double lado2 = scanner.nextDouble();
                            double perimetro = baseTriangulo + lado1 + lado2;
                            String resultado = "Perímetro del triángulo: " + String.format("%.2f", perimetro);
                            System.out.println(resultado);
                            resultados.add("Triángulo - Perímetro: " + String.format("%.2f", perimetro));
                        } else if (operacion == 3) {
                            System.out.print("Ingrese el exponente para la potencia: ");
                            double exponente = scanner.nextDouble();
                            double potenciaBase = Math.pow(baseTriangulo, exponente);
                            double potenciaAltura = Math.pow(alturaTriangulo, exponente);
                            String resultado = "Potencia de la base (" + baseTriangulo + "^" + exponente + "): " + String.format("%.2f", potenciaBase) +
                                    " | Potencia de la altura (" + alturaTriangulo + "^" + exponente + "): " + String.format("%.2f", potenciaAltura);
                            System.out.println(resultado);
                            resultados.add("Triángulo - Potencia: " + String.format("%.2f", potenciaBase) + ", " + String.format("%.2f", potenciaAltura));
                        }
                        break;

                    case 4: // Rectángulo
                        System.out.print("Ingrese la base del rectángulo: ");
                        double baseRectangulo = scanner.nextDouble();
                        System.out.print("Ingrese la altura del rectángulo: ");
                        double alturaRectangulo = scanner.nextDouble();
                        if (operacion == 1) {
                            double area = baseRectangulo * alturaRectangulo;
                            String resultado = "Área del rectángulo: " + String.format("%.2f", area);
                            System.out.println(resultado);
                            resultados.add("Rectángulo - Área: " + String.format("%.2f", area));
                        } else if (operacion == 2) {
                            double perimetro = 2 * (baseRectangulo + alturaRectangulo);
                            String resultado = "Perímetro del rectángulo: " + String.format("%.2f", perimetro);
                            System.out.println(resultado);
                            resultados.add("Rectángulo - Perímetro: " + String.format("%.2f", perimetro));
                        } else if (operacion == 3) {
                            System.out.print("Ingrese el exponente para la potencia: ");
                            double exponente = scanner.nextDouble();
                            double potenciaBase = Math.pow(baseRectangulo, exponente);
                            double potenciaAltura = Math.pow(alturaRectangulo, exponente);
                            String resultado = "Potencia de la base (" + baseRectangulo + "^" + exponente + "): " + String.format("%.2f", potenciaBase) +
                                    " | Potencia de la altura (" + alturaRectangulo + "^" + exponente + "): " + String.format("%.2f", potenciaAltura);
                            System.out.println(resultado);
                            resultados.add("Rectángulo - Potencia: " + String.format("%.2f", potenciaBase) + ", " + String.format("%.2f", potenciaAltura));
                        }
                        break;

                    case 5: // Pentágono
                        System.out.print("Ingrese el lado del pentágono: ");
                        double ladoPentagono = scanner.nextDouble();
                        if (operacion == 1) {
                            System.out.print("Ingrese la apotema del pentágono: ");
                            double apotema = scanner.nextDouble();
                            double area = (5 * ladoPentagono * apotema) / 2;
                            String resultado = "Área del pentágono: " + String.format("%.2f", area);
                            System.out.println(resultado);
                            resultados.add("Pentágono - Área: " + String.format("%.2f", area));
                        } else if (operacion == 2) {
                            double perimetro = 5 * ladoPentagono;
                            String resultado = "Perímetro del pentágono: " + String.format("%.2f", perimetro);
                            System.out.println(resultado);
                            resultados.add("Pentágono - Perímetro: " + String.format("%.2f", perimetro));
                        } else if (operacion == 3) {
                            System.out.print("Ingrese el exponente para la potencia: ");
                            double exponente = scanner.nextDouble();
                            double potencia = Math.pow(ladoPentagono, exponente);
                            String resultado = "Potencia del lado del pentágono (" + ladoPentagono + "^" + exponente + "): " + String.format("%.2f", potencia);
                            System.out.println(resultado);
                            resultados.add("Pentágono - Potencia: " + String.format("%.2f", potencia));
                        }
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Intente nuevamente.");
                scanner.nextLine();  // Limpiar el buffer
            }
        }

        scanner.close();
    }

    // Metodo que use para mostrar todos los resultados almacenados
    public static void mostrarResultados(ArrayList<String> resultados) {
        System.out.println("\n--- Resumen de Resultados ---");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
        System.out.println("¡Gracias por utilizar mi Calculadora Geométrica!");
    }
}
