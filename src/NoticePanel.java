import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class NoticePanel extends JPanel{
	private MyFrame frame;
	private JButton btBack;
	static JTextArea jtaTitle;
	static TextArea taNotice;
	
	private MyActionListener btnListener = new MyActionListener();
	
	public NoticePanel(MyFrame frame) {
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
		Image changeBackImg = backImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changeBackIcon = new ImageIcon(changeBackImg);
		
		btBack = new JButton(changeBackIcon);
		
		btBack.setBounds(20, 20, 100, 100);
		
		btBack.setBackground(Color.white);
		
		btBack.setFocusPainted(false);
		
		btBack.setBorderPainted(false);
		
		btBack.setOpaque(false);
		
		btBack.addActionListener(btnListener);
		
		add(btBack);
	}
	
	public void setTextArea() {
		jtaTitle = new JTextArea();
		taNotice = new TextArea(
							"\n ����ö ��ã�� ���� 3000��ŭ Ȱ���ϴ� ��� !!\n\n"
									+" - ��ã�� ���� ����� ���� ģ������ �����غ�����. �ּҺ����� �������ִ� ��� .. ���� �����ϱ���   \n\n\n\n\n"
						
							+" 12���� �Բ� ã�ƿ� ����ũ�к��� �츮 �Բ� �����ؿ� \n\n"
									+" - 12�� 6�Ϻ��� 4�ְ� ��� ���� ���ο� ��� ���� �������� 6��, ��������� 8�ϱ����� ���������� ���˴ϴ�.  \n\n"
									+" - 3��(����,����,����) ȯ���� ���ϰ� ���� �������� ����ũ ���� ���� �濪��Ģ�� �ؼ��Ͽ��ּ���\n\n\n\n\n"

							+" �����߾Ӽ� ����꿪 ���� ���� �ȳ� \n\n"
									+" - 11/27(��) ���� �����̾��� ����꿪 ���������� ���� ������� �ȳ��帳�ϴ�.\n\n"
									+" - ������~����� ��Ʋ ��ö ���� ����� ���� ����꿪�� �̿��� �� ���� �� ���� �����ñ� �ٶ��ϴ�.\n\n\n\n\n"
									
							+" ��Ը� ��ȸ�� ���� ���� �ó� ���� ���� �ȳ� (11/13)\n\n"
									+" - 11/13(��) ���ֳ��� ��Ը� ��ȸ�� �����Ǿ� �־ �ȳ��帳�ϴ�.\n\n"
									+" - ���� �ó� �ֿ� ������ ���� ������ ����ǿ��� ���߱��� �̿�� ���� ��Ź�帳�ϴ�.\n\n"
									+" <���� ���� �ȳ�> \n\n"
									+" - �Ͻ�: 11.13(��) ���� 2��~ \n"
									+" - ��ȸ ����: ������, �������, ��ȸ���, ���Ǵ�� ��\n"
									+" - ����: ����ö �Ǵ� �����뼱�� ������ ����� ���� ��ȸ �� ���� ���� \n\n\n"
									+"  �����մϴ�"
									,
								5, 30
		);
		
		jtaTitle.setText("NOTICE");
		jtaTitle.setSize(250, 100);
		jtaTitle.setBackground(Color.white);
		jtaTitle.setFont(new Font("", Font.BOLD, 60));
		jtaTitle.setVisible(true);
		
		jtaTitle.setLocation(210, 10);
		taNotice.setBounds(10,150,570,520);
		
		jtaTitle.setOpaque(false);
		
		jtaTitle.setEditable(false);
		taNotice.setEditable(false);
		
		add(taNotice);
		add(jtaTitle);
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btBack) {
				frame.change("menuPanel");
			}
		}
	}
}
