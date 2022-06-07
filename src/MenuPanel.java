import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	static JButton btnBack, btnNotice, btnDelete, btnHelp;
	private MyActionListener btnListener = new MyActionListener();
	private MyFrame frame;
	static JLabel title;
	
	public MenuPanel(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		setButton();
		setTitle();
	}
	
	public void setButton() {
		ImageIcon menuIcon = new ImageIcon("images/back.png");
		Image backImg = menuIcon.getImage();
		Image changeBackImg = backImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeBackIcon = new ImageIcon(changeBackImg);
		
		btnBack = new JButton(changeBackIcon);
		btnNotice = new JButton("공지사항");
		btnDelete = new JButton("검색 기록 삭제");
		btnHelp = new JButton("도움말");
		
		btnBack.setBounds(20, 20, 100, 100);
		btnNotice.setBounds(200, 300, 200, 50);
		btnDelete.setBounds(200, 370, 200, 50);
		btnHelp.setBounds(200, 440, 200, 50);
		
		btnNotice.setFont(new Font("", Font.BOLD, 20));
		btnDelete.setFont(new Font("", Font.BOLD, 20));
		btnHelp.setFont(new Font("", Font.BOLD, 20));
		
		btnBack.setBackground(Color.white);
		btnNotice.setBackground(Color.white);
		btnDelete.setBackground(Color.white);
		btnHelp.setBackground(Color.white);
		
		btnBack.setFocusPainted(false);
		btnNotice.setFocusPainted(false);
		btnDelete.setFocusPainted(false);
		btnHelp.setFocusPainted(false);
		
		btnBack.setBorderPainted(false);
		btnNotice.setBorderPainted(false);
		btnDelete.setBorderPainted(false);
		btnHelp.setBorderPainted(false);
		
		btnBack.setOpaque(false);
		btnNotice.setOpaque(false);
		btnDelete.setOpaque(false);
		btnHelp.setOpaque(false);
		
		btnBack.addActionListener(btnListener);
		btnNotice.addActionListener(btnListener);
		btnDelete.addActionListener(btnListener);
		btnHelp.addActionListener(btnListener);
		
		add(btnBack);
		add(btnNotice);
		add(btnDelete);
		add(btnHelp);
	}
	
	public void setTitle() {
		title = new JLabel("메뉴");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		title.setBounds(260, 30, 80, 80);
		add(title);
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				frame.change("mainPanel");
			} else if (e.getSource() == btnNotice) {
				frame.change("noticePanel");
			} else if (e.getSource() == btnHelp) {
				frame.change("helpPanel");
			} else if (e.getSource() == btnDelete) {
				System.out.println("delete"); //test
				// 김선권 구현 부분
				frame.srchRcrdData.clear();
			}
		}
		
	}
}
