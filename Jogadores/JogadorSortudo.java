package Jogadores;

import Jogo.Dado;

public class JogadorSortudo extends Jogador {

    public JogadorSortudo(String cor) {
        super(cor);
    }

    @Override
    public int rolarDados() {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        int res1 = dado1.rolar();
        int res2 = dado2.rolar();
        int soma = res1 + res2;
        if (soma <= 6) {
            rolarDados();
        }
        System.out.println("soma: " + soma);
        return soma;
    }

}
