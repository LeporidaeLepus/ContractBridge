package bridge;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class VerticalCardField extends CardField {
	static final int WIDTH = 450;
	static final int HEIGHT = 150;
	
	public VerticalCardField() {
		super(WIDTH, HEIGHT);
	}
	
	public void displayCards() {
		
	}
	
	public void paintComponent(Graphics g) {
		if (cards.size() <= 0)	return;
		Graphics2D g2d = (Graphics2D)g;
		//rotate the images to vertical
		g2d.rotate(Math.toRadians(90), HEIGHT/2, HEIGHT/2);

		int offset = cards.get(0).getWidth() / 3;
		int x = (WIDTH - (offset * (cards.size() - 1) + cards.get(0).getWidth())) / 2;
		int y = (HEIGHT - cards.get(0).getHeight()) / 2;
		for (Card c : cards) {
			boolean draw = g2d.drawImage(c.getImage(), x, y, c.getWidth(), c.getHeight(), this);
			x += offset;
		}
	}
}
