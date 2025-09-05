import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batalha {
    public static void main(String[] args){
        Random random = new Random();

        Personagem jogador = new Personagem("Isa linda", 50, 12);

        ArrayList<Personagem> inimigos  = new ArrayList<>();
        inimigos.add(new Personagem("Isadora", 30,8));
        inimigos.add(new Personagem("Fernando", 40,5));
        inimigos.add(new Personagem("Otávio", 20,3));

        while (jogador.estavivo() && inimigos.stream().anyMatch(Personagem::estavivo)) {
            Personagem alvo;
            do{
                alvo = inimigos.get(random.nextInt(inimigos.size()));
            }while (!alvo.estavivo());

            jogador.atacar(alvo);

            for (Personagem inimigo : inimigos){
                if (inimigo.estavivo() && jogador.estavivo()) {
                    inimigo.atacar(jogador);
                }
            }
        }
        if (jogador.estavivo()){
            System.out.println("Jogador venceu!");
        }else{
            System.out.println("Jogador perdeu!");
        }
    }
}
