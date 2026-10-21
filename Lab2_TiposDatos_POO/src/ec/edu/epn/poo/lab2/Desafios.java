/**
 * 
 */
package ec.edu.epn.poo.lab2;
import java.math.BigDecimal;
/**
 * 
 */
public class Desafios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Desafío 1: dinero con double frente a BigDecimal
        double total = 0.10 + 0.10 + 0.10;
        System.out.println("double     : " + total);
        BigDecimal precio = new BigDecimal("0.10");
        BigDecimal totalBD = precio.add(precio).add(precio);
        System.out.println("BigDecimal : " + totalBD);
 
        // Desafío 2: caché de Integer
        Integer p = 200, q = 200;
        System.out.println("200 == 200 : " + (p == q));

		// TODO Auto-generated method stub

	}

}
