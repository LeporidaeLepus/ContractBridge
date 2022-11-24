package bridge;

import java.awt.Color;

import javax.swing.*;

public class VerticalCardFieldPanel extends JPanel {
	final int WIDTH = 120;
	final int HEIGHT = 500;
	public VerticalCardFieldPanel() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
	}
}
