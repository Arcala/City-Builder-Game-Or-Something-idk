package model;

import java.util.Observable;
import java.util.Random;

public class Game extends Observable
{
	private Tile[][] map;
	Random rand = new Random();
	int randNum;

	public Game()
	{
		map = new Tile[10][10];

		// fill the board with tiles
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				randNum = rand.nextInt(4);

				if (randNum == 0)
				{
					map[i][j] = new Tile(0, TileType.CASTLE);
				} else if (randNum == 1)
				{
					map[i][j] = new Tile(0, TileType.FARM);
				} else if (randNum == 2)
				{
					map[i][j] = new Tile(0, TileType.SCHOOL);
				} else if (randNum == 3)
				{
					map[i][j] = new Tile(0, TileType.HOUSE);
				}
			}
		}
	}

	public Tile[][] getMap()
	{
		return this.map;
	}

	public TileType getTileType(int i, int j)
	{
		return map[i][j].getType();
	}
}
