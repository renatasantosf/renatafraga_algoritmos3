package controller;

import java.util.Scanner;

import javax.swing.JTable;

import app.AvaliadorExpressao;
import model.SpreadsheetModel;
import view.Spreadsheet;

public class CalcMachine {
	
	AvaliadorExpressao av = new AvaliadorExpressao();

	public static void main(String[] args) {
		(new CalcMachine()).run();
	}

	private void run() {
		SpreadsheetModel m = new SpreadsheetModel() {
			@Override
			public void setFormula(String cell, String formula) {
				System.out.println(cell + " : Resultado: "+av.verificar(formula));
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
				
				return  ""+cell;
			}
		};
		
		(new Spreadsheet(m)).start();
	}
}
