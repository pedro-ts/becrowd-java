import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US); // 0 - Setar o local para US, para aceitar inputs e outputs com .(padrão USA)

        Scanner sc = new Scanner(System.in); //1 - Criar a classe Scanner 
        Double pi = 3.14159;
        Double raio = sc.nextDouble(); // 2 - Ela vai ler o valor e converter com next+Tipo(exceto String)
        Double area;

        area = pi * Math.pow(raio, 2);
        
        System.out.printf("A=%.4f%n", area); //3 -
        // % -> inicia formatação
        // .4 -> casas depois da virgula
        // %n -> fecha formatação, quebra linha
        sc.close();
    } 
}