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
	private int positionX[] = new int[111]; //�� ��ư�� X ��ǥ
	private int positionY[] = new int[111]; //�� ��ư�� Y��ǥ
	
	private MyActionListener btnListener = new MyActionListener();

	//������ �޼ҵ�
	public MapLabel(MainPanel mainPanel) {
		super(new ImageIcon("images/subway.png")); //�뼱�� ����
		this.mainPanel = mainPanel;
		this.maplabel = this;
		
		popupPanel = new PopupPanel(this, 0, 0, 0);
		popupPanel.setVisible(false);
		
		setData(); //��ư���� ��ǥ ����
		setButton(); //��ư ����
	}
	
	//�뼱���� ��ư�� �����ϴ� �޼ҵ�
	public void setButton() {
		//111���� �� ��ư ����
		for(int i=0 ; i<111 ; i++) {
			btnStation[i] = new StationButton();
			
			btnStation[i].setBounds(positionX[i], positionY[i], 23, 23); //��ġ ����
			
			btnStation[i].setFocusPainted(false);
			
			btnStation[i].addActionListener(btnListener); //��ư �̺�Ʈ
			
			add(btnStation[i]);
		}
	}
	
	//��ư ��ǥ ����
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
		
		//��ǥ �ʱ�ȭ
		for(int i=0 ; i<111 ; i++) {
			positionX[i] = 0; positionY[i] = 0;
		}
		
		//��ư�� X���� ����
		for(int index=1 ; index <112 ; index++) {
			Cell cell = sheet.getCell(1, index);
			positionX[index-1] = Integer.parseInt(cell.getContents());
		}
		
		//��ư�� Y��ǥ ����
		for(int index=1 ; index <112 ; index++) {
			Cell cell = sheet.getCell(2, index);
			positionY[index-1] = Integer.parseInt(cell.getContents());
		}
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//�뼱���� PopupPanel�� �����Ѵٸ� ����
			if(popupPanel.isPlaying) {
				popupPanel.isPlaying = false;
				
				remove(popupPanel);
				revalidate();
				repaint();
			}
			
			//popupPanel ����
			for(int i=0 ; i<111 ; i++) {
				if (e.getSource() == btnStation[i]) {
					//�뼱�� ������ popupPanel�� �����Ǵ°� ����
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
