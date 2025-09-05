import java.util.*;

class Musica {
    private String titulo;
    private String artista;

    public Musica(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getArtista() {
        return artista;
    }
    @Override
    public String toString() {
        return titulo;
    }
}

class Playlist {
    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void imprimirPlaylist() {
        System.out.println("\nPlaylist:");
        for (Musica musica : musicas) {
            System.out.println("- " + musica.getTitulo());
        }
    }
}

class MusicaNaoEncontradaException extends Exception {
    public MusicaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}

class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        musicasDisponiveis = new ArrayList<>();
        musicasDisponiveis.add(new Musica("Macarena", "Los Del Rio"));
        musicasDisponiveis.add(new Musica("Evidencias", "Chitoozinho & Xororo"));
        musicasDisponiveis.add(new Musica("Shape of You", "Ed Sheeran"));
        musicasDisponiveis.add(new Musica("Bohemian Rhapsody", "Queen"));
        musicasDisponiveis.add(new Musica("Hino do Real Paulista", "Desconhecido"));
    }

    public Musica buscarMusica(String titulo) throws MusicaNaoEncontradaException {
        for (Musica musica : musicasDisponiveis) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        throw new MusicaNaoEncontradaException("A musica " + titulo + " no foi encontrada no sistema.");
    }
}

public class exc2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCloud musicCloud = new MusicCloud();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        while (true) {
            System.out.print("\nDigite o nome da música (ou 'sair' para encerrar): ");
            String nomeMusica = scanner.nextLine();

            if (nomeMusica.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                Musica musica = musicCloud.buscarMusica(nomeMusica);
                playlist.adicionarMusica(musica);
                System.out.println("Voce adicionou a musica " + musica.getTitulo() + " na playlist.");
            } catch (MusicaNaoEncontradaException e) {
                System.out.println(e.getMessage());
            }
        }
        playlist.imprimirPlaylist();
    }
}
