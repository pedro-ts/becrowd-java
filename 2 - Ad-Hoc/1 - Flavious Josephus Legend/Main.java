import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();

        for (int i = 1; i <= casos; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int sobrevivente = josephus(n, k);

            System.out.println("Case " + i + ": " + sobrevivente);
        }

        sc.close();
    }

    public static int josephus(int n, int k) {
        int resultado = 0; // começa em 0 porque a fórmula trabalha com índice base 0

        for (int i = 1; i <= n; i++) {
            resultado = (resultado + k) % i;
        }

        return resultado + 1; // converte para base 1
    }
}