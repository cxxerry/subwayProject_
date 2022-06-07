import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoutePanel1 extends JPanel {
	private MyFrame frame;
	private MyActionListener btnListener = new MyActionListener();
	private StationButton[] station = new StationButton[23];
	private JButton btnClose;
	public MiniPopupPanel popup;
	
	public RoutePanel1(MyFrame frame) {
		super(true);
		this.frame = frame;
		
		popup = new MiniPopupPanel(frame, "", 0);
		setBackground(Color.white);
		setLayout(null);
		
		setMap();
		setCloseButton();
	}
	
	public void setMap() {
		JLabel title = new JLabel("1호선");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		title.setBounds(20, 5, 200, 80);
		add(title);
		
		ImageIcon icon = new ImageIcon("images/1호선.jpg");
		JLabel img = new JLabel();
		img.setIcon(icon);
		img.setBounds(0, 200, icon.getIconWidth(), icon.getIconHeight());

		for(int i=0 ; i<23 ; i++) {
			station[i] = new StationButton();
		}
		
		//역의 이름 설정
		station[0].setName("101"); station[1].setName("102"); station[2].setName("103");
		station[3].setName("104"); station[4].setName("105"); station[5].setName("106");
		station[6].setName("107"); station[7].setName("108"); station[8].setName("109");
		station[9].setName("110"); station[10].setName("111"); station[11].setName("112");
		station[12].setName("113");	station[13].setName("114"); station[14].setName("115");
		station[15].setName("116"); station[16].setName("117"); station[17].setName("118");
		station[18].setName("119");	station[19].setName("120"); station[20].setName("121");
		station[21].setName("122"); station[22].setName("123");
		
		//역 버튼의 위치 설정
		station[0].setBounds(44, 51, 18, 18); station[1].setBounds(44, 106, 18, 18); station[2].setBounds(44, 167, 18, 18); 
		station[3].setBounds(44, 226, 18, 18); station[4].setBounds(44, 286, 18, 18); station[5].setBounds(73, 330, 18, 18);
		station[6].setBounds(139, 329, 18, 18);	station[7].setBounds(189, 330, 18, 18); station[8].setBounds(236, 329, 18, 18);
		station[9].setBounds(302, 330, 18, 18); station[10].setBounds(366, 330, 18, 18); station[11].setBounds(431, 330, 18, 18);
		station[12].setBounds(509, 329, 18, 18); station[13].setBounds(537, 282, 18, 18); station[14].setBounds(536, 227, 18, 18);
		station[15].setBounds(538, 147, 18, 18); station[16].setBounds(537, 105, 18, 18); station[17].setBounds(528, 37, 18, 18);
		station[18].setBounds(431, 19, 18, 18); station[19].setBounds(365, 20, 18, 18); station[20].setBounds(302, 19, 18, 18);
		station[21].setBounds(237, 20, 18, 18); station[22].setBounds(137, 19, 18, 18);
		
		for (StationButton b : station) {
			b.setFocusPainted(false);
			b.addActionListener(btnListener);
			img.add(b);
		}
		
		add(img);
	}
	
	public void setCloseButton() {
		ImageIcon closeIcon = new ImageIcon("images/닫기.png");
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
				if(popup.isPlaying) {
					popup.isPlaying = false;
					remove(popup);
					revalidate();
					repaint();
				}
				frame.change("mainPanel");
			} else {
				for (int i=0 ; i<111 ; i++) {
					if (e.getSource() == station[i]) {
						if(popup.isPlaying) {
							popup.isPlaying = false;
							remove(popup);
							revalidate();
							repaint();
						}
						
						popup = new MiniPopupPanel(frame, station[i].getName(), i);
						add(popup);
						revalidate();
						repaint();
						popup.isPlaying = true;
						break;
					}
				}
			}
		}
	}
}
