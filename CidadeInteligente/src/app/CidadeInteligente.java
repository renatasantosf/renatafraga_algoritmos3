package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import gtfs.Route;

/*
 * Objetivo: Criar uma estrutura que permita processar os dados
 * de rotas do arquivo routes.txt provido pelo site datapoa.com.br
 * como parte do conjunto de dados GTFS. 
 */

public class CidadeInteligente {

	public static void main(String[] args) {
		
		
		try {
			FileReader rotas = new FileReader("data/routes.txt");
			Scanner ler = new Scanner(rotas).useDelimiter("[,\n]");
			ler.nextLine(); 

			while(ler.hasNext()){
				Route rota = new Route(ler.next());
				ler.next(); // pula agency_id
				rota.setShortName(ler.next());
				rota.setLongName(ler.next());
				ler.next(); // pula desc
				rota.setType(ler.nextInt());
				ler.next(); // pula url
				rota.setColor(ler.next());
				rota.setTextColor(ler.next());
				System.out.println(rota.getLongName());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		           
	}

}
