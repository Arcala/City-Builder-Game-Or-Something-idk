package view;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Game;
import model.TileType;

public class CityView extends BorderPane implements Observer
{

	private Game theGame;
	Label label;
	Canvas canvas;
	GraphicsContext gc;
	Image farm, farmSel, house, houseSel, school, schoolSel, castle, castleSel;
	private String[] chatBoxArr;
	private static final int IMGSIZE = 60;
	private int prevSelX, prevSelY;

	// provides the DrawingView for the TicTacToe game...
	public CityView(Game game)
	{
		theGame = game;
		chatBoxArr = new String[5];
		chatBoxArr[0] = "Welcome to the game <3";
		chatBoxArr[1] = "Welcome to the game <3";
		chatBoxArr[2] = "Welcome to the game <3";
		chatBoxArr[3] = "Welcome to the game <3";
		chatBoxArr[4] = "Welcome to the game <3";
		
		prevSelX = -1;
		prevSelY = -1;

		farm = new Image("file:images/farm.png", false);
		house = new Image("file:images/house.png", false);
		school = new Image("file:images/school.png", false);
		castle = new Image("file:images/castle.png", false);
		farmSel = new Image("file:images/farmSelected.png", false);
		houseSel = new Image("file:images/houseSelected.png", false);
		schoolSel = new Image("file:images/schoolSelected.png", false);
		castleSel = new Image("file:images/castleSelected.png", false);

		canvas = new Canvas(600, 800);

		gc = canvas.getGraphicsContext2D();

		drawBoxes();
		drawTextBox();

		canvas.setOnMouseMoved(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event)
			{
				drawBoxes();
				boolean flag = false;
				gc.setStroke(Color.BLACK);

				for (int i = 0; i < 10; i++)
				{
					for (int j = 0; j < 10; j++)
					{
						if (event.getX() > (i * IMGSIZE) && event.getX() < ((i + 1) * IMGSIZE)
								&& event.getY() > (j * IMGSIZE) && event.getY() < ((j + 1) * IMGSIZE))
						{
							gc.fillRect(i * IMGSIZE, j * IMGSIZE, IMGSIZE, IMGSIZE);
							gc.drawImage(getTileName(i, j, true), i * 60, j * 60);
							
							if (prevSelX != i || prevSelY != j)
							{
								addToChatBox(theGame.getTile(i, j).getSelText());
								drawText();
								
								prevSelX = i;
								prevSelY = j;
							}
			

							flag = true;
							break;
						}
					}

					if (flag)
						break;
				}
			}
		});

		setCenter(canvas);
		setAlignment(canvas, Pos.TOP_CENTER);
	}
	
	private void addToChatBox(String newLine)
	{
		// hard-coding this because I am stupidly lazy lol
		String tempOne = chatBoxArr[0];
		String tempTwo = chatBoxArr[1];
		
		chatBoxArr[0] = newLine;
		chatBoxArr[1] = tempOne;
		
		tempOne = chatBoxArr[2];
		
		chatBoxArr[2] = tempTwo;
		
		tempTwo = chatBoxArr[3];
		
		chatBoxArr[3] = tempOne;
		chatBoxArr[4] = tempTwo;
	}

	private void drawTextBox()
	{
		gc.setFill(Color.BLACK);
		gc.fillRoundRect(0, 625, 600, 150, 20, 20);
		
		drawText();
	}

	private void drawText()
	{
		gc.setFill(Color.WHITE);
		gc.fillRoundRect(15, 638, 570, 125, 20, 20);
		gc.setFill(Color.BLACK);
		gc.setFont(Font.font("Courier", 20));
		
		for (int i = 0; i < 5; i++)
		{
			gc.fillText(chatBoxArr[i], 25, 756-(i*25));
		}
	}

	private void drawBoxes()
	{
		gc.setStroke(Color.GRAY);
		int xPos = 0, yPos = 0;

		gc.clearRect(0, 0, 600, 600);

		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				gc.strokeRect(xPos, yPos, 60, 60);
				gc.drawImage(getTileName(i, j, false), i * 60, j * 60);
				xPos += 60;
			}

			xPos = 0;
			yPos += 60;
		}
	}

	private Image getTileName(int i, int j, boolean sel)
	{
		if (theGame.getTileType(i, j) == TileType.CASTLE)
		{
			if (sel)
				return castleSel;
			else
				return castle;
		} else if (theGame.getTileType(i, j) == TileType.FARM)
		{
			if (sel)
				return farmSel;
			else
				return farm;
		} else if (theGame.getTileType(i, j) == TileType.SCHOOL)
		{
			if (sel)
				return schoolSel;
			else
				return school;
		} else if (theGame.getTileType(i, j) == TileType.HOUSE)
		{
			if (sel)
				return houseSel;
			else
				return house;
		}

		return null;
	}

	// whenever an observer is notified...
	@Override
	public void update(Observable observable, Object arg)
	{
	}

	// Draws the X and O images on the canvas respective to their coordinates on the
	// board.
	private void updateDrawing()
	{
	}
}
