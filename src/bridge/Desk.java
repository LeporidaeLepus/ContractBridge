package bridge;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Desk extends JPanel{
	final int WIDTH = 800;
	final int HEIGHT = 800;
	final int CARD_HEIGHT = 150;
	final int CENTER_LENGTH = 450;
	
	CardField east;
	CardField west;
	CardField north;
	CardField south;
	Center center;
	List<Integer> eastIDs = new ArrayList<>();
	List<Integer> westIDs = new ArrayList<>();
	List<Integer> northIDs = new ArrayList<>();
	List<Integer> southIDs = new ArrayList<>();
	List<Card> eastCards = new ArrayList<>();
	List<Card> westCards = new ArrayList<>();
	List<Card> northCards = new ArrayList<>();
	List<Card> southCards = new ArrayList<>();
	
	Bridge bridge;
	String banker;
	int bankerId = -1;
	protected int playerOnTurn;
	protected int count;
	protected String suit;	// suit of every turn
	protected String trumpSuit;
	protected int[] cardIDsSlot = {-1, -1, -1, -1};
	public int nTurns;
	public boolean isPlaying;	// whether the card game has started

	public Desk() {
		isPlaying = false;
		banker = "south";
		bankerId = 2;
		nTurns = 0;
		playerOnTurn = 0;
		count = 0;
		
		//set size
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMaximumSize(size);

		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		north = new HorizonCardField(this, "north");
		south = new HorizonCardField(this, "south");
		west = new VerticalCardField(this, "west");
		east = new VerticalCardField(this, "east");
		center = new Center(CENTER_LENGTH, CENTER_LENGTH);
		center.displayCards();
		
		north.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cf");
			}
		});
		
//		Card ca = new Card(1, true);
//		ca.setIsRotated(true);
//		center.add(ca);
		
		
		// Set the layout of the desk
		GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		this.setLayout(layout);
		
		// Set the horizon group
		GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup();
		hParalGroup.addComponent(north,CENTER_LENGTH,CENTER_LENGTH,CENTER_LENGTH);
		hParalGroup.addComponent(center,CENTER_LENGTH,CENTER_LENGTH,CENTER_LENGTH);
		hParalGroup.addComponent(south,CENTER_LENGTH,CENTER_LENGTH,CENTER_LENGTH);
		GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup();
		hSeqGroup.addGap(20);
		hSeqGroup.addComponent(west,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		hSeqGroup.addGroup(hParalGroup);
		hSeqGroup.addComponent(east,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		layout.setHorizontalGroup(hSeqGroup);
		
		// Set the vertical group
		GroupLayout.ParallelGroup vParalGroup = layout.createParallelGroup();
		vParalGroup.addComponent(west,CENTER_LENGTH,CENTER_LENGTH,CENTER_LENGTH);
		vParalGroup.addComponent(center,CENTER_LENGTH,CENTER_LENGTH,CENTER_LENGTH);
		vParalGroup.addComponent(east,CENTER_LENGTH,CENTER_LENGTH,CENTER_LENGTH);
		GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup();
		vSeqGroup.addGap(20);
		vSeqGroup.addComponent(north,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		vSeqGroup.addGroup(vParalGroup);
		vSeqGroup.addComponent(south,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		layout.setVerticalGroup(vSeqGroup);
	}
	
	public Desk(Bridge bridge) {
		this();
		this.bridge = bridge;
	}
	
	public Center getCenter() {
		return this.center;
	}
	
	public CardField getCardField(String position) {
		switch (position) {
		case "east":	return east;
		case "west":	return west;
		case "north":	return north;
		case "south":	return south;
		default:
			System.err.println("Error in Desk.getCardField(), "
					+ "argument must be one of east/west/north/south.");
			return null;
		}
	}
	
	public List<Integer> getCardIDs(String position){
		switch (position) {
		case "east":	return eastIDs;
		case "west":	return westIDs;
		case "north":	return northIDs;
		case "south":	return southIDs;
		default:
			System.err.println("Error in Desk.getCartList(), "
					+ "argument must be one of east/west/north/south.");
			return null;
		}
	}
	
	public String getBanker() {
		return this.banker;
	}
	
	public void setBanker(String banker) {
		switch (banker) {
		case "east":	
			this.bankerId = 1;
			break;
		case "west":	
			this.bankerId = 3;
			break;
		case "north":	
			this.bankerId = 0;
			break;
		case "south":	
			this.bankerId = 2;
			break;
		default:
			System.err.println("Error in Desk.setBanker(), "
					+ "argument must be one of east/west/north/south.");
			return;
		}
		
		this.banker = banker;
	}
	
//	public void setSuit(String suit) {
//		this.suit = suit;
//	}

	public void shuffleCards() {
		// Initialize a new pair of cards
		ArrayList<Integer> allCards = new ArrayList<>();
		for(int i = 0; i < 52; i++) {
			allCards.add(i);
		}
		
		// shuffle the cards randomly
		int times = new Random().nextInt(10);
		for (int k = 0; k < times; k++) {
			for (int i = 0; i < 52; i++) {
				int idx = new Random().nextInt(52);
				int temp = allCards.get(i);
				allCards.set(i, allCards.get(idx));
				allCards.set(idx, temp);
			}
		}
		
		// deal cards to each player
		eastIDs = allCards.subList(0, 13);
		westIDs = allCards.subList(13, 26);
		northIDs = allCards.subList(26, 39);
		southIDs = allCards.subList(39, 52);
		
		System.out.println(eastIDs.toString());
		System.out.println(westIDs.toString());
		System.out.println(northIDs.toString());
		System.out.println(southIDs.toString());
	}
	
	public void dealSelectedCards(String position) {
		CardField cardField = null;
		List<Integer> idsList = null;
		// get selected variables
		switch (position) {
		case "east":	
			cardField = this.east;
			idsList = this.eastIDs;
			break;
		case "west":	
			cardField = this.west;
			idsList = this.westIDs;
			break;
		case "north":	
			cardField = this.north;
			idsList = this.northIDs;
			break;
		case "south":	
			cardField = this.south;
			idsList = this.southIDs;
			cardField.setDisplayable(true);
			break;
		default:
			System.err.println(position + "Error in Desk.dealSelectedCards(), "
					+ "argument must be one of east/west/north/south.");
		}
		
		// sort the cards in order "♠", "♥", "♦", "♣" from K to A
		idsList.sort((a, b) -> {
			if (a / 13 != b / 13)
				return a / 13 - b / 13;
			else
				return b % 13 - a % 13;
		});
		
//		System.out.println(idsList.toString());
		
		cardField.setIDsList(idsList);
//		cardField.repaint();
	}
	
	public void dealCards() {
		dealSelectedCards("east");
		dealSelectedCards("west");
		dealSelectedCards("north");
		dealSelectedCards("south");
	}
	
	public void startPlaying() {
		this.playerOnTurn = this.bankerId;
		// Create a thread for each player
		Thread[] playerThreads = new Thread[4];
		for(int i = 0; i < 4; i++) {
			playerThreads[i] = new Thread(new Playing(i));
			playerThreads[i].start();
		}
	}
	
	public void moveToNextPlayer() {
		this.playerOnTurn = (this.playerOnTurn + 1) % 4;
	}
	
	public synchronized void checkCount() {
		if(count == 4) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// get the winner
			int winner = 0;
			for(int i = 1; i < 4; i++) {
				if (cardIDsSlot[i] > cardIDsSlot[winner])
					winner = i;
			}
			// update banker's win times
			if (winner == bankerId || winner == (bankerId + 2) / 4) {
				bridge.getBoard().plusOneWins();
			}
			
			// reset count
			count = 0;
			// update number of turns
			nTurns++;
			// reset center and cardIDsSlot
			for(int i = 0; i < 4; i++) {
				cardIDsSlot[i] = -1;
				center.cardsSlot[i] = null;
			}
			center.repaint();
		}
	}	
	
	
	public class Playing implements Runnable{
//		Desk desk;
		int playerId;
		CardField cardField;
		
		public Playing(int i) {
//			this.desk = desk;
			this.playerId = i;
			switch(i) {
			case 0 :
				cardField = getCardField("north");
				break;
			case 1 :
				cardField = getCardField("east");
				break;
			case 2 :
				cardField = getCardField("south");
				break;
			case 3 :
				cardField = getCardField("west");
				break;
			default:
				cardField = null;
			}
		}
		
		private int getSuitId(String suit) {
			switch(suit) {
			case "♠":	return 0;
			case "♥":	return 1;
			case "♦":	return 2;
			case "♣":	return 3;
			}
			return -1;
		}
		
		private void setSuit(int cardID) {
			switch(cardID/13) {
			case 0:
				suit = "♠";
				break;
			case 1:
				suit = "♥";
				break;
			case 2:
				suit = "♦";
				break;
			case 3:
				suit = "♣";
				break;
			}
		}
		
		private int playCardsWithNoTrump() {
			List<Integer> IDs = cardField.getIDsList();
			int id = IDs.remove(0);
			cardField.setIDsList(IDs);
			cardField.remove(0);
			cardField.repaint();
			return id;
		}
		
		private int playCardsWithTrumpOf(String trump) {
			if(trump == "NT") {
				return playCardsWithNoTrump();
			}
			
			int CardID = -1;
			List<Integer> IDs = cardField.getIDsList();
			int trumpId = getSuitId(trump);
			for(int i = 0; i < IDs.size(); i++) {
				if(IDs.get(i) / 13 == trumpId) {
					CardID = IDs.remove(i);
					cardField.setIDsList(IDs);
					cardField.remove(0);
					cardField.repaint();
					break;
				}
				// play cards with trump suit when there is no cards with current suit left 
				else if(IDs.get(i) / 13 > trumpId || i == IDs.size() - 1) {
					CardID = playCardsWithNoTrump();
					break;
				}
			}

			return CardID;
		}
		
		public void run() {
			while (nTurns != 13) {
				// players play cards when on their turns
				if(playerOnTurn == this.playerId) {
					System.out.println(playerId);
					
					int cardID = -1;
					// computer plays cards
					if(!cardField.getDisplayable()) {
						// if this is the first one to play, 
						// set the suit of this turn as the suit of the card it selected
						if (count == 0){
							cardID = playCardsWithNoTrump();
							setSuit(cardID);
						}
						else {
							// computer plays card automatically depends on the suit
							int suitId = getSuitId(suit);
							List<Integer> IDs = cardField.getIDsList();
							for(int i = 0; i < IDs.size(); i++) {
								if(IDs.get(i) / 13 == suitId) {
									cardID = IDs.remove(i);
									cardField.setIDsList(IDs);
									cardField.remove(0);
									cardField.repaint();
									break;
								}
								// play cards with trump suit when there is no cards with current suit left 
								else if(IDs.get(i) / 13 > suitId || i == IDs.size() - 1) {
									cardID = playCardsWithTrumpOf(trumpSuit);
									break;
								}
							}
						}
						cardIDsSlot[playerId] = cardID;
					}
					// user play cards
					else if (cardField.getDisplayable()) {
						// wait until user played the card
						while(cardField.isPlayed == false) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						// wait until get the selected card's id
						while(cardIDsSlot[playerId] == -1);						
						
						// if this is the first one to play, 
						// set the suit of this turn as the suit of the card it selected
						if (count == 0) {
							setSuit(cardIDsSlot[playerId]);
						}
					}
				
					count++;
					// check whether the turn is over
					checkCount();
					// this player's turn is end
					moveToNextPlayer();
					cardField.isPlayed = false;
					System.out.println(playerOnTurn);
				}
				
			}
		}
	}
	
	
//	public void dealSelectedCards(String position) {
//		CardField cardField = null;
//		List<Integer> idsList = null;
//		List<Card> cardsList = null;
//		
//		// get selected variables
//		switch (position) {
//		case "east":	
//			cardField = this.east;
//			idsList = this.eastIDs;
//			cardsList = this.eastCards;	
//			break;
//		case "west":	
//			cardField = this.west;
//			idsList = this.westIDs;
//			cardsList = this.westCards;
//			break;
//		case "north":	
//			cardField = this.north;
//			idsList = this.northIDs;
//			cardsList = this.northCards;
//			break;
//		case "south":	
//			cardField = this.south;
//			idsList = this.southIDs;
//			cardsList = this.southCards;
//			break;
//		default:
//			System.err.println(position + "Error in Desk.dealSelectedCards(), "
//					+ "argument must be one of east/west/north/south.");
//		}
//		
//		// sort the cards in order
//		idsList.sort((a, b) -> {
//			if (a / 13 != b / 13)
//				return a / 13 - b / 13;
//			else
//				return b % 13 - a % 13;
//		});
//		// refresh the cardList before deal new cards to it
//		cardsList.clear();
//		for (int i : idsList) {
//			cardsList.add(new Card(i));
//		}
//		cardField.setCardsList(cardsList);
//		cardField.repaint();
//	}
//	
//	public void dealCards() {
//		dealSelectedCards("east");
//		dealSelectedCards("west");
//		dealSelectedCards("north");
//		dealSelectedCards("south");
//	}
	
	
}
