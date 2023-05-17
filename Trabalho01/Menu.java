package Trabalho01;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {
	Dados d1 = new Dados();

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Dados d1 = new Dados();
		int op = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n---- JOGO DE TABULEIRO ----\n");
		System.out.println("Quantos jogadores irão jogar?");
		int qtd = scanner.nextInt();
		scanner.nextLine();
		while(qtd<2){
			System.out.println("Impossivel iniciar com apenas UM participante, chame mais pessoas!");
			System.out.println("Quantos jogadores irão jogar?");
			qtd = scanner.nextInt();
			scanner.nextLine();
		}

		List<Class<? extends Jogador>> classesFilhas = new ArrayList<>();
		classesFilhas.add(Sortudo.class);
		classesFilhas.add(Azarado.class);
		classesFilhas.add(Normal.class);

		for (int i = 0; i < qtd; i++) {

			Random random = new Random();
			int indiceAleatorio = random.nextInt(classesFilhas.size());

			Class<? extends Jogador> classeEscolhida = classesFilhas.get(indiceAleatorio);

			Jogador jogador = null;
			jogador = classeEscolhida.getDeclaredConstructor().newInstance();
			System.out.println("\nDigite a cor do jogador " + (i + 1));
			String cor = scanner.nextLine();
			jogador.setCor(cor);
			d1.inscreverJogadores(jogador);

		}

		d1.status();
		System.out.println("\n\nPartida iniciada...");
		for (int i = 0; i < d1.Jogando.size(); i++) {
			System.out.println("");
			
			while (d1.Jogando.get(i).getCasa() != 40) {
				System.out.println("\nDigite 1 para jogar o dado:");
				op = scanner.nextInt();
				scanner.nextLine();
				if (op == 1) {
					d1.ResultadoDados(d1.Jogando.get(i).jogarDados());
					if (d1.Jogando.get(i).getCasa() == 40) {
						break;
					}
				} else{
					System.out.println("Opcao Invalida. Jogo encerrado.");
					d1.status();
					System.exit(0);
				}

			}

		}

	}

}
