import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	Game game = new Game();
	boolean play = true;
	
	while(play == true) {
	    while (!game.isGameOver()) {
		game.playGame(keyboard);
	    } //  while

	    play = false;
	    System.out.println("\nPlay Again? (y/n)");	    
	    if (keyboard.next().equalsIgnoreCase("y")) {
		play = true;
		game = new Game();
	    } // if
	} // while
    } // main
} // Driver 
