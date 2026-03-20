import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Declaração de variáveis
        Scanner sc = new Scanner(System.in);
        int[] respostasArray = new int[5]; // array para armazenar as respostas
        int acertos = 0;
        // Input
        int T = sc.nextInt();
        for (int i = 0; i <=4; i++){
            respostasArray[i] = sc.nextInt(); // cada espaço precisa de um novo sc.nextInt()
        }
        // Processamento e Output
        if (1 <= T || T <= 4) { // validação do tipo de chá
            for (int resposta : respostasArray) { // conta acertos
                if (resposta == T) {
                    acertos = acertos + 1;
                }
            }
            System.out.println(acertos);
        } else {
            System.out.println("Tipo de chá inválido");
        }
        sc.close();
    }
}