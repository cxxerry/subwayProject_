import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FontPanel extends JPanel {
	public static final Font Monospaced = null;
	private MyFrame frame;
	static JLabel jlTitle, jlTest;
	private JButton btnFont1,btnFont2,btnFont3,btnFont4,btnBack;
	
	private MyActionListener btnListener = new MyActionListener();
		
	public FontPanel (MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		setLabel(); 
		setButton(); 
	}

	public void setButton() {
		ImageIcon backIcon = new ImageIcon("images/back.png");
		Image backImg = backIcon.getImage();
		Image changeBackImg = backImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeBackIcon = new ImageIcon(changeBackImg);
		
		btnBack = new JButton(changeBackIcon);
		btnBack.setBounds(20, 20, 100, 100);
		btnBack.setBackground(Color.white);
		btnBack.setFocusPainted(false);
		btnBack.setOpaque(false);
		btnBack.addActionListener(btnListener);
		btnBack.setBorderPainted(false);
		
		btnFont1= new JButton("Serif√º"); 
		btnFont2 = new JButton("Monospaced√º");
		btnFont3 = new JButton("∏º¿∫ ∞ÌµÒ√º");
		btnFont4 = new JButton("µ«µπ∏Æ±‚"); 
		 
				
		btnFont1.setBounds(200,330,200,50);
		btnFont2.setBounds(200,400,200,50);
		btnFont3.setBounds(200,470,200,50);
		btnFont4.setBounds(200,540,200,50);
		
		btnFont1.setBackground(Color.white);
		btnFont1.setFocusPainted(false);
		btnFont1.setOpaque(false);
		btnFont1.setBorderPainted(false);
		btnFont1.setFont(new Font("",Font.BOLD,20));
		
		btnFont2.setBackground(Color.white);
		btnFont2.setFocusPainted(false);
		btnFont2.setOpaque(false);
		btnFont2.setBorderPainted(false);
		btnFont2.setFont(new Font("",Font.BOLD,20));
		
		btnFont3.setBackground(Color.white);
		btnFont3.setFocusPainted(false);
		btnFont3.setOpaque(false);
		btnFont3.setBorderPainted(false);
		btnFont3.setFont(new Font("",Font.BOLD,20));
		
		btnFont4.setBackground(Color.white);
		btnFont4.setFocusPainted(false);
		btnFont4.setOpaque(false);
		btnFont4.setBorderPainted(false);
		btnFont4.setFont(new Font("",Font.BOLD,20));
		
		btnFont4.addActionListener(btnListener);
		btnFont3.addActionListener(btnListener);
		btnFont2.addActionListener(btnListener);
		btnFont1.addActionListener(btnListener);
		

		add(btnFont4);
		add(btnFont3);
		add(btnFont2);
		add(btnFont1);
		add(btnBack);
	}
	
	public void setLabel() {
		jlTest = new JLabel("ABCDEFGFGHIJK");
		jlTest.setBounds(160,190,500,70);
		jlTest.setVisible(true);
		jlTest.setOpaque(false);
		jlTest.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD, 34));
		
		jlTitle = new JLabel("∆˘∆Æ ∫Ø∞Ê");
		jlTitle.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 40));
		jlTitle.setSize(300,100);
		jlTitle.setBounds(220, 30, 300, 80);
		jlTitle.setOpaque(false);
		
		add(jlTitle);
		add(jlTest);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == btnBack) {
				frame.change("settingPanel");
			}else if(e.getSource() == btnFont1) {
				Font font1 = new Font("Serif",Font.BOLD,16);
				Font font2 = new Font("Serif",Font.BOLD,24); 	 
				Font font3 = new Font("Serif",Font.BOLD,43);	
				
				jlTest.setFont(font3);
				jlTitle.setFont(font3);
				
				jlTest.setBounds(130,200,500,40);
				jlTitle.setBounds(220, 30, 300, 80);
				
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
				
				SettingPanel.title.setBounds(250, 30, 100, 80);
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
				
				ThemePanel.jtaTitle.setFont(font3);
				ThemePanel.btGray.setFont(font1);
				ThemePanel.btPink.setFont(font1);
				ThemePanel.btOrange.setFont(font1);
				ThemePanel.btOriginal.setFont(font1);
				
				
				ThemePanel.btGray.setBounds(260, 220, 100, 50);
				ThemePanel.btPink.setBounds(260, 320, 100, 50);
				ThemePanel.btOrange.setBounds(260, 420, 100, 50);
				ThemePanel.btOriginal.setBounds(260, 520, 100, 50);
				
			
				
			}
			else if(e.getSource() == btnFont2) {
				Font font1 = new Font("Monospaced",Font.BOLD,16);
				Font font2 = new Font(" Monospaced",Font.BOLD,24); 	 
				Font font3 = new Font(" Monospaced",Font.BOLD,43);	
				
				jlTest.setFont(font3);
				jlTitle.setFont(font3);
				
				jlTest.setBounds(130,200,500,40);
				jlTitle.setBounds(220, 30, 300, 80);
				
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
				MainPanel.cbEndStation.setBounds(130, 75, 340, 45);
				
				ThemePanel.jtaTitle.setFont(font3);
				ThemePanel.btGray.setFont(font1);
				ThemePanel.btPink.setFont(font1);
				ThemePanel.btOrange.setFont(font1);
				ThemePanel.btOriginal.setFont(font1);
				
				ThemePanel.jtaTitle.setSize(250, 100);
				jlTitle.setLocation(210, 10);
				ThemePanel.btGray.setBounds(265, 220, 110, 50);
				ThemePanel.btPink.setBounds(265, 320, 110, 50);
				ThemePanel.btOrange.setBounds(265, 420, 110, 50);
				ThemePanel.btOriginal.setBounds(265, 520, 110, 50);
				
			}	else if(e.getSource() == btnFont3) {
				Font font1 = new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,16);
				Font font2 = new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,24); 	
				Font font3 = new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,43);	
				
				jlTest.setFont(font3);
				jlTitle.setFont(font3);
				
				jlTest.setBounds(130,200,500,40);
				jlTitle.setBounds(220, 30, 300, 80);
				
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
				
				ThemePanel.jtaTitle.setFont(font3);
				ThemePanel.btGray.setFont(font1);
				ThemePanel.btPink.setFont(font1);
				ThemePanel.btOrange.setFont(font1);
				ThemePanel.btOriginal.setFont(font1);
				
				ThemePanel.jtaTitle.setSize(250, 100);
				jlTitle.setLocation(210, 10);
				ThemePanel.btGray.setBounds(260, 220, 100, 50);
				ThemePanel.btPink.setBounds(260, 320, 100, 50);
				ThemePanel.btOrange.setBounds(260, 420, 100, 50);
				ThemePanel.btOriginal.setBounds(260, 520, 100, 50);
			}
			else if(e.getSource() == btnFont4) {
				Font font = new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,40); 
				
				jlTest.setFont(font);
				jlTitle.setFont(font);
				jlTest.setBounds(160,190,500,70);
				jlTitle.setBounds(220, 30, 300, 80);
				
				frame.setFont(font);
			}
			
		}
	}
}
