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
	
	@Override
	public int jogarDados() {
		if(this.casa >= 40) {
			System.out.println("O jogo já acabou, inicie outra partida!");
			return 0;
		} else {
		int soma = 8;
		while(soma > 7) {
			Random a1 = new Random();
			Random a2 = new Random();
			valor = a1.nextInt(1,6);
			valor2 = a2.nextInt(1,6);
			soma = valor + valor2;
		}
		if(valor == valor2) {
			soma = jogarNovamente(valor + valor2);
		} 
		return soma;
		}
	}
	
	protected int jogarNovamente(int i) {
		System.out.println("Valores iguais para " + this.cor + 
				"! você jogará novamente");
		int soma = 8;
		while(soma > 7) {
			Random a1 = new Random();
			Random a2 = new Random();
			valor = a1.nextInt(1,6);
			valor2 = a2.nextInt(1,6);
			soma = valor + valor2;
		}
		soma += i;
		if(valor == valor2) {
			soma = jogarNovamente(valor + valor2 + i);
		} 
		return soma;
	}
	

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return " [tipo=" + tipo + " cor=" + cor + " posicao=" + casa +
				" rodadas=" + rodadas + "]";
	}

	
	
	
}
