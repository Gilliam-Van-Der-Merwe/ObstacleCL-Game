import java.awt.Color;
import java.util.Scanner;

public class Board 
{	
	private final static int INVALID = -1;
	private final int WHITE_PIECE = 0;
	private final int BLACK_PIECE = 1;
	private final int EMPTY_SPACE = 2;
	
	private final int PLAYER_1 = 0;
	private final int PLAYER_2 = 1;
	
	private final static int BOARD_SIZE = 8;
	
	private final String ALPHABET = "ABCDEFGH";
	
	private static String[][] board;
	private String boardFile, inputFile, outputFile;
	private static PiecesArray b;
	
	public Board(String bFile, String inFile, String outFile)
	{
		boardFile = bFile;
		inputFile = inFile;
		outputFile = outFile;
		b = new PiecesArray(boardFile, inputFile, outputFile);
	}
	
	public static void boardInit()// Method to initialize String board matrix with PieceArray Object. 
	{
		board = new String[BOARD_SIZE][BOARD_SIZE];
		String boardSetup = b.toString();
		int index = 0;
		for(int r = 0; r < BOARD_SIZE; r++)
		 {
			 for(int c = 0; c < BOARD_SIZE; c++)
			 {
				 board[r][c] = "" + boardSetup.charAt(index);
				 index++;
			 }
		 }
	}
	
	public void boardDisplay()// Method to display board via console.
	{
		String temp;
		int temp2;
	    System.out.print(" ");
	    for(int i = 0; i < BOARD_SIZE; i++)
		{
	    	 temp = ALPHABET.substring(i, i+1);
			 System.out.print(" " + temp + " ");
		}
		System.out.println();
		for(int r = 0; r < BOARD_SIZE; r++)
	    {
			temp2 = BOARD_SIZE - r;
			System.out.print(temp2);

			 for(int c = 0; c < BOARD_SIZE; c++)
			 {
				System.out.print(" " + board[r][c] + " ");
			 }
			System.out.println();
	    }
	}
	
	public void moveConversion(String movement)// Method to take given move input and convert to array position.
	{
		String[] temp = movement.split("-");
		String currentMoveLoc = temp[0];
		String newMoveLoc = temp[1];
		
		System.out.println(currentMoveLoc + " --> " + newMoveLoc);
		
		int[] moveConvert = new int[4];
		
		if(movement.equals("QUIT"))
        {
        	System.out.println("Player Quit");
        	System.exit(0);
        }
		
		for(int k = 0; k < currentMoveLoc.length(); k++)
		{
			if(k == 0)
			{
				for(int j = 0; j < ALPHABET.length(); j++)
				{
					if(currentMoveLoc.charAt(k) == ALPHABET.charAt(j))
					{
						moveConvert[1] = j;
					}
				}
			}
			else if(k == 1)
			{
				moveConvert[0] = BOARD_SIZE - Character.getNumericValue(currentMoveLoc.charAt(k));
			}
		}
		
		for(int k = 0; k < newMoveLoc.length(); k++)
		{
			if(k == 0)
			{
				for(int j = 0; j < ALPHABET.length(); j++)
				{
					if(newMoveLoc.charAt(k) == ALPHABET.charAt(j))
					{
						moveConvert[3] = j;
					}
				}
			}
			else if(k == 1)
			{
				moveConvert[2] = BOARD_SIZE - Character.getNumericValue(newMoveLoc.charAt(k));
			}
		}
		
		System.out.println(moveConvert[0] + " " + moveConvert[1] + " " + moveConvert[2] + " " + moveConvert[3]);
		makeMove(moveConvert[0],moveConvert[1],moveConvert[2],moveConvert[3]);
		
		/*if(isValidMove(moveConvert[0],moveConvert[1],moveConvert[2],moveConvert[3]))
		{
			makeMove(moveConvert[0],moveConvert[1],moveConvert[2],moveConvert[3]);
			boardDisplay();
		}
		else
		{
			System.out.println("ERROR: invalid move");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Move");
			String move = sc.next();
			redoCheck(move, pNum);
			sc.close();
		}*/
	}
	
	public static String getPiece(int r, int c)
	{
		if ((r < 0) || (r >= BOARD_SIZE)) {
			return "" + INVALID;
		}
		if ((c < 0) || (c >= BOARD_SIZE)) {
			return "" + INVALID;
		}
		return board[r][c];
	}
	
	public void isValidMove()
	{
		
	}
	
	public void makeMove(int fromRow, int fromCol, int toRow, int toCol)// Method to move object from previous pos to new pos.
	{
		board[toRow][toCol] = board[fromRow][fromCol];
		board[fromRow][toCol] = ".";
	}
	
	public void saveGame()
	{
		
	}
	
	public void loadGame()
	{
		
	}
	
	public static void GUISetup()
	  {
		StdDraw.init();
		StdDraw.setCanvasSize(900, 900);
		StdDraw.setXscale(0, BOARD_SIZE+1);
		StdDraw.setYscale(0, BOARD_SIZE+1);
	    
		boardInit();
	    drawGUI();    
	  }
	
	 public static void drawGUI() // method renders graphical user interface of the board
		{
		  StdDraw.setPenColor(Color.RED);
		  StdDraw.filledSquare(BOARD_SIZE+1, BOARD_SIZE+1, 0.5);
		  
			for(int r = 0; r < BOARD_SIZE; r++)
			  {  
				  for(int c = 0; c < BOARD_SIZE; c++)
				  {
					  if((r+c) % 2 == 0)
					  {
						  StdDraw.setPenColor(Color.YELLOW);
						  StdDraw.filledSquare((c+1), (r+1), 0.5);
					  }
					  else
					  {
						  StdDraw.setPenColor(Color.GRAY);
						  StdDraw.filledSquare((c+1), (r+1), 0.5);
					  }
				  }
			  }
			
		}

	public static int SquareMoveCount(int fromRow, int fromCol, int toRow, int toCol) {
		// TODO Auto-generated method stub
		return 0;
	}
}
