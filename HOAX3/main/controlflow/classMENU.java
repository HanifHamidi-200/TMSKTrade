package controlflow;

import java.util.Scanner;

public class classMENU {
	private String _name1;
	private String _letter1;
	private String _name2;
	private String _letter2;
	private int _width;
	private int _height;
	private boolean _Autoplayer1;
	private boolean _Autoplayer2;
	
	private void setAutoplayer1(boolean value) {
		_Autoplayer1 = value;
	}

	private void setAutoplayer2(boolean value) {
		_Autoplayer2 = value;
	}

	private void setWidth(int value) {
		_width = value;
	}
	
	private void setHeight(int value) {
		_height = value;
	}
	
	private void setName1(String value) {
		_name1 = value;
	}
	
	private void setLetter1(String value) {
		_letter1 = value;
	}
	
	private void setName2(String value) {
		_name2 = value;
	}
	
	private void setLetter2(String value) {
		_letter2 = value;
	}
	
	public void fDisplay() {
		String sText;
		
		System.out.println("======================");
		System.out.println("MainMenu");
		System.out.println("======================");
		System.out.println("[1] Update Name1 = "+_name1);
		System.out.println("[2] Update Letter1 = "+_letter1);
		System.out.println("[3] Update Name2 = "+_name2);
		System.out.println("[4] Update Letter2 = "+_letter2);
		System.out.println("[5] ChangeWidth = "+_width);
		System.out.println("[6] ChangeHeight = "+_height);
		if (_Autoplayer1) {
			sText = "[7] Autoplayer1 = ON";
		}
		else {
			sText = "[7] Autoplayer1 = OFF";
		}
		System.out.println(sText);
		if (_Autoplayer2) {
			sText = "[8] Autoplayer2 = ON";
		}
		else {
			sText = "[8] Autoplayer2 = OFF";
		}
		System.out.println(sText);
		System.out.println("[9] StartGame");
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