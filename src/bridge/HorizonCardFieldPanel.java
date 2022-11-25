package bridge;

import java.awt.Graphics;
import java.util.*;

public class HorizonCardFieldPanel extends CardField {
	static final int WIDTH = 450;
	static final int HEIGHT = 150;
	List<Card> cards;
	
	public HorizonCardFieldPanel() {
		super(WIDTH, HEIGHT);
		cards = new ArrayList<Card>();
	}
	
	public void setCardsList(List<Card> cards) {
		this.cards = cards;
	}
	
	public void displayCards() {
//		int offset = 0;
//		for (Card c : cards) {
//			System.out.println(c.id);
//			c.setLocation(offset, 0);
//			this.add(c);
//			c.repaint();
//			offset += 27;
//		}
	}
	public void paintComponent(Graphics g) {
		if (cards.size() <= 0)	return;
		
		int offset = cards.get(0).getWidth() / 3;
		int x = (WIDTH - (offset * (cards.size() - 1) + cards.get(0).getWidth())) / 2;
		int y = (HEIGHT - cards.get(0).getHeight()) / 2;
		for (Card c : cards) {
			g.drawImage(c.getImage(), x, y, c.getWidth(), c.getHeight(), null);
			x += offset;
		}
	}
}
