package controlflow;

public class classGAME {
	private int[][] _character = new int[12][12];
	private String _letter1;
	private String _letter2;
	private int mnComplete;
	private int mnWidth;
	private int mnHeight;
	private int mnWinmode = 0;
	private int mnWinplus = 0;
	
	public void fStart() {
		mnWinmode = 0;
		mnWinplus = 0;
	}
	
	public int getWinmode() {
		return mnWinmode;
	}
	
	public int getWinplus() {
		return mnWinplus;
	}
	
	public void setWidth(int value) {
		mnWidth = value;
	}
	
	public void setHeight(int value) {
		mnHeight = value;
	}

	public boolean setMove(int nCol, int nRow, int turn) {
		if (turn<=2) {
			_character[nCol-1][nRow-1] = turn;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setCharacter(int nCol, int nRow, int value) {
		_character[nCol-1][nRow-1] = value;
	}
	
	public int getCharacter(int nCol, int nRow) {
		return _character[nCol-1][nRow-1];
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
		String sLine;
		
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
	
	private boolean fLineExists(int nCharacter, int A1, int A2, int B1, int B2, int C1, int C2, int D1, int D2) {
		mnComplete = 0;
		if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==0) {
			mnComplete = 4;
			return true;
		}		
		else if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==0 && _character[D1-1][D2-1]==nCharacter) {
			mnComplete = 3;
			return true;
		}	
		else if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==0 && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==nCharacter) {
			mnComplete = 2;
			return true;
		}	
		else if (_character[A1-1][A2-1]==0 && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==nCharacter) {
			mnComplete = 1;
			return true;
		}	
		else {
			return false;
		}
	}
	
	/*
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
	*/
	
	private int fDetect1(int nCharacter,int nCol) {
		int _height = mnHeight;
		int _length = 4;
		int _times = _height-_length+1;
		int _top = _height-_length+1;
		int A1=nCol, A2, B1=nCol, B2, C1=nCol, C2, D1=nCol, D2;
	
		do {
			A2 = _top;
			B2 = A2+1;
			C2 = B2+1;
			D2 = C2+1;
			if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==nCharacter) {
				return nCharacter;
			}
			_top--;
		} while (_top>=1);
		
		return 0;

	}
	
	private int fDetect21(int nCharacter,int nPlus) {
		int _height = mnHeight;
		int _length = 4;
		int A1, A2, B1, B2, C1, C2, D1, D2;
	
		A1 = 1;
		B1 = 2;
		C1 = 3;
		D1 = 4;
		A2 = _height-_length+1;
		B2 = A2-1;
		C2 = B2-1;
		D2 = C2-1;
		A2+=nPlus;
		B2+=nPlus;
		C2+=nPlus;
		D2+=nPlus;
		do {
			if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==nCharacter) {
				return nCharacter;
			}
			D1+=1;
			D2-=1;
			C1+=1;
			C2-=1;
			B1+=1;
			B2-=1;
			A1+=1;
			A2-=1;
		} while (D2>=1);

		return 0;

	}

	private int fDetect22(int nCharacter,int nCol) {
		int _width = mnWidth;
		int _height = mnHeight;
		int _length = 4;
		int A1, A2, B1, B2, C1, C2, D1, D2;
	
		A1 = nCol;
		B1 = A1+1;
		C1 = B1+1;
		D1 = C1+1;
		A2 = _height;
		B2 = A2-1;
		C2 = B2-1;
		D2 = C2-1;
		do {
			if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==nCharacter) {
				return nCharacter;
			}
			D1+=1;
			D2-=1;
			C1+=1;
			C2-=1;
			B1+=1;
			B2-=1;
			A1+=1;
			A2-=1;
		} while (D1<=_width);

		return 0;
	}

	private int fDetect31(int nCharacter,int nPlus) {
		int _height = mnHeight;
		int _width = mnWidth;
		int _length = 4;
		int A1, A2, B1, B2, C1, C2, D1, D2;
	
		A1 = _width;
		B1 = A1-1;
		C1 = B1-1;
		D1 = C1-1;
		A2 = _height-_length+1;
		B2 = A2-1;
		C2 = B2-1;
		D2 = C2-1;
		A2+=nPlus;
		B2+=nPlus;
		C2+=nPlus;
		D2+=nPlus;
		do {
			if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==nCharacter) {
				return nCharacter;
			}
			D1-=1;
			D2-=1;
			C1-=1;
			C2-=1;
			B1-=1;
			B2-=1;
			A1-=1;
			A2-=1;
		} while (D2>=1);

		return 0;

	}

	private int fDetect32(int nCharacter,int nCol) {
		int _width = mnWidth;
		int _height = mnHeight;
		int _length = 4;
		int A1, A2, B1, B2, C1, C2, D1, D2;
	
		A1 = nCol;
		B1 = A1-1;
		C1 = B1-1;
		D1 = C1-1;
		A2 = _height;
		B2 = A2-1;
		C2 = B2-1;
		D2 = C2-1;
		do {
			if (_character[A1-1][A2-1]==nCharacter && _character[B1-1][B2-1]==nCharacter && _character[C1-1][C2-1]==nCharacter && _character[D1-1][D2-1]==nCharacter) {
				return nCharacter;
			}
			D1-=1;
			D2-=1;
			C1-=1;
			C2-=1;
			B1-=1;
			B2-=1;
			A1-=1;
			A2-=1;
		} while (D1>=1);

		return 0;
	}

	public int fDetectWin() {
		int nDetect = 0;
		boolean bFound = false;
		int nCol = 1;
		int nCharacter = 1;
			
		do {
			nDetect = fDetect1(nCharacter, nCol);
			if (nDetect!=0) {
				mnWinmode = 1;
				mnWinplus = nCol;
				return nDetect;
			}
			nCol++;
			if (nCol==mnWidth+1) {
				bFound = true;
			}
		} while (!bFound);
		
		nCharacter = 2;
		
		do {
			nDetect = fDetect1(nCharacter, nCol);
			if (nDetect!=0) {
				mnWinmode = 1;
				mnWinplus = nCol;
				return nDetect;
			}
			nCol++;
			if (nCol==mnWidth+1) {
				bFound = true;
			}
		} while (!bFound);
	
		int _height = mnHeight;
		int _width = mnWidth;
		int _length = 4;
		int A2 = _height-_length+1;
		int nPlus = 0;
		
		nCol = 2;
		nCharacter = 1;
		
		do {
			nDetect = fDetect21(nCharacter, nPlus);
			if (nDetect!=0) {
				mnWinmode = 2;
				mnWinplus = nPlus;
				return nDetect;
			}
			nPlus++;
			if (nPlus+A2==mnHeight+1) {
				bFound = true;
			}
		} while (!bFound);
	
		nPlus = 0;
		nCharacter = 2;
		
		do {
			nDetect = fDetect21(nCharacter, nPlus);
			if (nDetect!=0) {
				mnWinmode = 2;
				mnWinplus = nPlus;
				return nDetect;
			}
			nPlus++;
			if (nPlus+A2==mnHeight+1) {
				bFound = true;
			}
		} while (!bFound);
	
		nCharacter = 1;
		
		do {
			nDetect = fDetect22(nCharacter, nCol);
			if (nDetect!=0) {
				mnWinmode = 3;
				mnWinplus = nCol;
				return nDetect;
			}
			nCol++;
			if (nCol+_length==mnWidth+1) {
				bFound = true;
			}
		} while (!bFound);

		nCol = 2;
		nCharacter = 1;
		
		do {
			nDetect = fDetect22(nCharacter, nCol);
			if (nDetect!=0) {
				mnWinmode = 3;
				mnWinplus = nCol;
				return nDetect;
			}
			nCol++;
			if (nCol+_length==mnWidth+1) {
				bFound = true;
			}
		} while (!bFound);

		nPlus = 0;
		nCharacter = 1;
		
		do {
			nDetect = fDetect31(nCharacter, nPlus);
			if (nDetect!=0) {
				mnWinmode = 4;
				mnWinplus = nPlus;
				return nDetect;
			}
			nPlus++;
			if (nPlus+A2==mnHeight+1) {
				bFound = true;
			}
		} while (!bFound);
	
	
		nPlus = 0;
		nCharacter = 2;
		
		do {
			nDetect = fDetect31(nCharacter, nPlus);
			if (nDetect!=0) {
				mnWinmode = 4;
				mnWinplus = nPlus;
				return nDetect;
			}
			nPlus++;
			if (nPlus+A2==mnHeight+1) {
				bFound = true;
			}
		} while (!bFound);
	
		nCol = _width-1;
		nCharacter = 1;
		
		do {
			nDetect = fDetect32(nCharacter, nCol);
			if (nDetect!=0) {
				mnWinmode = 5;
				mnWinplus = nCol;
				return nDetect;
			}
			nCol--;
			if (nCol-_length+1==0) {
				bFound = true;
			}
		} while (!bFound);

		nCol = _width-1;
		nCharacter = 2;
		
		do {
			nDetect = fDetect32(nCharacter, nCol);
			if (nDetect!=0) {
				mnWinmode = 5;
				mnWinplus = nCol;
				return nDetect;
			}
			nCol--;
			if (nCol-_length+1==0) {
				bFound = true;
			}
		} while (!bFound);
		
		return 0;
	}
}
