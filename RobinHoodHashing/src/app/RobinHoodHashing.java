package app;


class HashElement {
	public final String key;
	public final String value;
	public HashElement(String k, String v) {
		key = k;
		value = v;
	}
}

public class RobinHoodHashing {

	private HashElement[] table = new HashElement[10];

	public static void main(String[] args) {
		RobinHoodHashing table = new RobinHoodHashing();
		
		
		//o array irá receber as rotas 
		//pegar o modelo de inserção do CidadeInteligente
		String[] ks = {"123","124","125","130","423","612"};
		String[] vs = {"Rafael","Ivonei","Antonio",
				       "Guilherme","Marcelo","Aline"};
		
		for (int i = 0; i < ks.length; i++) {
			String key = ks[i], value = vs[i];
			System.out.println("Inserindo (" + key + " , " + value + " )");
			table.put(key,value);
		}

		for (int i = 0; i < ks.length; i++) {
			System.out.println(ks[i] + " - " + table.get(ks[i]));
		}
	}

	private String get(String key) {
		int hk = hash(key);
		int i = hk % table.length;

		for (int j = 0; j < table.length; j++) {
			// linear probing
			i = (i + j) % table.length;
			if (table[i] != null && table[i].key.equals(key)) {	
				return table[i].value;
			}
		}
		return null;
	}

	private void put(String key, String value) {
		int hk = hash(key);
		System.out.println("Key: " + key + "  - H(k): " + hk);
		
		int i = hk % table.length;
		
		for (int j = 0; j < table.length; j++) {
			// linear probing
			//i = (i + j) % table.length;
			// quadratic probing
			//i = (i + j*j) % table.length;
			//i = (i + (1 << j)) % table.length;
			// double hashing
			int hk2 = hash(String.format("%s%d", key, hk));
			System.out.println("H1 = " + hk + " - H2 = " + hk2);
			i = (hk + j*hk2) % table.length;
			
			i = i < 0 ? -1*i : i;
			
			System.out.println("Testando na posicao: " + i);
			if (table[i] == null || table[i].key.equals(key)) {	
				table[i] = new HashElement(key,value);
				break;
			}
		}
	}

	public int hash(String key) {
		int prime = 31;
		for (char c : key.toCharArray()) {
			prime = (prime + c) << 4 + (c & 0x0F);
		}
		return prime;
	}
	
	public String consulta(String key){
		h = hash(key);
		i = , table.length);
	}
	
	/*function consulta(key) -> value
		h = hash(key)
		i = mod(h & 0x7ffffff, tabela.length)
		probe = 0
		enquanto ! livre(tabela) e probe <= tabela[i].probe
		se tabela[i].hash == h e tabela[i].key == key
		retorna tabela[i].value
		i = mod(i + 1, tabela.length)
		probe = probe + 1
		retorna NULL*/
	/*função insere (key, value)
		se tabela.cheia()
		rehash()
		h = hash(key)
		entrada = HashEntry(key, value, h)
		i = mod(h & 0x7ffffff, tabela.length)
		enquanto ! livre(tabela[i])
		se entrada.probe < tabela[i].probe
		swap(entrada, tabela[i])
		senao
		incerementa entrada.probe
		i = mod(i + 1, tabela.length)
		tabela.set(i, entrada)*/

}
