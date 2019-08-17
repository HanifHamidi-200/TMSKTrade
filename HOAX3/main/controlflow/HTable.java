package controlflow;

import java.util.Random;
import java.util.Scanner;

public class HTable {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Random rnd1=new Random();
		storeName myname = new storeName("Hanif");
		classMENU mymenu = new classMENU();
		
		storePlayer myplayer = new storePlayer();
		myplayer.setName1("Hanif");
		myplayer.setName2("Suhaib");
		
		boolean bFound = false;
		int nAnswer;
		
		myname.Saying();
		do {
			mymenu.fDisplay();
			nAnswer=mymenu.fProcess();
			switch(nAnswer) {
			case 1:
				break;
			default:
				bFound = true;
				break;
			}
		}while (bFound==false);
	}
}
