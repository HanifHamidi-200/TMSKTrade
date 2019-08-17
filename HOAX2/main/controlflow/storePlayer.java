package controlflow;

import java.util.Scanner;

public class storePlayer {
	private String _name1;
	private String _letter1;
	private String _name2;
	private String _letter2;
		
		public void setName1(String value) {
			_name1 = value;
			_letter1 = _name1.substring(0,1);
		}
		
		public String getName1() {
			return _name1;
		}
		
		public void setLetter1(String value) {
			_letter1 = value;
		}
		
		public String getLetter1() {
			return _letter1;
		}

		public void setName2(String value) {
			_name2 = value;
			_letter2 = _name2.substring(0,1);
		}
		
		public String getName2() {
			return _name2;
		}

		public void setLetter2(String value) {
			_letter2 = value;
		}
		
		public String getLetter2() {
			return _letter2;
		}
		
		public String fProcess() {
			String nAnswer;
			Scanner input = new Scanner(System.in);
			
			nAnswer=input.nextLine();
			
			return nAnswer;
		}
	}
