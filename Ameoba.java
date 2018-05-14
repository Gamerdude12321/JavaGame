//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ameoba extends MovingThing
{
	private int speed;
	private Image image;
	private int w;
	private int h;

	public Ameoba()
	{
		this(0,0,0);
	}

	public Ameoba(int x, int y)
	{
		this(x,y,0);
	}

	public Ameoba(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\images\\playersize1.png"));
			BufferedImage bimg = ImageIO.read(new File("src\\images\\playersize1.png"));
			w = bimg.getWidth();
			h = bimg.getHeight();
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}
	
	public void changeImage(int num) throws IOException {
		if(num == 2) {
			image = ImageIO.read(new File("src\\images\\playersize2.png"));
			BufferedImage bimg = ImageIO.read(new File("src\\images\\playersize2.png"));
			w = bimg.getWidth();
			h = bimg.getHeight();
		}
		else {
			image = ImageIO.read(new File("src\\images\\playersize3.png"));
			BufferedImage bimg = ImageIO.read(new File("src\\images\\playersize3.png"));
			w = bimg.getWidth();
			h = bimg.getHeight();
		}
	}
	
	public int getImgW(){
		return w;
	}
	
	public int getImgH(){
		return h;
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
		window.drawImage(image,getX(),getY(),w - 20,h - 20,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}