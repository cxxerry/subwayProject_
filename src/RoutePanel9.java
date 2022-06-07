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

public class RoutePanel9 extends JPanel implements MouseListener {
	private MyFrame frame;
	private MyActionListener btnListener = new MyActionListener();
	private ImageIcon icon;
	private JLabel img;
	private ArrayList<JButton> stationList = new ArrayList<>();
	private JButton btnClose;
	//private MiniPopupPanel popup = new MiniPopupPanel(frame);
	
	public RoutePanel9(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		setMap();
		setCloseButton();
		
		addMouseListener(this);
	}
	
	public void setMap() {
		JLabel title = new JLabel("9È£¼±");
		title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		title.setBounds(20, 5, 200, 80);
		add(title);
		
		ImageIcon icon = new ImageIcon("images/9È£¼±.jpg");
		JLabel img = new JLabel();
		img.setIcon(icon);
		img.setBounds(0, 70, icon.getIconWidth(), icon.getIconHeight());

		Image image = new ImageIcon("images/station.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		ImageIcon changeStation = new ImageIcon(image);
		
		JButton station1 = new JButton(); stationList.add(station1); station1.setName("211");
		JButton station2 = new JButton(); stationList.add(station2); station2.setName("621");
		JButton station3 = new JButton(); stationList.add(station3); station3.setName("904");
		JButton station4 = new JButton(); stationList.add(station4); station4.setName("702");
		JButton station5 = new JButton(); stationList.add(station5); station5.setName("903");
		JButton station6 = new JButton(); stationList.add(station6); station6.setName("119");
		JButton station7 = new JButton(); stationList.add(station7); station7.setName("902");
		JButton station8 = new JButton(); stationList.add(station8); station8.setName("605");
		JButton station9 = new JButton(); stationList.add(station9); station9.setName("406");
		JButton station10 = new JButton(); stationList.add(station10); station10.setName("901");
		JButton station11 = new JButton(); stationList.add(station11); station11.setName("112");

		station1.setBounds(298, 27, 17, 17);
		station2.setBounds(297, 84, 17, 17);
		station3.setBounds(297, 118, 17, 17);
		station4.setBounds(297, 160, 17, 17);
		station5.setBounds(298, 203, 17, 17);
		station6.setBounds(297, 245, 17, 17);
		station7.setBounds(298, 324, 17, 17);
		station8.setBounds(297, 362, 17, 17);
		station9.setBounds(298, 431, 17, 17);
		station10.setBounds(298, 481, 17, 17);
		station11.setBounds(297, 526, 17, 17);

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
