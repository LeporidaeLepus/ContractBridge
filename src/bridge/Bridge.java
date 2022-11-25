package bridge;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Bridge extends JFrame {
	final int WIDTH = 1024;
	final int HEIGHT = 850;
	Desk desk;
	Board board;

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
		board.getStart().addActionListener(new StartAction(desk));
	}
	
	public Desk getDesk() {
		return this.desk;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public class StartAction implements ActionListener{
		Desk desk;
		
		public StartAction(Desk desk) {
			this.desk = desk;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			this.desk.shuffleCards();
			this.desk.dealCards();
		}
	}
	
	
	public static void main(String[] args) {
		Bridge bridge = new Bridge();
	}
}
