
public class Bishop extends Pieces
{
	private boolean validBishopMove;
	private String icon;
	
	public Bishop(int x, int y, int plyrPceCol, String i)
	{
		super(x, y, plyrPceCol, i);
	}
	
	public Bishop(int plyrPceCol, String i)
	{
		super(plyrPceCol, i);
		
		if(plyrPceCol == 0)
		{
			icon = "B";
		}
		else
		{
			icon = "b";
		}
	}
	
	public boolean isValidBishopMove()
	{
		return true;
	}
	
}
