package bridge;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class CardField extends JPanel {
	List<Integer> cardsIDs;
	List<Card> cards;
	boolean displayable;

	public CardField() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setVisible(true);
		
		cards = new ArrayList<Card>();
		displayable = false;
	}
	
	public CardField(int width, int height) {
		this();
		this.setSize(width, height);
	}
	
	// if the cardField belongs to the player, set the displayable to true;
	public void setDisplayable(boolean flag) {
		this.displayable = flag;
	}
	
	public void setIDsList(List<Integer> cardsIDs) {
		this.cardsIDs = cardsIDs;
		setCardsList();
		this.repaint();
		this.displayCards();
	}
	
	public void setCardsList() {
		// refresh the cardList before set new cards to it
		this.cards.clear();
		// if the displayable is true, show the card to the player
		if (this.displayable == true) {
			for (int i : this.cardsIDs) {
				this.cards.add(new Card(i));
			}
		}else {	// if the displayable is false, show the back of the card to the player
			for (int i : this.cardsIDs) {
				this.cards.add(new Card(-1));
			}
		}
	}
	
	public abstract void displayCards();
}
