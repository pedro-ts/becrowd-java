package Test;
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

        boolean existeHomensVivos = true; // variavel para controlar o loop
        int ultimoHomemVivoContado = 0; // variavel para guardar o ultimo homem vivo contado
        int posicao = 0;
        boolean primeiraVez = true;

        for (int i = 1; i <= homens; i++) { // adicionando homens em suas posições
            grupoDeHomensVivos.add(i);
        }

        sc.close();

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
                    System.out.println(ultimoHomemVivoContado); // imprimir o ultimo homem vivo
                }
            }

            if (existeHomensVivos == false) {
                break; // sair do while
            }

            int passosPercorrida = 0;

            // descobrir posição do próximo homem a ser morto
            if (primeiraVez) {
                System.out.println("[MEIO] PRIMEIRA VEZ, PULANDO PASSOS INICIAIS"); // ❗
                posicao = (posicao + passos) - 1; // ajuste de indice
                primeiraVez = false;
            } else {
                while (passosPercorrida < passos) {
                    if (!estaMorto(grupoDeHomensVivos, posicao)) { // se o homem na posição não estiver morto
                        passosPercorrida++;
                    }

                    posicao++;

                    if (ehUltimaPosicao(posicao, grupoDeHomensVivos.size())) {
                        posicao = 0;
                    }
                }

                // volta uma posição porque o loop anda uma casa a mais
                posicao--;
                if (posicao < 0) {
                    posicao = grupoDeHomensVivos.size() - 1;
                }

                // segurança extra: se caiu em morto, procura o próximo vivo
                while (estaMorto(grupoDeHomensVivos, posicao)) {
                    posicao++;
                    if (ehUltimaPosicao(posicao, grupoDeHomensVivos.size())) {
                        posicao = 0;
                    }
                }
            }

            ultimoHomemMorto = grupoDeHomensVivos.get(posicao); // guardar o homem morto
            grupoDeHomensVivos.set(posicao, 0); // remover o homem morto do grupo
        }
    }

    private static boolean estaMorto(List<Integer> vivos, int posicao) {
        return vivos.get(posicao) == 0;
    }

    private static boolean ehUltimaPosicao(int posicao, int tamanho) {
        if (posicao > (tamanho - 1)) {
            return true;
        } else {
            return false;
        }
    }
}