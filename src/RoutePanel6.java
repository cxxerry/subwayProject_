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

public class RoutePanel6 extends JPanel implements MouseListener {
	private MyFrame frame;
	private MyActionListener btnListener = new MyActionListener();
	private ImageIcon icon;
	private JLabel img;
	private ArrayList<JButton> stationList = new ArrayList<>();
	private JButton btnClose;
	//private MiniPopupPanel popup = new MiniPopupPanel(frame);

	public RoutePanel6(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);

		setMap();
		setCloseButton();
		
		addMouseListener(this);
	}
	
	public void setMap() {
		JLabel title = new JLabel("6È£¼±");
		title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		title.setBounds(20, 5, 200, 80);
		add(title);
		
		ImageIcon icon = new ImageIcon("images/6È£¼±.jpg");
		JLabel img = new JLabel();
		img.setIcon(icon);
		img.setBounds(0, 200, icon.getIconWidth(), icon.getIconHeight());
		
		JButton station1 = new JButton(); stationList.add(station1); station1.setName("601");
		JButton station2 = new JButton(); stationList.add(station2); station2.setName("602");
		JButton station3 = new JButton(); stationList.add(station3); station3.setName("121");
		JButton station4 = new JButton(); stationList.add(station4); station4.setName("603");
		JButton station5 = new JButton(); stationList.add(station5); station5.setName("604");
		JButton station6 = new JButton(); stationList.add(station6); station6.setName("605");
		JButton station7 = new JButton(); stationList.add(station7); station7.setName("606");
		JButton station8 = new JButton(); stationList.add(station8); station8.setName("116");
		JButton station9 = new JButton(); stationList.add(station9); station9.setName("607");
		JButton station10 = new JButton(); stationList.add(station10); station10.setName("608");
		JButton station11 = new JButton(); stationList.add(station11); station11.setName("609");
		JButton station12 = new JButton(); stationList.add(station12); station12.setName("412");
		JButton station13 = new JButton(); stationList.add(station13); station13.setName("610");
		JButton station14 = new JButton(); stationList.add(station14); station14.setName("611");
		JButton station15 = new JButton(); stationList.add(station15); station15.setName("612");
		JButton station16 = new JButton(); stationList.add(station16); station16.setName("613");
		JButton station17 = new JButton(); stationList.add(station17); station17.setName("614");
		JButton station18 = new JButton(); stationList.add(station18); station18.setName("615");
		JButton station19 = new JButton(); stationList.add(station19); station19.setName("616");
		JButton station20 = new JButton(); stationList.add(station20); station20.setName("417");
		JButton station21 = new JButton(); stationList.add(station21); station21.setName("617");
		JButton station22 = new JButton(); stationList.add(station22); station22.setName("618");
		JButton station23 = new JButton(); stationList.add(station23); station23.setName("619");
		JButton station24 = new JButton(); stationList.add(station24); station24.setName("620");
		JButton station25 = new JButton(); stationList.add(station25); station25.setName("621");
		JButton station26 = new JButton(); stationList.add(station26); station26.setName("622");
		
		station1.setBounds(36, 104, 18, 18);
		station2.setBounds(34, 147, 18, 18);
		station3.setBounds(34, 194, 18, 18);
		station4.setBounds(36, 273, 18, 18);
		station5.setBounds(97, 315, 18, 18);
		station6.setBounds(157, 314, 18, 18);
		station7.setBounds(207, 314, 18, 18);
		station8.setBounds(259, 313, 18, 18);
		station9.setBounds(297, 314, 18, 18);
		station10.setBounds(346, 314, 18, 18);
		station11.setBounds(402, 315, 18, 18);
		station12.setBounds(453, 313, 18, 18);
		station13.setBounds(515, 315, 18, 18);
		station14.setBounds(547, 275, 18, 18);
		station15.setBounds(545, 209, 18, 18);
		station16.setBounds(545, 146, 18, 18);
		station17.setBounds(549, 101, 18, 18);
		station18.setBounds(547, 57, 18, 18);
		station19.setBounds(498, 19, 18, 18);
		station20.setBounds(453, 20, 18, 18);
		station21.setBounds(401, 19, 18, 18);
		station22.setBounds(345, 23, 18, 18);
		station23.setBounds(286, 21, 18, 18);
		station24.setBounds(218, 21, 18, 18);
		station25.setBounds(159, 19, 18, 18);
		station26.setBounds(97, 21, 18, 18);
		
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
