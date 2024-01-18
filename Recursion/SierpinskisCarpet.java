package Recursion;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * @garrettspillman1
 *                   This class represents a simple implementation of
 *                   Sierpinski's Carpet using recursion.
 *                   It extends the Canvas class to draw the carpet on a JFrame.
 */
public class SierpinskisCarpet extends Canvas {

	/**
	 * The main method to create a JFrame and display Sierpinski's Carpet.
	 *
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sierpinski's Carpet");
		frame.setSize(900, 900);
		SierpinskisCarpet sp = new SierpinskisCarpet();
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Overrides the paint method to draw Sierpinski's Carpet on the canvas.
	 *
	 * @param g The Graphics object to paint on.
	 */
	@Override
	public void paint(Graphics g) {
		drawCarpet(0, 0, this.getSize().height, g);
	}

	/**
	 * Recursively draws Sierpinski's Carpet on the specified area.
	 *
	 * @param x    The x-coordinate of the top-left corner of the area.
	 * @param y    The y-coordinate of the top-left corner of the area.
	 * @param side The side length of the square area.
	 * @param g    The Graphics object to draw on.
	 */
	public void drawCarpet(int x, int y, int side, Graphics g) {
		int sub = side / 3;
		g.fillRect(x + sub, y + sub, sub, sub);
		if (sub >= 3) {
			// Top
			drawCarpet(x, y, sub, g); // Left
			drawCarpet(x + sub, y, sub, g); // Middle
			drawCarpet(x + sub * 2, y, sub, g); // Right
			// Middle
			drawCarpet(x, y + sub, sub, g); // Left
			drawCarpet(x + sub * 2, y + sub, sub, g); // Right
			// Bottom
			drawCarpet(x, y + sub * 2, sub, g); // Left
			drawCarpet(x + sub, y + sub * 2, sub, g);// Middle
			drawCarpet(x + sub * 2, y + sub * 2, sub, g); // Right
		}
	}
}