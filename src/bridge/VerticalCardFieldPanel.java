package bridge;

import java.awt.Color;

import javax.swing.*;

public class VerticalCardFieldPanel extends JPanel {
	final int WIDTH = 150;
	final int HEIGHT = 450;
	public VerticalCardFieldPanel() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
	}
}
