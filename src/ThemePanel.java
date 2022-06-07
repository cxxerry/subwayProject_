import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ThemePanel extends JPanel{
	private MyFrame frame;
	static  JButton btBack, btGray, btPink, btOrange, btOriginal;
	static public JTextArea jtaTitle;
	
	private MyActionListener btnListener = new MyActionListener();
	
	public ThemePanel(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		setTextArea();
		setButton();
	}
	public void setButton() {
		ImageIcon backIcon = new ImageIcon("images/back.png");
		Image backImg = backIcon.getImage();
		Image changeBackImg = backImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon changeBackIcon = new ImageIcon(changeBackImg);
		
		btBack = new JButton(changeBackIcon);
		btGray = new JButton("Gray");
		btPink = new JButton("Pink");
		btOrange = new JButton("Orange");
		btOriginal = new JButton("Original");
		
		btBack.setBounds(20, 20, 100, 100);
		btGray.setBounds(260, 220, 100, 60);
		btPink.setBounds(260, 320, 100, 60);
		btOrange.setBounds(260, 400, 100, 80);
		btOriginal.setBounds(260, 500, 100, 80);
		
		btBack.setBackground(Color.white);
		btGray.setBackground(Color.white);
		btPink.setBackground(Color.white);
		btOrange.setBackground(Color.white);
		btOriginal.setBackground(Color.white);
		
		btBack.setFocusPainted(false);
		btGray.setFocusPainted(false);
		btPink.setFocusPainted(false);
		btOrange.setFocusPainted(false);
		btOriginal.setFocusPainted(false);
		
		btBack.setFont(new Font("",Font.BOLD,20));
		btGray.setFont(new Font("",Font.BOLD,20));
		btPink.setFont(new Font("",Font.BOLD,20));
		btOrange.setFont(new Font("",Font.BOLD,20));
		btOriginal.setFont(new Font("",Font.BOLD,20));
		
		MenuPanel.btnBack.setBorderPainted(false);
		MenuPanel.btnNotice.setBorderPainted(false);
		MenuPanel.btnDelete.setBorderPainted(false);
		MenuPanel.btnHelp.setBorderPainted(false);
		
		btBack.setOpaque(false);
		btGray.setOpaque(false);
		btPink.setOpaque(false);
		btOrange.setOpaque(false);
		btOriginal.setOpaque(false);
		
		//Ãß°¡µÊ 
		btBack.setBorderPainted(false);
		btGray.setBorderPainted(false);
		btPink.setBorderPainted(false);
		btOrange.setBorderPainted(false);
		btOriginal.setBorderPainted(false);
		
		btBack.addActionListener(btnListener);
		btGray.addActionListener(btnListener);
		btPink.addActionListener(btnListener);
		btOrange.addActionListener(btnListener);
		btOriginal.addActionListener(btnListener);
		
		add(btBack);
		add(btGray);
		add(btPink);
		add(btOrange);
		add(btOriginal);
	}
	
	public void setTextArea() {
		jtaTitle = new JTextArea();
		
		jtaTitle.setText("Theme");
		jtaTitle.setSize(250, 100);
		jtaTitle.setBackground(Color.white);
		jtaTitle.setFont(new Font("", Font.BOLD, 60));
		jtaTitle.setVisible(true);
		jtaTitle.setOpaque(true);
		jtaTitle.setLocation(230, 10);
	    jtaTitle.setOpaque(false);
		jtaTitle.setEditable(false);
		
		add(jtaTitle);
	}
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btBack) {
				frame.change("settingPanel");
			} else if(e.getSource() == btGray) {
				frame.changeBackground(Color.gray);
			} else if(e.getSource() == btPink) {
				frame.changeBackground(Color.pink);
			} else if(e.getSource() == btOrange) {
				frame.changeBackground(Color.orange);
			} else if(e.getSource() == btOriginal) {
				frame.changeBackground(Color.white);
			}
		}
	}

}
