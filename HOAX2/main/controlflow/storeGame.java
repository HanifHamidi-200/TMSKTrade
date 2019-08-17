package controlflow;

import java.util.Random;
import java.util.Scanner;

public class storeGame {
	private int mnMove;
	private int mnTurn;
	private int mnCol, mnRow;
	private int[][] _character = new int[12][12];
	private int mnWidth;
	private int mnHeight;

	public void setWidth(int value) {
		mnWidth = value;
	}
	
	public void setHeight(int value) {
		mnHeight = value;
	}
	
	public storeGame(){
		mnMove = 1;
		mnTurn = 1;
		mnCol = 0;
		mnRow = 0;
	}
	
	public void fStart() {
		mnMove = 1;
		mnTurn = 1;	
		mnCol = 0;
		mnRow = 0;
	}

	private boolean fEven(int value) {
		boolean bFound = false;
		
		if(value>2) {
			do {
				value-=2;
				if (value<=1) {
					bFound = true;
				}
			} while (!bFound);			
		}
		
		if (value==1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private int fTurn(int nMove) {
		if (fEven(nMove)) {
			return 2;
		}
		else {
			return 1;
		}
	}
	
	public int getMove() {
		return mnMove;
	}
	public int getTurn() {
		mnTurn = fTurn(mnMove);
		return mnTurn;
	}
	public int getCol() {
		return mnCol;
	}
	public int getRow() {
		return mnRow;
	}
	
	public void setCharacter(int nCol, int nRow, int value) {
		_character[nCol-1][nRow-1] = value;
	}
	public int getCharacter(int nCol, int nRow) {
		return _character[nCol-1][nRow-1];
	}

	private boolean fFree(int nCol) {
		for (int i=mnHeight;i>=1;i--) {
			if (_character[nCol-1][i-1]==3) {
				return true;
			}
		}
		
		return false;
	}
	
	private int fNext(int nCol) {
		for (int i=mnHeight;i>=1;i--) {
			if (_character[nCol-1][i-1]==3) {
				return i;
			}
		}
		
		return 0;	
	}
	
	public boolean fMove(int nCol, int value) {
		if (nCol>=1 && nCol <=mnWidth) {
			if (fFree(nCol)) {
				mnCol = nCol;
				mnRow = fNext(nCol);
				mnMove = value;
				return true;
			}							
		}
		
		return false;
	}
	
	public int fMoveRandom(int value) {
		Random rnd1 = new Random();
		boolean bFound = false;
		int nCol, nRow;
		
		do {
			nCol = rnd1.nextInt(mnWidth)+1;
			if (fFree(nCol)) {
				mnCol = nCol;
				mnRow = fNext(nCol);
				mnMove = value;
				return nCol;
			}			
		} while (!bFound);
		
		return 0;
	}
	
	public int fProcess() {
		int nAnswer;
		Scanner input = new Scanner(System.in);
		
		nAnswer=input.nextInt();
		
		return nAnswer;
	}
}
