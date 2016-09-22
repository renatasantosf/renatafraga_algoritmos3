package app;

public class Coluna {
	
	private ListaEncadeada<Celula> lista;
	private String indice;
	public ListaEncadeada<Celula> getLista() {
		return lista;
	}
	public void setLista(ListaEncadeada<Celula> lista) {
		this.lista = lista;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public Coluna(ListaEncadeada<Celula> lista, String indice) {
		this.lista = lista;
		this.indice = indice;
	}
	
	
	
}
