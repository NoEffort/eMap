package me.njsharpie.emap;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import me.njsharpie.emap.util.FrameUtil;

/*
 *
 * Concept by: Ale
 * Program by: Nelson
 *
 * Project Supervisors: Ale
 *
 *
 *-
 * Date Started: 04/05/18
 * Date Completed: 04/
 *
 */

public class EMap {
		  
	public static int x;
	public static int y;
	public static int xi;
	public static int yi;
	public static boolean coords = true;
	
	public void paint(Graphics g) {
		g.drawLine(xi, yi, xi, yi);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				Scanner scan = new Scanner(System.in);
				
				System.out.println("Please choose an x coordinate: ");
				x = scan.nextInt();
				System.out.println("Please choose an y coordinate: ");
				y = scan.nextInt();
				System.out.println("Map size set to: " + x + ", " + y);
				FrameUtil.createFrame(x, y);
				
				while(coords == true) {
					if(scan.nextLine() == "close" || scan.nextLine() == "exit") {
						System.out.println("Closing the map...");
						FrameUtil.closeFrame();
						coords = false;
						scan.close();
						return;
					} else {
						System.out.println("Specify x and y coordinates to add a point!");
						xi = scan.nextInt();
						yi = scan.nextInt();
						FrameUtil.addPoint(xi, yi);
					}

				}
				
				scan.close();
				
			}
		});

	}

}
