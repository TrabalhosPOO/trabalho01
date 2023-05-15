package Trabalho01;

public class Menu {

	public static void main(String[] args) {
		Dados d1 = new Dados("Preto");
		Dados d2 = new Dados("Branco");
		Dados d3= new Dados("Verde");
		
		Normal n1 = new Normal("Preto");
		Azarado a1 = new Azarado("Branco");
		Sortudo s1 = new Sortudo("Verde");

		
		n1.inscreverJogadores(d1);
		a1.inscreverJogadores(d2);
		s1.inscreverJogadores(d3);
		
		n1.jogarDados(d1);
		a1.jogarDados(d2);
		s1.jogarDados(d3);
		
		n1.jogarDados(d1);
		a1.jogarDados(d2);
		s1.jogarDados(d3);
		
		n1.jogarDados(d1);
		a1.jogarDados(d2);
		s1.jogarDados(d3);
		
		n1.jogarDados(d1);
		a1.jogarDados(d2);
		s1.jogarDados(d3);
	}

}
