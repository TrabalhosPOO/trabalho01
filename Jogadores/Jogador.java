package Jogadores;

public abstract class Jogador {
    protected String cor;
    protected int posicao;
    protected int qtdJogadas;

    public Jogador(String cor) {
        this.cor = cor;
        posicao = 0;
        qtdJogadas = 0;
    }

    public int getQtdJogadas() {
        return qtdJogadas;
    }

    public int getPosicao() {
        return posicao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public abstract int rolarDados();

    public void moverJogador() {
        int valorDados = rolarDados();
        int novaPosicao = this.posicao + valorDados;
        this.posicao = novaPosicao;
        System.out.println("Jogador " + this.cor + " moveu " + valorDados + " casas para a posição " + novaPosicao);
    }

    public void trocarTipoJogador() {
    }

    public void voltarInicio() {
        this.posicao = 0;
        System.out.println("voce voltou para o inicio");
    }

    public void mostrarPosica() {
        System.out.println("jogador " + this.cor + "na posicao " + this.posicao);
    }
}
