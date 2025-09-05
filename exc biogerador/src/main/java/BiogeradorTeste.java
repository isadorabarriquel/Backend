import java.util.ArrayList;
import java.util.Random;

public class BiogeradorTeste {
    public static void main(String[] args) {
        ArrayList<Biocombustivel> combustiveis = new ArrayList<>();
        combustiveis.add(new CanaAcucar(2000));
        combustiveis.add(new Beterraba(3000));
        combustiveis.add(new Milho(1500));
        combustiveis.add(new Beterraba(3500));
        combustiveis.add(new Beterraba(2000));
        Biogerador gerador = new Biogerador();

        for (Biocombustivel b : combustiveis) {
            try {
                gerador.carregar(b);
            } catch (GeradorCheioException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.print("Potencia gerada no gerador 1: "+ gerador.getPotenciaAtual());
        System.out.println("Carga atual do gerador1: " + (int)gerador.getCargaAtual());
    }
}
class GeradorCheioException extends Exception {
    public GeradorCheioException(String mensagem) {
        super(mensagem);
    }
}

//--------//------------//----------//

class Biocombustivel {
    protected float quilogramas;


    public Biocombustivel() {
        this.quilogramas = 1000;
    }
    public Biocombustivel(float quilogramas) {
        this.quilogramas = quilogramas;
    }
    public float processar() {
        Random rand = new Random();
        int n = rand.nextInt(3) + 1; // 1, 2 ou 3
        return quilogramas * n;
    }
    public float getQuilogramas() {
        return quilogramas;
    }
    public void setQuilogramas(float quilogramas) {
        this.quilogramas = quilogramas;
    }
}

class CanaAcucar extends Biocombustivel {
    public CanaAcucar(float quilogramas) {
        super(quilogramas);
    }
    @Override
    public float processar() {
        return quilogramas * 3.5f;
    }
}

class Beterraba extends Biocombustivel {
    public Beterraba(float quilogramas) {
        super(quilogramas);
    }
    @Override
    public float processar() {
        return (quilogramas * 1.2f) + 1000;
    }
}

class Milho extends Biocombustivel {
    public Milho(float quilogramas) {
        super(quilogramas);
    }
    @Override
    public float processar() {
        return quilogramas + 1000;
    }
}

class Biogerador {
    private float potenciaAtual;
    private float cargaAtual;
    private final float cargaMaxima;

    public Biogerador() {
        this.potenciaAtual = 0;
        this.cargaAtual = 0;
        this.cargaMaxima = 5;
    }
    public void carregar(Biocombustivel b) throws GeradorCheioException {
        if (cargaAtual >= cargaMaxima) {
            throw new GeradorCheioException("Gerador cheio. Impossivel carregar mais.. ");
        }
        float energiaGerada = b.processar() * 2.36f;
        potenciaAtual += energiaGerada;
        cargaAtual += 1;
    }
    public void esvaziar() {
        potenciaAtual = 0;
        cargaAtual = 0;
    }
    public float getPotenciaAtual() {
        return potenciaAtual;
    }
    public void setPotenciaAtual(float potenciaAtual) {
        this.potenciaAtual = potenciaAtual;
    }
    public float getCargaAtual() {
        return cargaAtual;
    }
    public void setCargaAtual(float cargaAtual) {
        this.cargaAtual = cargaAtual;
    }
    public float getCargaMaxima() {
        return cargaMaxima;
    }
}