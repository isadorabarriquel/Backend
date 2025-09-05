public class Personagem {
    String nome;
    int vida;
    int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }
    public void receberDano(int dano){
        vida -= dano;
        if (vida <= 0){
            vida = 0;
            System.out.print(nome + " morreu.");
        }else{
            System.out.println(nome+" recebeu " +dano +" de dano. Vida restante: "+vida);
        }
    }
    public void atacar(Personagem alvo){
        if (alvo.vida <=0){
            vida = 0;
            System.out.println("O inimigo " + nome + "já foi derrotado. ");
        }else{
            alvo.receberDano(ataque);
        }
    }
    public boolean estavivo(){
        return vida > 0;
    }
}


