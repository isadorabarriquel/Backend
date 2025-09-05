import java.util.Scanner;

enum TipoPostagem {
    TEXTO, IMAGEM, VIDEO
}

class Postagem {
    private String titulo;
    private String descricao;
    private TipoPostagem tipo;

    public Postagem(String titulo, String descricao, TipoPostagem tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public TipoPostagem getTipo() {
        return tipo;
    }
}

interface PlataformaSocial {
    void compartilharPostagem(Postagem postagem) throws Exception;
    void compartilharImagem(Postagem postagem) throws Exception;
    void compartilharVideo(Postagem postagem) throws Exception;
}

class MyBook implements PlataformaSocial {
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no MyBook.");
    }
    public void compartilharImagem(Postagem postagem) {
        System.out.println("Você compartilhou essa imagem no MyBook.");
    }
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no MyBook.");
    }
}

class Fotogram implements PlataformaSocial {
    public void compartilharPostagem(Postagem postagem) throws Exception {
        throw new Exception("Fotogram não suporta compartilhamento de postagens de texto.");
    }
    public void compartilharImagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no Fotogram.");
    }
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no Fotogram.");
    }
}

class AnyTube implements PlataformaSocial {
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no AnyTube.");
    }
    public void compartilharImagem(Postagem postagem) throws Exception {
        throw new Exception("AnyTube não suporta compartilhamento de imagens.");
    }
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no AnyTube.");
    }
}

public class exc4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Tipo (texto, imagem, video): ");
        String tipoInput = scanner.nextLine().toUpperCase();

        TipoPostagem tipo;
        try {
            tipo = TipoPostagem.valueOf(tipoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido. Use: texto, imagem ou video.");
            return;
        }

        Postagem postagem = new Postagem(titulo, descricao, tipo);

        PlataformaSocial myBook = new MyBook();
        PlataformaSocial fotogram = new Fotogram();
        PlataformaSocial anyTube = new AnyTube();
        try {
            if (tipo == TipoPostagem.TEXTO) {
                myBook.compartilharPostagem(postagem);
            } else if (tipo == TipoPostagem.IMAGEM) {
                myBook.compartilharImagem(postagem);
            } else {
                myBook.compartilharVideo(postagem);
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao compartilhar essa postagem no MyBook.");
        }
        try {
            if (tipo == TipoPostagem.TEXTO) {
                fotogram.compartilharPostagem(postagem);
            } else if (tipo == TipoPostagem.IMAGEM) {
                fotogram.compartilharImagem(postagem);
            } else {
                fotogram.compartilharVideo(postagem);
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao compartilhar essa postagem no Fotogram.");
        }
        try {
            if (tipo == TipoPostagem.TEXTO) {
                anyTube.compartilharPostagem(postagem);
            } else if (tipo == TipoPostagem.IMAGEM) {
                anyTube.compartilharImagem(postagem);
            } else {
                anyTube.compartilharVideo(postagem);
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao compartilhar essa postagem no AnyTube.");
        }
    }
}
