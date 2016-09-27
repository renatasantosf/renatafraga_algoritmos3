package app;

public class Celula {
	private String indice;
	private String formula;
	private String valor;

        public Celula(String indice, String formula, String valor) {
            this.indice = indice;
            this.formula = formula;
            this.valor = valor;
        }
           
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

    @Override
    public String toString() {
        return "Célula: " + indice + " Fórmula: " + formula + " Resultado: " + valor;
    }
	
	
	
}
