package bridge;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class HorizonCardFieldPanel extends JPanel {
	final int WIDTH = 450;
	final int HEIGHT = 150;
	public HorizonCardFieldPanel() {
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
	}
}
