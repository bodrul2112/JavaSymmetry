import java.awt.BorderLayout;

import javax.swing.JFrame;


public class DrawingFrame {
	
	public DrawingFrame() {
		// TODO Auto-generated constructor stub
		JFrame f = new JFrame();
		f.setSize(1366,700);
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
