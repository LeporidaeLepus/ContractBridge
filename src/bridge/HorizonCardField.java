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
	
	public void setCardsList() {
		// refresh the cardList before set new cards to it
		this.cards.clear();
		// if the displayable is true, show the card to the player
		if (this.displayable == true) {
			for (int i : this.cardsIDs) {
				this.cards.add(new Card(i, false));
			}
		}else {	// if the displayable is false, show the back of the card to the player
			for (int i : this.cardsIDs) {
				this.cards.add(new Card(-1, false));
			}
		}
	}
	
	public void displayCards() {
		int offset = cards.get(0).getImageWidth() / 3;
		int x = (WIDTH - (offset * (cards.size() - 1) + cards.get(0).getImageWidth())) / 2;
		int y = (HEIGHT - cards.get(0).getImageHeight()) / 2;
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
