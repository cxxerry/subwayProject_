import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jxl.*;
import jxl.read.biff.BiffException;

public class MapLabel extends JLabel{
	public MainPanel mainPanel;
	private MapLabel maplabel;
	public PopupPanel popupPanel;
	
	private StationButton btnStation[] = new StationButton[111];
	private int positionX[] = new int[111]; //역 버튼의 X 좌표
	private int positionY[] = new int[111]; //역 버튼의 Y좌표
	
	private MyActionListener btnListener = new MyActionListener();

	//생성자 메소드
	public MapLabel(MainPanel mainPanel) {
		super(new ImageIcon("images/subway.png")); //노선도 셋팅
		this.mainPanel = mainPanel;
		this.maplabel = this;
		
		popupPanel = new PopupPanel(this, 0, 0, 0);
		popupPanel.setVisible(false);
		
		setData(); //버튼들의 좌표 셋팅
		setButton(); //버튼 셋팅
	}
	
	//노선도에 버튼을 셋팅하는 메소드
	public void setButton() {
		//111개의 역 버튼 셋팅
		for(int i=0 ; i<111 ; i++) {
			btnStation[i] = new StationButton();
			
			btnStation[i].setBounds(positionX[i], positionY[i], 23, 23); //위치 설정
			
			btnStation[i].setFocusPainted(false);
			
			btnStation[i].addActionListener(btnListener); //버튼 이벤트
			
			add(btnStation[i]);
		}
	}
	
	//버튼 좌표 셋팅
	public void setData() {
		Workbook WB = null;
		try {
			WB = Workbook.getWorkbook(new File("coordinates.xls"));
		} catch (BiffException e) {
			System.out.print(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			System.exit(0);
		}
		Sheet sheet = WB.getSheet(0);
		
		//좌표 초기화
		for(int i=0 ; i<111 ; i++) {
			positionX[i] = 0; positionY[i] = 0;
		}
		
		//버튼의 X좌포 셋팅
		for(int index=1 ; index <112 ; index++) {
			Cell cell = sheet.getCell(1, index);
			positionX[index-1] = Integer.parseInt(cell.getContents());
		}
		
		//버튼의 Y좌표 셋팅
		for(int index=1 ; index <112 ; index++) {
			Cell cell = sheet.getCell(2, index);
			positionY[index-1] = Integer.parseInt(cell.getContents());
		}
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//노선도에 PopupPanel이 존재한다면 삭제
			if(popupPanel.isPlaying) {
				popupPanel.isPlaying = false;
				
				remove(popupPanel);
				revalidate();
				repaint();
			}
			
			//popupPanel 생성
			for(int i=0 ; i<111 ; i++) {
				if (e.getSource() == btnStation[i]) {
					//노선도 밖으로 popupPanel이 생성되는걸 방지
					if (positionX[i]+15 < 638 && positionY[i]+15 < 625) popupPanel = new PopupPanel(maplabel, i, positionX[i]+15, positionY[i]+15);
					else if (positionX[i]+15 >= 638 && positionY[i]+15 >= 625) popupPanel = new PopupPanel(maplabel, i, 638, 624);
					else if (positionX[i]+15 >= 638) popupPanel = new PopupPanel(maplabel, i, 638, positionY[i]+15);
					else popupPanel = new PopupPanel(maplabel, i, positionX[i]+15, 624);
					
					popupPanel.isPlaying = true;
					
					add(popupPanel);
					revalidate();
					repaint();
					
					break;
				}
			}
		}
	}
}
