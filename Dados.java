package Trabalho01;

public class Dados {
	public String cor;
	public int casa;
	public int rodadas;
	public int semjogar;
	public int contaJogadas;
	
	public int getContaJogadas() {
		return contaJogadas;
	}

	public void setContaJogadas(int contaJogadas) {
		this.contaJogadas = contaJogadas;
	}

	public Dados(String c) {
		this.cor = c;
		this.casa = 0;
		this.rodadas = 0;
		this.semjogar = 0;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setCasa(int casa) {
		this.casa = casa;
	}

	public int getRodadas() {
		return rodadas;
	}

	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}

	public int getSemjogar() {
		return semjogar;
	}

	public void setSemjogar(int semjogar) {
		this.semjogar = semjogar;
	}

	public int getCasa() {
		return casa;
	}

	@Override
	public String toString() {
		return "Dados [cor=" + cor + ", casa=" + casa + ", rodadas=" + rodadas + "]";
	}
	
	

}
