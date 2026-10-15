package ec.edu.epn.poo.lab2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 */
public class Recibo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final double IVA = 0.15; int Codigo=127;                // IVA de Ecuador
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
 
        // --- LECTURA DEL PRODUCTO 1 ---
        System.out.print("Producto 1: ");
        String producto1 = sc.nextLine();
        System.out.print("Cantidad 1: ");
        int cantidad1 = sc.nextInt();
        System.out.print("Precio unitario 1: ");
        double precio1 = sc.nextDouble();
        
        // Consumir el Enter pendiente que deja sc.nextDouble()
        sc.nextLine(); 
 
        // --- LECTURA DEL PRODUCTO 2 ---
        System.out.print("Producto 2: ");
        String producto2 = sc.nextLine();
        System.out.print("Cantidad 2: ");
        int cantidad2 = sc.nextInt();
        System.out.print("Precio unitario 2: ");
        double precio2 = sc.nextDouble();
 
        // --- CÁLCULOS ---
        double subtotal1 = cantidad1 * precio1;
        double subtotal2 = cantidad2 * precio2;
        double subtotalGeneral = subtotal1 + subtotal2;
        
        double iva = subtotalGeneral * IVA;
        double total = subtotalGeneral + iva;
 
        // --- IMPRESIÓN DEL RECIBO ---
        System.out.printf(Locale.US, "Codigo de factura: %08d%n", Codigo);
        System.out.println();
        
        System.out.println("=========== RECIBO ===========");
        System.out.printf(Locale.US, "%-14s %4s %10s%n",
                "Producto", "Cant", "Subtotal");
        
        // Fila producto 1
        System.out.printf(Locale.US, "%-14.14s %4d %10.2f%n",
                producto1, cantidad1, subtotal1);
        
        // Fila producto 2
        System.out.printf(Locale.US, "%-14.14s %4d %.2f%n",
                producto2, cantidad2, subtotal2);
                
        System.out.println("------------------------------");
        System.out.printf(Locale.US, "%-19s %10.2f%n", "SUBTOTAL", subtotalGeneral);
        System.out.printf(Locale.US, "%-19s %10.2f%n", "IVA 15 %", iva);
        System.out.printf(Locale.US, "%-19s %10.2f%n", "TOTAL", total);
 
        NumberFormat moneda = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Total a pagar: " + moneda.format(total));
        
        sc.close();
    }
}
