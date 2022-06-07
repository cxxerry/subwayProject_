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

public class RoutePanel3 extends JPanel implements MouseListener {
	private MyFrame frame;
	private MyActionListener btnListener = new MyActionListener();
	private ImageIcon icon;
	private JLabel img;
	private ArrayList<JButton> stationList = new ArrayList<>();
	private JButton btnClose;
	//private MiniPopupPanel popup = new MiniPopupPanel(frame);
	
	public RoutePanel3(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		setMap();
		setCloseButton();
		
		addMouseListener(this);
	}

	public void setMap() {
		JLabel title = new JLabel("3È£¼±");
		title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		title.setBounds(20, 5, 200, 80);
		add(title);
		
		icon = new ImageIcon("images/3È£¼±.jpg");
		img = new JLabel();
		img.setIcon(icon);
		img.setBounds(0, 70, icon.getIconWidth(), icon.getIconHeight());
		
		Image image = new ImageIcon("images/station.png").getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH);
		ImageIcon changeStation = new ImageIcon(image);
		
		JButton station1 = new JButton(); stationList.add(station1); station1.setName("207");
		JButton station2 = new JButton(); stationList.add(station2); station2.setName("301");
		JButton station3 = new JButton(); stationList.add(station3); station3.setName("302");
		JButton station4 = new JButton(); stationList.add(station4); station4.setName("303");
		JButton station5 = new JButton(); stationList.add(station5); station5.setName("304");
		JButton station6 = new JButton(); stationList.add(station6); station6.setName("123");
		JButton station7 = new JButton(); stationList.add(station7); station7.setName("305");
		JButton station8 = new JButton(); stationList.add(station8); station8.setName("306");
		JButton station9 = new JButton(); stationList.add(station9); station9.setName("307");
		JButton station10 = new JButton(); stationList.add(station10); station10.setName("308");
		JButton station11 = new JButton(); stationList.add(station11); station11.setName("107");

		station1.setBounds(295, 29, 18, 18);
		station2.setBounds(296, 73, 18, 18);
		station3.setBounds(295, 117, 18, 18);
		station4.setBounds(295, 160, 18, 18);
		station5.setBounds(295, 202, 18, 18);
		station6.setBounds(295, 248, 18, 18);
		station7.setBounds(297, 321, 18, 18);
		station8.setBounds(295, 379, 18, 18);
		station9.setBounds(297, 432, 18, 18);
		station10.setBounds(296, 485, 18, 18);
		station11.setBounds(296, 526, 18, 18);

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

