import java.io.*;
import jxl.*;
import jxl.read.biff.BiffException;
import java.util.List;
import java.util.ArrayList;


public class Database {
	public List<ArrayList<Data>> Node = new ArrayList<ArrayList<Data>>(); //데이터 노드
	public ArrayList<Integer> bookMark = new ArrayList<>(); //즐겨찾기 동적 배열
	public String memo[] = new String[111]; //메모
	public int stopoverStation; //경유지
	
	Database() {
		for (int i=0 ; i<112 ; i++) this.Node.add(new ArrayList<Data>()); //데이터 초기화
		for (int i=0 ; i<111 ; i++) this.memo[i] = ""; //메모 초기화
		this.stopoverStation = -1; 
	}
	
	//데이터 셋팅
	public void setData() {
		Workbook WB = null; //엑셀로 저장된 데이터 파일
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
		
		String SS = ""; String ES = ""; int Time = 0; int Distance= 0; int Fare = 0; //노드에 저장할 데이터 buffer (시작역, 도착역, 시간, 거리, 요금)
		
		//데이터 저장
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
	
	
	//역의 이름을 받으면 해당 역의 인덱스를 반환하는 메소드
	//역의 인덱스는 오름차순으로 설정
	static public int conversionIndex(int Station) {
		if (Station < 200) return Station - 101;	//1호선 0~22
		else if (Station < 300) return Station - 178; //2호선 23~39
		else if (Station < 400) return Station - 261; //3호선 40~47
		else if (Station < 500) return Station - 353; //4호선 48~64
		else if (Station < 600) return Station - 436; //5호선 65~71
		else if (Station < 700) return Station - 529; //6호선 72~93
		else if (Station < 800) return Station - 607; //7호선 94~100
		else if (Station < 900) return Station - 700; //8호선 101~106
		else if (Station < 1000) return Station - 794; //9호선 107~110
		
		return -1;
	}
	
	//역의 인덱스를 받으면 해당 역의 이름을 반환하는 메소드
	static public int backconversionIndex(int Index) {
		if (0 <= Index && Index <= 22) return Index + 101;	//1호선 0~22
		else if (Index <= 39) return Index + 178; //2호선 23~39
		else if (Index <= 47) return Index + 261; //3호선 40~47
		else if (Index <= 64) return Index + 353; //4호선 48~64
		else if (Index <= 71) return Index + 436; //5호선 65~71
		else if (Index <= 93) return Index + 529; //6호선 72~93
		else if (Index <= 100) return Index + 607; //7호선 94~100
		else if (Index <= 106) return Index + 700; //8호선 101~106
		else if (Index <= 110) return Index + 794; //9호선 107~110
		
		return -1;
	}
	
	//입력받은 문자열이 역의 이름인지 확인하는 메소드
	static public boolean isStation(String Station) {
		int station; //역 이름
		
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
