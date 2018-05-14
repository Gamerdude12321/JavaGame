import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Bacteria extends MovingThing
{
	private int speed;
	private Image image;

	public Bacteria()
	{
		this(0,0,0);
	}

	public Bacteria(int x, int y)
	{
		this(x,y,0);
	}

	public Bacteria(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\images\\enemy.png"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	public boolean checkHit(Ameoba am){
		if(am.getX() + am.getImgW() > this.getX() && am.getX() < this.getX() + 50) {
			if(am.getY() + am.getImgH() > this.getY() && am.getY() < this.getY() + 50) {
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		return speed + " ";
	}
}
