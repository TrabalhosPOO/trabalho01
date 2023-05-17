package Trabalho01;

import java.util.Random;

public class Azarado extends Jogador{
	private String tipo;
	private int valor;
	private int valor2;
	
	public Azarado(String cor){
		super(cor);
		this.tipo = "Azarado";
	}

	public Azarado(){}
	
	@Override
	public int jogarDados() {
		int soma = 8;
		while(soma > 7) {
			Random a1 = new Random();
			Random a2 = new Random();
			valor = a1.nextInt(1,6);
			valor2 = a2.nextInt(1,6);
			soma = valor + valor2;
		}

		return soma;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return " [tipo=" + tipo + " cor=" + cor + " posicao=" + casa + "]";
	}

	
	
	
}
