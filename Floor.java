import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Floor extends Canvas implements KeyListener, Runnable
{
	private Ameoba am;
	private Bacteria bac;
	private Food food;
	private Food food2;
	private Food food3;
	private int number = 2;
	private int number2 = 1000;
	private boolean canSwitch = true;
	private int currentSecond;
	private ArrayList<Food> aLotOfFood = new ArrayList<Food>();
	Calendar calendar = Calendar.getInstance();

	Foods foods = new Foods(0);
	
	private boolean[] keys;
	private BufferedImage back;

	public Floor()
	{
		setBackground(Color.black);
		
		keys = new boolean[5];

		am = new Ameoba(400,300,3);
		bac = new Bacteria(200,75,1);
		
		food = new Food(100,100);
		food2 = new Food(800,800);
		food3 = new Food(500,600);
		
		foods.addFood(food);
		foods.addFood(food2);
		foods.addFood(food3);
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.ORANGE);
		graphToBack.fillRect(0,0,1000,1000);
		graphToBack.setColor(Color.GREEN);
		graphToBack.drawString("GrowingLarger ", 25, 50 );
		foods.draw(graphToBack);
		bac.draw(graphToBack);
		am.draw(graphToBack);
		
		if(foods.checkHit(am) != null) {
			try {
				if(canSwitch && number == 2){
					canSwitch = false;
					number++;
					currentSecond = calendar.get(Calendar.SECOND);
					am.changeImage(2);
					foods.foodEaten(graphToBack,foods.checkHit(am));
					canSwitch = true;
				}
				else{
					canSwitch = false;
					am.changeImage(3);
					foods.foodEaten(graphToBack,foods.checkHit(am));
					canSwitch = true;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		if(bac.getX() < am.getX()){
			bac.move("RIGHT");
		}
		else if(bac.getX() > am.getX() + am.getImgW() - 20){
			bac.move("LEFT");
		}
		if(bac.getY() < am.getY()){
			bac.move("DOWN");
		}
		else if(bac.getY() > am.getY() + am.getImgH()){
			bac.move("UP");
		}
		
		if(bac.checkHit(am)){
			bac.setPos(1000, 0);
		}
		
		
		if(keys[0] == true)
		{
			am.move("LEFT");
		}

		if(keys[1] == true)
		{
			am.move("RIGHT");
		}
		
		if(keys[2] == true)
		{
			am.move("UP");
		}
		
		if(keys[3] == true)
		{
			am.move("DOWN");
		}
		
		if(keys[4] == true){
			
		}
		
		while(am.getX() < 0){
			am.move("RIGHT");
		}
		while(am.getX() + am.getImgW() - 10 > 999){
			am.move("LEFT");
		}
		while(am.getY() < 10){
			am.move("DOWN");
		}
		while(am.getY() + am.getImgH() - 10> 999){
			am.move("UP");
		}
		
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}
