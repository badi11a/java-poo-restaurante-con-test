package cl.td.restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class AppRestaurante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        int opcion;

        do {
            System.out.println("\nADMINISTRACIÓN DEL MENÚ");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1: {
                    System.out.println("1. Plato");
                    System.out.println("2. Bebida");
                    System.out.print("Seleccione el tipo de producto: ");
                    int tipo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese el ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());

                    System.out.print("¿Está disponible? true/false: ");
                    boolean disponible = Boolean.parseBoolean(scanner.nextLine());

                    ProductoMenu producto;

                    if (tipo == 1) {
                        System.out.print("Ingrese la categoría: ");
                        String categoria = scanner.nextLine();
                        producto = new Plato(id, nombre, precio, disponible, categoria);
                    } else if (tipo == 2) {
                        System.out.print("Ingrese la capacidad en mililitros: ");
                        int capacidadEnMililitros = Integer.parseInt(scanner.nextLine());
                        producto = new Bebida(id, nombre, precio, disponible, capacidadEnMililitros);
                    } else {
                        System.out.println("Tipo de producto no válido.");
                        break;
                    }

                    if (restaurante.registrarProducto(producto)) {
                        System.out.println("Producto registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar el producto.");
                    }

                    break;
                }

                case 2: {
                    ArrayList<ProductoMenu> productos = restaurante.listarProductos();

                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (ProductoMenu producto : productos) {
                            System.out.println(producto);
                        }
                    }

                    break;
                }

                case 3: {
                    System.out.print("Ingrese el ID del producto: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    ProductoMenu producto = restaurante.buscarProductoPorId(id);

                    if (producto == null) {
                        System.out.println("Producto no encontrado.");
                    } else {
                        System.out.println(producto);
                    }

                    break;
                }

                case 4: {
                    System.out.print("Ingrese el ID del producto: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    ProductoMenu producto = restaurante.buscarProductoPorId(id);

                    if (producto == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    System.out.println("Producto actual:");
                    System.out.println(producto);

                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();

                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                    System.out.print("¿Está disponible? true/false: ");
                    boolean nuevaDisponibilidad = Boolean.parseBoolean(scanner.nextLine());

                    restaurante.modificarProducto(producto, nuevoNombre, nuevoPrecio, nuevaDisponibilidad);

                    System.out.println("Producto modificado:");
                    System.out.println(producto);

                    break;
                }

                case 5: {
                    System.out.print("Ingrese el ID del producto: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    if (restaurante.eliminarProducto(id)) {
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;
                }

                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}