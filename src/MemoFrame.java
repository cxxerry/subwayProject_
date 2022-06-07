import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoFrame extends JFrame{

	private MyFrame frame;
	private JTextArea txt;
	private JButton btnSave, btnClose;
	private int index;
	
	public MemoFrame(MyFrame frame, int stationIndex) {
		this.frame = frame;
		this.index = stationIndex;
		
		setSize(320, 210);
		setBackground(Color.CYAN);
		setTitle(Integer.toString(Database.backconversionIndex(stationIndex)) + " �޸�");
		setLocationRelativeTo(null); // â ��ġ �����
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
		txt = new JTextArea();
		btnSave = new JButton("����");
		btnClose = new JButton("�ݱ�");
		
		txt.setBounds(0, 0, 306, 112);
		btnSave.setBounds(26, 122, 91, 41);
		btnClose.setBounds(189, 122, 91, 41);
		
		txt.setText(frame.dtCtr.DB.memo[index]);
		
		add(txt);
		add(btnSave);
		add(btnClose);
		
		txt.setVisible(true);
		btnSave.setVisible(true);
		btnClose.setVisible(true);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txt.getText().length() < 110)
					frame.dtCtr.reviseMemo(index, txt.getText());
				else
					frame.dtCtr.reviseMemo(index, txt.getText().substring(0, 110));
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public int getIndex() {
		return index;
	}
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSave) {
				if(txt.getText().length() < 110)
					frame.dtCtr.reviseMemo(index, txt.getText());
				else
					frame.dtCtr.reviseMemo(index, txt.getText().substring(0, 110));
			}
			else if (e.getSource() == btnClose) {
				dispose();
			}
		}
	}
	
}
