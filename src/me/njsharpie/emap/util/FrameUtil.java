package me.njsharpie.emap.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class FrameUtil extends Object {
	
	// New Graphics2D named page - used to draw things
	private static Graphics2D page = null;
	
	// The degree of movement used to move the turtle
	public static final double DEGREE = Math.PI / 180;
	
	//Where the pen is initially facing
	private double heading = 0;
	
	// Is the pen on the paper?
	public boolean isDown;
	
	// Defines the size of the frame
	public final int WIDTH = 770;
	public final int HEIGHT = 698;
	// Colors!!!
	Color RED = new Color(229, 0, 0);
	Color ORANGE = new Color(255, 165, 0);
	Color GREEN = new Color(0, 128, 0);
	
	// Used to make circles using the fillCircle function
	private double xcor = WIDTH / 2; 
	private double ycor = HEIGHT / 2;
	
	// Lets this class (FrameUtil.java) to use Graphics defined earlier
	public FrameUtil(Graphics g) {
		page = (Graphics2D) g;
	}
	
	// Stops the program from drawing
	public void sleep (int wait) {	
		long timeToQuit = System.currentTimeMillis() + wait;
		while (System.currentTimeMillis() < timeToQuit);
	}
	
	// Switches colors for the program to draw
	public void switchTo (Color given) {	
		page.setColor (given);
	}
	
	// Rotates the pen left (by default), used to draw the crosshair
	// Negative numbers will go right
	public FrameUtil turn (double angle) {
		heading += angle * DEGREE;
		return this;
	}
	
	// Moves the pen forward, used to draw the crosshair
	public FrameUtil forward (double forward) {	
		if(isDown() == true) {
			double x = xcor + forward * Math.cos (heading);
			double y = ycor - forward * Math.sin (heading);
			page.draw (new Line2D.Double (xcor, ycor, x, y));
			xcor = x;
			ycor = y;
			return this;
		} else {
			xcor += forward * Math.cos (heading);
			ycor -= forward * Math.sin (heading);
			return this;
		}
	}
	
	// Lifts the pen from the paper
	public void up() {
		this.isDown = false;
	}
	
	// Places the pen onto the paper
	public void down() {
		this.isDown = true;
	}
	
	// Asks if the pen is on the paper
	public boolean isDown() {
		return this.isDown;
	}
	
	// Makes a circle
	public void fillCircle (double radius) {	
		page.fill (new Ellipse2D.Double (xcor - radius, 
		            ycor - radius, 2 * radius, 2 * radius));
	}
	
	// Changes the position of the "pen", used to define points on the graph
	public void setPos(double x, double y) {
		page.translate(x, y);
	}
	
	// Adds a triangle crosshair to the frame when called.
	public void addTriangle() {	
		down();
		forward(9);
		turn(120);
		forward(9);
		turn(120);
		forward(9);
		turn(120);
		up();
	}
	
	// Adds a square crosshair to the frame when called.
	public void addSquare() {
		down();
		forward(9);
		turn(90);
		forward(9);
		turn(90);
		forward(9);
		turn(90);
		forward(9);
		turn(90);
		up();
	}
	
	// Adds the "X" crosshair to the frame when called.
	public void addX() {
		page.drawString ("X", (int) xcor, (int) ycor);
	}
	
	// The actual frame
	public FrameUtil() {
		if(page == null) {
			JFrame frame = new JFrame("eMap");
		    frame.addWindowListener(new Closer());
			frame.setSize (WIDTH, HEIGHT);
			frame.setVisible (true);
			BufferedImage img;
			try {
				img = ImageIO.read(new File("C:\\$data\\eMap.PNG"));
				int w = img.getWidth(null);
				int h = img.getHeight(null);
				BufferedImage bi = new
				    BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				page = (Graphics2D) bi.getGraphics();
				page.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			page = (Graphics2D) frame.getGraphics();
			frame.paint (page);
		}
	}
	
	public void close() {
		if(page == null) {
			return;
		} else {
			System.exit(0);
		}
	}
	
	// New class to act as a closer for the frame, hence the listener
	private static class Closer implements WindowListener {
		
		// Main and only class we want to modify from the WindowListener
		public void windowClosing (WindowEvent e) {	
			System.exit (0);
		}
		
		// Other unused, but needed methods
		public void windowActivated (WindowEvent e)     { }
		public void windowDeactivated (WindowEvent e)   { }
		public void windowIconified (WindowEvent e)     { }
		public void windowDeiconified (WindowEvent e)   { }
		public void windowOpened (WindowEvent e)        { }
		public void windowClosed (WindowEvent e)        { }
	}     
	
}
