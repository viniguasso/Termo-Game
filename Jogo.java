import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {

    private String palavra;
    private int tamanhoPalavra;
    private int tentativasF;
    private int tentativas;

    List<String> suspeita;

    public Jogo(String[] arr) {
        palavra = arr[new Random().nextInt(arr.length)].toUpperCase();
        tamanhoPalavra = palavra.length();
        tentativas = 6;
        tentativasF = tentativas;
        suspeita = new ArrayList<String>();
    }

    public int getTamanhoPalavra() {
        return tamanhoPalavra;
    }

    public void setTamanhoPalavra(int tamanhoPalavra) {
        this.tamanhoPalavra = tamanhoPalavra;
    }

    public int getTentativasF() {
        return tentativasF;
    }

    public void setTentativasF(int tentativasF) {
        this.tentativasF = tentativasF;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public List<String> getSuspeita() {
        return suspeita;
    }

    public void setSuspeita(List<String> suspeita) {
        this.suspeita = suspeita;
    }

    public boolean fimDeJogo() {
        return tentativasF == 0 || acerto();
    }

    public boolean acerto() {
        return suspeita.contains(palavra);
    }

    public void suspeita(String str) {
        if (str.length() == palavra.length()) {
            suspeita.add(str);
            tentativasF--;
        }
    }
}