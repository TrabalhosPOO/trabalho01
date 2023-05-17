package Trabalho01;

import java.util.Random;

public class Normal extends Jogador{
	private String tipo;
	private int valor;
	private int valor2;
	private int contaJogadas = 0;
	private int semJogar;
	
	public Normal(String cor){
		super(cor);
		this.tipo = "Normal";
	}

	public Normal(){}
	
	@Override
	public int jogarDados() {
		if(this.casa >= 40) {
			System.out.println("O jogo já acabou, inicie outra partida!");
			return 0;
		} else {
		int soma = 0;
		Random a1 = new Random();
		Random a2 = new Random();
		valor = a1.nextInt(1,6);
		valor2 = a2.nextInt(1,6);
		soma = valor + valor2;
		if(valor == valor2) {
			soma = jogarNovamente(valor + valor2);
		}
		return soma;
		}
	}
	
	protected int jogarNovamente(int i) {
		System.out.println("Valores iguais para " + this.cor + 
				"! você jogará novamente");
		int soma = 0;
		Random a1 = new Random();
		Random a2 = new Random();
		valor = a1.nextInt(1,6);
		valor2 = a2.nextInt(1,6);
		soma = i + valor + valor2;
		if(valor == valor2) {
			soma = jogarNovamente(i + valor + valor2);
		} 
		return soma;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getSemJogar() {
		return semJogar;
	}

	public void setSemJogar(int semJogar) {
		this.semJogar = semJogar;
	}

	public int getContaJogadas() {
		return contaJogadas;
	}

	public void setContaJogadas(int contaJogadas) {
		this.contaJogadas = contaJogadas;
	}

	@Override
	public String toString() {
		return " [tipo=" + tipo + " cor=" + cor + " posicao=" + casa 
				+ " rodadas=" + rodadas + "]";
	}
	
}

