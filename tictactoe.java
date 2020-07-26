import java.util.Random;
import java.util.Scanner;

public class tictactoe {

	
	public static final Random rand=new Random();
	public static void main(String[] args)
	{
		
		Board b=new Board();
		Scanner sc=new Scanner(System.in);
		b.displayboard();
		System.out.println("Select 1.computer turn \n 2.human");
		int choice=sc.nextInt();
		
		if(choice==Board.player_ai)
		{
			Location p=new Location(rand.nextInt(3),rand.nextInt(3));
			//Location p=new Location(0,0);
			b.placeAMove(p, Board.player_ai);
			b.displayboard();
		}
		
		while(!b.isGameOver())
		{
			boolean moveok=true;
			
			
			do {
				if(!moveok)
				{
					System.out.println("Cell already fill");
				}
				System.out.println("Your moves");
				Location usermove=new Location(sc.nextInt(),sc.nextInt());
				moveok=b.placeAMove(usermove, Board.player_human);
				
				
			}while(!moveok);
			b.displayboard();
			
			if(b.isGameOver())
				break;
			
			b.minimax(0, Board.player_ai);
			
			System.out.println("Computer chosse position:"+b.computerMove);
		b.placeAMove(b.computerMove, Board.player_ai);
		b.displayboard();
		}
		
		if(b.hasPlayerwon(Board.player_ai))
			System.out.println("You lost!");
		else if(b.hasPlayerwon(Board.player_human))
			System.out.println("You win!");
		else
			System.out.println("Draw!");
	}
}
