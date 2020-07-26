import java.util.ArrayList;
import java.util.List;



public class Board{

    public static final int no_player=0;
    public static final int player_ai=1;
    public static final     int player_human=2;  //  public static  int winner=0;
       public static final int board[][]=new int[3][3];
	   public Location computerMove;
      public boolean isGameOver() {
    	  return hasPlayerwon(player_ai)||hasPlayerwon(player_human)||getAvaliablecell().isEmpty();
 }
       
   public boolean hasPlayerwon(int player)
   {    //horizontal
       for(int i=0;i<3;i++)
       {
           if(board[i][0]==board[i][1]&&board[i][0]==board[i][2] &&board[i][0]==player)
           {
        	   return true;
           }
       }
       
       //vertical
        for(int i=0;i<3;i++)
       {
           if(board[0][i]==board[1][i]&&board[0][i]==board[2][i]&&board[0][i]==player)
           {
        	   return true;
           }
           
       }
       ///dignol
       if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]==player)
       {
//           winner=board[0][0];
//           System.out.println(winner);
           return true;
       }
       if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[0][2]==player)
       {

           return true;
       }
       
       return false;
   }
   
   public List<Location> getAvaliablecell(){
	   List<Location> avaliablecell=new ArrayList<Location>();
	   
	   for(int i=0;i<3;i++)
	   {
		   for(int j=0;j<3;j++)
		   {
			   if(board[i][j]==no_player)
				   avaliablecell.add(new Location(i,j));
		   }
	   }
	   
	   return avaliablecell;
	   
   }
   public boolean placeAMove(Location location,int player)
   {
	if(board[location.x][location.y]!=no_player) 
		return false;
	
	board[location.x][location.y]=player;
	   return true;
   
   }
   public void displayboard()
   {System.out.println();
	   
	   for(int i=0;i<3;i++)
	   {
		   for(int j=0;j<3;j++)
		   {
			   String value="?";
			   if(board[i][j]==player_ai)
				   value="Ai";
			   if(board[i][j]==player_human)
				   value="H";
			   
			   System.out.print(value+" ");
		   }
		   System.out.println();
	   }
	   System.out.println();
   }
   
   public int minimax(int depth, int turn) {
       if (hasPlayerwon(1)) return +10;  //for ai_player
       if (hasPlayerwon(2)) return -10;  //for human

       List<Location> pointsAvailable = getAvaliablecell();
       if (pointsAvailable.isEmpty()) return 0;

       int min = Integer.MAX_VALUE; 
       int max = Integer.MIN_VALUE;

       for (int i = 0; i < pointsAvailable.size(); ++i) {
           Location location = pointsAvailable.get(i);
           if (turn == 1) {
               placeAMove(location , 1);   //player ai
               int currentScore = minimax(depth + 1, 2);//call for human turn
               max = Math.max(currentScore, max);

               if(currentScore >= 0){ if(depth == 0)
               {
            	   computerMove = location ; 
               //System.out.println("Computer Score for poistion "+location +"="+currentScore);
               
               }
               }
               if(currentScore == 1){
               board[location.x][location.y] = 0;
               break;}
               if(i == pointsAvailable.size()-1 && max < 0){
            	   if(depth == 0)computerMove = location ;}
           } else if (turn == 2) {   //player human
               placeAMove(location , 2);
               int currentScore = minimax(depth + 1, 1);//call for ai_player
               min = Math.min(currentScore, min);

           }
           board[location.x][location .y] = 0; //Reset this point
       }
       return turn == 1?max:min;
   }
   

   
}




