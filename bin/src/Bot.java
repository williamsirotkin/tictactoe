import java.util.Random;

public class Bot {

    private Random random;
    private String botPiece;

    public Bot(String botPiece) {
	random = new Random();
	this.botPiece = botPiece;
    } // Bot Constructor

    public int createMove(String[] piecePositions) {
	int pieces = getPieces(piecePositions);

	if (pieces == 0) {
	    return doFirstMove(piecePositions);
	} else if (pieces == 1) {
	    return doSecondMove(piecePositions);
	} else if (pieces == 2) {
	    return doThirdMove(piecePositions); 
	} else if (pieces == 3) {
	    return doFourthMove(piecePositions);
	} else if (pieces == 4) {
	    return doFifthMove(piecePositions);
	} else if (pieces == 5) {
	    return doSixthMove(piecePositions);
	} else if (pieces == 6) {
	    return doSeventhMove(piecePositions);
	} else if (pieces == 7) {
	    return doEighthMove(piecePositions);
	} else {
	    return doNinthMove(piecePositions);
	} // if/else				   
       
    } // createMove

    public String getBotPiece() {
	return botPiece;
    } //getBotPiece

    public void setBotPiece(String botPiece) {
	this.botPiece = botPiece;
    } //setBotPiece

    public String getOpponentPiece() {
	if (getBotPiece().equals("X")) {
	    return "O";
	}

	return "X";
    } //getOpponentPiece

    public int getPieces(String[] piecePositions) {
	int pieces = 0;
	
	for (int i = 0; i < 9; i++) {
	    if (piecePositions[i].equals("X") || piecePositions[i].equals("O")) {
		pieces++;
	    } // if
	}
	return pieces;
    } // pieces

    public boolean[] getOpponentMoves(String[] piecePositions) {
	boolean[] moves = new boolean[9];

	for (int i = 0; i < 9; i++) {
	    if (piecePositions[i].equals(getOpponentPiece())) {
		moves[i] = true; 
	    } else {
		moves[i] = false;
	    }
	} // for

	return moves;
    } //getOpponentMoves

    public boolean[]  getEveryMove(String[] piecePositions) {
	boolean[] moves = new boolean[9];

	for (int i = 0; i < 9; i++) {
	    if (!piecePositions[i].equals("-")) {
		moves[i] = true; 
	    } else {
		moves[i] = false;
 	    }
	} // for

	return moves;
    } //getEveryMove

    public boolean[] getOwnMoves(String[] piecePositions) {
	boolean[] moves = new boolean[9];

	for (int i = 0; i < 9; i++) {
	    if (piecePositions[i].equals(getBotPiece())) {
		moves[i] = true; 
	    } else {
		moves[i] = false;
	    }
	} // for

	return moves;
    } // getOwnMoves

    private boolean isSquareTaken(int square, String[] piecePositions) {
	if (getEveryMove(piecePositions)[square]) {
	    return true;
	}
	return false;
    }

    public int getRandomInt() {
	return random.nextInt(9);
    } //getRandomInt

    public int getRandomInt(int randomIntOne, int randomIntTwo) {
	int randomInt;
	
	do {
	    randomInt = random.nextInt(9);
	} while (randomInt != randomIntOne && randomInt != randomIntTwo);

	return randomInt;
    } // getRandomInt

    public int getRandomInt(int randomIntOne, int randomIntTwo, int randomIntThree) {
	int randomInt;
	
	do {
	    randomInt = random.nextInt(9);
	} while (randomInt != randomIntOne && randomInt != randomIntTwo && randomInt != randomIntThree);

	return randomInt;
    } //getRandomInt

    public int getRandomInt(int randomIntOne, int randomIntTwo, int randomIntThree, int randomIntFour) {
	int randomInt;
	
	do {
	    randomInt = random.nextInt(9);
	} while (randomInt != randomIntOne && randomInt != randomIntTwo && randomInt != randomIntThree && randomInt != randomIntFour);

	return randomInt;
    } // getRandomInt

    public int getRandomInt(int randomIntOne, int randomIntTwo, int randomIntThree, int randomIntFour, int randomIntFive) {
	int randomInt;
	
	do {
	    randomInt = random.nextInt(9);
	} while (randomInt != randomIntOne && randomInt != randomIntTwo && randomInt != randomIntThree && randomInt != randomIntFour && randomInt != randomIntFive);

	return randomInt;
    } // getRandomInt

    private boolean isACorner(int square) {
	if (square == 0 || square == 2 || square == 6 || square == 8) {
	    return true;
	}

	return false;
    } //isACorner

    private boolean isASide(int square) {
	if (square == 1 || square == 3 || square == 5 || square == 7) {
	    return true;
	}

	return false;
    } //isASide

    private boolean isMiddle(int square) {
	if (square == 4) {
	    return true;
	}

	return false;
    } // isMiddle

    private int getAcrossMove(int square) {
	if (square == 0) {
	    return 8;
	} else if (square == 1) {
	    return 7;
	} else if (square == 2) {
	    return 6;
	} else if (square == 3) {
	    return 5;
	} else if (square == 4) {
	    return 4;
	} else if (square == 5) {
	    return 3;
	} else if (square == 6) {
	    return 2;
	} else if (square == 7) {
	    return 1;
	} else if (square == 8) {
	    return 0;
	}

	return 0;
    } // getAcrossMove

    private int getAdjacentMove(int square) {
	if (square == 0) {
	    return getRandomInt(1, 4);
	} else if (square == 1) {
	    return getRandomInt(0, 2);
	} else if (square == 2) {
	    return getRandomInt(1, 5);
	} else if (square == 3) {
	    return getRandomInt(0, 6);
	} else if (square == 4) {
	    return getRandomInt(1, 3, 5, 7);
	} else if (square == 5) {
	    return getRandomInt(2, 8);
	} else if (square == 6) {
	    return getRandomInt(3, 7);
	} else if (square == 7) {
	    return getRandomInt(6, 8);
	} else if (square == 8) {
	    return getRandomInt(7, 5);
	}

	return 0;
    } //getAdjacentMove

    private int getDiagnolMove(int square) {
	if (square == 0) {
	    return getRandomInt(4, 8);
	} else if (square == 1) {
	    return getRandomInt(3, 5);
	} else if (square == 2) {
	    return getRandomInt(4, 6);
	} else if (square == 3) {
	    return getRandomInt(1, 7);
	} else if (square == 4) {
	    return getRandomInt(0, 2, 6, 8);
	} else if (square == 5) {
	    return getRandomInt(1, 7);
	} else if (square == 6) {
	    return getRandomInt(4, 2);
	} else if (square == 7) {
	    return getRandomInt(3, 5);
	} else if (square == 8) {
	    return getRandomInt(4, 0);
	}

	return 0;
    }

    private int getKnightMove(int square) {
	if (square == 0) {
	    return getRandomInt(5, 7);
	} else if (square == 1) {
	    return getRandomInt(6, 8);
	} else if (square == 2) {
	    return getRandomInt(1, 5);
	} else if (square == 3) {
	    return getRandomInt(2, 8);
	} else if (square == 5) {
	    return getRandomInt(0, 6);
	} else if (square == 6) {
	    return getRandomInt(1, 5);
	} else if (square == 7) {
	    return getRandomInt(0, 2);
	} else if (square == 8) {
	    return getRandomInt(1, 3);
	}

	return 4;
    } //getKnightMove

    private int doMiddleMove() {
	return 4;
    } // doMiddleMove

    private int getDoubleAdjacentMove(int square) {
	if (square == 0) {
	    return 2;
	} else if (square == 2) {
	    return getRandomInt(0, 2);
	} else if (square == 6) {
	    return getRandomInt(0, 8);
	} else if (square == 8) {
	    return getRandomInt(6, 2);
	}
				  
	return 0;
    }

    //Returns -10 if no need to block a move
    private int botBlockMove(String[] piecePositions) {
	int opponentFirstMove = -10;
	int opponentSecondMove = -10;
	int opponentThirdMove = -10;
	int opponentFourthMove = -10;
	
	for (int i = 0; i < 9; i++) {
	    if (getOpponentMoves(piecePositions)[i]) {
		if (opponentFirstMove == -10) {
		    opponentFirstMove = i;
		} else if (opponentSecondMove == -10) {
		    opponentSecondMove = i;
		} else if (opponentThirdMove == -10) {
		    opponentThirdMove = i;
		} else if (opponentFourthMove == -10) {
		    opponentFourthMove = i;
		}
	    } // if
	} // for

	int botFirstMove = -10;
	int botSecondMove = -10;
	int botThirdMove = -10;

	for (int i = 0; i < 9; i++) {
	    if (getOwnMoves(piecePositions)[i]) {
		if (botFirstMove == -10) {
		    botFirstMove = i;
		} else if (botSecondMove == -10) {
		    botSecondMove = i;
		} else if (botThirdMove == -10) {
		    botThirdMove = i;
		}
	    }
	} // for

	if (isContinuous(opponentFirstMove, opponentSecondMove)) {
	}
	
	return -1;
    } //botBlockMove

    public boolean isContinuous(int squareOne, int squareTwo) {
	if (squareOne == squareTwo + 1 || squareOne == squareTwo - 1) {
	    if (squareOne == 3 || squareOne == 6) {
		if (squareTwo == squareOne - 1) {
		    return false;
		}
	    }

	    if (squareOne == 2 || squareOne == 5) {
		if (squareTwo == squareOne + 1) {
		    return false;
		}
	    }

	    return true;
	}

	if (squareOne == squareTwo + 3 || squareOne == squareTwo - 3) {
	    return true;
	}

	if (squareOne == squareTwo + 4 || squareOne == squareTwo - 4) {
	    if (squareOne == 0 || squareOne == 4 || squareOne == 8) {
		return true;
	    }

	    if (squareOne == 2 && squareTwo == 6 || squareOne == 6 && squareTwo == 2) {
		return true;
	    }
	    return false;
	}

	if (squareOne == squareTwo + 2 || squareOne == squareTwo - 2) {
	    if (!isASide(squareOne) || !isASide(squareTwo)) {
		return true;
	    }

	    if (squareOne == 3 && squareTwo == 5 || squareOne == 5 && squareTwo == 3) {
		return true;
	    }
	    
	    return false;
	}

	if (squareOne == squareTwo + 8 || squareOne == squareTwo - 8) {
	    return true;
	}

	return false;
    }

    public boolean isSpotTaken(String[] piecePositions, int square) {	
	if (piecePositions[square].equals("X") || piecePositions[square].equals("O")) {
	    return true;
	}

	return false;
    }

    private boolean isDoubleMove(String[] piecePositions, int square) {
	int botFirstPiece = -10;
	int botSecondPiece = -10;

	for (int i = 0; i < 9; i++) {
	    if (piecePositions[i].equals(getBotPiece())) {
		if (botFirstPiece == -10) {
		    botFirstPiece = i;
		} else {
		    botSecondPiece = i;
		}
	    }		
	}

	int possibleWins = 0;
	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botFirstPiece, square, i)) {
		possibleWins++;
	    }

	    if (willMoveWinGame(piecePositions, botSecondPiece, square, i)) {
		possibleWins++;
	    }
	}

	if (possibleWins == 2) {
	    return true;
	} else {
	    return false;
	}
		
	    
	
    }

    private boolean willMoveWinGame(String[] piecePositions, int moveOne, int moveTwo, int moveNow) {
	if (isSpotTaken(piecePositions, moveNow)) {
	    return false;
	}

	if (moveOne == moveTwo + 1 && moveTwo == moveNow + 1 ||
	    moveTwo == moveNow + 1 && moveNow == moveOne + 1 ||
	    moveNow == moveOne + 1 && moveOne == moveTwo + 1) {
	    if (moveOne + moveTwo + moveNow == 3 ||
		moveOne + moveTwo + moveNow == 12 ||
		moveOne + moveTwo + moveNow == 21) {
		return true;
	    }
	}

	if (moveOne == moveTwo + 3 && moveTwo == moveNow + 3 ||
	    moveTwo == moveNow + 3 && moveNow == moveOne + 3 ||
	    moveNow == moveOne + 3 && moveOne == moveTwo + 3) {
	    if (moveOne + moveTwo + moveNow == 9 ||
		moveOne + moveTwo + moveNow == 12 ||
		moveOne + moveTwo + moveNow == 15) {
		return true;
	    }
	}

	if (moveOne == moveTwo + 4 && moveTwo == moveNow + 4 ||
	    moveTwo == moveNow + 4 && moveNow == moveOne + 4 ||
	    moveNow == moveOne + 4 && moveOne == moveTwo + 4) {
	    return true;
	}

	return false;
    }

    private int doFirstMove(String[] piecePositions) {
	return random.nextInt(9);
    } // doFirstMove

    private int doSecondMove(String[] piecePositions) {
	if (getOpponentMoves(piecePositions)[4]) {
	    return getRandomInt(0, 2, 6, 8);
	} // if

	return 4;
    } //doSecondMove

    private int doThirdMove(String[] piecePositions) {
	int botFirstPiece = 0;
	int playerFirstPiece = 0;
	int move = 0;

	for (int i = 0; i < 9; i++) {
	    if (getOwnMoves(piecePositions)[i]) {
		botFirstPiece = i;
	    } else if (getOpponentMoves(piecePositions)[i]) {
		playerFirstPiece = i;
	    }
	} // for

	if (isMiddle(playerFirstPiece)) {
	    if (isACorner(botFirstPiece)) {
		return getAcrossMove(botFirstPiece);
	    } // if

	    return getRandomInt(getDiagnolMove(botFirstPiece), getKnightMove(botFirstPiece));
	} // if

	if (isACorner(playerFirstPiece)) {
	    if (isASide(botFirstPiece)) {
		do {
		    move = getAdjacentMove(botFirstPiece);
		} while (move == getAcrossMove(playerFirstPiece));
		return move;
	    }

	    if (isACorner(botFirstPiece)) {
		if (getAcrossMove(botFirstPiece) == playerFirstPiece) {
		    return getDoubleAdjacentMove(botFirstPiece);
		}
	    } // if

	    return getAcrossMove(playerFirstPiece);
	} // if

	if (isMiddle(botFirstPiece)) {
	    return getAdjacentMove(botFirstPiece);
	} else if (isASide(botFirstPiece)) {
	    if (botFirstPiece == getDiagnolMove(playerFirstPiece)) {
		return doMiddleMove();
	    } else {
		return getRandomInt(getDiagnolMove(botFirstPiece), getKnightMove(botFirstPiece));
	    }
	} else {
	    return doMiddleMove();
	}
    } //doThirdMove

    private int doFourthMove(String[] piecePositions) {
	int botFirstPiece = 0;
	int playerFirstPiece = -1;
	int playerSecondPiece = 0;
	int move = 0;

	for (int i = 0; i < 9; i++) {
	    if (getOwnMoves(piecePositions)[i]) {
		botFirstPiece = i;
	    } else if (getOpponentMoves(piecePositions)[i]){
		if (playerFirstPiece == -1) {
		    playerFirstPiece = i;
		} else {
		    playerSecondPiece = i;
		}
	    }	    
	} // for

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	if (isMiddle(playerFirstPiece) || isMiddle(playerSecondPiece)) {
	    return getDiagnolMove(4);
	}

	if (isACorner(playerFirstPiece) && isACorner(playerSecondPiece)) {
	    return getAdjacentMove(4);
	}

	if (isACorner(playerFirstPiece) || isACorner(playerSecondPiece)) {
	    if (isASide(playerFirstPiece) || isASide(playerSecondPiece)) {
		if (isASide(playerFirstPiece)) {
		    return getAdjacentMove(playerFirstPiece);
		} else {
		    return getAdjacentMove(playerSecondPiece);
		}			
	    }
	}
	
	if (botFirstPiece == 4) {
	    return getAdjacentMove(playerFirstPiece);
	}

	if (botFirstPiece == playerFirstPiece + 1 && botFirstPiece == playerSecondPiece + 3 ||
	    botFirstPiece == playerFirstPiece - 1 && botFirstPiece == playerSecondPiece - 3 ||
	    botFirstPiece == playerFirstPiece - 1 && botFirstPiece == playerSecondPiece + 3 ||
	    botFirstPiece == playerFirstPiece + 1 && botFirstPiece == playerSecondPiece - 3 ||
	    botFirstPiece == playerSecondPiece + 1 && botFirstPiece == playerFirstPiece + 3 ||
	    botFirstPiece == playerSecondPiece - 1 && botFirstPiece == playerFirstPiece - 3 ||
	    botFirstPiece == playerSecondPiece - 1 && botFirstPiece == playerFirstPiece + 3 ||
	    botFirstPiece == playerSecondPiece + 1 && botFirstPiece == playerFirstPiece - 3) {
	    return 4;
	}

	do {
	    move = getDoubleAdjacentMove(botFirstPiece);
	} while (move != getKnightMove(playerFirstPiece) && move != getKnightMove(playerSecondPiece));
	return move;
    } //doFourthMove

    private int doFifthMove(String[] piecePositions) {
	int botFirstPiece = -10;
	int botSecondPiece = -10;
	int playerFirstPiece = -10;
	int playerSecondPiece = -10;

	for (int i = 0; i < 9; i++) {
	    if (getOwnMoves(piecePositions)[i]) {
		if (botFirstPiece == -10) {
		    botFirstPiece = i;
		} else {
		    botSecondPiece = i;
		}
	    }

	    if (getOpponentMoves(piecePositions)[i]) {
		if (playerFirstPiece == -10) {
		    playerFirstPiece = i;
		} else {
		    playerSecondPiece = i;
		}			 
	    }
	}
	
	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botFirstPiece, botSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (isDoubleMove(piecePositions, i)) {
		return i;
	    }
	}		
	    
	return getRandomInt();
    } //doFifthMove

    private int doSixthMove(String[] piecePositions) {
	int botFirstPiece = -10;
	int botSecondPiece = -10;
	int playerFirstPiece = -10;
	int playerSecondPiece = -10;
	int playerThirdPiece = -10;

	for (int i = 0; i < 9; i++) {
	    if (getOwnMoves(piecePositions)[i]) {
		if (botFirstPiece == -10) {
		    botFirstPiece = i;
		} else {
		    botSecondPiece = i;
		}
	    }

	    if (getOpponentMoves(piecePositions)[i]) {
		if (playerFirstPiece == -10) {
		    playerFirstPiece = i;
		} else if (playerSecondPiece == -10) {
		    playerSecondPiece = i;
		} else {
		    playerThirdPiece = i;
		}
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botFirstPiece, botSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerThirdPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerThirdPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (isDoubleMove(piecePositions, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (willMoveWinGame(piecePositions, botFirstPiece, i, j)) {
		    return i;
		}

		if (willMoveWinGame(piecePositions, botSecondPiece, i, j)) {
		    return i;
		}
	    }	    
	}

	return getRandomInt();
    } //doSixthMove

    private int doSeventhMove(String[] piecePositions) {
	int botFirstPiece = -10;
	int botSecondPiece = -10;
	int botThirdPiece = -10;
	int playerFirstPiece = -10;
	int playerSecondPiece = -10;
	int playerThirdPiece = -10;

	for (int i = 0; i < 9; i++) {
	    if (getOwnMoves(piecePositions)[i]) {
		if (botFirstPiece == -10) {
		    botFirstPiece = i;
		} else if (botSecondPiece == -10) {
		    botSecondPiece = i;
		} else {
		    botThirdPiece = i;
		}
	    }

	    if (getOpponentMoves(piecePositions)[i]) {
		if (playerFirstPiece == -10) {
		    playerFirstPiece = i;
		} else if (playerSecondPiece == -10) {
		    playerSecondPiece = i;
		} else {
		    playerThirdPiece = i;
		}
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botFirstPiece, botSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botThirdPiece, botSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botFirstPiece, botThirdPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerThirdPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerThirdPiece, i)) {
		return i;
	    }
	}

	return getRandomInt();
    } //doSeventhMove

    private int doEighthMove(String[] piecePositions) {
	int botFirstPiece = -10;
	int botSecondPiece = -10;
	int botThirdPiece = -10;
	int playerFirstPiece = -10;
	int playerSecondPiece = -10;
	int playerThirdPiece = -10;
	int playerFourthPiece = -10;

	for (int i = 0; i < 9; i++) {
	    if (getOwnMoves(piecePositions)[i]) {
		if (botFirstPiece == -10) {
		    botFirstPiece = i;
		} else if (botSecondPiece == -10) {
		    botSecondPiece = i;
		} else {
		    botThirdPiece = i;
		}
	    }

	    if (getOpponentMoves(piecePositions)[i]) {
		if (playerFirstPiece == -10) {
		    playerFirstPiece = i;
		} else if (playerSecondPiece == -10) {
		    playerSecondPiece = i;
		} else if (playerThirdPiece == -10) {
		    playerThirdPiece = i;
		} else {
		    playerFourthPiece = i;
		}
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botFirstPiece, botSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botThirdPiece, botSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, botFirstPiece, botThirdPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerThirdPiece, playerSecondPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerThirdPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerFirstPiece, playerFourthPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerThirdPiece, playerFourthPiece, i)) {
		return i;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (willMoveWinGame(piecePositions, playerSecondPiece, playerFourthPiece, i)) {
		return i;
	    }
	}

	return getRandomInt();
    } //doEighthMove

    private int doNinthMove(String[] piecePositions) {
	for (int i = 0; i < 9; i++) {
	    if (!piecePositions[i].equals("X") && !piecePositions[i].equals("O")) {
		return i;
	    } // if
	}

	return getRandomInt();
    } //doNinthMove

} // Bot

