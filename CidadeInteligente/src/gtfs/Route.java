package gtfs;

public class Route {
	private String id;
	// TODO: Criar Classe Agencia
	// private Agencia agency_id;
	private String shortName;
	private String longName;
	private int type;
	// TODO: Trocar para classe cor
	private String color;
	private String textColor;
	
	public Route(String id) {
		this.id = id;
	}
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getId() {
		return id;
	}	
}
