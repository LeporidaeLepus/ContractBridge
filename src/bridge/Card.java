package bridge;

import java.awt.*;

import javax.swing.*;

public class Card extends JPanel{
	public int id;
	Image img;
	int height;
	int width;

	public Card() {
		super();
	}
	
	public Card(int id) {
		this();
		this.id = id;
		String name = new String("./img/" + (id + 1) + ".png");
		img = new ImageIcon(name).getImage();
		height = img.getHeight(null);
		width = img.getWidth(null);
		
		Dimension size = new Dimension(width, height);
		this.setPreferredSize(size);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setVisible(true);
		
	}
	
	public Image getImage() {
		return this.img;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createLineBorder(Color.black));
//		panel.setSize(100, 100);
////		panel.setLocation(0, 100);
//		Card card = new Card(1);
//		card.setLocation(100, 100);
//		panel.add(card);
//		frame.add(panel);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.setSize(500, 500);
//		
//		
//	}
}
