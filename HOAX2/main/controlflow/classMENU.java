package controlflow;

import java.util.Scanner;

public class classMENU {
	private String _name1;
	private String _letter1;
	private String _name2;
	private String _letter2;
	private int[][] _character = new int[12][12];
	private int mnWidth;
	private int mnHeight;
	
	public void setWidth(int value) {
		mnWidth = value;
	}
	
	public void setHeight(int value) {
		mnHeight = value;
	}
	
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
	
	public void setCharacter(int nCol, int nRow, int value) {
		_character[nCol-1][nRow-1] = value;
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
		System.out.println("[5] ChangeWidth = "+mnWidth);
		System.out.println("[6] ChangeHeight = "+mnHeight);
		System.out.println("[7] StartGame");
		System.out.println("[8] EXIT");
		System.out.println("======================");
	}
	
	private String fWord(int nCol, int nRow) {
		switch(_character[nCol-1][nRow-1]) {
		case 1:
			return _letter1;
		case 2:
			return _letter2;
		default:
			return "^";
		}	
	}
	
	private void fDisplayBoard() {
		String sWord1, sWord2, sWord3;
		String sLine, sText;
		
		System.out.println("======================");
		System.out.println("BOARD");
		System.out.println("======================");
	
		for (int i=1;i<=mnHeight;i++) {
			sLine = "";
			for (int j=1;j<=mnWidth;j++) {
				sLine = sLine + fWord(j,i);
			}
			System.out.println(sLine);			
		}
		System.out.println("======================");
	}
	
	public int fProcess() {
		int nAnswer;
		Scanner input = new Scanner(System.in);
		
		nAnswer=input.nextInt();
		
		return nAnswer;
	}
}