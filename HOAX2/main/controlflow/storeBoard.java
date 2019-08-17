package controlflow;

import java.util.Scanner;

public class storeBoard {
	private int[][] _character = new int[12][12];
	private int mnWidth;
	private int mnHeight;
	
	public storeBoard(int nWidth, int nHeight) {
		mnWidth = nWidth;
		mnHeight = nHeight;
		fStart();
	}
	
	public void setWidth(int value) {
		mnWidth = value;
	}
	
	public int getWidth() {
		return mnWidth;
	}

	public void setHeight(int value) {
		mnHeight = value;
	}
	
	public int getHeight() {
		return mnHeight;
	}

	public void setCharacter(int nCol, int nRow, int value) {
		_character[nCol-1][nRow-1] = value;
	}
	
	public int getCharacter(int nCol, int nRow) {
		return _character[nCol-1][nRow-1];
	}
	
	public void fStart() {
		for (int i=1;i<=12;i++) {
			for (int j=1;j<=12;j++) {
				_character[i-1][j-1] = 3;				
			}
		}
	}
	
	public int fProcess() {
		int nAnswer;
		Scanner input = new Scanner(System.in);
		
		nAnswer=input.nextInt();
		
		return nAnswer;
	}
}