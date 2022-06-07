//���� �̵��ϴµ� �ʿ��� ������ Ŭ����
public class Data {
	private int startStationIndex, endStationIndex = 0; //��߿�, ������ �ε���
	private int time, distance, fare = 0; //�ð�(��), �Ÿ�(����), ���(��)
	
	//������ �޼ҵ�
	Data(String SS, String ES, int Time, int Distance, int Fare) {
		this.startStationIndex = Database.conversionIndex(Integer.parseInt(SS));
		this.endStationIndex = Database.conversionIndex(Integer.parseInt(ES));
		this.time = Time;
		this.distance = Distance;
		this.fare = Fare;
	}
	
	//������ �޼ҵ�
	Data(int SSI, int ESI, int Time, int Distance, int Fare){
		this.startStationIndex = SSI;
		this.endStationIndex = ESI;
		this.time = Time;
		this.distance = Distance;
		this.fare = Fare;
	}
	
	//test ����� ���� �޼ҵ�
	@Override
	public String toString() {
		return Integer.toString(startStationIndex) + "\t" + Integer.toString(endStationIndex) + "\t" + Integer.toString(time) + "\t" + Integer.toString(distance) + "\t" + Integer.toString(fare) +"\n";
	}
		
	//������ ��ȯ
	public int getStartStationIndex() { return startStationIndex; } //��߿� �ε��� ��ȯ
	public int getEndStationIndex() { return endStationIndex; } //������ �ε��� ��ȯ
	public int getTime() { return time; } //�ð� ��ȯ
	public int getDistance() { return distance; } //�Ÿ� ��ȯ
	public int getFare() { return fare; } //��� ��ȯ
}
