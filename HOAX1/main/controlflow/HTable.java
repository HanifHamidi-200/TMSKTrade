package controlflow;

import java.util.Random;
import java.util.Scanner;

public class HTable {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Random rnd1=new Random();
		storeName myname = new storeName("Hanif");
		classMENU mymenu = new classMENU();
		storeBoard myboard = new storeBoard();
		
		storePlayer myplayer = new storePlayer();
		storeGame mygame = new storeGame();
		classGAME mygame2 = new classGAME();
		
		boolean bFound = false, bFound2 = false;
		boolean bDone, bDone2;
		int nAnswer, nAnswer2, nMove;
		String sAnswer;
		int[] _character = new int[9];
		String msName1 = "Hanif", msLetter1, msName2 = "Suhaib", msLetter2;
		
		int mnMove;
		int mnTurn;
		int mnSquare;

		myplayer.setName1(msName1);
		myplayer.setName2(msName2);
		msLetter1 = myplayer.getLetter1();
		msLetter2 = myplayer.getLetter2();
		
		myname.Saying();
		for (int i=1;i<=9;i++) {
			_character[i-1] = myboard.getCharacter(i);
		}
		do {
			mymenu.setName1(msName1);
			mymenu.setLetter1(msLetter1);
			mymenu.setName2(msName2);
			mymenu.setLetter2(msLetter2);
			mymenu.fDisplay();
			for (int i=1;i<=9;i++) {
				mymenu.setCharacter(i, _character[i-1]);
			}
			nAnswer=mymenu.fProcess();
			switch(nAnswer) {
			case 1:
				sAnswer = myplayer.fProcess();
				msName1 = sAnswer;
				myplayer.setName1(sAnswer);
				msLetter1 = myplayer.getLetter1();
				break;
			case 2:
				sAnswer = myplayer.fProcess();
				msLetter1 = sAnswer;
				myplayer.setLetter1(sAnswer);
				break;
			case 3:
				sAnswer = myplayer.fProcess();
				msName2 = sAnswer;
				myplayer.setName2(sAnswer);
				msLetter2 = myplayer.getLetter2();
				break;
			case 4:
				sAnswer = myplayer.fProcess();
				msLetter2 = sAnswer;
				myplayer.setLetter2(sAnswer);
				break;
			case 5:
				for (int i=1;i<=9;i++) {
					mygame.setCharacter(i, _character[i-1]);
					mygame2.setCharacter(i, _character[i-1]);
				}
				mygame.fStart();
				mygame2.setLetter1(msLetter1);;
				mygame2.setLetter2(msLetter2);;
				mnMove = mygame.getMove();
				mnTurn = mygame.getTurn();
				mnSquare = mygame.getSquare();
				bFound2 = false;
				do {
					for (int i=1;i<=9;i++) {
						_character[i-1] = mygame.getCharacter(i);
						mygame2.setCharacter(i, _character[i-1]);
					}
					mygame2.fDisplay();
					nAnswer2=mygame.fProcess();
					switch(nAnswer2) {
					case 1:
						System.out.println("ENTER MOVE");
						nMove = mygame.fProcess();
						bDone = mygame.fMove(nMove, mnMove);
						if (bDone) {
							mnMove++;
							mnTurn = mygame.getTurn();
							bDone2 = mygame2.setMove(nMove, mnTurn);
							for (int i=1;i<=9;i++) {
								_character[i-1] = mygame2.getCharacter(i);
								mygame.setCharacter(i, _character[i-1]);
							}
						}
						break;
					case 2:
						nMove = mygame.fMoveRandom(mnMove);
						if (nMove!=0) {
							mnMove++;
							mnTurn = mygame.getTurn();
							bDone2 = mygame2.setMove(nMove, mnTurn);
							for (int i=1;i<=9;i++) {
								_character[i-1] = mygame2.getCharacter(i);
								mygame.setCharacter(i, _character[i-1]);
							}
						}
						break;
					case 3:
						nMove = mygame2.fCompleteSquare();
						if (nMove!=0) {
							mnMove++;
							mnTurn = mygame.getTurn();
							bDone2 = mygame2.setMove(nMove, mnTurn);
							for (int i=1;i<=9;i++) {
								_character[i-1] = mygame2.getCharacter(i);
								mygame.setCharacter(i, _character[i-1]);
							}
						}		
						break;
					case 4:
						int nWin;
						String sText;
						nWin = mygame2.fDetectWin();
						if (nWin==1) {
							sText = msName1 + " WINS!!";
						}
						else if (nWin==2) {
							sText = msName2 + " WINS!!";
						}
						else {
							sText = "[DRAWNGAME]";
						}
						System.out.println(sText);
						bFound2 = true;
						break;
					default:
						bFound2 = true;
						break;	
					}
				} while (!bFound2);
				myboard.fStart();
				for (int i=1;i<=9;i++) {
					_character[i-1] = myboard.getCharacter(i);
				}
				break;
			default:
				bFound = true;
				break;
			}
		}while (bFound==false);
	}
}
