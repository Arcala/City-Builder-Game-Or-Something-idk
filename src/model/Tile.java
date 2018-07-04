package model;

public class Tile
{
	private int cost;
	private final TileType type;

	public Tile()
	{
		this.setCost(0);
		this.type = TileType.CASTLE;
	}

	public Tile(int cost)
	{
		this.setCost(cost);
		this.type = TileType.CASTLE;
	}

	public Tile(int cost, TileType type)
	{
		this.setCost(cost);
		this.type = type;
	}

	public TileType getType()
	{
		return type;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public String getSelText()
	{
		return "You've selected a " + this.tileTypeToString();
	}

	public String tileTypeToString()
	{
		if (this.getType() == TileType.CASTLE)
			return "Castle";
		else if (this.getType() == TileType.FARM)
			return "Farm";
		else if (this.getType() == TileType.HOUSE)
			return "House";
		else if (this.getType() == TileType.SCHOOL)
			return "School";

		return "Tile";
	}

}
