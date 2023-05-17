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
	
	@Override
	public int jogarDados() {
		int soma = 0;
		Random a1 = new Random();
		Random a2 = new Random();
		valor = a1.nextInt(1,6);
		valor2 = a2.nextInt(1,6);
		soma = valor + valor2;
		setContaJogadas(getContaJogadas() + 1);
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

