package bridge;

import java.awt.*;

import javax.swing.*;

public class Board extends JPanel {
	final int WIDTH = 200;
	final int HEIGHT = 800;
	JLabel score;
	JButton start;
	

	public Board() {
		super();
		this.setLayout(new GridLayout(4,1));
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel name = new JLabel();
		name.setText("User Name:");
		this.add(name);
		
		JLabel position = new JLabel();
		position.setText("Position:");
		this.add(position);
		
		score = new JLabel();
		score.setText("Score:");
		this.add(score);
		
		start = new JButton("START");
		this.add(start);
	}

}
