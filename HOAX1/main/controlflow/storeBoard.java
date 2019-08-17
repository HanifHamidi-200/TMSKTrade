package controlflow;

public class storeBoard {
private int[] _character = new int[9];
		
	public storeBoard() {
		fStart();
	}
	
	public void setCharacter(int pos, int value) {
		_character[pos-1] = value;
	}
	
	public int getCharacter(int pos) {
		return _character[pos-1];
	}
	
	public void fStart() {
		for (int i=1;i<=9;i++) {
			_character[i-1] = 3;
		}
	}
	
}