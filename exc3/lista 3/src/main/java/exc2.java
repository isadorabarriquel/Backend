import java.util.Random;

public class exc2 {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            Jogador jogador = Jogador.gerarJogadorAleatorio();
            System.out.println(jogador);
        }
    }
}
class Jogador {
    private String nome;
    private String sobrenome;
    private int idade;
    private String posicao;
    private String time;

    public Jogador(String nome, String sobrenome, int idade, String posicao, String time) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.posicao = posicao;
        this.time = time;
    }

    public static Jogador gerarJogadorAleatorio() {
        String[] nomes = {"leonardo", "Gabriel", "lucas", "Henzo", "Tiago"};
        String[] sobrenomes = {"Ramos", "Silva", "Oliveira", "Souza", "Costa"};
        String[] posicoes = {"goleiro", "zagueiro", "meio-campo", "atacante", "lateral"};
        String[] times = {"Corinthians", "Internacional", "Santos", "Gremio", "Sao Paulo"};

        Random random = new Random();
        String nome = nomes[random.nextInt(nomes.length)];
        String sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];
        int idade = random.nextInt(22) + 18; // 18 a 39 anos
        String posicao = posicoes[random.nextInt(posicoes.length)];
        String time = times[random.nextInt(times.length)];

        return new Jogador(nome, sobrenome, idade, posicao, time);
    }
    @Override
    public String toString() {
        return nome + " " + sobrenome + " e um jogador brasileiro de " + idade +
                " anos que atua como " + posicao + ". Atualmente defende o " + time + ".";
    }
}
