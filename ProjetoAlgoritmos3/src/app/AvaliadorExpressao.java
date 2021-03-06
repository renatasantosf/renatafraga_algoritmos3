package app;

import java.util.Scanner;

public class AvaliadorExpressao {
	
	public static String texto() {
		Scanner ler = new Scanner(System.in);
		String texto = ler.next();
		return texto;
		
	}
	
	
	public static void main (String[] args){
		
		
	}
	public String verificar(String cell) {	

		Scanner entrada = new Scanner(cell);
		
		Pilha<Double> pilha = new Pilha<>();
		
		while (entrada.hasNext()) {
			if(entrada.hasNextDouble()) {
				pilha.push(entrada.nextDouble());
			}
			
			if(entrada.hasNext("[+-/*]")) {
				double rhs = pilha.pop();
				double lhs = pilha.pop();
				
				switch(entrada.next()) {
					case "/":
						pilha.push(lhs / rhs);
						break;
					case "*":
						pilha.push(lhs * rhs);
						break;
					case "+":
						pilha.push(lhs + rhs);
						break;	
					case "-":
						pilha.push(lhs - rhs);
						break;					
				}
				
			}
			
		}
		
		return ""+pilha.pop();
	}
	

}
