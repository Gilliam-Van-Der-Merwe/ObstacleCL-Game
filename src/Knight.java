
public class Knight extends Pieces
{
	private String icon;
	
	public Knight(int x, int y, int plyrPceCol, String i)
	{
		super(x, y, plyrPceCol, i);
	}
	
	public Knight(int plyrPceCol, String i)
	{
		super(plyrPceCol, i);
		
		if(plyrPceCol == 0)
		{
			icon = "N";
		}
		else
		{
			icon = "n";
		}
	}
	
	public boolean isValidKnightMove()
	{
		return true;
	}

}
