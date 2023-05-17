package Trabalho01;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Dados d1 = new Dados();

		Normal n1 = new Normal("Preto");
		Sortudo s1 = new Sortudo("Verde");
		Azarado a1 = new Azarado("Branco");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Quantos jogadores irão jogar?");
		int qtd = scanner.nextInt();
		scanner.nextLine();

		List<Class<? extends Jogador>> classesFilhas = new ArrayList<>();
		classesFilhas.add(Sortudo.class);
		classesFilhas.add(Azarado.class);
		classesFilhas.add(Normal.class);

		for (int i = 0; i < qtd; i++) {
			// Gerar um número aleatório
			Random random = new Random();
			int indiceAleatorio = random.nextInt(classesFilhas.size());

			// Obter a classe correspondente ao número aleatório
			Class<? extends Jogador> classeEscolhida = classesFilhas.get(indiceAleatorio);

			// Instanciar a classe escolhida
			Jogador jogador = null;
			jogador = classeEscolhida.getDeclaredConstructor().newInstance();
			System.out.println("Digite a cor do jogador "+ (i+1));
			String cor = scanner.nextLine();
			jogador.setCor(cor);
			d1.inscreverJogadores(jogador);
			

		}

		d1.status();
		System.out.println("\n\nPartida iniciada...\n\n");
		for(int i=0; i<d1.Jogando.size();i++){
			while(d1.Jogando.get(i).getCasa()!=40){
				d1.ResultadoDados(d1.Jogando.get(i).jogarDados());
				if(d1.Jogando.get(i).getCasa()==40){
					break;
				}
			}
		}

		/*d1.ResultadoDados(n1.jogarDados());
		d1.ResultadoDados(s1.jogarDados());
		d1.ResultadoDados(a1.jogarDados());

		d1.ResultadoDados(n1.jogarDados());
		d1.ResultadoDados(s1.jogarDados());
		d1.ResultadoDados(a1.jogarDados());

		d1.ResultadoDados(n1.jogarDados());
		d1.ResultadoDados(s1.jogarDados());
		d1.ResultadoDados(a1.jogarDados());

		d1.ResultadoDados(n1.jogarDados());
		d1.ResultadoDados(s1.jogarDados());
		d1.ResultadoDados(a1.jogarDados());*/

	}

}
