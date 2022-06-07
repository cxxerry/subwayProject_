import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class StationButton extends JButton {

	public StationButton() { super(); decorate(); } 
	public StationButton(String name) { super(name); decorate(); }
	
	protected void decorate() { 
		setContentAreaFilled(false); 
		setFocusPainted(false); setBackground(new Color(50,50,50,50)); setBorder(new LineBorder(Color.BLACK, 1));
	}
	
	@Override 
	protected void paintComponent(Graphics g) {
		Color c = new Color(204,204,255); //배경색 결정
		Color o = new Color(247,99,12); //글자색 결정
		
		int width = getWidth(); 
		int height = getHeight();
		
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
		else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
		else { graphics.setColor(c); } 
		
		graphics.fillArc(0, 0, width, height, 0, 360);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		int textX = (width - stringBounds.width) / 2; 
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		graphics.setColor(o); 
		graphics.setFont(getFont()); 
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); 
		super.paintComponent(g); 
	}
}
