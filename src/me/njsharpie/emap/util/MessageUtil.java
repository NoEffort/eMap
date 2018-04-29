package me.njsharpie.emap.util;

import java.util.Scanner;

public class MessageUtil {
	
	// Creates a new Scanner called scan using the Scanner.java class
	// Scanner.java class created by Sun Microsystems
	public static Scanner scan = new Scanner(System.in);
	
	// Creates a new JFrame called frame using the FrameUtil.java class
	// FrameUtil.java class created by Nelson and Ale
	public static FrameUtil frame = new FrameUtil();
	
	public static void sendMessage(String message) {
		System.out.println(message);
	}
	
	public static void run() {
		
		int x;
		int y;
		
		String tree = "Tree";
		String pothole = "Pothole";
		String other = "Other";
		String low = "1";
		String intermediate = "2";
		String emergency = "3";
		
		String[] obstacles = {tree, pothole, other};
		String[] levels = {low, intermediate, emergency};
			
		boolean isRunning = true;
		
		while(isRunning == true) {
			
			sendMessage("What is the issue? " + String.join(", ", obstacles));
			
			String input = scan.nextLine();
			
		    if(input.equals(tree)){
				sendMessage("Specify an x coordinate: ");
				x = scan.nextInt();
				sendMessage("Specify a y coordinate: ");
				y = scan.nextInt();
				sendMessage("Points: " + x + ", " + y + " selected!");
				sendMessage("How important is this issue? " + String.join(", ", levels));
				
				int level = scan.nextInt();
				
				if(level == 1) {
					frame.switchTo(frame.GREEN);
				}
				else if(level == 2) {
					frame.switchTo(frame.ORANGE);
				}
				else if(level == 3) {
					frame.switchTo(frame.RED);
				}
				sendMessage("Your point has been placed on the map.");
				
				frame.setPos(x, y);
				frame.addX();
				isRunning = true;
	        }
		    else if(input.equals(pothole)){
				sendMessage("Specify an x coordinate: ");
				x = scan.nextInt();
				sendMessage("Specify a y coordinate: ");
				y = scan.nextInt();
				sendMessage("Points: " + x + ", " + y + " selected!");
				sendMessage("How important is this issue? " + String.join(", ", levels));
				
				int level = scan.nextInt();
				
				if(level == 1) {
					frame.switchTo(frame.GREEN);
				}
				else if(level == 2) {
					frame.switchTo(frame.ORANGE);
				}
				else if(level == 3) {
					frame.switchTo(frame.RED);
				}
				sendMessage("Your point has been placed on the map.");
					
				frame.setPos(x, y);
				frame.addTriangle();
				isRunning = true;
	        }
		    else if(input.equals(other)){
				sendMessage("Specify an x coordinate: ");
				x = scan.nextInt();
				sendMessage("Specify a y coordinate: ");
				y = scan.nextInt();
				sendMessage("Points: " + x + ", " + y + " selected!");
				sendMessage("How important is this issue? " + String.join(", ", levels));
				
				int level = scan.nextInt();
				
				if(level == 1) {
					frame.switchTo(frame.GREEN);
				}
				else if(level == 2) {
					frame.switchTo(frame.ORANGE);
				}
				else if(level == 3) {
					frame.switchTo(frame.RED);
				}
				sendMessage("Your point has been placed on the map.");
				
				frame.setPos(x, y);
				frame.addSquare();
				isRunning = true;
	        }
		}
		scan.close();
		
	}
	
}
