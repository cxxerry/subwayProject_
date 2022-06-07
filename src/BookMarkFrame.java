import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BookMarkFrame extends JFrame implements MouseListener {
	private MyFrame frame;
	private JTable table;
	private DefaultTableModel dtm;
	private JButton btnDelete;
	
	public BookMarkFrame(MyFrame frame) {
		this.frame = frame;

		setSize(300, 500);
		setTitle("즐겨찾기");
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

		setTable();
		table.addMouseListener(this);
	}
	
	public void setTable() {
		ArrayList<Integer> arrayList = frame.getDtCtr().DB.bookMark;
		ArrayList<String> newArrayList = new ArrayList<>();
		for (Integer i : arrayList) {
			newArrayList.add(i.toString());
		}
		
		String header[] = {"역"};
		String contents[][] = new String[newArrayList.size()][1];
		int t = 0;
		for (String i : newArrayList) {
			int temp = Database.backconversionIndex(Integer.parseInt(i));
			contents[t][0] = Integer.toString(temp);
			t++;
		}
		
		dtm = new DefaultTableModel(contents, header);
		
		table = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String station = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
		System.out.println(station);
		int result = JOptionPane.showConfirmDialog(null, station + "번을 즐겨찾기에서 삭제하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			dtm.removeRow(table.getSelectedRow());
			frame.dtCtr.removeBookMark(Database.conversionIndex(Integer.parseInt(station)));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
