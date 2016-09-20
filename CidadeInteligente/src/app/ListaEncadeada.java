package app;

public class ListaEncadeada<T> implements Iterable<T> {
	private No<T> head;
	private No<T> tail;
	
	private class ListaIterador implements Iterador<T> {

		private No<T> atual = null;
		
		@Override
		public boolean hasNext() {
			if (atual == null)
				return head != null;
			else
				return atual.getNext() != null;
		}

		@Override
		public T next() {
			if (atual == null)
				atual = head;
			else
				atual = atual.getNext();
			return atual.getValue();
		}

		@Override
		public void append(T valor) {
			if (atual == null)
				throw new IllegalStateException("Use next()!");
			No<T> elemento = new No<>(valor);
			No<T> proximo = atual.getNext();
			elemento.setNext(proximo);
			elemento.setPrevious(atual);
			atual.setNext(elemento);
			if (proximo == null) {
				tail = elemento;
			} else {
				proximo.setPrevious(elemento);
			}
		}

		@Override
		public void insert(T valor) {
			if (atual == null)
				throw new IllegalStateException("Use next()!");
			No<T> elemento = new No<>(valor);
			No<T> anterior = atual.getPrevious();
			elemento.setNext(atual);
			elemento.setPrevious(anterior);
			atual.setPrevious(elemento);
			if (anterior == null) {
				head = elemento;
			} else {
				anterior.setNext(elemento); 
			}
		}
		
	}
	
	public void addFirst(T valor) {
		No<T> elemento = new No<>(valor);
		
		if (head == null) {
			tail = elemento;
		} else {
			elemento.setNext(head);
			head.setPrevious(elemento);
		}
		
		head = elemento; 
	}
	
	public void append(T valor) {
		No<T> elemento = new No<>(valor);
		
		if (this.head == null) {
			this.head = elemento;
		} else {
			elemento.setPrevious(this.tail);
			this.tail.setNext(elemento);
		}
		
		this.tail = elemento;
		
	}
	
	public Iterador<T> iterator(){
		return new ListaIterador();
	}

	public static void main(String... args) {
		ListaEncadeada <Integer> lista = new ListaEncadeada<>();
		lista.append(1);
		lista.append(2);
		lista.append(3);
		lista.addFirst(0);
		
		for (Integer i : lista)
			System.out.print( i + ", " );
		System.out.println();
		
		System.out.println("======");
		
		Iterador<Integer> iter = lista.iterator();
		iter.next();
		iter.insert(100);
		iter.append(50);
		iter.next();
		iter.next();
		iter.next();
		iter.insert(100);
		iter.append(50);

		for (Integer i : lista)
			System.out.print( i  + ", ");
		System.out.println();
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public T getLast() {
		if (isEmpty()){
			return null;
		}
		
		return tail.getValue();
	}

	
	public void removeLast() {
		
		if (isEmpty()) {
			return;
		}
		
		if (tail == head) {
			tail = head = null;
			
		} else {
			No<T> anterior = tail.getPrevious();
			anterior.setNext(null);
			tail = anterior;
			
		}
		
		
		
	}

}
