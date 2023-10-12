package model;

public class ListaEncadeadaSimples_TipoGenerico<T> {

	No_ListaEncadeada<T> inicio;

	public boolean isEmpty() {// Lista Vazia?
		if (inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {// Tamanho Lista
		int tamanhoList = 0;

		if (!isEmpty()) {
			No_ListaEncadeada<T> auxiliar = inicio;

			while (auxiliar != null) {
				auxiliar = auxiliar.proximo;
				tamanhoList++;
			}

		}
		return tamanhoList;
	}

	public No_ListaEncadeada<T> getNo(int posicaoBuscada) throws Exception {// Pega Valor na Lista

		if (isEmpty()) {// Ta Vazia?
			throw new Exception("Lista Vazia");
		}

		int tamanhoLista = size();
		if ((posicaoBuscada < 0) || (posicaoBuscada > tamanhoLista - 1)) {// Posição está dentro da Lista?
			throw new Exception("Posição Inválida");
		}

		No_ListaEncadeada<T> auxiliar = inicio;
		int contador = 0;

		while (contador < posicaoBuscada) {
			contador++;
			auxiliar = auxiliar.proximo;
		}

		return auxiliar;
	}

	public void addFirst(T valor) {// adiciona elemento ao início da lista

		No_ListaEncadeada<T> novoInicio = new No_ListaEncadeada<>();// novo Nó
		novoInicio.dado = valor; // recebe o valor do "usuário"
		novoInicio.proximo = inicio;// Aponta para o antigo nó inicial
		inicio = novoInicio; // este se torna o novo nó inicial
	}

	public void addLast(T valor) throws Exception { // Adiciona valor ao final da Lista

		if (isEmpty()) {
			addFirst(valor);
			
		} else {
			No_ListaEncadeada<T> novoFim = new No_ListaEncadeada<>();
			novoFim.dado = valor;
			novoFim.proximo = null;

			No_ListaEncadeada<T> ultimo = getNo(size() - 1);
			ultimo.proximo = novoFim;
		}
	}

	public void add(T valor, int posicaoDesejada) throws Exception {

		int tamanho = size();

		if ((posicaoDesejada < 0) || (posicaoDesejada > tamanho)) {
			throw new Exception("Posição Inválida");
		}

		if (isEmpty()) {
			addFirst(valor);

		} else if (posicaoDesejada == tamanho) {
			addLast(valor);

		} else {
			No_ListaEncadeada<T> novoNo = new No_ListaEncadeada<>();
			novoNo.dado = valor;

			No_ListaEncadeada<T> anterior = getNo(posicaoDesejada - 1);
			novoNo.proximo = anterior.proximo;
			anterior.proximo = novoNo;
		}

	}

	public void removeFirst() throws Exception {// remove o Primeiro Item da Lista
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		inicio = inicio.proximo;
	}

	public void removeLast() throws Exception {// Remove o último item da Lista

		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();

		if (tamanho == 1) {
			removeFirst();

		} else {
			No_ListaEncadeada<T> penultimoNo = getNo(tamanho - 2);
			penultimoNo.proximo = null;
		}

	}

	public void remove(int posicaoQueSeraExcluida) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();

		if (tamanho == 1) {
			removeFirst();

		} else if (posicaoQueSeraExcluida == tamanho - 1) {
			removeLast();

		} else {
			No_ListaEncadeada<T> anterior = getNo(posicaoQueSeraExcluida - 1);
			No_ListaEncadeada<T> noQueSeraExcluido = getNo(posicaoQueSeraExcluida);
			anterior.proximo = noQueSeraExcluido.proximo;
		}

	}

	public T getValue(int posicaoDesejada) throws Exception {

		if (isEmpty()) {
			throw new Exception("Lista Vazia");

		} else if ((posicaoDesejada < 0) || (posicaoDesejada > size())) {
			throw new Exception("Posição Inválida");

		} else {
			No_ListaEncadeada<T> auxiliar = getNo(posicaoDesejada);
			return auxiliar.dado;
		}

	}

}
