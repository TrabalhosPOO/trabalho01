package Casas;

import Jogadores.Jogador;

public class CasaMagica extends Casa{

    public CasaMagica(int num) {
        super(num);
        
    }

    public void verificaAcao(Jogador jogador){
        System.out.println("voce parou numa casa magica e ira trocar de lugar com o ultimo jogador!");

    }
    
}
