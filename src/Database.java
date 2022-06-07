import java.io.*;
import jxl.*;
import jxl.read.biff.BiffException;
import java.util.List;
import java.util.ArrayList;


public class Database {
	public List<ArrayList<Data>> Node = new ArrayList<ArrayList<Data>>(); //������ ���
	public ArrayList<Integer> bookMark = new ArrayList<>(); //���ã�� ���� �迭
	public String memo[] = new String[111]; //�޸�
	public int stopoverStation; //������
	
	Database() {
		for (int i=0 ; i<112 ; i++) this.Node.add(new ArrayList<Data>()); //������ �ʱ�ȭ
		for (int i=0 ; i<111 ; i++) this.memo[i] = ""; //�޸� �ʱ�ȭ
		this.stopoverStation = -1; 
	}
	
	//������ ����
	public void setData() {
		Workbook WB = null; //������ ����� ������ ����
		try {
			WB = Workbook.getWorkbook(new File("stations.xls"));
		} catch (BiffException e) {
			System.out.print(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			System.exit(0);
		}
		
		Sheet sheet = WB.getSheet(0);
		
		String SS = ""; String ES = ""; int Time = 0; int Distance= 0; int Fare = 0; //��忡 ������ ������ buffer (���ۿ�, ������, �ð�, �Ÿ�, ���)
		
		//������ ����
        for (int col=1 ; col<139 ; col++) {
        	
             for (int row=0 ; row<5 ; row++) {
            	 
            	 Cell cell = sheet.getCell(row, col);
            	 if(row == 0) SS = cell.getContents();
         		 else if(row == 1) ES = cell.getContents();
         		 else if(row == 2) Time = Integer.parseInt(cell.getContents());
         		 else if(row == 3) Distance = Integer.parseInt(cell.getContents());
         		 else Fare = Integer.parseInt(cell.getContents());
             }
             
             Node.get(conversionIndex(Integer.parseInt(SS))).add(new Data(SS, ES, Time, Distance, Fare));
             Node.get(conversionIndex(Integer.parseInt(ES))).add(new Data(ES, SS, Time, Distance, Fare));
        }
	}
	
	
	//���� �̸��� ������ �ش� ���� �ε����� ��ȯ�ϴ� �޼ҵ�
	//���� �ε����� ������������ ����
	static public int conversionIndex(int Station) {
		if (Station < 200) return Station - 101;	//1ȣ�� 0~22
		else if (Station < 300) return Station - 178; //2ȣ�� 23~39
		else if (Station < 400) return Station - 261; //3ȣ�� 40~47
		else if (Station < 500) return Station - 353; //4ȣ�� 48~64
		else if (Station < 600) return Station - 436; //5ȣ�� 65~71
		else if (Station < 700) return Station - 529; //6ȣ�� 72~93
		else if (Station < 800) return Station - 607; //7ȣ�� 94~100
		else if (Station < 900) return Station - 700; //8ȣ�� 101~106
		else if (Station < 1000) return Station - 794; //9ȣ�� 107~110
		
		return -1;
	}
	
	//���� �ε����� ������ �ش� ���� �̸��� ��ȯ�ϴ� �޼ҵ�
	static public int backconversionIndex(int Index) {
		if (0 <= Index && Index <= 22) return Index + 101;	//1ȣ�� 0~22
		else if (Index <= 39) return Index + 178; //2ȣ�� 23~39
		else if (Index <= 47) return Index + 261; //3ȣ�� 40~47
		else if (Index <= 64) return Index + 353; //4ȣ�� 48~64
		else if (Index <= 71) return Index + 436; //5ȣ�� 65~71
		else if (Index <= 93) return Index + 529; //6ȣ�� 72~93
		else if (Index <= 100) return Index + 607; //7ȣ�� 94~100
		else if (Index <= 106) return Index + 700; //8ȣ�� 101~106
		else if (Index <= 110) return Index + 794; //9ȣ�� 107~110
		
		return -1;
	}
	
	//�Է¹��� ���ڿ��� ���� �̸����� Ȯ���ϴ� �޼ҵ�
	static public boolean isStation(String Station) {
		int station; //�� �̸�
		
		try {
			station = Integer.parseInt(Station);
		} catch (NumberFormatException e){
			return false;
		}
		
		if(101 <= station && station <= 123) return true; 
		else if(201 <= station && station <= 217) return true;
		else if(301 <= station && station <= 308) return true;
		else if(401 <= station && station <= 417) return true;
		else if(501 <= station && station <= 507) return true;
		else if(601 <= station && station <= 622) return true;
		else if(701 <= station && station <= 707) return true;
		else if(801 <= station && station <= 806) return true;
		else if(901 <= station && station <= 904) return true;
		else return false;
	}
}
