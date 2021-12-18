import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Game {    

    private String[] piecePositions;
    private String turn;
    private String playerPiece;
    private String botPiece;
    private Bot bot;
    private Random random;
    private int randomInt;
    
    public Game() {
	piecePositions = new String[9];
	for (int i = 0; i < 9; i++) {
	    piecePositions[i] = "-";
	} // for

	turn = "X";

	random = new Random();
        randomInt = random.nextInt(2);
	if (randomInt == 0) {
	    setPlayerPiece("X");
	    setBotPiece("O");
	    bot = new Bot("O");
	} else {
	    setPlayerPiece("O");
	    setBotPiece("X");
	    bot = new Bot("X");
	}

    } // Game Constructor


    public void playGame(Scanner keyboard) {
	System.out.println("");
	printBoard(piecePositions);

	int square = 0;
	if (turn.equals(getPlayerPiece())) {
	    do {
		System.out.println("\nWhich Square Would You Like To Place An " + turn + "? (1 - 9)");
		try {
		    square = keyboard.nextInt() - 1;
		} catch (InputMismatchException imme) {
		    System.out.println("Make Sure To Type A Number Between 1 And 9 Or Program Crashes");
		    System.exit(1);
		}
	    } while ((square < 0 || square > 8) || isSquareTaken(square, piecePositions));
	} else {
	    do {
		square = bot.createMove(getPiecePositions());
	    } while (isSquareTaken(square, piecePositions));
	}

	setPiece(square, turn);
	
	if (turn.equals("X")) {
	    turn = "O";
	} else {
	    turn = "X";
	}

	System.out.println("");

	if (hasPlayerWon("X")) {
	    System.out.println("");
	    printBoard(piecePositions);
	    System.out.println("Player X Wins!");
	} else if (hasPlayerWon("O")) {
	    System.out.println("");
	    printBoard(piecePositions);
	    System.out.println("Player O Wins!");
	} else if (isGameOver()) {
	    System.out.println("");
	    printBoard(piecePositions);
	    System.out.println("Tie!");
	}
    } // playGame

    public String getPlayerPiece() {
	return playerPiece;
    }

    public void setPlayerPiece(String playerPiece) {
	this.playerPiece = playerPiece;
    }

    public String getBotPiece() {
	return botPiece;
    }

    public void setBotPiece(String botPiece) {
	this.botPiece = botPiece;
    }

    public void printBoard(String[] piecesOnBoard) {
	System.out.print(piecesOnBoard[0]);
	System.out.print("|");
	System.out.print(piecesOnBoard[1]);
	System.out.print("|");
	System.out.println(piecesOnBoard[2]);
	
	System.out.print(piecesOnBoard[3]);
	System.out.print("|");
	System.out.print(piecesOnBoard[4]);
	System.out.print("|");
	System.out.println(piecesOnBoard[5]);

	System.out.print(piecesOnBoard[6]);
	System.out.print("|");
	System.out.print(piecesOnBoard[7]);
	System.out.print("|");
	System.out.println(piecesOnBoard[8]);	 
    }

    public String[] getPiecePositions() {
	return piecePositions;
    } //getPiecePositions

    public void setPiecePositions(String[] piecePositions) {
	this.piecePositions = piecePositions;
    } // piecePositions

    public String getPiece(int position) {
	return getPiecePositions()[position];
    }

    public void setPiece(int position, String piece) {
	String[] tempPiecePositions = getPiecePositions();
	tempPiecePositions[position] = piece;
	setPiecePositions(tempPiecePositions);
    } //setPiece

    public String getTurn() {
	return turn;
    } // getTurn

    public void setTurn(String turn) {
	this.turn = turn;
    } // setTurn

    public boolean isGameOver() {
	if (hasPlayerWon("X") || hasPlayerWon("O")) {
	    return true;
	}

	for (int i = 0; i < 9; i++) {
	    if (piecePositions[i].equals("-")) {
		return false;
	    }
	} // for

	return true;
    } // isGameOver

    public boolean hasPlayerWon(String piece) {
	if (piecePositions[4].equals(piece)) {
	    if (piecePositions[0].equals(piece) && piecePositions[8].equals(piece)) {
		return true;
	    } else if (piecePositions[2].equals(piece) && piecePositions[6].equals(piece)){
		return true;
	    } else if (piecePositions[3].equals(piece) && piecePositions[5].equals(piece)) {
		return true;
	    } else if (piecePositions[1].equals(piece) && piecePositions[7].equals(piece)) {
		return true;
	    } // else/if
	} // if

	if (piecePositions[0].equals(piece)) {
	    if (piecePositions[3].equals(piece) && piecePositions[6].equals(piece)) {
		return true;
	    } else if (piecePositions[1].equals(piece) && piecePositions[2].equals(piece)) {
		return true;
	    } // else/if
	} // if

	if (piecePositions[8].equals(piece)) {
	    if (piecePositions[7].equals(piece) && piecePositions[6].equals(piece)) {
		return true;
	    } else if (piecePositions[5].equals(piece) && piecePositions[2].equals(piece)) {
		return true;
	    } // else if
	} // if
	
	return false;
    }
    
    public boolean isSquareTaken(int square, String[] piecePositions) {
	if (piecePositions[square].equalsIgnoreCase("O") || piecePositions[square].equalsIgnoreCase("X")) {
	    return true;
	} // if
	
	return false;
    } //isSquareTaken

} // Game 
