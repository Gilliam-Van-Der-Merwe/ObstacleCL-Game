
public class King extends Pieces
{
	private String icon;
	
	public King(int x, int y, int plyrPceCol, String i)
	{
		super(x, y, plyrPceCol, i);
	}
	
	public King(int plyrPceCol, String i)
	{
		super(plyrPceCol, i);
		
		if(plyrPceCol == 0)
		{
			icon = "K";
		}
		else
		{
			icon = "k";
		}
	}

	public boolean isValidKingMove()
	{
		return true;
	}
}
