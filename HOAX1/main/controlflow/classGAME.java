package controlflow;

public class classGAME {
	private int[] _character = new int[9];
	private String _letter1;
	private String _letter2;
	private int mnComplete;
	
	public boolean setMove(int pos, int turn) {
		if (turn<=2) {
			_character[pos-1] = turn;
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

	public void setLetter1(String value) {
		_letter1 = value;
	}
	

	public void setLetter2(String value) {
		_letter2 = value;
	}
	

	public void fDisplay() {
		fDisplayBoard();
		System.out.println("======================");
		System.out.println("OPTIONS");
		System.out.println("======================");
		System.out.println("[1] SelectMove");
		System.out.println("[2] RandomMove");
		System.out.println("[3] CompleteSquare");
		System.out.println("[4] DETECTWin");
		System.out.println("[5] CANCELGame");
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

	private boolean fLineExists(int nCharacter, int X1, int X2, int X3) {
		mnComplete = 0;
		if (_character[X1-1]==nCharacter && _character[X2-1]==nCharacter && _character[X3-1]==0) {
			mnComplete = X3;
			return true;
		}		
		else if (_character[X1-1]==nCharacter && _character[X2-1]==0 && _character[X3-1]==nCharacter) {
			mnComplete = X2;
			return true;
		}	
		else if (_character[X1-1]==0 && _character[X2-1]==nCharacter && _character[X3-1]==nCharacter) {
			mnComplete = X1;
			return true;
		}	
		else {
			return false;
		}
	}
	
	public int fCompleteSquare() {
		int nCharacter = 1;
		int nReturn;
		
		if (fLineExists(nCharacter, 7, 8, 9)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 4, 5, 6)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 1, 2, 3)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 7, 4, 1)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 8, 5, 2)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 9, 6, 3)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 7, 5, 3)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 9, 5, 1)) {
			return mnComplete;
		}
		
		nCharacter = 2;
		if (fLineExists(nCharacter, 7, 8, 9)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 4, 5, 6)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 1, 2, 3)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 7, 4, 1)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 8, 5, 2)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 9, 6, 3)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 7, 5, 3)) {
			return mnComplete;
		}
		else if (fLineExists(nCharacter, 9, 5, 1)) {
			return mnComplete;
		}
		else {
			return 0;
		}
		
	}
	
	public int fDetectWin() {
		int nCharacter = 1;
		
		if (_character[7-1]==nCharacter && _character[8-1]==nCharacter && _character[9-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[4-1]==nCharacter && _character[5-1]==nCharacter && _character[6-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[1-1]==nCharacter && _character[2-1]==nCharacter && _character[3-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[7-1]==nCharacter && _character[4-1]==nCharacter && _character[1-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[8-1]==nCharacter && _character[5-1]==nCharacter && _character[2-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[9-1]==nCharacter && _character[6-1]==nCharacter && _character[3-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[7-1]==nCharacter && _character[5-1]==nCharacter && _character[3-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[9-1]==nCharacter && _character[5-1]==nCharacter && _character[1-1]==nCharacter) {
			return nCharacter;
		}
		
		nCharacter = 2;
		if (_character[7-1]==nCharacter && _character[8-1]==nCharacter && _character[9-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[4-1]==nCharacter && _character[5-1]==nCharacter && _character[6-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[1-1]==nCharacter && _character[2-1]==nCharacter && _character[3-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[7-1]==nCharacter && _character[4-1]==nCharacter && _character[1-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[8-1]==nCharacter && _character[5-1]==nCharacter && _character[2-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[9-1]==nCharacter && _character[6-1]==nCharacter && _character[3-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[7-1]==nCharacter && _character[5-1]==nCharacter && _character[3-1]==nCharacter) {
			return nCharacter;
		}
		else if (_character[9-1]==nCharacter && _character[5-1]==nCharacter && _character[1-1]==nCharacter) {
			return nCharacter;
		}
		else {
			return 3;
		}
	}
}
