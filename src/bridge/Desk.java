package bridge;

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

	

}
