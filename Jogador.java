package Trabalho01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogador{
	protected int rodadas;
	protected String cor;
	protected int casa;
	protected int valor;
	protected int valor2;
	protected int contaJogadas = 0;
	protected int contador;
	protected String tipo;
	private Scanner tom;
	ArrayList<Dados> Jogando;

	public Jogador() {
		this.Jogando = new ArrayList<>();
	}
	
	public void inscreverJogadores(Dados j) {
		if(this.getContador() <= 6) {
			this.Jogando.add(j);
			this.setContador(this.getContador() + 1);
		} else {
			System.out.println("Não pode ter mais que 6 jogadores!");
		}
	}
	
	public void jogarDados(Dados j) {
		int soma = 0;
		for(int i = 0; i < Jogando.size(); i++) {
			if(Jogando.get(i).getCor().equals(j.getCor())) {
				Random a1 = new Random();
				Random a2 = new Random();
				valor = a1.nextInt(1,6);
				valor2 = a2.nextInt(1,6);
				soma = valor + valor2;
				Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
				Jogando.get(i).setRodadas(Jogando.get(i).getRodadas() + 1);
				CasasEspeciais(i);
			}
		}
	}
	
	protected void CasasEspeciais(int i) {
		if(Jogando.get(i).getCasa() == 10 || Jogando.get(i).getCasa() == 15 || 
				Jogando.get(i).getCasa() == 38) {
			if(Jogando.get(i).getSemjogar() > 0) {
				Jogando.get(i).setSemjogar(Jogando.get(i).getSemjogar() - 1);
			} else {
				Jogando.get(i).setSemjogar(Jogando.get(i).getSemjogar() + 1);
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" ficará 1 rodada sem jogar!");
			}
		}
		
		else if(Jogando.get(i).getCasa() == 13) {
			Random a1 = new Random();
			int res = a1.nextInt(3);
			switch(res) {
				case 0:
					Jogador novoTipo = new Sortudo(Jogando.get(i).getCor());
					novoTipo.setCor(Jogando.get(i).getCor());
					novoTipo.setCasa(Jogando.get(i).getCasa());
					novoTipo.setRodadas(Jogando.get(i).getRodadas());
					System.out.println("O tipo do jogador " + Jogando.get(i).getCor() + 
							" foi alterado pra Sortudo");
					break;
				case 1:
					Jogador novoTipo1 = new Normal(Jogando.get(i).getCor());
					novoTipo1.setCor(Jogando.get(i).getCor());
					novoTipo1.setCasa(Jogando.get(i).getCasa());
					novoTipo1.setRodadas(Jogando.get(i).getRodadas());
					System.out.println("O tipo do jogador " + Jogando.get(i).getCor() + 
							" foi alterado pra Normal");
					break;
				case 2:
					Jogador novoTipo2 = new Azarado(Jogando.get(i).getCor());
					novoTipo2.setCor(Jogando.get(i).getCor());
					novoTipo2.setCasa(Jogando.get(i).getCasa());
					novoTipo2.setRodadas(Jogando.get(i).getRodadas());
					System.out.println("O tipo do jogador " + Jogando.get(i).getCor() + 
							" foi alterado pra Azarado");
					break;
			}
		}
		
		else if(Jogando.get(i).getCasa() == 5 || Jogando.get(i).getCasa() == 15 
				|| Jogando.get(i).getCasa() == 30) {
			if(this.tipo.equals("Azarado")) {
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" é Azarado, então não avança nenhuma casa");
			}
			else {
				Jogando.get(i).setCasa(Jogando.get(i).getCasa() + 3);
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" avançou 3 casas!");
			}
		}
		
		else if(Jogando.get(i).getCasa() == 17 || Jogando.get(i).getCasa() == 27) {
			System.out.println("O jogador da cor " + Jogando.get(i).getCor() + 
					"parou na casa " + Jogando.get(i).getCasa());
			System.out.println("Escolha a cor de um competidor "
					+ "para voltar ao início(Digite com inicial maiúscula");
			System.out.println("--------------------STATUS DA PARTIDA"
					+ "--------------------");
			for(int l = 0; l < Jogando.size(); l++) {
				System.out.println(Jogando.get(l).toString());		
			}
			System.out.println("");
			voltandoInicio();
			
		}
		
		else if(Jogando.get(i).getCasa() == 20 || Jogando.get(i).getCasa() == 35) {
			trocandoInicio(i);
		}
		
		else if(Jogando.get(i).getCasa() >= 40) {
			System.out.println("O jogador " + Jogando.get(i).getCor() + 
					"venceu a partida!");
			System.out.println("Resetando...");
			//Comando pra resetar tudo e mostrar relatorio
		}
		
		this.contaJogadas++;
		
	}
	
	protected void verificarRodada(int i) {
		if (valor == valor2) {
			System.out.println("Valores iguais! O jogador da cor " 
		+ Jogando.get(i).getCor() + " jogará novamente!");
			jogarNovamente(i);
		}
		
		else if(contaJogadas % this.getContador() == 0) {
			System.out.println("------------------DADOS " + contaJogadas/this.getContador() 
					+ " rodada------------------");
			for(int l = 0; l < Jogando.size(); l++) {
				System.out.println(Jogando.get(l).toString());		
			}
			System.out.println(" ");
		}
	}
	
	protected void jogarNovamente(int i) {
		int soma = 0;
		if(this.tipo.equals("Sortudo")) {
			while(soma < 7) {
				Random a1 = new Random();
				Random a2 = new Random();
				valor = a1.nextInt(1,6);
				valor2 = a2.nextInt(1,6);
				soma = valor + valor2;
			}
			Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
			CasasEspeciais(i);
		} else if(this.tipo.equals("Normal")) {
			Random a1 = new Random();
			Random a2 = new Random();
			valor = a1.nextInt(1,6);
			valor2 = a2.nextInt(1,6);
			soma = valor + valor2;
			Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
			CasasEspeciais(i);
		} else {
			soma = 8;
			while(soma > 7) {
				Random a1 = new Random();
				Random a2 = new Random();
				valor = a1.nextInt(1,6);
				valor2 = a2.nextInt(1,6);
				soma = valor + valor2;
			}
			Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
			CasasEspeciais(i);
		}
		
	}
	
	protected void voltandoInicio() {
		int somador = 0;
		tom = new Scanner(System.in);
		String c = tom.nextLine();
		for(int i = 0; i < Jogando.size(); i++) {
			if(Jogando.get(i).getCor().equals(c)) {
				somador++;
				Jogando.get(i).setCasa(0);
				System.out.println("O jogador da cor " + c + " voltou para o início");
			}
		}
		if(somador == 0) {
			System.out.println("Cor não presente no jogo ou digitada de forma errada,"
					+ " digite uma cor presente no jogo com inicial maiúscula");
			voltandoInicio();
		}
	}
	
	protected void trocandoInicio(int i) {
		int menor = 40;
		int pos = 0;
		for(int j = 0; j < Jogando.size(); j++) {
			if(Jogando.get(j).getCasa() < menor) {
				menor = Jogando.get(j).getCasa();
				pos = j;
			}
		}
		if(menor == 40) {
			System.out.println("O jogador da cor " + Jogando.get(i).getCor() +
					" já está na última colocação, então não trocará com ninguém!");
		} else {
			Jogando.get(pos).setCasa(Jogando.get(i).getCasa());
			Jogando.get(i).setCasa(menor);
			System.out.println("O jogador da cor " + Jogando.get(i).getCor() +
					" trocou de posição com o último jogador que era " + 
					Jogando.get(pos).getCor());
		}
	}
	
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
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

	
	
}


