import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PopupPanel extends JPanel{
	private MapLabel mapLabel;
	private JButton btnStrtSt, btnDstSt, btnNote, btnLayover, btnFavrit, btnExit; //출발지, 도착지, 메모, 경유지, 종료
	private JLabel title;
	private int stationIndex;
	
	public boolean isPlaying = false; //노선도에 PopupPanel이 있는지 판단
	public boolean bookMarkSelected = false;
	
	private MyActionListener btnListener = new MyActionListener();
	
	public PopupPanel(MapLabel label, int StationIndex, int positionX, int positionY) {
		super(true);
		this.mapLabel = label;
		this.stationIndex = StationIndex;
		
		setBounds(positionX, positionY, 430, 106);
		setBackground(Color.white);
		setLayout(null);
		
		// 패널 테두리
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		setBorder(tb);
		
		setButton();
		setTitle();
	}
	
	
	public void setButton() {
		ImageIcon closeIcon = new ImageIcon("images/닫기.png");
		Image closeImg = closeIcon.getImage();
		Image changeCloseImg = closeImg.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		ImageIcon changecloseIcon = new ImageIcon(changeCloseImg);
		
		btnStrtSt = new JButton("출발지");
		btnDstSt = new JButton("도착지");
		btnNote = new JButton("메모");
		btnLayover = new JButton("경유지");
		btnFavrit = new JButton("즐겨찾기");
		btnExit = new JButton(changecloseIcon);
		
		btnStrtSt.setBounds(0, 20, 86, 86);
		btnDstSt.setBounds(86, 20, 86, 86);
		btnNote.setBounds(172, 20, 86, 86);
		btnLayover.setBounds(258, 20, 86, 86);
		btnFavrit.setBounds(344, 20, 86, 86);
		btnExit.setBounds(410, 3, 15, 15);
		
		btnExit.setFont(new Font("굴림", Font.PLAIN, 5));
		
		btnStrtSt.setBackground(Color.white);
		btnDstSt.setBackground(Color.white);
		btnNote.setBackground(Color.white);
		btnLayover.setBackground(Color.white);
		btnFavrit.setBackground(Color.white);
		btnExit.setBackground(Color.white);
		
		btnStrtSt.setFocusPainted(false);
		btnDstSt.setFocusPainted(false);
		btnNote.setFocusPainted(false);
		btnLayover.setFocusPainted(false);
		btnFavrit.setFocusPainted(false);
		btnExit.setFocusPainted(false);
		
		btnExit.setBorderPainted(false);
		
		add(btnStrtSt);
		add(btnDstSt);
		add(btnNote);
		add(btnLayover);
		add(btnFavrit);
		add(btnExit);
		
		btnStrtSt.addActionListener(btnListener);
		btnDstSt.addActionListener(btnListener);
		btnNote.addActionListener(btnListener);
		btnLayover.addActionListener(btnListener);
		btnFavrit.addActionListener(btnListener);
		btnExit.addActionListener(btnListener);
	}
	
	public void setTitle() {
		title = new JLabel(Integer.toString(Database.backconversionIndex(stationIndex)));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		title.setBounds(0, 0, 30, 20);
		add(title);
	}
	
	class MyActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnExit) {
				isPlaying = false;
				
				mapLabel.remove(mapLabel.popupPanel);
				mapLabel.revalidate();
				mapLabel.repaint();
			} else if(e.getSource() == btnNote) {
				new MemoFrame(mapLabel.mainPanel.frame, stationIndex);
				System.out.println("note");
			} else if(e.getSource() == btnLayover) {
				System.out.println("layover");
				mapLabel.mainPanel.frame.getDtCtr().setStopover(stationIndex);
			} else if(e.getSource() == btnFavrit) {
				System.out.println("favrit");
				if(mapLabel.mainPanel.frame.getDtCtr().findBookMark(stationIndex)) {
					mapLabel.mainPanel.frame.getDtCtr().removeBookMark(stationIndex);
					JOptionPane.showMessageDialog(null, mapLabel.mainPanel.frame.getDtCtr().DB.backconversionIndex(stationIndex) + "번이 즐겨찾기에서 삭제되었습니다."  );
				} else {
					mapLabel.mainPanel.frame.getDtCtr().addBookMark(stationIndex);
				}
				// 즐겨찾기 추가 혹은 삭제되었다는 문자 출력
			} else if(e.getSource() == btnStrtSt) {
				System.out.println("btNStrtSt");
				mapLabel.mainPanel.frame.getMainPanel().setCbStartStaion(Integer.toString(stationIndex));
			} else if(e.getSource() == btnDstSt) {
				System.out.println("btNDstSt");
				mapLabel.mainPanel.frame.getMainPanel().setCbEndStation(Integer.toString(stationIndex));
			}
		}
	}
}
