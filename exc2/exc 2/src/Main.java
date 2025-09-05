import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        exercicio1();
        exercicio2();
        exercicio3();
    }

    public static void exercicio1() {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int tamanhoSenha = 8;
        StringBuilder senha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < tamanhoSenha; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        System.out.println("Senha gerada: " + senha.toString());
    }

    public static void exercicio2() {
        String[] nomes = {"Cassio", "Gabriel", "Luca", "Henzo", "Tiago"};
        String[] sobrenomes = {"Ramos", "Silva", "Oliveira", "Souza", "Costa"};
        String[] posicoes = {"goleiro", "zagueiro", "meio-campo", "atacante", "lateral"};
        String[] times = {"Corinthians", "Internacional", "Santos", "Grêmio", "São Paulo"};

        Random random = new Random();

        String nome = nomes[random.nextInt(nomes.length)];
        String sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];
        int idade = random.nextInt(22) + 18; // idade entre 18 e 39
        String posicao = posicoes[random.nextInt(posicoes.length)];
        String time = times[random.nextInt(times.length)];

        System.out.println(nome + " " + sobrenome + " é um futebolista brasileiro de " + idade +
                " anos que atua como " + posicao + ". Atualmente defende o " + time + ".");
    }
    static void exercicio3(){
        String[] nomes = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Eevee", "Snorlax", "Jigglypuff"};
        String[] tipos = {"Elétrico", "Fogo", "Água", "Planta", "Normal", "Psíquico", "Fantasma"};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Quantos Pokemons você quer gerar? ");
        int quantidade = scanner.nextInt();

        System.out.println("\npokemons gerados:");
        for (int i = 0; i < quantidade; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            String tipo = tipos[random.nextInt(tipos.length)];
            int nivel = random.nextInt(100) + 1; // nível entre 1 e 100

            System.out.println(nome + " é um Pokémon do tipo " + tipo + " de nível " + nivel + ".");
        }
        scanner.close();
    }
}
