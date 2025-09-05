import java.util.Random;
import java.util.Scanner;

public class exc3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos pokemons vc quer gerar? ");
        int quantidade = scanner.nextInt();

        System.out.println("Pokemons gerados:");
        for (int i = 0; i < quantidade; i++) {
            pokemon p = pokemon.gerarPokemonAleatorio();
            System.out.println(p);
        }
        scanner.close();
    }
}
class pokemon {
    private String nome;
    private String tipo;
    private int nivel;

    public pokemon(String nome, String tipo, int nivel) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
    }
    public static pokemon gerarPokemonAleatorio() {
        String[] nomes = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Eeve", "Snorlax", "Jigglypuf"};
        String[] tipos = {"Eletrico", "Fogo", "agua", "Planta", "Normal", "Psiquico", "Fantasma"};

        Random random = new Random();
        String nome = nomes[random.nextInt(nomes.length)];
        String tipo = tipos[random.nextInt(tipos.length)];
        int nivel = random.nextInt(100) + 1;

        return new pokemon(nome, tipo, nivel);
    }
    @Override
    public String toString() {
        return nome + " é um pokemon do tipo " + tipo + " de nivel " + nivel + ".";
    }
}
