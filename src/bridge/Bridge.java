package bridge;

import java.awt.FlowLayout;

import javax.swing.*;

public class Bridge extends JFrame {
	final int WIDTH = 1024;
	final int HEIGHT = 850;
	JPanel desk;
	JPanel board;

	public Bridge() {
		super("Bridge");
		
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		
		desk = new Desk();
		this.add(desk);
		board = new Board();
		this.add(board);
	}
	
	
	public static void main(String[] args) {
		Bridge bridge = new Bridge();
		
	}
}
