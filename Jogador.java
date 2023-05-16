package Trabalho01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Jogador{
	protected int rodadas;
	protected String cor;
	protected int casa;
	protected int contaJogadas = 0;
	protected int semJogar;
	protected String tipo;

	public Jogador(String c) {
		this.cor = c;
		this.rodadas = 0;
		this.casa = 0;
		this.semJogar = 0;
	}
	
	public abstract int jogarDados() {
		int soma = 0;
		Random a1 = new Random();
		Random a2 = new Random();
		valor = a1.nextInt(1,6);
		valor2 = a2.nextInt(1,6);
		soma = valor + valor2;
		return soma;
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

	public int getRodadas() {
		return rodadas;
	}
	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getCasa() {
		return casa;
	}
	public void setCasa(int casa) {
		this.casa = casa;
	}

	public int getSemJogar() {
		return semJogar;
	}

	public void setSemJogar(int semJogar) {
		this.semJogar = semJogar;
	}

	
}


