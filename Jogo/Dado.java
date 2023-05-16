package Jogo;

import java.util.Random;

public class Dado {
    protected int valor;

    public int getValor() {
        return valor;
    }

    public int rolar() {
        Random random = new Random();
        valor = random.nextInt(6) + 1;
        return valor;

    }

}
