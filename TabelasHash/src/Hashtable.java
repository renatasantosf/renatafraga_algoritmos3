
class HashElement {
	public final String key;
	public final String value;
	
	public HashElement(String k, String v) {
		this.key = k;
		this.value = v;
	}
}


public class Hashtable {
	private HashElement[] table = new HashElement[10];
	
	public static void main(String...args) {
		Hashtable table = new Hashtable();
		
		String[] ks = {"123","124","125","130","423","612"};
		String[] vs = {"Rafael","Ivonei","Antonio",
			       "Guilherme","Marcelo","Aline"};
		
		for(int i = 0; i < ks.length; i++){
			String key = ks[i], value = vs[i];
			System.out.println("Inserindo ("+ key + " , "+ value + " ) ");
			table.put(key,value);
			
		}
		for(int i=0; i<ks.length;i++) {
			System.out.println(ks[i] + " - " + table.get(ks[i]));
		}
	}
	
	private String get(String key) {
		int hk  = hash(key);
		int i = hk % table.length;
		for(int j=0; j<table.length;j++) {
			i = (i+j) % table.length;
			if(table[i] != null && table[i].key.equals(key)) {
				return table[i].value;
			}
		}
		return null;
	}
	
	private void put(String key, String value) {
		int hk = hash(key);
		System.out.println("Key: " + key + " - H(k): "+hk);
		
		int i = hk % table.length;
		
		for(int j=0; j<table.length;j++) {
			//linear probing
			i = (i + j) % table.length;
			// quadratic probing
			i = (i + j*j) % table.length;
			i = (i + (1 << j)) % table.length;
			//double hashing
			int hk2 = hash(String.format("%s%d", key, hk));
			System.out.println("H1 = "+ hk + " - H2 = "+hk2);
			i = (hk + j*hk2) % table.length;
			i = i<0 ? -1 * i : i;
			
			System.out.println("Testando na posicao: "+ i);
			if(table[i] == null || table[i].key.equals(key)) {
				table[i] = new HashElement(key, value);
				break;
			}
		}
	}
	
	public int hash(String key) {
		int prime = 31;
		for(char c: key.toCharArray()) {
			prime = (prime + c) << 4 + (c & 0x0F);
		}
		return prime;
	}
	
}
