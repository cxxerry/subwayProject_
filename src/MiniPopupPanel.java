import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MiniPopupPanel extends JPanel {
	private JButton btNote, btFavrit, btExit;
	private ArrayList<JButton> buttonList = new ArrayList<>();
	private MyActionListener btnListener = new MyActionListener();
	private MyFrame frame;
	private String stationName;
	private int stationIndex;

	public boolean isPlaying = false;
	
	public MiniPopupPanel(MyFrame frame, String stationName, int stationIndex) {
		super(true);
		this.frame = frame;
		this.stationName = stationName;
		this.stationIndex = stationIndex;
		
		setBounds(0, 640, 600, 110);
		setBackground(Color.white);
		setLayout(null);
		setStationName();
		
		
		// ÆÐ³Î Å×µÎ¸®
		TitledBorder tb = new TitledBorder(new LineBorder(Color.black));
		setBorder(tb);
		
		setButton();
	}
	
	public void setButton() {
		Image image = new ImageIcon("images/´Ý±â.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon changeImage = new ImageIcon(image);		
		
		btNote = new JButton("¸Þ¸ð"); buttonList.add(btNote);
		btFavrit = new JButton("Áñ°ÜÃ£±â"); buttonList.add(btFavrit);
		btExit = new JButton(changeImage); buttonList.add(btExit);
		btExit.setBorderPainted(false);

		btNote.setBounds(0, 30, 300, 80);
		btFavrit.setBounds(300, 30, 300, 80);
		btExit.setBounds(570, 8, 15, 15);
		
		for (JButton b : buttonList) {
			b.setBackground(Color.white);
			b.setFocusPainted(false);
			b.addActionListener(btnListener);
			add(b);
		}
	}
	
	public void setStationName() {
		JLabel title = new JLabel(stationName);
		title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		title.setBounds(10, 2, 100, 20);
		add(title);
	}
	
	class MyActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btExit) {
				System.out.println("close");
				setVisible(false);
			} else if (e.getSource() == btNote) {
				new MemoFrame(frame, stationIndex);
				System.out.println("note");
			} else if(e.getSource() == btFavrit) {
				System.out.println("favrit");
				if (frame.getDtCtr().findBookMark(stationIndex)) {
					frame.getDtCtr().removeBookMark(stationIndex);
				} else {
					frame.getDtCtr().addBookMark(stationIndex);
				}
			} 
		}
	}
	
	
}