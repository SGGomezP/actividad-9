import java.util.Arrays;

public class Escaleras {
    public static void resolverEscaleras(int n) {
        if (n == 0) {
            System.out.println("Formas posibles: 1");
            System.out.println("Tabla DP: [1]");
            return;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println("Entrada: N = " + n);
        System.out.println("Formas posibles: " + dp[n]);
        System.out.println("Tabla DP: " + Arrays.toString(dp));
    }

    public static void main(String[] args) {
        // Ejemplos de prueba
        System.out.println(" Ejemplo 1 ");
        resolverEscaleras(5); 
        System.out.println("\n Ejemplo 2 ");
        resolverEscaleras(7);
    }
}