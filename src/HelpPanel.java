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
						"\n 출발역, 도착역은 어떻게 선택하나요 ? \n\n"
								+" - 이용방법 : 메인 화면 상단 입력창 > 출발역 & 도착역 입력 \n\n"
								+" - 또한 노선도에서 클릭하시면 출발역 & 도착역 선택이 가능하십니다.\n\n\n\n "
								
						+" 최소시간,최단거리,최소요금을 알고 싶어요\n\n"
								+" - 출발역부터 도착역까지의 최소시간/최단거리/최소요금을 나타내는 이 기능은 이 어플의 필수 기능입니다.\n\n"
								+" - 이용방법: 검색창에 출발역 입력 > 도착역 입력 > 최소시간/최단거리/최소요금 버튼 선택\n\n\n\n"
							
						+" 길찾기 정보를 공유하고 싶어요 \n\n"
								+" - 이용방법: 출발역, 도착역 입력 > 최소시간/최단거리/최소요금 하단 공유 버튼 선택 > 복사 버튼을 눌러 클립보드에 복사 완료 > 원하시는 곳에 붙여넣기 \n\n\n\n"	
					
						+" 특정역을 즐겨찾기에 추가하고 싶어요\n\n"
								+" - 이용방법: 노선도에서 특정역 선택 > 즐겨찾기 아이콘 선택  \n\n\n\n"
								
						+" 즐겨찾기 목록을 확인 후 삭제하고 싶어요\n\n"
								+" - 이용방법: 메인 화면 하단 별모양 선택 > 즐겨찾기 목록 확인 > 삭제할 역 선택 > 즐겨찾기 삭제 완료   \n\n\n\n"
							
						+" 오류 메세지가 떠요\n\n"
								+" - 오류 메세지는 출발역과 도착역 둘 다 입력하지 않아 발생하는 오류입니다.\n\n "
								+" - 이용방법: 검색란에 출발역과 도착역을 모두 기입하고 검색 버튼을 눌러주세요. \n\n\n\n"
								
						+" 메모는 어떤 기능인가요 ?\n\n"
								+" - 역메모 기능은 복잡한 노선 중에 특정역 혹은 역 주변의 정보를 기록해둘 수 있는 기능입니다.\n\n"
								+" - 이용방법: 노선도에서 특정역 선택 > 메모 아이콘 선택 > 메모 작성 후 저장  \n\n"
								+" - 메모 작성 후 저장을 잊지 말아주세요!!! 작성하신 메모가 다 날아가게 된답니다 ... \n\n\n\n"
						
						+" 특정 노선도는 어떤 기능인가요? \n\n"
								+" - 복잡한 노선도 속 사용자가 원하는 특정 노선만 볼 수 있는 기능입니다. \n\n"
								+" - 이 특정 노선도 기능에서도 메모& 즐겨찾기 기능을 지원합니다. \n\n "
								+" - 이용방법: 메인 화면 왼쪽 하단에 있는 버튼 1 클릭 > 특정 노선 입력 \n\n\n\n"
								
						+" 검색 기록을 보고 싶어요\n\n"
								+" - 이용방법: 메인 화면 상단 입력칸에 위치한 역삼각형을 눌러 확인해주세요. \n\n\n\n "
						
						+" 검색 기록을 삭제하고 싶습니다\n\n"
								+" - 이용방법 : 메뉴 > 검색 기록 삭제 > 검색 기록 삭제 완료 \n\n\n\n"
						
						+" 테마를 바꾸고 싶어요 \n\n "
								+" - 이용방법: 설정 > 테마 변경 > 색상 선택 \n\n\n\n"
								
						+" 글꼴을 바꾸고 싶어요 \n\n"
								+" - 이용방법: 설정 > 글꼴 변경 > 글꼴 선택  \n\n\n\n"
						
						+" 초기화는 어느 범위까지 적용 되나요 ? \n\n"
								+" - 초기화 기능은 설정하신 테마, 폰트, 메모에 적용됩니다. \n\n"
								+" - 이용방법: 설정 > 초기화 > Yes > 초기화 완료 \n\n\n\n"	
						+"  감사합니다.",5, 30);
		
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
