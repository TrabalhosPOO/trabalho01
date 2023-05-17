package Trabalho01;

import java.util.Random;

public class Sortudo extends Jogador{
	private int contaJogadas = 0;
	private String tipo;
	private int semJogar;
	private int valor;
	private int valor2;
	
	public Sortudo() {
		
	}



	public Sortudo(String cor){
		super(cor);
		this.tipo = "Sortudo";
	}

	
	
	@Override
	public int jogarDados() {
		int soma = 0;
		while(soma < 7) {
			Random a1 = new Random();
			Random a2 = new Random();
			valor = a1.nextInt(6);
			valor2 = a2.nextInt(1,6);
			soma = valor + valor2;
		}
		
		return soma;
	}

	public int getSemJogar() {
		return semJogar;
	}

	public void setSemJogar(int semJogar) {
		this.semJogar = semJogar;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getContaJogadas() {
		return contaJogadas;
	}

	public void setContaJogadas(int contaJogadas) {
		this.contaJogadas = contaJogadas;
	}

	@Override
	public String toString() {
		return " [tipo=" + tipo + " cor=" + cor + " posicao=" + casa + "]";
	}
	
	
	
}
