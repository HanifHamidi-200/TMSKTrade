package controlflow;

import java.util.Scanner;

public class classMENU {
	public void fDisplay() {
	
		System.out.println("======================");
		System.out.println("MainMenu");
		System.out.println("======================");
		System.out.println("[1] CBCB did actually payoff");
		System.out.println("[2] ECPLAN sees ItsDemise");
		System.out.println("[3] TRAQNR sustains damage");
		System.out.println("[4] ROOFEG sees Visibility");
		System.out.println("[5] CANDST makes remarks");
		System.out.println("[6] DENTML has resoundings");
		System.out.println("[7] HSHAFF has its BestLap");
		System.out.println("[8] DELPIA retakes exam");
		System.out.println("[9] MOARCH is reimbursed");
		System.out.println("[10] EXIT");
		System.out.println("======================");
	}
	
	public int fProcess() {
		int nAnswer;
		Scanner input = new Scanner(System.in);
		
		nAnswer=input.nextInt();
		
		return nAnswer;
	}
}