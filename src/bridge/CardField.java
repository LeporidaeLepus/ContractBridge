package bridge;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class CardField extends JPanel {
	List<Card> cards;

	public CardField() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setVisible(true);
	}
	
	public CardField(int width, int height) {
		this();
		this.setSize(width, height);
	}
	
	public void setCardsList(List<Card> cards) {
		this.cards = cards;
	}
	
	public abstract void displayCards();
}
