package Trabalho01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dados {
	public int semjogar;
	public int contaJogadas = 0;
	public int Contador;
	public int contaRodadas = 0;
	public int semJogar;
	public int Parar = 0;
	public int contaNormal = 0;
	public int contaAzarado = 0;
	public int contaSortudo = 0;
	private Scanner tom;
	ArrayList<Jogador> Jogando;
	
	
	public Dados() {
		this.Jogando = new ArrayList<>();
	}
	
	public void inscreverJogadores(Jogador j) {
		if(this.getContador() <= 6) {
			this.Jogando.add(j);
			this.setContador(this.getContador() + 1);
		} else {
			System.out.println("Não pode ter mais que 6 jogadores!");
		}
	}
	
	public void EstadoAtual() {
		for(int i = 0; i < Jogando.size(); i++) {
			System.out.println("Jogador " + (i+1) + Jogando.get(i).toString());
		}
	}
	
	public void ResultadoDados(int i) {
		if((contaRodadas == 0) && (contaJogadas == 0)) {
			for(int j = 0; j < Jogando.size(); j++) {
				if(Jogando.get(j) instanceof Normal) {
					contaNormal++;
				} else if(Jogando.get(j) instanceof Sortudo) {
					contaSortudo++;
				} else {
					contaAzarado++;
				}
			}
			if(((contaNormal == 0) && (contaSortudo == 0)) || 
					((contaNormal == 0) && (contaAzarado == 0)) ||
					((contaAzarado == 0) && (contaSortudo == 0))) {
				this.setContador(0);
			}
		}
		
		if(this.getContador() < 2) {
			System.out.println("Partida não iniciada!");
			System.out.println("------REGRAS PARA INICIAR PARTIDA------");
			System.out.println("Escolha mais de 1 tipo pra começar o jogo");
			System.out.println("Quantidade mínima de 2 jogadores");
			System.out.println("");
		} else {
			if(Parar == 0) {
				Jogando.get(contaJogadas).setCasa(Jogando.get(contaJogadas).getCasa() + i);
				Jogando.get(contaJogadas).setRodadas(Jogando.get(contaJogadas).getRodadas() + 1);
				System.out.println("O jogador " + Jogando.get(contaJogadas).getCor() 
						+ " avançou " + i + " casas");
				Rodada(contaJogadas);
			} else {
				System.out.println("O jogo já acabou, inicie outra partida!");
			}
		}
	}
	
	protected void Rodada(int i) {
		if(Jogando.get(i).getCasa() == 10 || Jogando.get(i).getCasa() == 15 || 
				Jogando.get(i).getCasa() == 38) {
			if(Jogando.get(i).getSemJogar() > 0) {
				Jogando.get(i).setSemJogar(Jogando.get(i).getSemJogar() - 1);
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						"não jogará essa rodada");
			} else {
				Jogando.get(i).setSemJogar(Jogando.get(i).getSemJogar() + 1);
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" ficará 1 rodada sem jogar!");
			}
		}
		
		else if(Jogando.get(i).getCasa() == 13) {
			Random a1 = new Random();
			int res = a1.nextInt(2);
			if (Jogando.get(i) instanceof Normal) {
				switch(res) {
					case 0:
						Jogador novoSortudo = new Sortudo(Jogando.get(i).getCor());
						novoSortudo.setCasa(Jogando.get(i).getCasa());
						novoSortudo.setRodadas(Jogando.get(i).getRodadas());
						Jogando.remove(i);
						Sortudo ns = (Sortudo) novoSortudo;
						Jogando.add(i, ns);
						System.out.println("O tipo do jogador " + Jogando.get(i).getCor() +
								" foi alterado pra Sortudo");
						break;
					case 1:
						Jogador novoSortudo2 = new Azarado(Jogando.get(i).getCor());
						novoSortudo2.setCasa(Jogando.get(i).getCasa());
						novoSortudo2.setRodadas(Jogando.get(i).getRodadas());
						Jogando.remove(i);
						Azarado na = (Azarado) novoSortudo2; 
						Jogando.add(i, na);
						System.out.println("O tipo do jogador " + Jogando.get(i).getCor() +
								" foi alterado pra Azarado");
						break;
				}
			}
			else if (Jogando.get(i) instanceof Sortudo) {
				switch (res) {
					case 0:
						Jogador novoAzarado = new Azarado(Jogando.get(i).getCor());
						novoAzarado.setCasa(Jogando.get(i).getCasa());
						novoAzarado.setRodadas(Jogando.get(i).getRodadas());
						Jogando.remove(i);
						Azarado na1 = (Azarado) novoAzarado;
						Jogando.add(i, na1);
						System.out.println("O tipo do jogador " + 
						Jogando.get(i).getCor() + " foi alterado pra Azarado");

						break;
					case 1:
						Jogador novoNormal3 = new Normal(Jogando.get(i).getCor());
						novoNormal3.setCasa(Jogando.get(i).getCasa());
						novoNormal3.setRodadas(Jogando.get(i).getRodadas());
						Jogando.remove(i);
						Normal nn = (Normal) novoNormal3;
						Jogando.add(i, nn);
						System.out.println("O tipo do jogador " + Jogando.get(i).getCor() +
								" foi alterado pra Normal");
						break;
				}
			} else {
				switch (res) {
					case 0:
						Jogador novoNormal1 = new Normal(Jogando.get(i).getCor());
						novoNormal1.setCasa(Jogando.get(i).getCasa());
						novoNormal1.setRodadas(Jogando.get(i).getRodadas());
						Jogando.remove(i);
						Normal nn1 = (Normal) novoNormal1;
						Jogando.add(i, nn1);
						System.out.println("O tipo do jogador " + Jogando.get(i).getCor() +
								" foi alterado pra Normal");
						break;
					case 1:
						Jogador novoSortudo3 = new Sortudo(Jogando.get(i).getCor());
						novoSortudo3.setCasa(Jogando.get(i).getCasa());
						novoSortudo3.setRodadas(Jogando.get(i).getRodadas());
						Jogando.remove(i);
						Sortudo ns3 = (Sortudo) novoSortudo3;
						Jogando.add(i, ns3);
						System.out.println("O tipo do jogador " + Jogando.get(i).getCor() +
								" foi alterado pra Sortudo");
						break;
				}
			}
		}
		
		else if(Jogando.get(i).getCasa() == 5 || Jogando.get(i).getCasa() == 15 
				|| Jogando.get(i).getCasa() == 30) {
			if(Jogando.get(i) instanceof Azarado) {
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" é Azarado, então não avança 3 casas");
			}
			else {
				Jogando.get(i).setCasa(Jogando.get(i).getCasa() + 3);
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" avançou 3 casas!");
			}
		}
		
		else if(Jogando.get(i).getCasa() == 17 || Jogando.get(i).getCasa() == 27) {
			System.out.println("O jogador da cor " + Jogando.get(i).getCor() + 
					" parou na casa " + Jogando.get(i).getCasa());
			System.out.println("Escolha a cor de um competidor "
					+ "para voltar ao início(Digite com inicial maiúscula)");
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
					" venceu a partida!");
			System.out.println("Parando...");
			System.out.println("------------------DADOS " + contaRodadas 
					+ " rodada------------------");
			for(int l = 0; l < Jogando.size(); l++) {
				System.out.println(Jogando.get(l).toString());		
			}
			System.out.println("");
			this.setParar(1);
			
		}
		this.contaJogadas++;
		verificarRodada(i);
	}
	
	protected void verificarRodada(int i) {	
		if(contaJogadas == this.getContador()) {
			System.out.println("");
			contaRodadas++;
			System.out.println("------------------DADOS " + contaRodadas 
					+ " rodada------------------");
			for(int l = 0; l < Jogando.size(); l++) {
				System.out.println(Jogando.get(l).toString());		
			}
			System.out.println("");
			contaJogadas = 0;
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
	
	protected void jogarNovamente(int i) {
		
	}
	
	public int getSemJogar() {
		return semJogar;
	}

	public void setSemJogar(int semJogar) {
		this.semJogar = semJogar;
	}

	public int getParar() {
		return Parar;
	}

	public void setParar(int parar) {
		Parar = parar;
	}

	public int getContador() {
		return Contador;
	}

	public void setContador(int contador) {
		Contador = contador;
	}

	public int getContaJogadas() {
		return contaJogadas;
	}

	public void setContaJogadas(int contaJogadas) {
		this.contaJogadas = contaJogadas;
	}
	

	public int getSemjogar() {
		return semjogar;
	}

	public void setSemjogar(int semjogar) {
		this.semjogar = semjogar;
	}

	
	

}
