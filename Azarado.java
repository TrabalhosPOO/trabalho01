package Trabalho01;

import java.util.ArrayList;
import java.util.Random;


public class Azarado extends Jogador{
	private String tipo;
	private int valor;
	private int valor2;
	private int semJogar;
	private int contaJogadas = 0;
	ArrayList<Dados> Jogando;
	
	public Azarado(String cor){
		this.cor = cor;
		this.tipo = "Azarado";
		this.Jogando = new ArrayList<>();
	}
	
	public void jogarDados(Jogador j) {
		for(int i = 0; i < Jogando.size(); i++) {
			if(this.semJogar == 0 
					&& Jogando.get(i).getCor().equals(j.getCor())) {
				int soma = 8;
				while(soma > 7) {
					Random a1 = new Random();
					Random a2 = new Random();
					valor = a1.nextInt(1,6);
					valor2 = a2.nextInt(1,6);
					soma = valor + valor2;
				}
				Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
				Jogando.get(i).setRodadas(Jogando.get(i).getRodadas() + 1);
				contaJogadas++;
				CasasEspeciais(i);
			}
		}
	}

	public int getContaJogadas() {
		return contaJogadas;
	}

	public void setContaJogadas(int contaJogadas) {
		this.contaJogadas = contaJogadas;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Azarado [tipo=" + tipo + ", Jogando=" + Jogando + "]";
	}

	
	
	

}
