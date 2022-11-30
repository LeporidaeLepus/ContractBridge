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
		board.getStart().addActionListener(new StartAction(desk, board));
	}
	
	public Desk getDesk() {
		return this.desk;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public class StartAction implements ActionListener{
		Desk desk;
		Board board;
		
		public StartAction(Desk desk, Board board) {
			this.desk = desk;
			this.board = board;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			this.desk.isPlaying = true;
			this.desk.shuffleCards();
			this.desk.dealCards();
			
			String[] orderOptions = {"1", "2", "3", "4", "5", "6", "7"};
			String order = (String)JOptionPane.showInputDialog(desk, "Choose the order: ", "Bid", 
					JOptionPane.OK_OPTION, null, orderOptions, orderOptions[0]);
			String[] suitOptions = {"♠", "♥", "♦", "♣", "NT"};
			String suit = (String)JOptionPane.showInputDialog(desk, "Choose the trump suit: ", "Bid", 
					JOptionPane.OK_OPTION, null, suitOptions, suitOptions[0]);
			this.board.setContract(new String(order + " " + suit));
			
			
		}
	}
	
	
	public static void main(String[] args) {
		Bridge bridge = new Bridge();
	}
}
