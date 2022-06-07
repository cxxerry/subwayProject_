import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MainPanel extends JPanel {
	//최한송
	private JButton btnMenu, btnSetting, btnSearch, btnOneRoute, btnBookMark;
	private JScrollPane scrollbar;
	private MyActionListener btnListener = new MyActionListener();
	public MyFrame frame;
	private MapLabel mapLabel = new MapLabel(this);
	private String inputRoute = null;
	
	//진언한
	private SearchFrame searchFrame;
	private String startSationInput, endStationInput;
	static RoundJCombobox cbStartStation, cbEndStation;
	
	public MainPanel(MyFrame frame) {
		super(true);
		this.frame = frame;
		setBackground(Color.white);
		setLayout(null);
		
		add(mapLabel);

		setButton();
		//setTextFeild();
		setScrollPane();
		setComboBox();
	}
	
	public void setButton() {
		ImageIcon menuIcon = new ImageIcon("images/menu.png");
		Image menuImg = menuIcon.getImage();
		Image changeMenuImg = menuImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changeMenuIcon = new ImageIcon(changeMenuImg);
		
		ImageIcon settingIcon = new ImageIcon("images/setting.png");
		Image settingImg = settingIcon.getImage();
		Image changeSettingImg = settingImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changeSettingIcon = new ImageIcon(changeSettingImg);
		
		
		ImageIcon searchIcon = new ImageIcon("images/search.png");
		Image searchImg = searchIcon.getImage();
		Image changeSearchImg = searchImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon changeSearchIcon = new ImageIcon(changeSearchImg);
		
		ImageIcon oneStationIcon = new ImageIcon("images/one.png");
		Image oneStationImg = oneStationIcon.getImage();
		Image changeOneStationImg = oneStationImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon changeOneStationIcon = new ImageIcon(changeOneStationImg);
		
		ImageIcon bookMarkIcon = new ImageIcon("images/bookmark.png");
		Image bookMarkImg = bookMarkIcon.getImage();
		Image changeBookMarkImg = bookMarkImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon changeBookMarkIcon = new ImageIcon(changeBookMarkImg);
		
		btnMenu = new JButton(changeMenuIcon);
		btnSetting = new JButton(changeSettingIcon);
		btnSearch = new JButton(changeSearchIcon);
		btnOneRoute = new JButton(changeOneStationIcon);
		btnBookMark = new JButton(changeBookMarkIcon);
		
		btnMenu.setBounds(20, 20, 100, 100);
		btnSetting.setBounds(480, 20, 100, 100);
		btnSearch.setBounds(425, 78, 40, 40);
		btnOneRoute.setBounds(20, 685, 275, 45);
		btnBookMark.setBounds(305, 685, 275, 45);
		
		btnMenu.setBackground(Color.white);
		btnSetting.setBackground(Color.white);
		btnSearch.setBackground(Color.white);
		btnOneRoute.setBackground(Color.white);
		btnBookMark.setBackground(Color.white);
		
		btnMenu.setFocusPainted(false);
		btnSetting.setFocusPainted(false);
		btnSearch.setFocusPainted(false);
		btnOneRoute.setFocusPainted(false);
		btnBookMark.setFocusPainted(false);
		
		btnSearch.setBorderPainted(false);
		
		btnMenu.setBorder(new RoundBorder(15));
		btnSetting.setBorder(new RoundBorder(15));
		btnOneRoute.setBorder(new RoundBorder(15));
		btnBookMark.setBorder(new RoundBorder(15));
		
		btnMenu.setOpaque(false);
		btnSetting.setOpaque(false);
		btnOneRoute.setOpaque(false);
		btnBookMark.setOpaque(false);
		
		btnMenu.addActionListener(btnListener);
		btnSetting.addActionListener(btnListener);
		btnOneRoute.addActionListener(btnListener);
		btnSearch.addActionListener(btnListener);
		btnBookMark.addActionListener(btnListener);
		
		add(btnMenu);
		add(btnSetting);
		add(btnSearch);
		add(btnOneRoute);
		add(btnBookMark);
		
	}
	
	public void setComboBox() {
		cbStartStation = new RoundJCombobox();
		cbEndStation = new RoundJCombobox();
		
		cbEndStation.setBackground(Color.white);
		cbStartStation.setBackground(Color.white);
		
		String start ="현재 위치 입력";
		String end ="도착역 입력";
		
		cbStartStation.addItem(start);
		cbEndStation.addItem(end);
		
		cbStartStation.setEditable(true);
		cbEndStation.setEditable(true);
		
		cbStartStation.setBounds(130, 20, 340, 45);
		cbEndStation.setBounds(130, 75, 290, 45);
		
		add(cbEndStation);
		add(cbStartStation);
		
	}
	
	public void setScrollPane() {
		scrollbar = new JScrollPane(mapLabel);
		
		scrollbar.setBounds(20, 140, 560, 525);
		
		add(scrollbar);
	}
	
	public void setCbStartStaion(String str) {
		cbStartStation.addItem(Database.backconversionIndex(Integer.parseInt(str)));
		cbStartStation.setSelectedIndex(cbStartStation.getItemCount()-1);
	}
	
	public void setCbEndStation(String str) {
		cbEndStation.addItem(Database.backconversionIndex(Integer.parseInt(str)));
		cbEndStation.setSelectedIndex(cbEndStation.getItemCount()-1);
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnMenu) {
				frame.change("menuPanel");
			} else if (e.getSource() == btnSetting) {
				frame.change("settingPanel");
			} else if (e.getSource() == btnOneRoute) {
				inputRoute = JOptionPane.showInputDialog(null, "노선을 입력하세요.", "한 노선만 보기", JOptionPane.QUESTION_MESSAGE);
				if (inputRoute.equals("1")) {
					frame.change("routePanel1");
				} else if (inputRoute.equals("2")) {
					frame.change("routePanel2");
				} else if (inputRoute.equals("3")) {
					frame.change("routePanel3");
				} else if (inputRoute.equals("4")) {
					frame.change("routePanel4");
				} else if (inputRoute.equals("5")) {
					frame.change("routePanel5");
				} else if (inputRoute.equals("6")) {
					frame.change("routePanel6");
				} else if (inputRoute.equals("7")) {
					frame.change("routePanel7");
				} else if (inputRoute.equals("8")) {
					frame.change("routePanel8");
				} else if (inputRoute.equals("9")) {
					frame.change("routePanel9");
				}
			} else if (e.getSource() == btnSearch) {
				startSationInput = cbEndStation.getSelectedItem().toString();
				endStationInput =  cbStartStation.getSelectedItem().toString();
				
				if(Database.isStation(startSationInput) && Database.isStation(endStationInput)) {
					searchFrame = new SearchFrame(frame, startSationInput, endStationInput);
					
					cbEndStation.addItem(startSationInput);
					cbStartStation.addItem(endStationInput);
				} else {
					JOptionPane.showMessageDialog(null, "Please enter station information");
				}
			} else if (e.getSource() == btnBookMark) {
				new BookMarkFrame(frame);
			}
		}
	}
}
