package controlflow;

import java.util.Scanner;

public class classMENU {
	private String _name1;
	private String _letter1;
	private String _name2;
	private String _letter2;
	private int[] _character = new int[9];
	
	public void setName1(String value) {
		_name1 = value;
	}
	
	public void setLetter1(String value) {
		_letter1 = value;
	}
	
	public void setName2(String value) {
		_name2 = value;
	}
	
	public void setLetter2(String value) {
		_letter2 = value;
	}
	
	public void setCharacter(int pos, int value) {
		_character[pos-1] = value;
	}
	
	public int getCharacter(int pos) {
		return _character[pos-1];
	}

	public void fDisplay() {
	
		fDisplayBoard();
		System.out.println("======================");
		System.out.println("MainMenu");
		System.out.println("======================");
		System.out.println("[1] Update Name1 = "+_name1);
		System.out.println("[2] Update Letter1 = "+_letter1);
		System.out.println("[3] Update Name2 = "+_name2);
		System.out.println("[4] Update Letter2 = "+_letter2);
		System.out.println("[5] StartGame");
		System.out.println("[6] EXIT");
		System.out.println("======================");
	}
	
	private String fWord(int pos) {
		switch(_character[pos-1]) {
		case 1:
			return _letter1;
		case 2:
			return _letter2;
		default:
			return "[-]";
		}	
	}
	
	private void fDisplayBoard() {
		String sWord1, sWord2, sWord3;
		String sLine;
		
		System.out.println("======================");
		System.out.println("BOARD");
		System.out.println("======================");
	
		sWord1 = fWord(7);
		sWord2 = fWord(8);
		sWord3 = fWord(9);
		sLine = sWord1 + sWord2 +sWord3;
		System.out.println(sLine);
		
		sWord1 = fWord(4);
		sWord2 = fWord(5);
		sWord3 = fWord(6);
		sLine = sWord1 + sWord2 +sWord3;
		System.out.println(sLine);

		sWord1 = fWord(1);
		sWord2 = fWord(2);
		sWord3 = fWord(3);
		sLine = sWord1 + sWord2 +sWord3;
		System.out.println(sLine);
	
		System.out.println("======================");
	}
	
	public int fProcess() {
		int nAnswer;
		Scanner input = new Scanner(System.in);
		
		nAnswer=input.nextInt();
		
		return nAnswer;
	}
}