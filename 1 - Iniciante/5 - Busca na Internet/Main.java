import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //terceiro
        int s; //segundo
        int p; //primeiro

        s = t * 2; //segundo é o dobro do terceiro, metade do primeiro
        p = s * 2; //primeiro é o dobro do segundo
        System.out.println(p);
        sc.close();
    }

}