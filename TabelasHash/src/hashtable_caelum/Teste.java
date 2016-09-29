package hashtable_caelum;

public class Teste {
	public static void main(String[] args) {
	    	ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

		    conjunto.adiciona("Bianca");
		    conjunto.adiciona("Brenda");
		    conjunto.adiciona("Bruno");
		    conjunto.adiciona("Atlas");
	    	conjunto.adiciona("Georgiana");

	    	
	   
		    java.util.List<String> palavras = conjunto.listar();

		    System.out.println("antes de remover");
		    for (String palavra : palavras) {
		      System.out.println(palavra);
		    }
		    
		    conjunto.remove("Georgiana");
		    
		    palavras = conjunto.listar();
		    
		    System.out.println("depois de remover");        
		    for (String palavra : palavras) {
		      System.out.println(palavra);
		    }
	    
	    
	  }
}
