import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Food implements Locatable{

	private Image image;
	private int xPos;
	private int yPos;
	
	
	
	public Food(int x, int y)
	{
		xPos = x;
		yPos = y;
		try
		{
			image = ImageIO.read(new File("src\\images\\food1.png"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}
	
	public void draw(Graphics window){
		window.drawImage(image,getX(),getY(),50,50,null);
	}
	
	public boolean checkHit(Ameoba am){
		if(am.getX() > this.getX() && am.getX() < this.getX() + 100) {
			if(am.getY() > this.getY() && am.getY() < this.getY() + 100) {
				return true;
			}
		}
		return false;
	}
	
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void setX(int x) {
		xPos = x;
	}
	
	public void setY(int y) {
		yPos = y;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return xPos;
	}

	public void erase(Graphics window) {
		window.fillRect(getX(),getY(),100,100);
	}
}