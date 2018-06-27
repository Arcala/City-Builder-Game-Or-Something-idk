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
	
}
