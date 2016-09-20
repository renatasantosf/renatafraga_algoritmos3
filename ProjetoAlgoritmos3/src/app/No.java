package app;

public class No<T> {

	private T valor;
	private No<T> previous;
	private No<T> next;

	public No(T valor) {
		this.valor = valor;
	}

	public void setPrevious(No<T> elemento) {
		this.previous = elemento;
		
	}

	public void setNext(No<T> elemento) {
		this.next = elemento;
		
	}

	public No<T> getNext() {
		return next;
	}

	public T getValue() {
		return valor;
	}

	public No<T> getPrevious() {
		return previous;
	}

}
