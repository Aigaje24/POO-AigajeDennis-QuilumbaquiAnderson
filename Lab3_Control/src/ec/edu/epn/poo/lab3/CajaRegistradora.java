
package ec.edu.epn.poo.lab3;
 
import java.util.Locale;
import java.util.Scanner;
 
public class CajaRegistradora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        final double IVA = 0.15;
 
        // Catálogo en arreglos paralelos (solución provisional: ver Semana 4)
        String[] nombres = {"Cuaderno", "Esfero", "Borrador", "Regla", "Carpeta"};
        double[] precios = {2.50, 0.75, 0.40, 1.20, 3.10};
        int[] stock = {10, 50, 30, 0, 8};
        int[] carrito = new int[nombres.length];   // unidades compradas
 
        int opcion;
        do {
            System.out.println();
            System.out.println("=== CAJA REGISTRADORA ===");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar producto");
            System.out.println("3. Ver recibo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            // TODO 1: validar que la opción sea un entero (Parte IV)
            while (!sc.hasNextInt()) {
                System.out.print("No es un entero. Opción: ");
                sc.next();
            }
            opcion = sc.nextInt();
 
            switch (opcion) {
                case 1 -> {
                    // TODO 2: mostrar código, nombre, precio y stock (Parte V)
                    System.out.printf("%-4s %-10s %7s %6s%n", "Cód", "Producto", "Precio", "Stock");
                    for (int i = 0; i < nombres.length; i++) {
                        System.out.printf(Locale.US, "%-4d %-10s %7.2f %6d%n",
                                i + 1, nombres[i], precios[i], stock[i]);
                    }
                }
                case 2 -> {
                    // TODO 3: pedir el código (1 a nombres.length) y validarlo:
                    //         entero y dentro del rango (Parte IV)
                    int codigo;
                    do {
                        System.out.print("Código (1 a " + nombres.length + "): ");
                        while (!sc.hasNextInt()) {
                            System.out.print("No es un entero. Código (1 a " + nombres.length + "): ");
                            sc.next();
                        }
                        codigo = sc.nextInt();
                        if (codigo < 1 || codigo > nombres.length) {
                            System.out.println("Fuera de rango.");
                        }
                    } while (codigo < 1 || codigo > nombres.length);
 
                    // TODO 4: pedir la cantidad (> 0). Si hay stock suficiente,
                    //         sumarla a carrito[] y restarla de stock[];
                    //         si no, mostrar "Stock insuficiente (disponible: N)"
                    int cantidad;
                    do {
                        System.out.print("Cantidad: ");
                        while (!sc.hasNextInt()) {
                            System.out.print("No es un entero. Cantidad: ");
                            sc.next();
                        }
                        cantidad = sc.nextInt();
                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor a 0.");
                        }
                    } while (cantidad <= 0);
 
                    int indice = codigo - 1;
                    if (stock[indice] >= cantidad) {
                        carrito[indice] += cantidad;
                        stock[indice] -= cantidad;
                        System.out.println("Agregado: " + cantidad + " x " + nombres[indice]);
                    } else {
                        System.out.println("Stock insuficiente (disponible: " + stock[indice] + ")");
                    }
                }
                case 3 -> {
                    // TODO 5: recorrer el carrito, mostrar las filas con
                    //         cantidad > 0 y acumular el subtotal (Parte V)[cite: 13]
                    System.out.println("----------- RECIBO -----------");
                    double subtotal = 0;
                    for (int i = 0; i < carrito.length; i++) {
                        if (carrito[i] > 0) {
                            double totalFila = carrito[i] * precios[i];
                            subtotal += totalFila;
                            System.out.printf(Locale.US, "%-10s %3d x %5.2f %7.2f%n",
                                    nombres[i], carrito[i], precios[i], totalFila);
                        }
                    }
                    System.out.println("------------------------------");
 
                    // TODO 6: descuento por monto (Parte III), IVA 15 % sobre
                    //         (subtotal - descuento) y resumen con printf[cite: 13]
                    double porcentajeDesc;
                    if (subtotal >= 100) {
                        porcentajeDesc = 0.10;
                    } else if (subtotal >= 50) {
                        porcentajeDesc = 0.05;
                    } else {
                        porcentajeDesc = 0.0;
                    }
                    double descuento = subtotal * porcentajeDesc;
                    double baseImponible = subtotal - descuento;
                    double valorIva = baseImponible * IVA;
                    double totalPagar = baseImponible + valorIva;
 
                    System.out.printf(Locale.US, "Subtotal        %14.2f%n", subtotal);
                    System.out.printf(Locale.US, "Descuento       %14.2f%n", descuento);
                    System.out.printf(Locale.US, "IVA 15 %%        %14.2f%n", valorIva);
                    System.out.printf(Locale.US, "TOTAL           %14.2f%n", totalPagar);
                }
                case 0 -> System.out.println("Gracias por su compra.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}