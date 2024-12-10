import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private String nombre;
    private int inventarioInicial;
    private int unidadesDisponibles;

    public Producto(String nombre, int inventarioInicial) {
        this.nombre = nombre;
        this.inventarioInicial = inventarioInicial;
        this.unidadesDisponibles = inventarioInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getInventarioInicial() {
        return inventarioInicial;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void vender(int cantidad) {
        if (cantidad <= unidadesDisponibles) {
            unidadesDisponibles -= cantidad;
            System.out.println("Venta exitosa. " + cantidad + " unidades vendidas de " + nombre + ".");
        } else {
            System.out.println("Stock insuficiente para la venta.");
        }
    }

    public boolean haySuficienteStock(int cantidad) {
        return cantidad <= unidadesDisponibles;
    }

    public void duplicarInventario() {
        if (unidadesDisponibles == 0) {
            unidadesDisponibles = inventarioInicial * 2;
            System.out.println("Inventario duplicado para el producto: " + nombre);
        }
    }

    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Inventario inicial: " + inventarioInicial);
        System.out.println("Unidades disponibles: " + unidadesDisponibles);
    }
}

public class Parcial1 {
    private static ArrayList<Producto> inventario = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenú de gestión de inventario:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Duplicar inventario");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    venderProducto();
                    break;
                case 3:
                    duplicarInventario();
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad inicial del producto: ");
        int cantidad = scanner.nextInt();
        Producto producto = new Producto(nombre, cantidad);
        inventario.add(producto);
        System.out.println("Producto agregado con éxito.");
    }

    private static void venderProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();

        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                if (producto.haySuficienteStock(cantidad)) {
                    producto.vender(cantidad);
                } else {
                    System.out.println("No hay suficiente stock para la venta.");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private static void duplicarInventario() {
        System.out.print("Ingrese el nombre del producto a duplicar inventario: ");
        String nombre = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.duplicarInventario();
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private static void mostrarInventario() {
        System.out.println("\nInventario actual:");
        for (Producto producto : inventario) {
            producto.mostrarInformacion();
            System.out.println();
        }
    }
}
