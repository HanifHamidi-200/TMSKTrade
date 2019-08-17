package controlflow;

import java.util.Random;
import java.util.Scanner;

public class storeGame {
	private int mnMove;
	private int mnTurn;
	private int mnSquare;
	private int[] _character = new int[9];

	public storeGame(){
		mnMove = 1;
		mnTurn = 1;
		mnSquare = 0;
	}
	
	public void fStart() {
		mnMove = 1;
		mnTurn = 1;	
		mnSquare = 0;
	}

	private int fTurn(int nMove) {
		switch(nMove) {
		case 2:
			return 2;
		case 4:
			return 2;
		case 6:
			return 2;
		case 8:
			return 2;
		default:
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
	public int getSquare() {
		return mnSquare;
	}
	
	public boolean setMove(int value) {
		if (value<=9) {
			mnMove = value;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setCharacter(int pos, int value) {
		_character[pos-1] = value;
	}
	public int getCharacter(int pos) {
		return _character[pos-1];
	}

	private boolean fFree(int pos) {
		if(_character[pos-1]==3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean fMove(int nSquare, int value) {
		if (nSquare>=1 && nSquare <=9) {
			if (fFree(nSquare)) {
				if (value<=9) {
					mnSquare = nSquare;
					mnMove = value;
					return true;
				}
			}			
		}
		
		return false;
	}
	
	public int fMoveRandom(int value) {
		Random rnd1 = new Random();
		boolean bFound = false;
		int nSquare;
		
		do {
			nSquare = rnd1.nextInt(9)+1;
			if (fFree(nSquare)) {
				if (value<=9) {
					mnSquare = nSquare;
					mnMove = value;
					return nSquare;
				}
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
