package bridge;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

public class HorizonCardField extends CardField {
	static final int WIDTH = 450;
	static final int HEIGHT = 150;
	
	public HorizonCardField() {
		super(WIDTH, HEIGHT);
	}
	
//	public void setCardsList(List<Card> cards) {
//		this.cards = cards;
//	}
	
	public void displayCards() {
		int offset = cards.get(0).getWidth() / 3;
		int x = (WIDTH - (offset * (cards.size() - 1) + cards.get(0).getWidth())) / 2;
		int y = (HEIGHT - cards.get(0).getHeight()) / 2;
		for (Card c : cards) {
//			System.out.println(c.id);
			this.add(c, 0);
			c.setLocation(x, y);
			c.repaint();
			x += offset;
		}
	}
//	public void paintComponent(Graphics g) {
//		if (cards.size() <= 0)	return;
//		
//		int offset = cards.get(0).getWidth() / 3;
//		int x = (WIDTH - (offset * (cards.size() - 1) + cards.get(0).getWidth())) / 2;
//		int y = (HEIGHT - cards.get(0).getHeight()) / 2;
//		for (Card c : cards) {
//			boolean draw = g.drawImage(c.getImage(), x, y, c.getWidth(), c.getHeight(), null);
//			x += offset;
//		}
//	}
}
