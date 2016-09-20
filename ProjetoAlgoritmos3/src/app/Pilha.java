package app;

public class Pilha<T> {
	
	private ListaEncadeada<T> lista = new ListaEncadeada<>();
	
	public void push(T valor){
		lista.append(valor);	
	}
	
	public boolean isEmpty(){ 
		return lista.isEmpty();
	}
	
	public T peek(){
		return lista.getLast();
	}
	
	public T pop(){
		
		T valor = peek();
		lista.removeLast();
		return valor;
		
	}
	
	public static void main(String... args) {
		Pilha<Integer> pilha = new Pilha<>();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
	}
}
