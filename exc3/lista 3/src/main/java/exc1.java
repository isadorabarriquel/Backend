import java.util.Random;

public class exc1 {
    public static void main(String[] args) {
        GeradorSenha gerador = new GeradorSenha(8); // senha de 8 caracteres
        String senha = gerador.gerar();
        System.out.println("Senha gerada: " + senha);
    }
}

class GeradorSenha {
    private String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int tamanho;
    private Random random;

    public GeradorSenha(int tamanho) {
        this.tamanho = tamanho;
        this.random = new Random();
    }

    public String gerar() {
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }
        return senha.toString();
    }
}
