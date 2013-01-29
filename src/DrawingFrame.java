import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawingFrame {
	
	public DrawingFrame() {
		// TODO Auto-generated constructor stub
		JFrame f = new JFrame();
		f.setSize(600,600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		DrawingPanel centerPanel = new DrawingPanel();
		f.add(centerPanel, BorderLayout.CENTER);
		//centerPanel.setBackground(Color.RED);
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		DrawingFrame df = new DrawingFrame();
	}

}
