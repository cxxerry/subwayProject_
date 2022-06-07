import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RoutePanel2 extends JPanel implements MouseListener {
	private MyFrame frame;
	private MyActionListener btnListener = new MyActionListener();
	private ArrayList<JButton> stationList = new ArrayList<>();
	private JButton btnClose;
	private MiniPopupPanel popup;
	
	public RoutePanel2(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);

		setMap();
		setCloseButton();
		
		addMouseListener(this);
	}
	
	public void setMap() {
		JLabel title = new JLabel("2È£¼±");
		title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		title.setBounds(20, 5, 200, 80);
		add(title);
		
		ImageIcon icon = new ImageIcon("images/2È£¼±.jpg");
		JLabel img = new JLabel();
		img.setIcon(icon);
		img.setBounds(0, 250, icon.getIconWidth(), icon.getIconHeight());
		
		JButton station1 = new JButton(); stationList.add(station1); station1.setName("101");
		JButton station2 = new JButton(); stationList.add(station2); station2.setName("201");
		JButton station3 = new JButton(); stationList.add(station3); station3.setName("202");
		JButton station4 = new JButton(); stationList.add(station4); station4.setName("203");
		JButton station5 = new JButton(); stationList.add(station5); station5.setName("204");
		JButton station6 = new JButton(); stationList.add(station6); station6.setName("205");
		JButton station7 = new JButton(); stationList.add(station7); station7.setName("206");
		JButton station8 = new JButton(); stationList.add(station8); station8.setName("207");
		JButton station9 = new JButton(); stationList.add(station9); station9.setName("208");
		JButton station10 = new JButton(); stationList.add(station10); station10.setName("209");
		JButton station11 = new JButton(); stationList.add(station11); station11.setName("210");
		JButton station12 = new JButton(); stationList.add(station12); station12.setName("211");
		JButton station13 = new JButton(); stationList.add(station13); station13.setName("212");
		JButton station14 = new JButton(); stationList.add(station14); station14.setName("213");
		JButton station15 = new JButton(); stationList.add(station15); station15.setName("214");
		JButton station16 = new JButton(); stationList.add(station16); station16.setName("215");
		JButton station17 = new JButton(); stationList.add(station17); station17.setName("216");
		JButton station18 = new JButton(); stationList.add(station18); station18.setName("217");

		station1.setBounds(36, 214, 12, 12);
		station2.setBounds(37, 161, 12, 12);
		station3.setBounds(37, 129, 12, 12);
		station4.setBounds(37, 98, 12, 12);
		station5.setBounds(36, 65, 12, 12);
		station6.setBounds(38, 33, 12, 12);
		station7.setBounds(69, 34, 12, 12);
		station8.setBounds(97, 34, 12, 12);
		station9.setBounds(131, 35, 12, 12);
		station10.setBounds(162, 33, 12, 12);
		station11.setBounds(205, 32, 12, 12);
		station12.setBounds(293, 33, 12, 12);
		station13.setBounds(332, 33, 12, 12);
		station14.setBounds(381, 33, 12, 12);
		station15.setBounds(422, 35, 12, 12);
		station16.setBounds(460, 35, 12, 12);
		station17.setBounds(497, 33, 12, 12);
		station18.setBounds(560, 33, 12, 12);

		for (JButton b : stationList) {
			b.setBackground(Color.white);
			b.setFocusPainted(false);
			b.setBorder(new RoundBorder(30));
			b.addActionListener(btnListener);
			img.add(b);
		}
		
		add(img);
	}
	
	public void setCloseButton() {
		ImageIcon closeIcon = new ImageIcon("images/´Ý±â.png");
		Image closeImg = closeIcon.getImage();
		Image changeCloseImg = closeImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon changecloseIcon = new ImageIcon(changeCloseImg);
		
		btnClose = new JButton(changecloseIcon);
		btnClose.setBounds(530, 20, 50, 50);
		btnClose.setBackground(Color.white);
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.addActionListener(btnListener);
		add(btnClose);
	}
	
	class MyActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnClose) {
				popup.addPopup("false");
				frame.change("mainPanel");
			} else {
				for (JButton b : stationList) {
					if (e.getSource() == b) {
						popup = new MiniPopupPanel(frame);
						popup.setStationName(b.getName());
						add(popup);
						popup.addPopup("true");
						break;
					}
				}
			}
		}
				
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX() + " " + e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
