import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private String nome;
    private int idade;
    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
}

class Filme {
    private String nome;
    private double preco;
    private int idadeMinima;

    public Filme(String nome, double preco, int idadeMinima) {
        this.nome = nome;
        this.preco = preco;
        this.idadeMinima = idadeMinima;
    }
    public String getNome() {
        return nome;
    }
    public int getIdadeMinima() {
        return idadeMinima;
    }
    public double getPreco() {
        return preco;
    }
}

class Ingresso {
    private Cliente cliente;
    private Filme filme;
    private String assento;

    public Ingresso(Cliente cliente, Filme filme, String assento) {
        this.cliente = cliente;
        this.filme = filme;
        this.assento = assento;
    }

    public String toString() {
        return filme.getNome() + " - " + assento + " - " + cliente.getNome();
    }
}
class Cinema {
    private List<Filme> filmesDisponiveis;
    private List<String> assentosDisponiveis;
    private List<Ingresso> ingressosVendidos;

    public Cinema() {
        filmesDisponiveis = new ArrayList<>();
        assentosDisponiveis = new ArrayList<>();
        ingressosVendidos = new ArrayList<>();

        filmesDisponiveis.add(new Filme("Homen Aranha", 20.0, 12));
        filmesDisponiveis.add(new Filme("Vingadores", 25.0, 10));
        filmesDisponiveis.add(new Filme("O Rei Leão", 18.0, 0));
        filmesDisponiveis.add(new Filme("Jumanji", 22.0, 12));
        filmesDisponiveis.add(new Filme("Jurassic Park", 28.0, 12));

        for (char row = 'A'; row <= 'F'; row++) {
            for (int col = 1; col <= 5; col++) {
                assentosDisponiveis.add(row + String.valueOf(col));
            }
        }
    }

    public List<Filme> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }
    public List<String> getAssentosDisponiveis() {
        return assentosDisponiveis;
    }
    public void venderIngresso(Ingresso ingresso) {
        ingressosVendidos.add(ingresso);
        assentosDisponiveis.remove(ingresso.toString().split(" - ")[1]); // Remove o assento
    }
}

public class exc5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();

        while (true) {
            try {
                System.out.println("\nFilmes disponíveis:");
                for (Filme filme : cinema.getFilmesDisponiveis()) {
                    System.out.println(filme.getNome());
                }

                System.out.print("Que filme você deseja assistir? ");
                String nomeFilme = scanner.nextLine();

                Filme filmeSelecionado = null;
                for (Filme filme : cinema.getFilmesDisponiveis()) {
                    if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                        filmeSelecionado = filme;
                        break;
                    }
                }
                if (filmeSelecionado == null) {
                    System.out.println("Filme não encontrado!");
                    continue;
                }
                System.out.print("Qual assento você deseja? ");
                String assentoEscolhido = scanner.nextLine();

                if (!cinema.getAssentosDisponiveis().contains(assentoEscolhido)) {
                    System.out.println("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
                    continue;
                }

                System.out.print("Qual o seu nome? ");
                String nomeCliente = scanner.nextLine();

                System.out.print("Qual a sua idade? ");
                int idadeCliente = Integer.parseInt(scanner.nextLine());

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);
                if (idadeCliente < filmeSelecionado.getIdadeMinima()) {
                    System.out.println("O ingresso não pode ser vendido pois sua idade não permite!");
                    continue;
                }

                Ingresso ingresso = new Ingresso(cliente, filmeSelecionado, assentoEscolhido);
                cinema.venderIngresso(ingresso);
                System.out.println("Ingresso vendido com sucesso! " + ingresso);
            } catch (Exception e) {
                System.out.println("Erro ao processar sua solicitação: " + e.getMessage());
            }
        }
    }
}
