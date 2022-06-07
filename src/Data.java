//역을 이동하는데 필요한 데이터 클래스
public class Data {
	private int startStationIndex, endStationIndex = 0; //출발역, 도착역 인덱스
	private int time, distance, fare = 0; //시간(초), 거리(미터), 요금(원)
	
	//생성자 메소드
	Data(String SS, String ES, int Time, int Distance, int Fare) {
		this.startStationIndex = Database.conversionIndex(Integer.parseInt(SS));
		this.endStationIndex = Database.conversionIndex(Integer.parseInt(ES));
		this.time = Time;
		this.distance = Distance;
		this.fare = Fare;
	}
	
	//생성자 메소드
	Data(int SSI, int ESI, int Time, int Distance, int Fare){
		this.startStationIndex = SSI;
		this.endStationIndex = ESI;
		this.time = Time;
		this.distance = Distance;
		this.fare = Fare;
	}
	
	//test 출력을 위한 메소드
	@Override
	public String toString() {
		return Integer.toString(startStationIndex) + "\t" + Integer.toString(endStationIndex) + "\t" + Integer.toString(time) + "\t" + Integer.toString(distance) + "\t" + Integer.toString(fare) +"\n";
	}
		
	//데이터 반환
	public int getStartStationIndex() { return startStationIndex; } //출발역 인덱스 반환
	public int getEndStationIndex() { return endStationIndex; } //도착열 인덱스 반환
	public int getTime() { return time; } //시간 반환
	public int getDistance() { return distance; } //거리 반환
	public int getFare() { return fare; } //요금 반환
}
