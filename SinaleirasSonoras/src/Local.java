
public class Local {
	private String endereco;
	private String dataImplantacao;
	private int botoeira;
	
	
	public Local() {
	
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getDataImplantacao() {
		return dataImplantacao;
	}


	public void setDataImplantacao(String dataImplantacao) {
		this.dataImplantacao = dataImplantacao;
	}


	public int getBotoeira() {
		return botoeira;
	}


	public void setBotoeira(int botoeira) {
		this.botoeira = botoeira;
	}


	@Override
	public String toString() {
		return "Local [endereco=" + endereco + ", dataImplantacao=" + dataImplantacao + ", botoeira=" + botoeira + "]";
	}
	
	
	
	
}
