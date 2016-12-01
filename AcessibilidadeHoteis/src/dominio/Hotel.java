package dominio;

public class Hotel {
	private String id;
	private String nomeHotel;
	private String telefone;
	private String endereco;
	private String bairro;
	
	public Hotel() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getNomeHotel() {
		return nomeHotel;
	}
	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	@Override
	public String toString() {
		return "Id:" + id + " Nome Hotel:" + nomeHotel + " Telefone: " + telefone + " Endereço: " + endereco
				+ " Bairro: " + bairro;
	}
	
	
}
