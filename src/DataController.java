import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.read.biff.BiffException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DataController {
	public Database DB = new Database();
	public Database DB1 = new Database();

	//�ּ� ��� ���ϴ� �Լ�
	//���ۿ��� �ε���, �������� �ε���, ����� ����� ���� 0 = Time, 1 = Distance, 2 = Fare
	public int minWeight(int startIndex, int endIndex, int weightType) {
		//���� ���� ���� & �ʱ�ȭ
		int dist[] = new int[112];	//���� ������ �湮�� �������� �ּ� ��� �迭
		PriorityQueue<Data> PQ = new PriorityQueue<>();	//�� Ʈ��
		ArrayList<Data> resultNode = new ArrayList<Data>();	//�ִ� ��θ� ����� �� ����� �迭
		DB.setData(); //test ����
		
		for (int i=0 ; i<111 ; i++) dist[i] = Integer.MAX_VALUE;	//��� ��� �湮 ����� �ִ�� ����
		
		switch(weightType) {
			case 0: PQ = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getTime(), N2.getTime())); //�ð�
					break;
			case 1: PQ = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getDistance(), N2.getDistance())); //�Ÿ�
					break;
			case 2: PQ = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getFare(), N2.getFare())); //���
					break;
			default: System.out.println("weightType Error!"); //���� �޼���
		}
	
		//���ۿ��� ������ �� ť�� �ִ´�
		PQ.offer(new Data(startIndex, startIndex, 0, 0, 0));
		dist[startIndex] = 0; //���ۿ� �̹Ƿ� �ʿ��� dist�� 0
		
		//���ͽ�Ʈ�� �˰��� ����
		while (!PQ.isEmpty()) {
			Data currentNode = PQ.poll(); //�� Ʈ�� ��Ʈ ��带 �ӽ� ������ �����ϰ� ��Ʈ������ ����
			resultNode.add(currentNode); //���
			System.out.println("currentNodeIndex = " + currentNode.getEndStationIndex()); //test ����
			
			//�������� �����ߴٸ� ��� ����� ����
			if (currentNode.getEndStationIndex() == endIndex) {
				System.out.println("���� ������ �ּ� ����ġ = " + dist[currentNode.getEndStationIndex()]); //test ����
				//���������� ���ۿ����� �ּ� ������� �̵��ϴ� ��� ���
				arrival(startIndex, endIndex, resultNode);
				return dist[currentNode.getEndStationIndex()];
			}
			
			//���ۿ� ���� ���� �������� ����� dist�� ��ϵ� ������ ũ�ٸ� ��ŵ
			//�̹� �湮�� ��带 �ٽ� �湮���� �ʱ� ���� ����
			//����� ����� ���¿� ���� ���
			switch (weightType) {
				case 0: if (dist[currentNode.getEndStationIndex()] < currentNode.getTime()) {
						System.out.println("skip\n"); //test ����
						continue;
						} break;
				case 1: if (dist[currentNode.getEndStationIndex()] < currentNode.getDistance()) {
						System.out.println("skip\n"); //test ����
						continue;
						} break;
				case 2: if (dist[currentNode.getEndStationIndex()] < currentNode.getFare()) {
						System.out.println("skip\n"); //test ����
						continue;
						} break;
				default: System.out.println("weightType Error!"); //���� �޼���
			}
			
			//���� ����� �ֺ� ��带 ���� �˻��ؼ� ����� ���
			//dist�� ����� ������ ���ۿ����� ���� �������� ����� ���ٸ� dist �� ���� �� �� Ʈ���� ����
			//����� ����� ���¿� ���� ���
			for (int i=0 ; i < DB.Node.get(currentNode.getEndStationIndex()).size() ; i++) {
				Data nextNode = DB.Node.get(currentNode.getEndStationIndex()).get(i);	//���� ��忡�� �� �� �ִ� �ֺ� ���
				
				switch (weightType) {
					case 0: if (dist[nextNode.getEndStationIndex()] > currentNode.getTime() + nextNode.getTime()) {
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test ����
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getTime() + nextNode.getTime())); //test ����
						
							dist[nextNode.getEndStationIndex()] = currentNode.getTime() + nextNode.getTime();
							PQ.offer(new Data(currentNode.getEndStationIndex(), nextNode.getEndStationIndex(), dist[nextNode.getEndStationIndex()], 0, 0)); //�� Ʈ�� ����
					
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test ����
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t�ּҰ� ����\n"); //test����
					
							} else System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex() + "\n" + dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getTime() + nextNode.getTime()) + "\n"); //test ����
							break;
					case 1: if (dist[nextNode.getEndStationIndex()] > currentNode.getDistance() + nextNode.getDistance()) {
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test ����
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getDistance() + nextNode.getDistance()));//test ����
					
							dist[nextNode.getEndStationIndex()] = currentNode.getDistance() + nextNode.getDistance();
							PQ.offer(new Data(currentNode.getEndStationIndex(), nextNode.getEndStationIndex(), 0, dist[nextNode. getEndStationIndex()], 0)); //�� Ʈ�� ����
					
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t�ּҰ� ����\n"); //test ����
					
							} else System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex() + "\n" + dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getDistance() + nextNode.getDistance()) + "\n"); //test ����
							break;
					case 2: if (dist[nextNode.getEndStationIndex()] > currentNode.getFare() + nextNode.getFare()) {
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test ����
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getFare() + nextNode.getFare())); //test ����
					
							dist[nextNode.getEndStationIndex()] = currentNode.getFare() + nextNode.getFare();
							PQ.offer(new Data(currentNode.getEndStationIndex(), nextNode.getEndStationIndex(), 0, 0, dist[nextNode. getEndStationIndex()])); //�� Ʈ�� ����				
					
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t�ּҰ� ����\n"); //test����
					
							} else System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex() + "\n" + dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getDistance() + nextNode.getDistance()) + "\n"); //test ����
							break;
					default: System.out.println("weightType Error!"); //���� �޼���
				}
			}
			System.out.println("���� ����ġ ��Ȳ(�ش� �ε����� ������ ���� ���� ���) : " + Arrays.toString(dist) + "\n"); //test ����
		}
		return -1;
	}
	
	//���ã�� �߰�
	public void addBookMark(int StationIndex) {
		System.out.println("���ã�⿡ �߰��մϴ�");
		DB.bookMark.add(StationIndex);
	}
	
	//���ã�� ����
	public void removeBookMark(int StationIndex) {
		for(int i=0 ; i<DB.bookMark.size() ; i++) {
			if(DB.bookMark.get(i) == StationIndex) {
				System.out.println("���ã�⿡ �����մϴ�");
				DB.bookMark.remove(i);
				break;
			}
		}
	}
	
	public void reviseMemo(int StationIndex, String memo) {
		System.out.println("���޵� : ��ȣ : " + StationIndex + ", �޸� : " + memo);
		DB.memo[StationIndex] = memo;
	}
	
	
	
	public void setStopover(int StationIndex) {
		System.out.println("Got index" + StationIndex);
		DB.stopoverStation = StationIndex;
	}
	
	public void cancelStopover() {
		DB.stopoverStation = -1;
	}
	
	//���ۿ����� ���������� �ּ� ������� �̵��ϴ� ��θ� ����ϴ� �Լ�
	public ArrayList<Integer> arrival(int startIndex, int endIndex, ArrayList<Data> resultNode2) {
		//�������� ���� & �ʱ�ȭ
		ArrayList<Integer> shortestPath = new ArrayList<>();
		int path = endIndex;
		
		//���������� ���ۿ����� �ּ� ����� ����, ����
		while(path != startIndex) {
			for(int i=0 ; i < resultNode2.size() ; i++) {
				if(resultNode2.get(i).getEndStationIndex() == path) {
					shortestPath.add(path);
					path = resultNode2.get(i).getStartStationIndex();
					break;
				}
			}
		}
		
		//�ִܰ�� ���
		System.out.print("�ִ� ���: " + startIndex + "\t"); //test ����
		for(int i=shortestPath.size()-1 ; i >= 0 ; i--) System.out.print(shortestPath.get(i) + "\t");
		
		return shortestPath;
	}
	public ArrayList<Data> minWeight1(int startIndex, int endIndex, int weightType) throws FileNotFoundException, BiffException, IOException {
		//���� ���� ���� & �ʱ�ȭ
		int dist1[] = new int[112];	//���� ������ �湮�� �������� �ּ� ��� �迭
		PriorityQueue<Data> PQ1 = new PriorityQueue<>();	//�� Ʈ��
		 ArrayList<Data> resultNode1 = new ArrayList<Data>();	//�ִ� ��θ� ����� �� ����� �迭
		DB1.setData(); //test ����
		
		for (int i=0 ; i<111 ; i++) dist1[i] = Integer.MAX_VALUE;	//��� ��� �湮 ����� �ִ�� ����
		
		switch(weightType) {
		case 0: PQ1 = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getTime(), N2.getTime())); //�ð�
				break;
		case 1: PQ1 = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getDistance(), N2.getDistance())); //�Ÿ�
				break;
		case 2: PQ1 = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getFare(), N2.getFare())); //���
				break;
		default: System.out.println("weightType Error!"); //���� �޼���
		}
	
		//���ۿ��� ������ �� ť�� �ִ´�
		PQ1.offer(new Data(startIndex, startIndex, 0, 0, 0));
		dist1[startIndex] = 0; //���ۿ� �̹Ƿ� �ʿ��� dist�� 0
		
		//���ͽ�Ʈ�� �˰��� ����
		while (!PQ1.isEmpty()) {
			Data currentNode1 = PQ1.poll(); //�� Ʈ�� ��Ʈ ��带 �ӽ� ������ �����ϰ� ��Ʈ������ ����
			resultNode1.add(currentNode1); //���
			
			System.out.println("currentNodeIndex = " + currentNode1.getEndStationIndex()); //test ����
			
			//�������� �����ߴٸ� ��� ����� ����
			if (currentNode1.getEndStationIndex() == endIndex) {
				System.out.println("���� ������ �ּ� ����ġ = " + dist1[currentNode1.getEndStationIndex()]); //test ����
				//���������� ���ۿ����� �ּ� ������� �̵��ϴ� ��� ���
				
				arrival(startIndex, endIndex, resultNode1);
				return resultNode1;
			}
			
			//���ۿ� ���� ���� �������� ����� dist�� ��ϵ� ������ ũ�ٸ� ��ŵ
			//�̹� �湮�� ��带 �ٽ� �湮���� �ʱ� ���� ����
			//����� ����� ���¿� ���� ���
			switch (weightType) {
				case 0: if (dist1[currentNode1.getEndStationIndex()] < currentNode1.getTime()) {
						System.out.println("skip\n"); //test ����
						continue;
						} break;
				case 1: if (dist1[currentNode1.getEndStationIndex()] < currentNode1.getDistance()) {
						System.out.println("skip\n"); //test ����
						continue;
						} break;
				case 2: if (dist1[currentNode1.getEndStationIndex()] < currentNode1.getFare()) {
						System.out.println("skip\n"); //test ����
						continue;
						} break;
				default: System.out.println("weightType Error!"); //���� �޼���
			}
			
			//���� ����� �ֺ� ��带 ���� �˻��ؼ� ����� ���
			//dist�� ����� ������ ���ۿ����� ���� �������� ����� ���ٸ� dist �� ���� �� �� Ʈ���� ����
			//����� ����� ���¿� ���� ���
			for (int i=0 ; i < DB1.Node.get(currentNode1.getEndStationIndex()).size() ; i++) {
				Data nextNode1 = DB1.Node.get(currentNode1.getEndStationIndex()).get(i);	//���� ��忡�� �� �� �ִ� �ֺ� ���
				
				switch (weightType) {
					case 0: if (dist1[nextNode1.getEndStationIndex()] > currentNode1.getTime() + nextNode1.getTime()) {
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test ����
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getTime() + nextNode1.getTime())); //test ����
						
							dist1[nextNode1.getEndStationIndex()] = currentNode1.getTime() + nextNode1.getTime();
							PQ1.offer(new Data(currentNode1.getEndStationIndex(), nextNode1.getEndStationIndex(), dist1[nextNode1.getEndStationIndex()], 0, 0)); //�� Ʈ�� ����
					
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test ����
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t�ּҰ� ����\n"); //test����
					
							} else System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex() + "\n" + dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getTime() + nextNode1.getTime()) + "\n"); //test ����
							break;
					case 1: if (dist1[nextNode1.getEndStationIndex()] > currentNode1.getDistance() + nextNode1.getDistance()) {
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test ����
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getDistance() + nextNode1.getDistance()));//test ����
					
							dist1[nextNode1.getEndStationIndex()] = currentNode1.getDistance() + nextNode1.getDistance();
							PQ1.offer(new Data(currentNode1.getEndStationIndex(), nextNode1.getEndStationIndex(), 0, dist1[nextNode1. getEndStationIndex()], 0)); //�� Ʈ�� ����
					
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t�ּҰ� ����\n"); //test ����
					
							} else System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex() + "\n" + dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getDistance() + nextNode1.getDistance()) + "\n"); //test ����
							break;
					case 2: if (dist1[nextNode1.getEndStationIndex()] > currentNode1.getFare() + nextNode1.getFare()) {
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test ����
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getFare() + nextNode1.getFare())); //test ����
					
							dist1[nextNode1.getEndStationIndex()] = currentNode1.getFare() + nextNode1.getFare();
							PQ1.offer(new Data(currentNode1.getEndStationIndex(), nextNode1.getEndStationIndex(), 0, 0, dist1[nextNode1. getEndStationIndex()])); //�� Ʈ�� ����				
					
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t�ּҰ� ����\n"); //test����
					
							} else System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex() + "\n" + dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getDistance() + nextNode1.getDistance()) + "\n"); //test ����
							break;
					default: System.out.println("weightType Error!"); //���� �޼���
				}
			}
			System.out.println("���� ����ġ ��Ȳ(�ش� �ε����� ������ ���� ���� ���) : " + Arrays.toString(dist1) + "\n"); //test ����
		}
		return resultNode1;
	}
	
	// �輱�� - �̹� �ִ��� Ȯ���ϴ� �ڵ�
	public boolean findBookMark(int StationIndex) {
		boolean isExist = false;
		for(int i=0 ; i<DB.bookMark.size() ; i++) {
			if(DB.bookMark.get(i) == StationIndex) {
				System.out.println("�̹� �ִ� �� Ȯ��!");
				isExist = true;
				break;
			}
		}
		return isExist;
	}
	
	// �輱�� - �˻� ��� �ʱ�ȭ
	public void resetBookMark() {
		DB.bookMark.clear();
	}
	// �輱��	- �޸� �ʱ�ȭ
	public void resetMemo() {
		for(int i = 0; i < 111; i++)
			DB.memo[i] = "";
	}
}

