package othello_game;
import java.util.Scanner;

public class Othello {
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public static void main(String[] args) {
		OthelloBoard b = new OthelloBoard();
		Scanner s=new Scanner(System.in);  
		System.out.print("Enter no of moves:");
		int n = s.nextInt();  //based users interest we will run that many times
		n=n*2; // for 1 move both user 1 and user 2 have to play so it is multiplied by 2
		boolean p1Turn = true;
		b.print();
		while(n > 0) {
			if(p1Turn) {
				System.out.println("Player 1's turn ....");
			}else {
				System.out.println("Player 2's turn ....");
			}
			System.out.print("Enter x value:");
			int x = s.nextInt();
			System.out.print("Enter y value:");
			int y = s.nextInt();
			boolean ans = false;   //indicates invalid move which is returned from move function
			if(p1Turn) {
				ans = b.move(player1Symbol, x, y);
			}
			else {
				ans = b.move(player2Symbol, x, y);
			}
			if(ans) {  //checking if the move is valid or not
				b.print();
				p1Turn = !p1Turn;
				n--;
			}
			else {
				System.out.println("Wrong move try again:");
			}
		}
		int winner=b.winner();  //after completion of moves checking who is the winner
		if(winner==1) {
			System.out.println("Player 1 wins......");
		}
		else if(winner==2) {
			System.out.println("Player 2 wins......");
		}
		else {
			System.out.println("Draw..");
		}
	}

}
