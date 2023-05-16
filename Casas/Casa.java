package Casas;

import Jogadores.Jogador;

public abstract class Casa {
    protected int num;


    public Casa(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void verificaAcao(Jogador jogador){
        System.out.println("jogador " + jogador.getCor() + " parou na casa " + getNum());

    }
    
}
