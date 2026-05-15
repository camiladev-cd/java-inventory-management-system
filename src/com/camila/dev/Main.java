package com.camila.dev;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int option = 0;

        do {
            System.out.println("\n--- GESTOR DE PRODUCTOS ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Lista productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, introduzca un número válido.");
                scanner.nextLine();
                continue;
            }

            if (option == 1) {
                System.out.print("Ingrese nombre del producto: ");
                String name = scanner.nextLine();

                System.out.print("Ingrese precio del producto: ");
                double price = -1;
                while (price < 0) {
                    if (scanner.hasNextDouble()) {
                        price = scanner.nextDouble();
                        scanner.nextLine();

                        if (price < 0) {
                            System.out.println(" Error: El precio no puede ser negativo. Intente de nuevo.");
                        }
                    } else {
                        System.out.println(" Error: Ingrese un número válido.");
                        scanner.next();
                    }
                }

                System.out.print("Ingrese stock del producto: ");
                int stock = -1;
                while (stock < 0) {
                    if (scanner.hasNextInt()) {
                        stock = scanner.nextInt();
                        scanner.nextLine();
                        if (stock < 0) {
                            System.out.println(" Error: El stock no puede ser negativo. Intente de nuevo.");
                        }
                    } else {
                        System.out.println("Error: Ingrese un número entero válido.");
                        scanner.next();
                    }
                }

                Category selectCategory = null;

                while (selectCategory == null) {
                    System.out.println("Seleccione Categoria (1.ELECTRONICS 2.FOOD, 3.CLOTHING, 4.BOOKS, 5.HOME): ");
                    if (scanner.hasNextInt()) {
                        int categoryOption = scanner.nextInt();
                        scanner.nextLine();

                        if (categoryOption == 1) selectCategory = Category.ELECTRONICS;
                        else if (categoryOption == 2) selectCategory = Category.FOOD;
                        else if (categoryOption == 3) selectCategory = Category.CLOTHING;
                        else if (categoryOption == 4) selectCategory = Category.BOOKS;
                        else if (categoryOption == 5) selectCategory = Category.HOME;
                        else {
                            System.out.println("Error: '" + categoryOption + "' no es una opción válida. Intente de nuevo.");
                        }
                    } else {
                        System.out.println("Ingrese un número válido.");
                        scanner.nextLine();
                    }
                }

                productManager.addProduct(new Product(name, price, stock, selectCategory));
                System.out.println("Producto creado correctamente con nombre : " + name + " " + "un precio: " + price + " " + "un stock de " + stock + " " + "y con categoria " + selectCategory);

            } else if (option == 2) {
                ArrayList<Product> products = productManager.getProducts();
                if (products.isEmpty()) {
                    System.out.println("La lista está vacía.");
                } else {

                    System.out.println("\n--- LISTA DE PRODUCTOS ---");

                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
            } else if (option == 3) {
                System.out.print("Ingrese el ID del producto a buscar: ");
                int productIdToFind = scanner.nextInt();

                Product foundProduct = productManager.findProductById(productIdToFind);

                if (foundProduct != null) {
                    System.out.println(" Producto encontrado:");
                    System.out.println(foundProduct.toString());
                } else {
                    System.out.println("Error: No se encontró ningún producto con el ID: " + productIdToFind);
                }
            } else if (option == 4) {
                System.out.print("Ingrese el ID del producto a eliminar: ");
                int productIdToDelete = scanner.nextInt();

                if (productManager.deleteProduct(productIdToDelete)) {
                    System.out.println("Producto eliminado correctamente.");
                } else {
                    System.out.println("Error: No se encontró ningun producto con ese ID");
                }
            }

        }  while (option != 5);

            System.out.println("Saliendo del programa... ¡Hasta luego!");
            scanner.close();
        }
}