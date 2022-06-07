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
							"\n 지하철 길찾기 어플 3000만큼 활용하는 방법 !!\n\n"
									+" - 길찾기 공유 기능을 통해 친구에게 공유해보세요. 최소비용까지 공유해주는 당신 .. 제법 스윗하군요   \n\n\n\n\n"
						
							+" 12월과 함께 찾아온 오미크론변이 우리 함께 조심해요 \n\n"
									+" - 12월 6일부터 4주간 백신 접종 여부와 상관 없이 수도권은 6인, 비수도권은 8일까지만 사적모임이 허용됩니다.  \n\n"
									+" - 3밀(밀집,밀폐,밀접) 환경을 피하고 열차 내에서도 마스크 착용 등의 방역수칙을 준수하여주세요\n\n\n\n\n"

							+" 경의중앙선 도라산역 개통 연기 안내 \n\n"
									+" - 11/27(토) 개통 예정이었던 도라산역 관람열차가 운행 연기됨을 안내드립니다.\n\n"
									+" - 임진강~도라산 셔틀 전철 운행 연기로 인해 도라산역을 이용할 수 없는 점 착오 없으시길 바랍니다.\n\n\n\n\n"
									
							+" 대규모 집회로 인한 서울 시내 교통 통제 안내 (11/13)\n\n"
									+" - 11/13(초) 민주노총 대규모 집회가 예정되어 있어서 안내드립니다.\n\n"
									+" - 서울 시내 주요 도로의 교통 불편이 예상되오니 대중교통 이용시 참고 부탁드립니다.\n\n"
									+" <교통 동제 안내> \n\n"
									+" - 일시: 11.13(토) 오후 2시~ \n"
									+" - 집회 지역: 사직로, 세종대로, 국회대로, 여의대로 등\n"
									+" - 내용: 지하철 또는 버스노선의 무정차 통과와 차량 우회 등 교통 통제 \n\n\n"
									+"  감사합니다"
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
