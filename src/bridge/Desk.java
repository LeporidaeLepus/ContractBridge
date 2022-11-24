package bridge;

import java.util.*;
import java.util.List;
import java.awt.*;

import javax.swing.*;

public class Desk extends JPanel{
	final int WIDTH = 800;
	final int HEIGHT = 800;
	final int CARD_HEIGHT = 120;
	final int TABLE_LENGTH = 500;
	JPanel east;
	JPanel west;
	JPanel north;
	JPanel south;
	JPanel table;
	List<Integer> eastList = new ArrayList<>();
	List<Integer> westList = new ArrayList<>();
	List<Integer> northList = new ArrayList<>();
	List<Integer> southList = new ArrayList<>();

	public Desk() {
		
		//set size
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMaximumSize(size);

		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		north = new HorizonCardFieldPanel();
		south = new HorizonCardFieldPanel();
		west = new VerticalCardFieldPanel();
		east = new VerticalCardFieldPanel();
		table = new JPanel();
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		table.setSize(TABLE_LENGTH, TABLE_LENGTH);
		
		// Set the layout of the desk
		GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		this.setLayout(layout);
		
		// Set the horizon group
		GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup();
		hParalGroup.addComponent(north,TABLE_LENGTH,TABLE_LENGTH,TABLE_LENGTH);
		hParalGroup.addComponent(table,TABLE_LENGTH,TABLE_LENGTH,TABLE_LENGTH);
		hParalGroup.addComponent(south,TABLE_LENGTH,TABLE_LENGTH,TABLE_LENGTH);
		GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup();
		hSeqGroup.addGap(20);
		hSeqGroup.addComponent(west,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		hSeqGroup.addGroup(hParalGroup);
		hSeqGroup.addComponent(east,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		layout.setHorizontalGroup(hSeqGroup);
		
		// Set the vertical group
		GroupLayout.ParallelGroup vParalGroup = layout.createParallelGroup();
		vParalGroup.addComponent(west,TABLE_LENGTH,TABLE_LENGTH,TABLE_LENGTH);
		vParalGroup.addComponent(table,TABLE_LENGTH,TABLE_LENGTH,TABLE_LENGTH);
		vParalGroup.addComponent(east,TABLE_LENGTH,TABLE_LENGTH,TABLE_LENGTH);
		GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup();
		vSeqGroup.addGap(20);
		vSeqGroup.addComponent(north,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		vSeqGroup.addGroup(vParalGroup);
		vSeqGroup.addComponent(south,CARD_HEIGHT,CARD_HEIGHT,CARD_HEIGHT);
		layout.setVerticalGroup(vSeqGroup);
	}

	public void shuffleCard() {
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
		eastList = allCards.subList(0, 13);
		westList = allCards.subList(13, 26);
		northList = allCards.subList(26, 39);
		southList = allCards.subList(39, 52);
		
//		System.out.println(eastList.toString());
//		System.out.println(westList.toString());
//		System.out.println(northList.toString());
//		System.out.println(southList.toString());

	}

}
