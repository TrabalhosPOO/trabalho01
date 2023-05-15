package Trabalho01;

import java.util.ArrayList;
import java.util.Random;

public class Normal extends Jogador{
	private String tipo;
	private int valor;
	private int valor2;
	private int contaJogadas = 0;
	private int semJogar;
	ArrayList<Dados> Jogando;
		
	public Normal(String cor){
		this.cor = cor;
		this.tipo = "Normal";
		this.Jogando = new ArrayList<>();
	}
	
	public void jogarDados(Jogador j) {
		int soma = 0;
		for(int i = 0; i < Jogando.size(); i++) {
			if(this.semJogar == 0 
					&& Jogando.get(i).getCor().equals(j.getCor())) {
				Random a1 = new Random();
				Random a2 = new Random();
				valor = a1.nextInt(1,6);
				valor2 = a2.nextInt(1,6);
				soma = valor + valor2;
				Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
				Jogando.get(i).setRodadas(Jogando.get(i).getRodadas() + 1);
				setContaJogadas(getContaJogadas() + 1);
				CasasEspeciais(i);
			}
		}
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
	
	
	
}

