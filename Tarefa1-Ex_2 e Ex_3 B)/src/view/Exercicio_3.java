package view;

import model.ListaEncadeadaSimples_TipoGenerico;

public class Exercicio_3 {

	public static void main(String[] args) throws Exception {
		int[] vet = { 3, 5, 18, 12, 9, 7, 6, 2, 13, 4, 16 };

		ListaEncadeadaSimples_TipoGenerico<Integer> listaInicial = new ListaEncadeadaSimples_TipoGenerico<>();
		ListaEncadeadaSimples_TipoGenerico<Integer> listaFinal = new ListaEncadeadaSimples_TipoGenerico<>();

		System.out.println("Lista inicial");// Exibe Lista

		for (int i : vet) {// Preenche Lista
			listaInicial.addLast(i);
		}
		for (int no = 0; no < listaInicial.size(); no++) {
			System.out.print(listaInicial.getValue(no) + " ");
		}
		System.out.println();// quebra Linha

		
		System.out.println("Lista Final");

		for (int ctd = 10; ctd >= 0; ctd--) {// Preenche a listaFinal
			listaFinal.addLast(listaInicial.getValue(ctd));
		}
		for (int no = 0; no < listaFinal.size(); no++) {// Exibe Lista Invertida
			System.out.print(listaFinal.getValue(no) + " ");
		}
	}
}