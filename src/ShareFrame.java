import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShareFrame extends JFrame{
	private MyFrame frame;
	private JButton btnCopy;
	private JPanel SharePanel;
	private JTextArea CTitle, txtMemo;
	private String copyString;
	
	private int startStation, endStation, cost;
	
	private MyActionListener btnListener = new MyActionListener();
	
	public ShareFrame(MyFrame frame, int StartSation, int EndStation, int Cost) {
		this.frame = frame;
		this.startStation = StartSation;
		this.endStation = EndStation;
		this.cost = Cost;
		
		getContentPane().setLayout(null);
		setSize(460,260);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("share");
		
		setPanel();
	}
	
	public void setPanel() {
		SharePanel = new JPanel();
		SharePanel.setBackground(Color.white);
		SharePanel.setBounds(0,0,700,700);	
		SharePanel.setLayout(null);
		
		setTextArea();
		setButton();
		
		getContentPane().add(SharePanel);
	}
	
	public void setTextArea() {
		CTitle = new JTextArea("*복사 버튼을 누르시면 해당 내용이 클립보드에 복사됩니다");		//클립보드 타이틀 
		CTitle.setBounds(10,10,500,130);
		CTitle.setBackground(Color.white);
		CTitle.setFont(new Font("", Font.BOLD, 13));
		CTitle.setOpaque(false);
		CTitle.setEditable(false);
		
		txtMemo = new JTextArea(startStation+"에서"+endStation+"까지 최소비용 "+cost+"원 입니다"); 
		txtMemo.setBounds(20,70,500,60);
		txtMemo.setVisible(true);
		txtMemo.setFont(new Font("", Font.BOLD, 18));
		txtMemo.setOpaque(false);
		
		SharePanel.add(txtMemo);
		SharePanel.add(CTitle);
	}
	
	public void setButton() {
		btnCopy = new JButton("복사");
		btnCopy.setBounds(100,140,250,40);
		btnCopy.setEnabled(true);
		btnCopy.setBackground(Color.white);
		
		btnCopy.addActionListener(btnListener);
		
		SharePanel.add(btnCopy);
		
	}
	
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnCopy) {
				System.out.print("hello");
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				
				copyString = txtMemo.getText();	///txtMemo 전체 복사 
				 
				if(copyString != null) {
					StringSelection contents = new StringSelection(copyString);
					clipboard.setContents(contents, null);
				}
			} 
		}
	}
}
