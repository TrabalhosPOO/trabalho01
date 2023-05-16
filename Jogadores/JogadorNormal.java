package Jogadores;

import Jogo.Dado;

public class JogadorNormal extends Jogador {

    public JogadorNormal(String cor) {
        super(cor);
    }

    @Override
    public int rolarDados() {

        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        int res1 = dado1.rolar();
        int res2 = dado2.rolar();
        int soma = res1 + res2;
        System.out.println("Valor dos dados: " + res1 + ", " + res2 + " (soma: " + soma + ")");
        return soma;

    }

}
