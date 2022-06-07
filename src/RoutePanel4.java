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

public class RoutePanel4 extends JPanel  implements MouseListener {
	private MyFrame frame;
	private MyActionListener btnListener = new MyActionListener();
	private ImageIcon icon;
	private JLabel img;
	private ArrayList<JButton> stationList = new ArrayList<>();
	private JButton btnClose;
	//private MiniPopupPanel popup = new MiniPopupPanel(frame);
	
	public RoutePanel4(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		setMap();
		setCloseButton();
		
		addMouseListener(this);
	}
	
	public void setMap() {
		JLabel title = new JLabel("4È£¼±");
		title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		title.setBounds(20, 5, 200, 80);
		add(title);
		
		ImageIcon icon = new ImageIcon("images/4È£¼±.jpg");
		JLabel img = new JLabel();
		img.setIcon(icon);
		img.setBounds(0, 200, icon.getIconWidth(), icon.getIconHeight());
		
		JButton station1 = new JButton(); stationList.add(station1); station1.setName("104");
		JButton station2 = new JButton(); stationList.add(station2); station2.setName("401");
		JButton station3 = new JButton(); stationList.add(station3); station3.setName("307");
		JButton station4 = new JButton(); stationList.add(station4); station4.setName("402");
		JButton station5 = new JButton(); stationList.add(station5); station5.setName("403");
		JButton station6 = new JButton(); stationList.add(station6); station6.setName("404");
		JButton station7 = new JButton(); stationList.add(station7); station7.setName("405");
		JButton station8 = new JButton(); stationList.add(station8); station8.setName("406");
		JButton station9 = new JButton(); stationList.add(station9); station9.setName("407");
		JButton station10 = new JButton(); stationList.add(station10); station10.setName("115");
		JButton station11 = new JButton(); stationList.add(station11); station11.setName("408");
		JButton station12 = new JButton(); stationList.add(station12); station12.setName("409");
		JButton station13 = new JButton(); stationList.add(station13); station13.setName("410");
		JButton station14 = new JButton(); stationList.add(station14); station14.setName("411");
		JButton station15 = new JButton(); stationList.add(station15); station15.setName("412");
		JButton station16 = new JButton(); stationList.add(station16); station16.setName("413");
		JButton station17 = new JButton(); stationList.add(station17); station17.setName("414");
		JButton station18 = new JButton(); stationList.add(station18); station18.setName("415");
		JButton station19 = new JButton(); stationList.add(station19); station19.setName("416");
		JButton station20 = new JButton(); stationList.add(station20); station20.setName("417");
		JButton station21 = new JButton(); stationList.add(station21); station21.setName("216");

		station1.setBounds(33, 367, 14, 14);
		station2.setBounds(68, 366, 14, 14);
		station3.setBounds(103, 366, 14, 14);
		station4.setBounds(140, 366, 14, 14);
		station5.setBounds(177, 366, 14, 14);
		station6.setBounds(224, 366, 14, 14);
		station7.setBounds(274, 366, 14, 14);
		station8.setBounds(324, 366, 14, 14);
		station9.setBounds(364, 366, 14, 14);
		station10.setBounds(401, 366, 14, 14);
		station11.setBounds(435, 366, 14, 14);
		station12.setBounds(471, 366, 14, 14);
		station13.setBounds(516, 366, 14, 14);
		station14.setBounds(556, 368, 14, 14);
		station15.setBounds(556, 306, 14, 14);
		station16.setBounds(556, 279, 14, 14);
		station17.setBounds(557, 224, 14, 14);
		station18.setBounds(555, 176, 14, 14);
		station19.setBounds(557, 140, 14, 14);
		station20.setBounds(556, 77, 14, 14);
		station21.setBounds(557, 31, 14, 14);
		
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
