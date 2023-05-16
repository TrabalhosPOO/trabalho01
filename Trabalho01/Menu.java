package Trabalho01;

public class Menu {

	public static void main(String[] args) {
		
		Dados d1 = new Dados();
		
		Jogador n1 = new Normal("Preto");
		Jogador s1 = new Sortudo("Verde");
		Jogador a1 = new Azarado("Branco");
		
		d1.inscreverJogadores(n1);
		d1.inscreverJogadores(s1);
		d1.inscreverJogadores(a1);
		d1.status();
		
		d1.ResultadoDados(n1.jogarDados());
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
		d1.ResultadoDados(a1.jogarDados());
		
		d1.ResultadoDados(n1.jogarDados());
		d1.ResultadoDados(s1.jogarDados());
		d1.ResultadoDados(a1.jogarDados());

		d1.ResultadoDados(n1.jogarDados());
		d1.ResultadoDados(s1.jogarDados());
		d1.ResultadoDados(a1.jogarDados());

		
	}

}
