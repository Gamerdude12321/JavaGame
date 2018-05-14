import java.awt.Component;

import javax.swing.JFrame;

public class GrowingLarger extends JFrame
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;

	public GrowingLarger()
	{
		super("Growing Larger");
		setSize(WIDTH,HEIGHT);

		Floor theGame = new Floor();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		GrowingLarger run = new GrowingLarger();
	}
}