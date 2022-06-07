import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SettingPanel extends JPanel{
	static JButton btnBack, btnSetNotice, btnFont, btnTheme, btnReset;
	private MyActionListener btnListener = new MyActionListener();
	private MyFrame frame;
	static JLabel title;
	private JRadioButton noticeON, noticeOFF;
	private ButtonGroup noticeGroup;
	
	//최희정 
	private JPanel ResetPanel; 
	private JFrame ResetFrame;  
	static JButton btnYes,btnNo; 
	static JLabel ResetLabel; 
	
	public SettingPanel(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		setButton();
		setRadioButton();
		setLabel();
	}
	
	public void setButton() {
		ImageIcon menuIcon = new ImageIcon("images/back.png");
		Image backImg = menuIcon.getImage();
		Image changeBackImg = backImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeBackIcon = new ImageIcon(changeBackImg);
		
		btnBack = new JButton(changeBackIcon);
		btnSetNotice = new JButton("알림");
		btnFont = new JButton("폰트 변경");
		btnTheme = new JButton("테마 변경");
		btnReset = new JButton("초기화");
		
		btnBack.setBounds(20, 20, 100, 100);
		btnSetNotice.setBounds(250, 250, 100, 50);
		btnFont.setBounds(200, 320, 200, 50);
		btnTheme.setBounds(200, 390, 200, 50);
		btnReset.setBounds(200, 460, 200, 50);
		
		btnSetNotice.setFont(new Font("", Font.BOLD, 20));
		btnFont.setFont(new Font("", Font.BOLD, 20));
		btnTheme.setFont(new Font("", Font.BOLD, 20));
		btnReset.setFont(new Font("", Font.BOLD, 20));
		
		btnBack.setBackground(Color.white);
		btnSetNotice.setBackground(Color.white);
		btnFont.setBackground(Color.white);
		btnTheme.setBackground(Color.white);
		btnReset.setBackground(Color.white);
		
		btnBack.setFocusPainted(false);
		btnSetNotice.setFocusPainted(false);
		btnFont.setFocusPainted(false);
		btnTheme.setFocusPainted(false);
		btnReset.setFocusPainted(false);
		
		btnBack.setBorderPainted(false);
		btnSetNotice.setBorderPainted(false);
		btnFont.setBorderPainted(false);
		btnTheme.setBorderPainted(false);
		btnReset.setBorderPainted(false);
		
		btnBack.setOpaque(false);
		btnSetNotice.setOpaque(false);
		btnFont.setOpaque(false);
		btnTheme.setOpaque(false);
		btnReset.setOpaque(false);
		
		btnBack.addActionListener(btnListener);
		btnSetNotice.addActionListener(btnListener);
		btnFont.addActionListener(btnListener);
		btnTheme.addActionListener(btnListener);
		btnReset.addActionListener(btnListener);
		
		add(btnBack);
		add(btnSetNotice);
		add(btnFont);
		add(btnTheme);
		add(btnReset);
	}
	
	public void setLabel() {
		title = new JLabel("설정");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		title.setBounds(250, 30, 80, 80);
		title.setOpaque(false);
		add(title);
	}
	
	public void setRadioButton() {
		noticeON = new JRadioButton("ON");
		noticeOFF = new JRadioButton("OFF");
		
		noticeON.setSelected(true);
		
		noticeGroup = new ButtonGroup();
		noticeGroup.add(noticeON);
		noticeGroup.add(noticeOFF);
		
		noticeON.setBounds(350, 250, 50, 50);
		noticeOFF.setBounds(400, 250, 200, 50);
		noticeON.setBackground(Color.white);
		noticeOFF.setBackground(Color.white);
		noticeON.setFocusPainted(false);
		noticeOFF.setFocusPainted(false);
		
		noticeON.setOpaque(false);
		noticeOFF.setOpaque(false);
		
		add(noticeON);
		add(noticeOFF);
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				frame.change("mainPanel");
			} else if (e.getSource() == btnSetNotice) {
				System.out.println("notice");
			} else if (e.getSource() == btnFont) {
				frame.change("fontPanel");
			} else if (e.getSource() == btnTheme) {
				frame.change("themePanel");
			} else if (e.getSource() == btnReset) {
				
				ResetFrame = new JFrame();
				ResetFrame.getContentPane().setLayout(null);
				ResetFrame.setSize(460,260);
				ResetFrame.setVisible(true);
				ResetFrame.setLocationRelativeTo(null) ;
				ResetFrame.setTitle("share");
				
				ResetPanel = new JPanel();
				ResetPanel.setBackground(Color.white);
				ResetPanel.setBounds(0,0,700,700);	
				ResetPanel.setLayout(null);
			
				ResetLabel = new JLabel("초기화를 실행시킬까요?");		
				ResetLabel.setBounds(120,30,300,50);
				ResetLabel.setFont(new Font("", Font.BOLD, 17));
				ResetLabel.setOpaque(false);
				ResetLabel.setBackground(Color.white);

				btnYes = new JButton("YES"); 
				btnYes.setBounds(100,120,100,40);
				
				btnNo = new JButton("NO"); 
				btnNo.setBounds(240,120,100,40);
				
				btnYes.setFocusPainted(false);
				btnYes.setOpaque(false);
				btnYes.setBackground(Color.white);
				btnYes.setFont(new Font("", Font.BOLD, 17));
				
				btnNo.setFocusPainted(false);
				btnNo.setOpaque(false);
				btnNo.setBackground(Color.white);
				btnNo.setFont(new Font("", Font.BOLD, 17));
				
				ResetPanel.add(btnNo);
				ResetPanel.add(btnYes);
				ResetPanel.add(ResetLabel);
				ResetFrame.add(ResetPanel);
				
				btnYes.addActionListener(btnListener);
				btnNo.addActionListener(btnListener);
			
			} else if(e.getSource() == btnYes) {
				
				Font font1 = new Font("",Font.BOLD,16);
				Font font2 = new Font("",Font.BOLD,24); 	//폰트 
				Font font3 = new Font("",Font.BOLD,43);
				
				FontPanel.jlTest.setFont(font3);
				FontPanel.jlTitle.setFont(font3);
				
				FontPanel.jlTest.setBounds(130,200,500,40);
				
				MenuPanel.btnNotice.setFont(font2);
				MenuPanel.btnDelete.setFont(font2);
				MenuPanel.btnHelp.setFont(font2);
				MenuPanel.title.setFont(font3);
				
				MenuPanel.btnNotice.setBounds(200,300,200,50);
				MenuPanel.btnDelete.setBounds(120, 370, 350, 50);
				MenuPanel.btnHelp.setBounds(200, 440, 200, 50);
				MenuPanel.title.setBounds(260, 30, 100, 80);
		
				SettingPanel.title.setFont(font3);
				SettingPanel.btnSetNotice.setFont(font2);
				SettingPanel.btnFont.setFont(font2);
				SettingPanel.btnTheme.setFont(font2);
				SettingPanel.btnReset .setFont(font2);
				
				SettingPanel.title.setBounds(260, 30, 100, 80);
				SettingPanel.btnSetNotice.setBounds(250, 250, 100, 50);
				SettingPanel.btnFont.setBounds(200, 320, 200, 50);
				SettingPanel.btnTheme.setBounds(200, 390, 200, 50);
				SettingPanel.btnReset.setBounds(200, 460, 200, 50);
				
				NoticePanel.jtaTitle.setFont(font3);
				NoticePanel.taNotice.setFont(font1);
				
				NoticePanel.jtaTitle.setSize(250, 100);
				NoticePanel.taNotice.setBounds(10,150,570,520);
				
				HelpPanel.jtaTitle.setFont(font3);
				HelpPanel.taHelp.setFont(font1);
				
				HelpPanel.jtaTitle.setSize(250, 100);
				HelpPanel.taHelp.setBounds(10,150,570,520);
				
				MainPanel.cbStartStation.setFont(font1);
				MainPanel.cbEndStation.setFont(font1);
				
				MainPanel.cbStartStation.setBounds(130, 20, 340, 45);
				MainPanel.cbEndStation.setBounds(130, 75, 290, 45);
				
				ThemePanel.btGray.setFont(font2);
				ThemePanel.btPink.setFont(font2);
				ThemePanel.btOrange.setFont(font2);
				ThemePanel.btOriginal.setFont(font2);
				
				ThemePanel.btGray.setBounds(260, 220, 100, 50);
				ThemePanel.btPink.setBounds(260, 320, 100, 50);
				ThemePanel.btOrange.setBounds(260, 420, 100, 50);
				ThemePanel.btOriginal.setBounds(260, 520, 100, 50);
				
				//김선권 구현 부분
				frame.srchRcrdData.clear(); // 검색 기록 삭제
				frame.getDtCtr().resetBookMark(); // 즐겨찾기 삭제
				frame.getDtCtr().resetMemo();
				
				ResetFrame.dispose();
				frame.changeBackground(Color.white);
				
			}else if(e.getSource() == btnNo) {
				ResetFrame.dispose();
			}
		}
		
	}
}
