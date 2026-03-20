import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); // criar scanner

        int homens = sc.nextInt(); // pegar numero de homens
        int passos = sc.nextInt(); // pegar numero de passos

        List<Integer> grupoDeHomensVivos = new ArrayList<>(); // array que será percorrida

        int ultimoHomemMorto = 0; // variavel para guardar o ultimo homem morto
        boolean existeHomensVivos = true; // variavel para controlar o loop
        int ultimoHomemVivoContado = 0; // variavel para guardar o ultimo homem vivo contado
        int posicao = 0;
        boolean primeiraVez = true;

        for (int i = 1; i <= homens; i++) { // adicionando homens em suas posições
            grupoDeHomensVivos.add(i);
        }

        System.out.println("[INICIO] GRUPO =" + grupoDeHomensVivos); // ❗
        System.out.println("[INICIO] HOMENS VIVOS =" + homens); // ❗
        System.out.println("[INICIO] PASSOS =" + passos); // ❗
        System.out.println("======================================="); // ❗

        while (existeHomensVivos) {
            int homensMortos = 0;
            for (Integer homem : grupoDeHomensVivos) {
                if (homem == 0) { // contar homens mortos
                    homensMortos++;
                } else {
                    ultimoHomemVivoContado = homem;
                }
                if (homensMortos == (grupoDeHomensVivos.size() - 1)) { // se todos morreram e só restou 1
                    existeHomensVivos = false;
                    System.out.println("[FIM] ÚLTIMO HOMEM VIVO = " + ultimoHomemVivoContado); // ❗
                }
            }
            if (existeHomensVivos == false) {
                break;// sair do while
            }

            int passosPercorrida = 0;

            // descobrir posição do próximo homem a ser morto
            if (primeiraVez) {
                System.out.println("[MEIO] PRIMEIRA VEZ, PULANDO PASSOS INICIAIS"); // ❗
                System.out.println("[MEIO] INFO = Soma posicao = " + posicao); // ❗
                System.out.println("[MEIO] INFO = Soma passos = " + passos); // ❗
                posicao = (posicao + passos) - 1; // ajuste de indice
                System.out.println("[MEIO] INFO = resultado = " + posicao); // ❗
                primeiraVez = false;
            } else {
                // posicao = posicao + 1;
                // passosPercorrida = passosPercorrida + 1;
                while (passosPercorrida < passos) {
                    passosPercorrida++;
                    posicao++;
                    System.out.println("[MEIO] INFO = DepoisPrimeiraVez posicao = " + posicao); // ❗
                    System.out.println("[MEIO] INFO = Depois PrimeiraVez passosPercorrida = " + passosPercorrida); // ❗

                    if (grupoDeHomensVivos.get(posicao) == 0) {
                        System.out.println("[MEIO] INFO = HOMEM MORTO ENCONTRADO, PULANDO POSIÇÃO"); // ❗
                        posicao++;
                        passosPercorrida = passosPercorrida - 1;
                    }
                    System.out.println("[MEIO] INFO = Depois do if posicao = " + posicao); // ❗
                    System.out.println("[MEIO] INFO = Depois do if tamanho = " + (grupoDeHomensVivos.size() - 1)); // ❗
                    if (posicao > (grupoDeHomensVivos.size() - 1)) {
                        System.out.println("[MEIO] INFO = FIM DO GRUPO, VOLTANDO PARA O INICIO"); // ❗
                        posicao = 0; // se parou na ultima possição e não é um homem morto, volta para o inicio
                        passosPercorrida = passosPercorrida - 1;
                    }
                    // se não parou em um homem morto, nem na ultima posição, continua normalmente
                    // se não parou em um homem morto, nem na ultima posição, continua normalmente
                }
            }

            ultimoHomemMorto = grupoDeHomensVivos.get(posicao); // guardar o homem morto
            System.out.println("[MEIO] INFO = PRÓXIMO HOMEM ELIMINADO"); // ❗
            System.out.println("[MEIO] HOMEM = " + ultimoHomemMorto); // ❗
            grupoDeHomensVivos.set(posicao, 0); // remover o homem morto do grupo
            System.out.println("[MEIO] GRUPO RESTANTE = " + grupoDeHomensVivos); // ❗
        }
        sc.close();
    }
}
