package controller;

import java.util.Scanner;

import javax.swing.JTable;

import app.AvaliadorExpressao;
import app.Celula;
import app.Pilha;
import model.SpreadsheetModel;
import view.Spreadsheet;

public class CalcMachine {
	
	AvaliadorExpressao av = new AvaliadorExpressao();
        Celula celula;
        Pilha<Celula> pilha = new Pilha<>();

	public static void main(String[] args) {
		(new CalcMachine()).run();
	}

	private void run() {
		SpreadsheetModel m = new SpreadsheetModel() {
			@Override
			public void setFormula(String cell, String formula) {
                                celula = new Celula(cell,formula,av.verificar(formula));
                                pilha.push(celula);
                                System.out.println(pilha.peek());
                               
                               
                               
			}
			
			@Override
			public String getValue(String cell) {
                           switch(cell) {
                               default: 
                                   return "0";
                           }
                            
                             
          
                            
                        }

			@Override
			public String getFormula(String cell) {
				switch(cell) {
					default:
						return "0";
				}
				
			}
		};
		
		(new Spreadsheet(m)).start();
	}
}
