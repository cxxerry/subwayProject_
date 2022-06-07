import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SearchFrame extends JFrame{
	//진언한
	private MyFrame frame;
	private JFrame mapFrame;
	private JPanel PnPathway, LinePanel;
	private JButton btnMinTime, btnMinDistance, btnMinFare, btnMinMap;
	private JScrollPane jspTable;
	private JTable jtTable;
	private DefaultTableModel tableModel;
	private MapPanel mapPanel;
	
	private int startStation,endStation,cost, weightType, startStation1;
	
	private Vector<Object> rowVector;
	private Vector<Vector<Object>> data1;
	private Vector<String> columns;
	
	public ArrayList<Integer> shortestPath1;
	public ArrayList<Data> rNode;
	
	private MyActionListener btnListener = new MyActionListener();
	
	//최희정
	private ShareFrame shareFrame;
	private JButton btnShare; 

	
	public SearchFrame(MyFrame frame, String StartStation, String EndStation) {
		this.frame = frame;
		this.startStation = Integer.parseInt(StartStation);
		this.endStation = Integer.parseInt(EndStation);
		this.cost = 0;
		
		setBounds(100, 100, 612, 726);
		setVisible(true);
		setLayout(null);
		
		setPanel();
		
	}
	
	public void setPanel() {
		PnPathway = new JPanel();
		PnPathway.setBackground(Color.white);
		PnPathway.setBounds(0, 0, 598, 689);
		PnPathway.setLayout(null);
		
		setButton();
		setScrollPane();
		
		add(PnPathway);
	}
	
	public void setButton() {
		ImageIcon shareIcon = new ImageIcon("images/share.png");
		Image shareImg = shareIcon.getImage();
		Image changeShareImg = shareImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon changeShareIcon = new ImageIcon(changeShareImg);
		
		btnMinTime = new JButton("최소시간");
		btnMinDistance = new JButton("최소거리");
		btnMinFare = new JButton("최소요금");
		btnMinMap = new JButton("최단경로map");
		btnShare = new JButton(changeShareIcon);
		
		btnMinTime.setBounds(12, 10, 114, 104);
		btnMinDistance.setBounds(165, 10, 114, 104);
		btnMinFare.setBounds(320, 10, 114, 104);
		btnMinMap.setBounds(470, 10, 114, 104);
		//최희정구현
		btnShare.setBounds(15, 635, 570, 40);
		
		btnMinTime.setBackground(Color.white);
		btnMinDistance.setBackground(Color.white);
		btnMinFare.setBackground(Color.white);
		btnMinMap.setBackground(Color.white);
		btnShare.setBackground(Color.white);
		
		btnMinTime.setFocusPainted(false);
		btnMinDistance.setFocusPainted(false);
		btnMinFare.setFocusPainted(false);
		btnMinMap.setFocusPainted(false);
		btnShare.setFocusPainted(false);
		
		btnMinTime.setOpaque(false);
		btnMinDistance.setOpaque(false);
		btnMinFare.setOpaque(false);
		btnMinMap.setOpaque(false);
		btnShare.setOpaque(false);
		
		btnMinTime.setBorder(new RoundBorder(15));
		btnMinDistance.setBorder(new RoundBorder(15));
		btnMinFare.setBorder(new RoundBorder(15));
		btnMinMap.setBorder(new RoundBorder(15));
		btnShare.setBorder(new RoundBorder(15));
		
		btnMinTime.addActionListener(btnListener);
		btnMinDistance.addActionListener(btnListener);
		btnMinFare.addActionListener(btnListener);
		btnMinMap.addActionListener(btnListener);
		btnShare.addActionListener(btnListener);
		
		PnPathway.add(btnMinTime);
		PnPathway.add(btnMinDistance);
		PnPathway.add(btnMinFare);
		PnPathway.add(btnMinMap);
		PnPathway.add(btnShare);
	}
	
	public void setScrollPane() {
		columns = new Vector<>();
		columns.addElement("출발역");
		columns.addElement("도착역");
		columns.addElement("최소비용(원)");
		data1 = new Vector<>();
		
		rowVector =new Vector<>();
		rowVector.addElement(startStation);
		rowVector.addElement(endStation);
		rowVector.addElement(cost);
		data1.addElement(rowVector);
		
		tableModel =new DefaultTableModel();
		tableModel.setDataVector(data1, columns);
		jtTable = new JTable(tableModel);
		
		jspTable = new JScrollPane(jtTable);
		jspTable.setBounds(12, 124, 574, 498);
		
		searchMinCost(0);
		
		PnPathway.add(jspTable);
	}
	
	public void searchMinCost(int weightType) {
		this.weightType = weightType;
		
		cost = frame.getDtCtr().minWeight(Database.conversionIndex(startStation), Database.conversionIndex(endStation), weightType);
		
		rowVector.clear();
		data1.clear();
		rowVector.addElement(endStation);
		rowVector.addElement(startStation);
		rowVector.addElement(cost);
		data1.addElement(rowVector);
		tableModel.setDataVector(data1, columns);
		jtTable.setModel(tableModel);
		
	}
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnMinTime) {
				searchMinCost(0);
			} else if (e.getSource() == btnMinDistance) {
				searchMinCost(1);
			} else if (e.getSource() == btnMinFare) {
				searchMinCost(2);
			} else if(e.getSource() == btnMinMap) {
				System.out.print("hello");
				/*shortestPath1 = new ArrayList<>();
				rNode = new ArrayList<>();
				try {
					rNode=dc.minWeight1(dc.DB1.conversionIndex(startStation), dc.DB1.conversionIndex(endStation), weightType);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				shortestPath1=dc.arrival(dc.DB.conversionIndex(startStation), dc.DB.conversionIndex(endStation), rNode);
				x = shortestPath1.size();
								
				mapFrame = new JFrame();
				mapFrame.setBounds(100, 100, 612, 726);
				mapFrame.getContentPane().setLayout(null);
				mapFrame.setVisible(true);
				
				LinePanel = new JPanel();
				LinePanel.setBounds(0, 0, 1000, 1000);
				LinePanel.setBackground(Color.GRAY);
				mapFrame.getContentPane().add(LinePanel);
				LinePanel.setLayout(null);
			
				mapPanel = new MapPanel();
				mapPanel.setBounds(10, 120, 1000, 1000);
				mapPanel.setPreferredSize(new Dimension(1000,1000));
				int n = 15;
			
				jsp1 = new JScrollPane(mapPanel);
				jsp1.setBounds(20, 140, 560, 525);
				LinePanel.add(jsp1);
			
				mapFrame.setVisible(true);*/
			} else if(e.getSource() ==  btnShare) {
				shareFrame = new ShareFrame(frame, startStation, endStation, cost);
			}
		}
	}
	
}
