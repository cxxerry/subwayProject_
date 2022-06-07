import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class MyFrame extends JFrame {
	//JLayeredPane jlp = this.getLayeredPane();
	
	private MainPanel mainPanel = new MainPanel(this);
	private MenuPanel menuPanel = new MenuPanel(this);
	private SettingPanel settingPanel = new SettingPanel(this);
	
	private RoutePanel1 routePanel1 = new RoutePanel1(this);
	private RoutePanel2 routePanel2 = new RoutePanel2(this);
	private RoutePanel3 routePanel3 = new RoutePanel3(this);
	private RoutePanel4 routePanel4 = new RoutePanel4(this);
	private RoutePanel5 routePanel5 = new RoutePanel5(this);
	private RoutePanel6 routePanel6 = new RoutePanel6(this);
	private RoutePanel7 routePanel7 = new RoutePanel7(this);
	private RoutePanel8 routePanel8 = new RoutePanel8(this);
	private RoutePanel9 routePanel9 = new RoutePanel9(this);
	
	private NoticePanel noticePanel = new NoticePanel(this);
	private HelpPanel helpPanel = new HelpPanel(this);
	private ThemePanel themePanel = new ThemePanel(this);
	private FontPanel fontPanel = new FontPanel(this);
	
	protected DataController dtCtr;
	
	// 김선권 - 검색 기록.
	protected ArrayList<Data> srchRcrdData = new ArrayList<Data>(20);
	
	public MyFrame() {
		dtCtr = new DataController();
		
		add(mainPanel);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(616, 789);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void change(String name) {
		if (name.equals("mainPanel")) {
			getContentPane().removeAll();
			getContentPane().add(mainPanel);
			revalidate();
			repaint();
		} else if (name.equals("menuPanel")){
			getContentPane().removeAll();
			getContentPane().add(menuPanel);
			revalidate();
			repaint();
		} else if (name.equals("settingPanel")) {
			getContentPane().removeAll();
			getContentPane().add(settingPanel);
			revalidate();
			repaint();
		} else if (name.equals("noticePanel")) {
			getContentPane().removeAll();
			getContentPane().add(noticePanel);
			revalidate();
			repaint();
		} else if (name.equals("helpPanel")) {
			getContentPane().removeAll();
			getContentPane().add(helpPanel);
			revalidate();
			repaint();
		} else if (name.equals("themePanel")) {
			getContentPane().removeAll();
			getContentPane().add(themePanel);
			revalidate();
			repaint();
		} else if(name.equals("fontPanel")) {
			getContentPane().removeAll();
			getContentPane().add(fontPanel);
			revalidate();
			repaint();
		} else if (name.equals("routePanel1")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel1);
			revalidate();
			repaint();
		} else if (name.equals("routePanel2")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel2);
			revalidate();
			repaint();
		} else if (name.equals("routePanel3")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel3);
			revalidate();
			repaint();
		} else if (name.equals("routePanel4")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel4);
			revalidate();
			repaint();
		} else if (name.equals("routePanel5")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel5);
			revalidate();
			repaint();
		} else if (name.equals("routePanel6")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel6);
			revalidate();
			repaint();
		} else if (name.equals("routePanel7")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel7);
			revalidate();
			repaint();
		} else if (name.equals("routePanel8")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel8);
			revalidate();
			repaint();
		} else if (name.equals("routePanel9")) {
			getContentPane().removeAll();
			getContentPane().add(routePanel9);
			revalidate();
			repaint();
		} 

	}
	
	public void changeBackground(Color color) {
		mainPanel.setBackground(color);
		menuPanel.setBackground(color);
		settingPanel.setBackground(color);
		noticePanel.setBackground(color);
		helpPanel.setBackground(color);
		themePanel.setBackground(color);
		fontPanel.setBackground(color);
	}
	
	public MainPanel getMainPanel() {return this.mainPanel;}
	
	public DataController getDtCtr() {return this.dtCtr;}
}
