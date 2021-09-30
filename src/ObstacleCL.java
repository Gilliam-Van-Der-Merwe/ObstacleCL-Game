import java.util.Scanner;

public class ObstacleCL
{
	private static String gameInput;
	private static String boardFile;
	private static String gameOutput;
	
	private static Board b;
	
	public static void main(String[] args) 
	{	
		
		boardFile = args[0];
		gameInput = args[1];
		gameOutput = args[2];
	    
		b = new Board(boardFile, gameInput, gameOutput);
		System.out.println(boardFile);
		System.out.println(gameInput);
		System.out.println(gameOutput);
		
		if(args.length == 4)
		{
			String mode = args[3];
			GUIMode();
		}
		else if(args.length == 3)
		{
			textBasedInterfaceMode();
		}
		else
		{
			System.out.println("Invalid Input");
		}
		

	}
	
	public static void textBasedInterfaceMode()
	{
		boolean GameOver = false;
		String move = "";
		Scanner scMove = new Scanner(System.in);// move input is made through text file which needs to be scanned in.
		b.boardInit();
		
		while(GameOver != true)
		{	
			b.boardDisplay();
			move = scMove.next();
			b.moveConversion(move);
			b.boardDisplay();
			GameOver = true;
			scMove.close();
		}
	}
	
	public static void GUIMode()
	{
		b.GUISetup();
	}

}
