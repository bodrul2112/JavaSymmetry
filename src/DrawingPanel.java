import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener
{
	
	BufferedImage backBuffer = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
	ArrayList<Point> mousePoints = new ArrayList<Point>();
	ArrayList<LineXY> reflection_lines = new ArrayList<LineXY>();
	
	public DrawingPanel() {
		// TODO Auto-generated constructor stub
		Graphics2D  g2d = (Graphics2D) backBuffer.getGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 2000, 2000);
		
		int offset = 0;
		
		/*
		
		// x sign
		reflection_lines.add(new LineXY(0+offset, 0+offset, 600+offset, 600+offset));
		reflection_lines.add(new LineXY(0+offset, 600+offset, 600+offset, 0+offset));
		
		
		
		offset+=100;
		
		reflection_lines.add(new LineXY(0+offset, 0+offset, 600+offset, 600+offset));
		reflection_lines.add(new LineXY(0+offset, 600+offset, 600+offset, 0+offset));
		
		
		offset-=200;
		reflection_lines.add(new LineXY(0+offset, 0+offset, 600+offset, 600+offset));
		reflection_lines.add(new LineXY(0+offset, 600+offset, 600+offset, 0+offset)); 
		
		*/
		
		int n=1000;
		
		for(int i=0; i<5; i++){
			reflection_lines.add(new LineXY((int)(Math.random()*n),(int)(Math.random()*n),(int)(Math.random()*n),(int)(Math.random()*n)));
			
		}
		
		// cross sign
		//reflection_lines.add(new LineXY(0, 300, 600, 300));
		//reflection_lines.add(new LineXY(300,0,300,600)); 
		
		for(LineXY line : reflection_lines){
			g2d.setColor(Color.RED);
			g2d.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
		
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
		
		
		ArrayList<ArrayList<Point>> allpoints = new ArrayList<ArrayList<Point>>();
		allpoints.add(mousePoints);
		
		for(LineXY line : reflection_lines){
		
			for(int j=0; j<allpoints.size(); j++){
			
					ArrayList<Point> reflectivePoints2 = new ArrayList<Point>();
					ArrayList<Point> originalPoints = allpoints.get(j);
					for(Point p : originalPoints){
					
						  Point p0 = new Point(line.x1,line.y1);
						  Point p1 = new Point(line.x2,line.y2);
							
						  double nx = p1.x - p0.x;
						  double ny = p1.y - p0.y;
						  double d = Math.sqrt((nx*nx + ny*ny));
						  nx /= d;
						  ny /= d;
				
						  int px = p.x - p0.x;
						  int py = p.y - p0.y;
						  int w  = (int) ( nx*px + ny*py);
						  int rx = (int) (2*p0.x - p.x + 2*w*nx);
						  int ry = (int) (2*p0.y - p.y + 2*w*ny);
						  
						reflectivePoints2.add(new Point(rx, ry));
					}
					
					if(reflectivePoints2.size()>1){
						for(int i=1; i<reflectivePoints2.size(); i++){
							Point p1 = reflectivePoints2.get(i-1);
							Point p2 = reflectivePoints2.get(i);
							g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
		
						}
					}
					
					if(allpoints.size()<2 && j<reflection_lines.size()-1) {
						if(allpoints.size()==2){
							allpoints.remove(0);
						}
						allpoints.add(reflectivePoints2); 
					}
			
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
