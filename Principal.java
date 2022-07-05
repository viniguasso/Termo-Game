import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        String[] palavras = { "peido", "tosse", "cravo", "nobre", "sagaz", "fazer", "poder" };
        String resposta = palavras[new Random().nextInt(palavras.length)].toUpperCase();

        Jogo linha = new Jogo(palavras);
        Scanner input = new Scanner(System.in);
        Console Console = new Console(linha, input);

        while (!linha.fimDeJogo()) {
            Console.exibir();
            Console.solicitarChute();
        }

        Console.exibir();

        if (linha.acerto()) {
            System.out.println("Você acertou a palavra");
        } else {
            System.out.println("Você não acertou a palavra");
        }
        System.out.println("A palavra é: " + linha.getPalavra());
        input.close();
    }
}