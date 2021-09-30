public class Mine extends Pieces
{
	
	private String icon;
	
	public Mine(int x, int y, int plyrPceCol, String i)
	{
		super(x, y, plyrPceCol, i);
	}
	
	public Mine(int plyrPceCol, String i)
	{
		super(plyrPceCol, i);
		
		if(plyrPceCol == 0)
		{
			icon = "M";
		}
		else
		{
			icon = "M";
		}
	}

	public boolean isValidMinePlacement()
	{
		return true;
	}
	
}