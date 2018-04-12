package me.njsharpie.emap.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameUtil extends JPanel {
	
	public static String title = "eMap";
	public static JFrame frame = new JFrame(title);
	
	public static void addPoint(int x, int y) {
		FrameUtil panel = new FrameUtil();
		frame.add(panel);
		frame.setVisible(true);	
	}
	
	public static void createFrame(int x, int y) {
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new FrameUtil());

	    JLabel emptyLabel = new JLabel("");
	    emptyLabel.setPreferredSize(new Dimension(x, y));
	    frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		    
	    frame.pack();
	    frame.setResizable(false);
	    frame.setVisible(true);
		    
	}
	
	public static void closeFrame() {
		frame.setVisible(false);
	}
	
}
