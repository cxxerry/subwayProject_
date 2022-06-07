import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel{
	private MyFrame frame;
	private JButton btnBack;
	static JTextArea jtaTitle;
	static TextArea taHelp;
	
	private MyActionListener btnListener = new MyActionListener();
	
	public HelpPanel(MyFrame frame) {
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
		
		btnBack = new JButton(changeBackIcon);
		
		btnBack.setBounds(20, 20, 100, 100);
		
		btnBack.setBackground(Color.white);
		
		btnBack.setFocusPainted(false);
		
		btnBack.setBorderPainted(false);
		
		btnBack.setOpaque(false);
		
		btnBack.addActionListener(btnListener);
		
		add(btnBack);
	}
	
	public void setTextArea() {
		jtaTitle = new JTextArea();
		taHelp = new TextArea(
						"\n ��߿�, �������� ��� �����ϳ��� ? \n\n"
								+" - �̿��� : ���� ȭ�� ��� �Է�â > ��߿� & ������ �Է� \n\n"
								+" - ���� �뼱������ Ŭ���Ͻø� ��߿� & ������ ������ �����Ͻʴϴ�.\n\n\n\n "
								
						+" �ּҽð�,�ִܰŸ�,�ּҿ���� �˰� �;��\n\n"
								+" - ��߿����� ������������ �ּҽð�/�ִܰŸ�/�ּҿ���� ��Ÿ���� �� ����� �� ������ �ʼ� ����Դϴ�.\n\n"
								+" - �̿���: �˻�â�� ��߿� �Է� > ������ �Է� > �ּҽð�/�ִܰŸ�/�ּҿ�� ��ư ����\n\n\n\n"
							
						+" ��ã�� ������ �����ϰ� �;�� \n\n"
								+" - �̿���: ��߿�, ������ �Է� > �ּҽð�/�ִܰŸ�/�ּҿ�� �ϴ� ���� ��ư ���� > ���� ��ư�� ���� Ŭ�����忡 ���� �Ϸ� > ���Ͻô� ���� �ٿ��ֱ� \n\n\n\n"	
					
						+" Ư������ ���ã�⿡ �߰��ϰ� �;��\n\n"
								+" - �̿���: �뼱������ Ư���� ���� > ���ã�� ������ ����  \n\n\n\n"
								
						+" ���ã�� ����� Ȯ�� �� �����ϰ� �;��\n\n"
								+" - �̿���: ���� ȭ�� �ϴ� ����� ���� > ���ã�� ��� Ȯ�� > ������ �� ���� > ���ã�� ���� �Ϸ�   \n\n\n\n"
							
						+" ���� �޼����� ����\n\n"
								+" - ���� �޼����� ��߿��� ������ �� �� �Է����� �ʾ� �߻��ϴ� �����Դϴ�.\n\n "
								+" - �̿���: �˻����� ��߿��� �������� ��� �����ϰ� �˻� ��ư�� �����ּ���. \n\n\n\n"
								
						+" �޸�� � ����ΰ��� ?\n\n"
								+" - ���޸� ����� ������ �뼱 �߿� Ư���� Ȥ�� �� �ֺ��� ������ ����ص� �� �ִ� ����Դϴ�.\n\n"
								+" - �̿���: �뼱������ Ư���� ���� > �޸� ������ ���� > �޸� �ۼ� �� ����  \n\n"
								+" - �޸� �ۼ� �� ������ ���� �����ּ���!!! �ۼ��Ͻ� �޸� �� ���ư��� �ȴ�ϴ� ... \n\n\n\n"
						
						+" Ư�� �뼱���� � ����ΰ���? \n\n"
								+" - ������ �뼱�� �� ����ڰ� ���ϴ� Ư�� �뼱�� �� �� �ִ� ����Դϴ�. \n\n"
								+" - �� Ư�� �뼱�� ��ɿ����� �޸�& ���ã�� ����� �����մϴ�. \n\n "
								+" - �̿���: ���� ȭ�� ���� �ϴܿ� �ִ� ��ư 1 Ŭ�� > Ư�� �뼱 �Է� \n\n\n\n"
								
						+" �˻� ����� ���� �;��\n\n"
								+" - �̿���: ���� ȭ�� ��� �Է�ĭ�� ��ġ�� ���ﰢ���� ���� Ȯ�����ּ���. \n\n\n\n "
						
						+" �˻� ����� �����ϰ� �ͽ��ϴ�\n\n"
								+" - �̿��� : �޴� > �˻� ��� ���� > �˻� ��� ���� �Ϸ� \n\n\n\n"
						
						+" �׸��� �ٲٰ� �;�� \n\n "
								+" - �̿���: ���� > �׸� ���� > ���� ���� \n\n\n\n"
								
						+" �۲��� �ٲٰ� �;�� \n\n"
								+" - �̿���: ���� > �۲� ���� > �۲� ����  \n\n\n\n"
						
						+" �ʱ�ȭ�� ��� �������� ���� �ǳ��� ? \n\n"
								+" - �ʱ�ȭ ����� �����Ͻ� �׸�, ��Ʈ, �޸� ����˴ϴ�. \n\n"
								+" - �̿���: ���� > �ʱ�ȭ > Yes > �ʱ�ȭ �Ϸ� \n\n\n\n"	
						+"  �����մϴ�.",5, 30);
		
		jtaTitle.setText("HELP");
		jtaTitle.setSize(250, 100);
		jtaTitle.setBackground(Color.white);
		jtaTitle.setFont(new Font("", Font.BOLD, 60));
		jtaTitle.setVisible(true);
		
		jtaTitle.setLocation(210, 10);
		taHelp.setBounds(10,150,570,520);
		
		jtaTitle.setEditable(false);
		taHelp.setEditable(false);
		
		jtaTitle.setOpaque(false);
		
		add(taHelp);
		add(jtaTitle);
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				frame.change("menuPanel");
			}
		}
	}
}
