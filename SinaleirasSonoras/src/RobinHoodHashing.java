import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RobinHoodHashing<K,V> {
			
			private class HashEntry {
				public final K key;
				public final V value;
				public int distance;
				public boolean deleted;
				
				public HashEntry(K key, V value) {
					this.key = key;
					this.value = value;
					this.distance = 0;
					this.deleted = false;
				}
			}

			private int numElementos = 0;
			
			private Object[] table = new Object[10];
			private boolean rehashing = false;

			public RobinHoodHashing() {
			}

			public int size() {
				return numElementos;
			}

			public double loadFactor() {
				return numElementos / (1.0*table.length);
			}

			public void put(K key, V value) {
				int h = (key.hashCode() & 0x7FFFFFFF) % table.length;
				HashEntry entry = new HashEntry(key, value);
				insert(entry, h);
			}

			private void insert(HashEntry entry, int hash) {
				if (numElementos == table.length) {
					rehash(entry);
				} else {
					for (int i = 0; i < table.length; ++i) {
						int n = (hash + i) % table.length;
						@SuppressWarnings("unchecked")
						HashEntry candidate = (HashEntry)table[n];
						if (candidate == null) {
							entry.distance = i;
							table[n] = entry;
							numElementos++;
							return;
						}
						if (i > candidate.distance) {
							entry.distance = i;
							table[n] = entry;
							entry = candidate;
							i = entry.distance;
							hash = (entry.key.hashCode() & 0x7FFFFFFF) % table.length;
						}
					}
				}
			}

			private void rehash(HashEntry toRehash) {
				if (rehashing) {
					throw new IllegalStateException();
				}
				rehashing = true;
				Object[] oldTable = table;
				table = new Object[(table.length / 2) * 3];
				int oldCount = numElementos;
				numElementos = 0; 
				for (Object o : oldTable) {
					if (o != null) {
						@SuppressWarnings("unchecked")
						HashEntry candidate = (HashEntry)o;
						if (!candidate.deleted) {
							int h = (candidate.key.hashCode() & 0x7FFFFFFF) % table.length;
							HashEntry entry = new HashEntry(candidate.key, candidate.value);
							try {
								insert(entry, h);
							} catch (IllegalStateException e) {
								table = oldTable;
								numElementos = oldCount;
								throw new RuntimeException("Could not insert into table.");
							}
						}
					}
				}
				int h = (toRehash.key.hashCode() & 0x7FFFFFFF) % table.length;
				HashEntry entry = new HashEntry(toRehash.key, toRehash.value);
				insert(entry, h);
				rehashing  = false;
			}

			public V get(K key) {
				HashEntry entry = find(key);
				if (entry == null || entry.deleted)
					return null;
				return entry.value;
			}

			private HashEntry find(K key) {
				int h = (key.hashCode() & 0x7FFFFFFF) % table.length;
				for (int i = 0; i < table.length; ++i) {
					int n = (h + i) % table.length;
					@SuppressWarnings("unchecked")
					HashEntry candidate = (HashEntry)table[n];
					if (candidate == null || candidate.distance < i) {
						System.out.println(candidate.value.toString());
						return null;
					}
					if (candidate.key.equals(key)) {
						System.out.println(candidate.value.toString());
						return candidate;
					}
				}
				System.out.println(key + " not found after " + table.length + " tries.");
				return null;		
			}
			
			
			public static void main(String...args) throws FileNotFoundException {
				RobinHoodHashing<Integer,Local> rb = new RobinHoodHashing<>();
				
				try {
					FileReader locais = new FileReader("C:\\renatafraga_algoritmos3\\SinaleirasSonoras\\src\\sinaleiras.txt");
					@SuppressWarnings("resource")
					Scanner ler = new Scanner(locais).useDelimiter("[,]");
					
					
					Integer cont = 0;
					
					while(ler.hasNext()){
							
							Local local = new Local();
							local.setEndereco(ler.next());
							local.setDataImplantacao(ler.next());
							local.setBotoeira(ler.next());
							int random = 1 + (int) (Math.random() * 300);
							rb.put(random, local);
							rb.get(random);
							
					}
				
				}catch(FileNotFoundException ef){
					ef.printStackTrace();
				}
				System.out.println(rb.size());
				
		
			}
}
				
			
			
		
