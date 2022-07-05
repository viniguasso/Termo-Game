import java.util.Scanner;

public class Console {
    Jogo linha;
    Scanner input;
    public static final String normal = "\u001B[0m";
    public static final String verde = "\u001B[32m";
    public static final String amarelo = "\u001B[33m";

    public Console(Jogo linha, Scanner input) {
        this.linha = linha;
        this.input = input;
    }

    public void exibir() {
        exibirChutes();
        exibirLinhas();
    }

    // solicitar palavra ao usuário
    public String solicitarChute() {
        while (true) {
            System.out.println("Digite a palavra:");
            String suspeita = input.nextLine().toUpperCase();
            if (suspeita.length() != linha.getPalavra().length()) {
                System.out.println("Digite uma palavra com 5 letras.");
            } else {
                linha.suspeita(suspeita);
                return suspeita;
            }
        }
    }

    // exibir tentativa com a ajuda
    public void exibirChutes() {

        StringBuilder b = new StringBuilder();
        for (String s : linha.suspeita) {

            for (int i = 0; i < s.length(); i++) {
                String answer = linha.getPalavra();
                char c = s.charAt(i);

                // letra no lugar certo
                if (answer.charAt(i) == c) {
                    b.append(verde + c + normal);
                }
                // lestra existe na palavra
                else if (answer.contains(Character.toString(c))) {
                    b.append(amarelo + c + normal);
                } else {
                    b.append(c);
                }
                // letra não existe na palavra
                b.append("|");
            }

            b.setLength((b.length() - 1));
            System.out.println(b.toString());
            b = new StringBuilder();
        }
    }

    // exibir espaços para tentativas restantes
    public void exibirLinhas() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < linha.getTentativasF(); i++) {
            for (int j = 0; j < linha.getPalavra().length(); j++) {
                b.append("_|");
            }
            b.setLength(b.length() - 1);
            System.out.println(b.toString());
            b = new StringBuilder();
        }
    }
}