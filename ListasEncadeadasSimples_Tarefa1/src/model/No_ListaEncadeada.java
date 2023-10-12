package model;

public class No_ListaEncadeada<T> {

	T dado;// Tipo generido de dado
	No_ListaEncadeada<T> proximo;// Ponteiro para proximo dado da lista

	public String toString() {
		return (String) dado;// Mostra como String o dado que está contido neste nó.
	}
}