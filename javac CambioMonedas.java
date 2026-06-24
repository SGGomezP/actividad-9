import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class CambioMonedas {
    public static void resolverMonedas(int[] monedas, int cantidad) {
        int[] dp = new int[cantidad + 1];
        int[] uso = new int[cantidad + 1]; 
        
        Arrays.fill(dp, cantidad + 1);
        
        dp[0] = 0;
        
        for (int i = 1; i <= cantidad; i++) {
            for (int moneda : monedas) {
                if (i >= moneda && dp[i - moneda] + 1 < dp[i]) {
                    dp[i] = dp[i - moneda] + 1;
                    uso[i] = moneda; 
                }
            }
        }
        System.out.println("Monedas: " + Arrays.toString(monedas));
        System.out.println("Cantidad: " + cantidad);

        if (dp[cantidad] > cantidad) {
            System.out.println(".");
        } else {
            System.out.println("Cantidad minima de monedas: " + dp[cantidad]);
            
            int actual = cantidad;
            List<String> combinacion = new ArrayList<>();
            while (actual > 0) {
                combinacion.add(String.valueOf(uso[actual]));
                actual -= uso[actual];
            }
            System.out.println("Combinacion: " + String.join("+", combinacion));
            System.out.println("Tabla DP: " + Arrays.toString(dp));
        }
    }

    public static void main(String[] args) {
        // Ejemplos de prueba
        System.out.println(" Ejemplo 1 ");
        int[] monedas1 = {1, 3, 4};
        resolverMonedas(monedas1, 6);
        
        System.out.println("\n Ejemplo 2 ");
        int[] monedas2 = {1, 2, 5};
        resolverMonedas(monedas2, 11);
    }
}