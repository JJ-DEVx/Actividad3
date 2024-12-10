import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Interfaz que define las operaciones
interface Operaciones {
    double calcularArea();
    double calcularPerimetro();
    double calcularPotencia(double exponente);
}

// Clase abstracta Figura
abstract class Figura implements Operaciones {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase Círculo
class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double calcularPotencia(double exponente) {
        return Math.pow(radio, exponente);
    }
}

// Clase Cuadrado
class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        super("Cuadrado");
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public double calcularPotencia(double exponente) {
        return Math.pow(lado, exponente);
    }
}

// Clase Triángulo
class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        super("Triángulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        // Este ejemplo asume un triángulo equilátero para simplificar
        return 3 * base;
    }

    @Override
    public double calcularPotencia(double exponente) {
        return Math.pow(base, exponente);
    }
}

// Clase Rectángulo
class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public double calcularPotencia(double exponente) {
        return Math.pow(base, exponente);
    }
}

// Clase Pentágono
class Pentagono extends Figura {
    private double lado;

    public Pentagono(double lado) {
        super("Pentágono");
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        double apotema = lado / (2 * Math.tan(Math.PI / 5));  // Aproximación
        return (5 * lado * apotema) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 5 * lado;
    }

    @Override
    public double calcularPotencia(double exponente) {
        return Math.pow(lado, exponente);
    }
}

// Clase principal
public class Actividad8 {
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

                int opcionFigura = scanner.nextInt();

                if (opcionFigura == 0) {
                    System.out.println("\nSaliendo del programa...");
                    mostrarResultados(resultados);
                    break;
                }

                Figura figura = null;

                switch (opcionFigura) {
                    case 1 -> {
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        figura = new Circulo(radio);
                    }
                    case 2 -> {
                        System.out.print("Ingrese el lado del cuadrado: ");
                        double lado = scanner.nextDouble();
                        figura = new Cuadrado(lado);
                    }
                    case 3 -> {
                        System.out.print("Ingrese la base del triángulo: ");
                        double base = scanner.nextDouble();
                        System.out.print("Ingrese la altura del triángulo: ");
                        double altura = scanner.nextDouble();
                        figura = new Triangulo(base, altura);
                    }
                    case 4 -> {
                        System.out.print("Ingrese la base del rectángulo: ");
                        double base = scanner.nextDouble();
                        System.out.print("Ingrese la altura del rectángulo: ");
                        double altura = scanner.nextDouble();
                        figura = new Rectangulo(base, altura);
                    }
                    case 5 -> {
                        System.out.print("Ingrese el lado del pentágono: ");
                        double lado = scanner.nextDouble();
                        figura = new Pentagono(lado);
                    }
                    default -> System.out.println("Opción no válida.");
                }

                if (figura != null) {
                    System.out.println("Seleccione la operación:");
                    System.out.println("1. Área");
                    System.out.println("2. Perímetro");
                    System.out.println("3. Potencia");

                    int operacion = scanner.nextInt();

                    switch (operacion) {
                        case 1 -> resultados.add(figura.getNombre() + " - Área: " + String.format("%.2f", figura.calcularArea()));
                        case 2 -> resultados.add(figura.getNombre() + " - Perímetro: " + String.format("%.2f", figura.calcularPerimetro()));
                        case 3 -> {
                            System.out.print("Ingrese el exponente para la potencia: ");
                            double exponente = scanner.nextDouble();
                            resultados.add(figura.getNombre() + " - Potencia: " + String.format("%.2f", figura.calcularPotencia(exponente)));
                        }
                        default -> System.out.println("Opción no válida.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Intente nuevamente.");
                scanner.nextLine();  // Limpiar el buffer
            }
        }

        scanner.close();
    }

    // Método para mostrar todos los resultados almacenados
    public static void mostrarResultados(ArrayList<String> resultados) {
        System.out.println("\n--- Resumen de Resultados ---");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
        System.out.println("¡Gracias por utilizar mi Calculadora Geométrica!");
    }
}
