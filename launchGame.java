package colletions;

import java.util.Random;
import java.util.Scanner;

class TicTacToe
{
    public  static  char [][] board;

	public TicTacToe() {
		board = new char[3][3];
		initBoard();
	}
	
	
    public void initBoard()
    {
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[i].length;j++)
    		{
    			board[i][j] = ' ';
    		}
    	}
    }
    
    public void display()
    {
    	System.out.println("-------------");
    	for(int i=0;i<board.length;i++)
    	{
    		System.out.print("|");
    		for(int j=0;j<board[i].length;j++)
    		{
    			System.out.print(" "+board[i][j]+" |");
    		}
    		System.out.println();
    		System.out.println("-------------");
    	}
    }
    
    
   static  public void placeMark(int row, int col, char mark)
    {    
    	if(row>=0 && row <=2)
    	{
    		if(col>=0 && col <=2)
    		{
    			if(board[row][col] == ' ')
    			{
    					if(mark == 'X' || mark == 'O')
    				{
    						board[row][col] = mark;
    						
    				}
    				else
    				{
    					System.out.println("Invalid symbol");
    				}
    				
    			}
    			else
    			{
    				System.out.println("Position occupied");
    			}
    			
    			
    		}
    		else
    		{
    			System.out.println("Invalid column");
    		}
    		
    		
    	}
    	else
        {
        	System.out.println("Invalid row");
        }
    	
    }
    
    static public boolean  CheckRow ()
    {
    	for(int i=0;i<=2;i++)
    	{
    		if((board[i][0]!=' ') && (board [i][0] == board  [i][1]) && (board[i][1] == board [i][2]))
    		 {
    		    return true;
    	      }
    	}
    	return false;
    	
    }
    
    
  static  public boolean  CheckCol ()
    {
    	for(int i=0;i<=2;i++)
    	{
    		if(((board [0][i] != ' ' )&& board [0][i] == board  [1][i]) && (board[1][i] == board [2][i]))
    		 {
    		    return true;
    	      }
    	}
    	return false;
    	
    }
    
   static  public boolean CheckDiag()
    {
    	if((board[0][0]!=' ')&& ((board[0][0] ==  board[1][1]) && (board[1][1] == board[2][2])) || ((board[0][2]!=' ') && (board[0][2]==board[1][1])&& (board[1][1] == board[2][0]))) 
    	{
    		return true;
    	}
    	return false;
    }
   
   
  static public boolean isBoardFull() {
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[i].length; j++) {
	            if (board[i][j] == ' ') {
	                return false;
	            }
	        }
	    }
	    return true;
	}

    
    
    }









abstract class Player
{
	String name;
	char mark;
	abstract void MakeMove();
	public boolean IsValidMove(int row, int col) {
		if((row >=0 && row <=2)&&(col>=0 && col <=2))
		{
			if(TicTacToe.board[row][col] == ' ')
			{
				return true;
			}
		}
return false;
}
}




















	class HumanPlayer extends Player
	{
		
		public HumanPlayer(String name, char mark)
		{
			this.name = name;
			this.mark = mark;
		}
		
		void MakeMove()
		{
			Scanner sc = new  Scanner(System.in);
			int row;
			int col;
			
			do
			{
				System.out.println("Enter the row and column values");
				row = sc.nextInt();
				col = sc.nextInt();
			}
			while(!IsValidMove(row,col));
			TicTacToe.placeMark(row,col,mark);
		}

		
	}
	
	
	
	
	
	class AIPlayer extends Player
	{

		AIPlayer(String name, char mark)
		{
		 this.name = name;
		 this.mark = mark;
		}
		void MakeMove() {
			Scanner sc = new Scanner(System.in);
			int row;
			int col;
			do
			{
				Random r = new Random();
				row = r.nextInt(3);
				col = r.nextInt(3);
			}
			while(!IsValidMove(row, col));
			TicTacToe.placeMark(row, col, mark);
		}
		
	}





















public class launchGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TicTacToe t = new TicTacToe();
		HumanPlayer p1 = new HumanPlayer("Bob", 'X');
		System.out.println("do you want to play against AI or Player");
		String user = sc.next();
		if(user.equalsIgnoreCase("ai"))
		{
			AIPlayer pl2 = new AIPlayer("TapAI",'O');
			Player cp;
			cp=p1;
			while(true)
			{
				System.out.println(cp.name+" turn now");
				cp.MakeMove();
				t.display();
				if(TicTacToe.CheckRow()|| TicTacToe.CheckCol()||TicTacToe.CheckDiag())
				{
					System.out.println(cp.name+" has won the game");
					break;
				}
				else if(TicTacToe.isBoardFull())
				{
					System.out.println("The game is a draw");
				}
				else
				{
					if(cp==p1)
					{
						cp=pl2;
					}
					else
						{
							cp=p1;
						}
					}
					
				}
		}
		else
		{
			HumanPlayer p2 = new HumanPlayer("Billy",'O');
			HumanPlayer b;
			b=p1;
			
			
			
			while(true)
			{
				System.out.println(b.name+" turn now");
				b.MakeMove();
				t.display();
				if(TicTacToe.CheckRow()|| TicTacToe.CheckCol()||TicTacToe.CheckDiag())
				{
					System.out.println(b.name+" has won the game");
					break;
				}
				else if(TicTacToe.isBoardFull())
				{
					System.out.println("The game is a draw");
				}
				else
				{
					if(b==p1)
					{
						b=p2;
					}
					else
						{
							b=p1;
						}
					}
					
				}
			
			}

		}
	}



