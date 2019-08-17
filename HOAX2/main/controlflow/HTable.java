package controlflow;

import java.util.Random;
import java.util.Scanner;

public class HTable {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Random rnd1=new Random();
		storeName myname = new storeName("Hanif");
		classMENU mymenu = new classMENU();
		storeBoard myboard = new storeBoard(7,7);
		
		storePlayer myplayer = new storePlayer();
		storeGame mygame = new storeGame();
		classGAME mygame2 = new classGAME();
		
		boolean bFound = false, bFound2 = false;
		boolean bDone, bDone2;
		int nAnswer, nAnswer2, nMove;
		String sAnswer;
		int mnWidth, mnHeight;
		int[][] _character = new int[12][12];
		String msName1 = "Hanif", msLetter1, msName2 = "Suhaib", msLetter2;
		
		int mnMove;
		int mnTurn;
		int mnCol, mnRow;
		int mnWinmode;
		int mnWinplus;
		
		myplayer.setName1(msName1);
		myplayer.setName2(msName2);
		msLetter1 = myplayer.getLetter1();
		msLetter2 = myplayer.getLetter2();
		mnWidth = myboard.getWidth();
		mnHeight = myboard.getHeight();
		mymenu.setWidth(mnWidth);
		mymenu.setHeight(mnHeight);
		mygame.setWidth(mnWidth);
		mygame.setHeight(mnHeight);
		mygame2.setWidth(mnWidth);
		mygame2.setHeight(mnHeight);
		mygame2.fStart();
		
		myname.Saying();
		for (int i=1;i<=mnWidth;i++) {
			for (int j=1;j<=mnHeight;j++) {
				_character[i-1][j-1] = myboard.getCharacter(i,j);				
			}
		}
		do {
			mymenu.setName1(msName1);
			mymenu.setLetter1(msLetter1);
			mymenu.setName2(msName2);
			mymenu.setLetter2(msLetter2);
			mymenu.fDisplay();
			for (int i=1;i<=mnWidth;i++) {
				for (int j=1;j<=mnHeight;j++) {
					mymenu.setCharacter(i,j, _character[i-1][j-1]);
				}
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
				int nReply;
				System.out.printf("ENTER NEW WIDTH ");
				nReply = myboard.fProcess();
				if (nReply>=3 && nReply<=12) {
					mnWidth = nReply;
					myboard.setWidth(mnWidth);
					myboard.setHeight(mnHeight);
					mymenu.setWidth(mnWidth);
					mymenu.setHeight(mnHeight);
					mygame.setWidth(mnWidth);
					mygame.setHeight(mnHeight);
					mygame2.setWidth(mnWidth);
					mygame2.setHeight(mnHeight);
				}
				break;
			case 6:
				int nReply2;
				System.out.printf("ENTER NEW HEIGHT ");
				nReply2 = myboard.fProcess();
				if (nReply2>=3 && nReply2<=12) {
					mnHeight = nReply2;
					myboard.setWidth(mnWidth);
					myboard.setHeight(mnHeight);
					mymenu.setWidth(mnWidth);
					mymenu.setHeight(mnHeight);
					mygame.setWidth(mnWidth);
					mygame.setHeight(mnHeight);
					mygame2.setWidth(mnWidth);
					mygame2.setHeight(mnHeight);
				}
				break;
			case 7:
				for (int i=1;i<=mnWidth;i++) {
					for (int j=1;j<=mnHeight;j++) {
						mygame.setCharacter(i, j, _character[i-1][j-1]);
						mygame2.setCharacter(i, j, _character[i-1][j-1]);
					}
				}
				mygame.fStart();
				mygame2.setLetter1(msLetter1);;
				mygame2.setLetter2(msLetter2);;
				mnMove = mygame.getMove();
				mnTurn = mygame.getTurn();
				bFound2 = false;
				do {
					for (int i=1;i<=mnWidth;i++) {
						for (int j=1;j<=mnHeight;j++) {
							_character[i-1][j-1] = mygame.getCharacter(i, j);
							mygame2.setCharacter(i, j, _character[i-1][j-1]);
							}
					}
					mygame2.fDisplay();
					nAnswer2=mygame.fProcess();
					switch(nAnswer2) {
					case 1:
						System.out.println("ENTER COL");
						nMove = mygame.fProcess();
						bDone = mygame.fMove(nMove, mnMove);
						mnCol = mygame.getCol();
						mnRow = mygame.getRow();
						if (bDone) {
							mnMove++;
							mnTurn = mygame.getTurn();
							bDone2 = mygame2.setMove(mnCol, mnRow, mnTurn);
							myboard.setCharacter(mnCol, mnRow, mnTurn);
							mymenu.setCharacter(mnCol, mnRow, mnTurn);
							mygame2.setCharacter(mnCol, mnRow, mnTurn);
							for (int i=1;i<=mnWidth;i++) {
								for (int j=1;j<=mnHeight;j++) {
									_character[i-1][j-1] = mygame2.getCharacter(i, j);
									mygame.setCharacter(i, j, _character[i-1][j-1]);
									}
							}
						}
						break;
					case 2:
						nMove = mygame.fMoveRandom(mnMove);
						mnCol = mygame.getCol();
						mnRow = mygame.getRow();
						if (nMove!=0) {
							mnMove++;
							mnTurn = mygame.getTurn();
							bDone2 = mygame2.setMove(mnCol, mnRow, mnTurn);
							myboard.setCharacter(mnCol, mnRow, mnTurn);
							mymenu.setCharacter(mnCol, mnRow, mnTurn);
							mygame2.setCharacter(mnCol, mnRow, mnTurn);
							for (int i=1;i<=mnWidth;i++) {
								for (int j=1;j<=mnHeight;j++) {
									_character[i-1][j-1] = mygame2.getCharacter(i, j);
									mygame.setCharacter(i, j, _character[i-1][j-1]);
									}
							}
						}
						break;
					case 3:
						nMove = 0;
//						nMove = mygame2.fCompleteSquare();
						if (nMove!=0) {
							mnMove++;
							mnTurn = mygame.getTurn();
//							bDone2 = mygame2.setMove(nMove, mnTurn);
							for (int i=1;i<=mnWidth;i++) {
								for (int j=1;j<=mnHeight;j++) {
									_character[i-1][j-1] = mygame2.getCharacter(i, j);
									mygame.setCharacter(i, j, _character[i-1][j-1]);
									}
								}
							}
						break;
					case 4:
						int nWin=0;
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
						mnWinmode = mygame2.getWinmode();
						mnWinplus = mygame2.getWinplus();
						switch(mnWinmode) {
						case 1:
							sText = "DOWN-WIN";
							break;
						case 2:
							sText = "DIAGONAL-LEFT1";
							break;
						case 3:
							sText = "DIAGONAL-LEFT2";
							break;
						case 4:
							sText = "DIAGONAL-RIGHT1";
							break;
						case 5:
							sText = "DIAGONAL-RIGHT2";
							break;
						}
						System.out.println(sText);
						sText = "PLUS = " + mnWinplus;
						System.out.println(sText);
						bFound2 = true;
						break;
					default:
						bFound2 = true;
						break;	
					}
				} while (!bFound2);
				myboard.fStart();
				mygame2.fStart();
				for (int i=1;i<=mnWidth;i++) {
					for (int j=1;j<=mnHeight;j++) {
						_character[i-1][j-1] = myboard.getCharacter(i, j);
						mymenu.setCharacter(i, j, _character[i-1][j-1]);
						mygame.setCharacter(i, j, _character[i-1][j-1]);
						mygame2.setCharacter(i, j, _character[i-1][j-1]);
					}
				}
				break;
			default:
				bFound = true;
				break;
			}
		}while (bFound==false);
	}
}
