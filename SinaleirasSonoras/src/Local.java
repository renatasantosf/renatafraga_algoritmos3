
public class Local {
	private String endereco;
	private String dataImplantacao;
	private String botoeira;
	
	
	public Local() {
		
	}


	public Local(String endereco, String data, String botoeira) {
		this.endereco = endereco;
		this.dataImplantacao = data;
		this.botoeira = botoeira;
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


	public String getBotoeira() {
		return botoeira;
	}


	public void setBotoeira(String string) {
		this.botoeira = string;
	}


	@Override
	public String toString() {
		return "Endereço: " + endereco + "- Data de implantação: " + dataImplantacao + " - Botoeira: " + String.valueOf(botoeira);
	}
	
	
	
	
}
