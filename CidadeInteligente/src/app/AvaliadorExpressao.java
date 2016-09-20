package app;

import java.util.Scanner;

public class AvaliadorExpressao {
	
	public static void main (String[] args){
		
		Scanner entrada = new Scanner("4 2 / 4 + 2 * 8 -");

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
		
		System.out.println(pilha.pop());
		
	}

}
