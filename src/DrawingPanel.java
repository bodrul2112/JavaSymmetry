import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener
{
	

	BufferedImage backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
	ArrayList<Point> mousePoints = new ArrayList<Point>();
	Rectangle r1 = new Rectangle(0,0,600,600); 
	
	public DrawingPanel() {
		// TODO Auto-generated constructor stub
		Graphics2D  g2d = (Graphics2D) backBuffer.getGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 600, 600);
		
		g2d.setColor(Color.RED);
		//g2d.drawLine(r1.x, r1.y, r1.width, r1.y+r1.height);
		g2d.drawLine(r1.x, r1.y, r1.width, r1.height);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//g2d.setColor(Color.BLACK);
		//g2d.drawLine(0, 0, 100, 100);
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(backBuffer, 0, 0, this);
		
		
	}
	

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Graphics2D  g2d = (Graphics2D) backBuffer.getGraphics();
		g2d.setColor(Color.BLACK);
		
		
		mousePoints.add(new Point(e.getX(), e.getY()));
		if(mousePoints.size()>1){
			for(int i=1; i<mousePoints.size(); i++){
				Point p1 = mousePoints.get(i-1);
				Point p2 = mousePoints.get(i);
				g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
			}
		}
		
		
		/*
		ArrayList<Point> reflectivePoints = new ArrayList<Point>();
		for(Point p : mousePoints){
			reflectivePoints.add(new Point(600-p.y, 600-p.x));
		}
		
		if(reflectivePoints.size()>1){
			for(int i=1; i<reflectivePoints.size(); i++){
				Point p1 = reflectivePoints.get(i-1);
				Point p2 = reflectivePoints.get(i);
				g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
			}
		}*/
		
		
		ArrayList<Point> reflectivePoints2 = new ArrayList<Point>();
		for(Point p : mousePoints){
			reflectivePoints2.add(new Point(p.y, p.x));
		}
		
		if(reflectivePoints2.size()>1){
			for(int i=1; i<reflectivePoints2.size(); i++){
				Point p1 = reflectivePoints2.get(i-1);
				Point p2 = reflectivePoints2.get(i);
				g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
			}
		}
		
		
		
		
		this.repaint();
		e.consume();
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePoints = new ArrayList<Point>();
		e.consume();
	}
	
}
