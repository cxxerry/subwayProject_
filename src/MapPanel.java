import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MapPanel extends JPanel{
	private int startStation, startStation1, x;
	public ArrayList<Integer> shortestPath1;
	
		@Override
		public void paint(Graphics g)
		    {
			 	super.paint(g); 
			 	Graphics2D g2 = (Graphics2D)g;
			 	g2.setColor(Color.blue);
			 	g2.setStroke(new BasicStroke(3.0f));
		        g2.drawLine(30,225,(x)*50+30,225);
		        int m = 15;
		        int n = 65;
		        for(int i = 0;i<x+1;i++) {
		        	if(i==0) {
		        
		        g2.drawOval(15,210,30,30);
		        g2.fillOval(15, 210, 30, 30);
		        	}
		        	else {
		       
		        g2.drawOval(m=m+50,210,30,30);	
		        g2.fillOval(m, 210, 30, 30);
		        	}
		        }
		        x=0;
		        
		        Database DB1 = new Database(); 
		        for(int k=shortestPath1.size() -1; k >= 0 ; k--)
		        {
		        	if(k==shortestPath1.size() -1) {
		        	
		        		g2.drawString(startStation+"",15,200);
		        		startStation1 = DB1.backconversionIndex(shortestPath1.get(k));
		        		g2.drawString(startStation1+"",65,200);
		        	}
		        	else {
		        		startStation1 = DB1.backconversionIndex(shortestPath1.get(k));
		        		g2.drawString(startStation1+"",n=n+50,200);
		        	}
		        }
		}	
	}