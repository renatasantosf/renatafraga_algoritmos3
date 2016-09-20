package algorithms;

import java.util.Comparator;
import java.util.Iterator;

public class Sorting {

	private static <T>
	void compara(T a, T b, Comparator<T> comp)
	{
		if (comp.compare(a,b) < 0)
			System.out.println(a + " e menor");
		else
			System.out.println("Sao iguais ou " + b + " e menor");
	}

	public static void main(String[] args) {
		
		Integer [] v = {5,6,12,17,20,7,1,9,13};
		String a = "Ivonei";
		String b = "Rafael";
		
		insertSort(v,(i,j)->i-j);
		for (Integer i : v) {
			System.out.println(i);
			
		}
		
		/// THE JAVA 8 WAY !!!!!! -------> LAMBDA
		compara(a,b, (i,j) -> i.compareTo(j) );
	}

	private static <T> void bubbleSort(T[] v, Comparator<T> comp) {
		for (int i = 0; i < v.length; i++) {
			boolean troca = false;
			for (int j = 0; j < v.length-i-1; j++) {
				if(comp.compare(v[j+1],v[j]) < 0 ){
					troca(v,j,j+1);
					troca = true;
				}
			}
			if(!troca){
				return; 
			}
		}
		
	}
	
	private static <T> void selectionSort(T[] v, Comparator<T> comp){
		for (int i = 0; i < v.length; i++) {
			T min = v[i];
			int n=i;
			for (int j = i; j < v.length; j++) {
				if(comp.compare(v[j], min) < 0){
					min = v[j];
					n=j;	
				}
				
			}
			if(n!=i){
				troca(v,i,n);
			}
			
		}
	}
	
	private static <T> void insertSort(T[] v, Comparator<T> comp){
		for (int i = 1; i < v.length; i++){
			for(int j = i;j > 0 && comp.compare(v[j], v[j-1]) < 0;  j--) {
				troca(v,j,j-1);
			}
		}
	}
	private static <T> void troca(T[] v, int j, int i) {
		T aux=v[i];
		v[i]=v[j];
		v[j]=aux;
		
	}

	

}
