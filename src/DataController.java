import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.read.biff.BiffException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DataController {
	public Database DB = new Database();
	public Database DB1 = new Database();

	//최소 비용 구하는 함수
	//시작역의 인덱스, 도착역의 인덱스, 계산할 비용의 형태 0 = Time, 1 = Distance, 2 = Fare
	public int minWeight(int startIndex, int endIndex, int weightType) {
		//지역 변수 선언 & 초기화
		int dist[] = new int[112];	//시작 노드부터 방문한 노드까지의 최소 비용 배열
		PriorityQueue<Data> PQ = new PriorityQueue<>();	//힙 트리
		ArrayList<Data> resultNode = new ArrayList<Data>();	//최단 경로를 출력할 때 사용할 배열
		DB.setData(); //test 문구
		
		for (int i=0 ; i<111 ; i++) dist[i] = Integer.MAX_VALUE;	//모든 노드 방문 비용을 최대로 설정
		
		switch(weightType) {
			case 0: PQ = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getTime(), N2.getTime())); //시간
					break;
			case 1: PQ = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getDistance(), N2.getDistance())); //거리
					break;
			case 2: PQ = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getFare(), N2.getFare())); //요금
					break;
			default: System.out.println("weightType Error!"); //에러 메세지
		}
	
		//시작역을 선택한 후 큐에 넣는다
		PQ.offer(new Data(startIndex, startIndex, 0, 0, 0));
		dist[startIndex] = 0; //시작역 이므로 필요한 dist는 0
		
		//다익스트라 알고리즘 시작
		while (!PQ.isEmpty()) {
			Data currentNode = PQ.poll(); //힙 트리 루트 노드를 임시 변수에 저장하고 힙트리에서 제거
			resultNode.add(currentNode); //기록
			System.out.println("currentNodeIndex = " + currentNode.getEndStationIndex()); //test 문구
			
			//도착역에 도착했다면 비용 출력후 종료
			if (currentNode.getEndStationIndex() == endIndex) {
				System.out.println("도착 역까지 최소 가중치 = " + dist[currentNode.getEndStationIndex()]); //test 문구
				//도착역부터 시작역까지 최소 비용으로 이동하는 경로 출력
				arrival(startIndex, endIndex, resultNode);
				return dist[currentNode.getEndStationIndex()];
			}
			
			//시작역 부터 현재 노드까지의 비용이 dist에 기록된 값보다 크다면 스킵
			//이미 방문한 노드를 다시 방문하지 않기 위한 조건
			//계산할 비용의 형태에 따라 계산
			switch (weightType) {
				case 0: if (dist[currentNode.getEndStationIndex()] < currentNode.getTime()) {
						System.out.println("skip\n"); //test 문구
						continue;
						} break;
				case 1: if (dist[currentNode.getEndStationIndex()] < currentNode.getDistance()) {
						System.out.println("skip\n"); //test 문구
						continue;
						} break;
				case 2: if (dist[currentNode.getEndStationIndex()] < currentNode.getFare()) {
						System.out.println("skip\n"); //test 문구
						continue;
						} break;
				default: System.out.println("weightType Error!"); //에러 메세지
			}
			
			//현재 노드의 주변 노드를 전부 검사해서 비용을 계산
			//dist에 저장된 값보다 시작역부터 다음 노드까지의 비용이 적다면 dist 값 수정 후 힙 트리에 삽입
			//계산할 비용의 형태에 따라 계산
			for (int i=0 ; i < DB.Node.get(currentNode.getEndStationIndex()).size() ; i++) {
				Data nextNode = DB.Node.get(currentNode.getEndStationIndex()).get(i);	//현재 노드에서 갈 수 있는 주변 노드
				
				switch (weightType) {
					case 0: if (dist[nextNode.getEndStationIndex()] > currentNode.getTime() + nextNode.getTime()) {
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test 문구
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getTime() + nextNode.getTime())); //test 문구
						
							dist[nextNode.getEndStationIndex()] = currentNode.getTime() + nextNode.getTime();
							PQ.offer(new Data(currentNode.getEndStationIndex(), nextNode.getEndStationIndex(), dist[nextNode.getEndStationIndex()], 0, 0)); //힙 트리 삽입
					
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test 문구
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t최소값 갱신\n"); //test문구
					
							} else System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex() + "\n" + dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getTime() + nextNode.getTime()) + "\n"); //test 문구
							break;
					case 1: if (dist[nextNode.getEndStationIndex()] > currentNode.getDistance() + nextNode.getDistance()) {
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test 문구
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getDistance() + nextNode.getDistance()));//test 문구
					
							dist[nextNode.getEndStationIndex()] = currentNode.getDistance() + nextNode.getDistance();
							PQ.offer(new Data(currentNode.getEndStationIndex(), nextNode.getEndStationIndex(), 0, dist[nextNode. getEndStationIndex()], 0)); //힙 트리 삽입
					
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t최소값 갱신\n"); //test 문구
					
							} else System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex() + "\n" + dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getDistance() + nextNode.getDistance()) + "\n"); //test 문구
							break;
					case 2: if (dist[nextNode.getEndStationIndex()] > currentNode.getFare() + nextNode.getFare()) {
							System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex()); //test 문구
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getFare() + nextNode.getFare())); //test 문구
					
							dist[nextNode.getEndStationIndex()] = currentNode.getFare() + nextNode.getFare();
							PQ.offer(new Data(currentNode.getEndStationIndex(), nextNode.getEndStationIndex(), 0, 0, dist[nextNode. getEndStationIndex()])); //힙 트리 삽입				
					
							System.out.println(dist[nextNode.getEndStationIndex()] + "\t최소값 갱신\n"); //test문구
					
							} else System.out.println("nextNodeIndex = " + nextNode.getEndStationIndex() + "\n" + dist[nextNode.getEndStationIndex()] + "\t" + (currentNode.getDistance() + nextNode.getDistance()) + "\n"); //test 문구
							break;
					default: System.out.println("weightType Error!"); //에러 메세지
				}
			}
			System.out.println("계산된 가중치 현황(해당 인덱스의 역으로 가기 위한 비용) : " + Arrays.toString(dist) + "\n"); //test 문구
		}
		return -1;
	}
	
	//즐겨찾기 추가
	public void addBookMark(int StationIndex) {
		System.out.println("즐겨찾기에 추가합니다");
		DB.bookMark.add(StationIndex);
	}
	
	//즐겨찾기 해제
	public void removeBookMark(int StationIndex) {
		for(int i=0 ; i<DB.bookMark.size() ; i++) {
			if(DB.bookMark.get(i) == StationIndex) {
				System.out.println("즐겨찾기에 삭제합니다");
				DB.bookMark.remove(i);
				break;
			}
		}
	}
	
	public void reviseMemo(int StationIndex, String memo) {
		System.out.println("전달됨 : 번호 : " + StationIndex + ", 메모 : " + memo);
		DB.memo[StationIndex] = memo;
	}
	
	
	
	public void setStopover(int StationIndex) {
		System.out.println("Got index" + StationIndex);
		DB.stopoverStation = StationIndex;
	}
	
	public void cancelStopover() {
		DB.stopoverStation = -1;
	}
	
	//시작역부터 도착역까지 최소 비용으로 이동하는 경로를 출력하는 함수
	public ArrayList<Integer> arrival(int startIndex, int endIndex, ArrayList<Data> resultNode2) {
		//지역변수 선언 & 초기화
		ArrayList<Integer> shortestPath = new ArrayList<>();
		int path = endIndex;
		
		//도착역부터 시작역까지 최소 비용경로 추적, 저장
		while(path != startIndex) {
			for(int i=0 ; i < resultNode2.size() ; i++) {
				if(resultNode2.get(i).getEndStationIndex() == path) {
					shortestPath.add(path);
					path = resultNode2.get(i).getStartStationIndex();
					break;
				}
			}
		}
		
		//최단경로 출력
		System.out.print("최단 경로: " + startIndex + "\t"); //test 문구
		for(int i=shortestPath.size()-1 ; i >= 0 ; i--) System.out.print(shortestPath.get(i) + "\t");
		
		return shortestPath;
	}
	public ArrayList<Data> minWeight1(int startIndex, int endIndex, int weightType) throws FileNotFoundException, BiffException, IOException {
		//지역 변수 선언 & 초기화
		int dist1[] = new int[112];	//시작 노드부터 방문한 노드까지의 최소 비용 배열
		PriorityQueue<Data> PQ1 = new PriorityQueue<>();	//힙 트리
		 ArrayList<Data> resultNode1 = new ArrayList<Data>();	//최단 경로를 출력할 때 사용할 배열
		DB1.setData(); //test 문구
		
		for (int i=0 ; i<111 ; i++) dist1[i] = Integer.MAX_VALUE;	//모든 노드 방문 비용을 최대로 설정
		
		switch(weightType) {
		case 0: PQ1 = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getTime(), N2.getTime())); //시간
				break;
		case 1: PQ1 = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getDistance(), N2.getDistance())); //거리
				break;
		case 2: PQ1 = new PriorityQueue<Data>((N1, N2) -> Integer.compare(N1.getFare(), N2.getFare())); //요금
				break;
		default: System.out.println("weightType Error!"); //에러 메세지
		}
	
		//시작역을 선택한 후 큐에 넣는다
		PQ1.offer(new Data(startIndex, startIndex, 0, 0, 0));
		dist1[startIndex] = 0; //시작역 이므로 필요한 dist는 0
		
		//다익스트라 알고리즘 시작
		while (!PQ1.isEmpty()) {
			Data currentNode1 = PQ1.poll(); //힙 트리 루트 노드를 임시 변수에 저장하고 힙트리에서 제거
			resultNode1.add(currentNode1); //기록
			
			System.out.println("currentNodeIndex = " + currentNode1.getEndStationIndex()); //test 문구
			
			//도착역에 도착했다면 비용 출력후 종료
			if (currentNode1.getEndStationIndex() == endIndex) {
				System.out.println("도착 역까지 최소 가중치 = " + dist1[currentNode1.getEndStationIndex()]); //test 문구
				//도착역부터 시작역까지 최소 비용으로 이동하는 경로 출력
				
				arrival(startIndex, endIndex, resultNode1);
				return resultNode1;
			}
			
			//시작역 부터 현재 노드까지의 비용이 dist에 기록된 값보다 크다면 스킵
			//이미 방문한 노드를 다시 방문하지 않기 위한 조건
			//계산할 비용의 형태에 따라 계산
			switch (weightType) {
				case 0: if (dist1[currentNode1.getEndStationIndex()] < currentNode1.getTime()) {
						System.out.println("skip\n"); //test 문구
						continue;
						} break;
				case 1: if (dist1[currentNode1.getEndStationIndex()] < currentNode1.getDistance()) {
						System.out.println("skip\n"); //test 문구
						continue;
						} break;
				case 2: if (dist1[currentNode1.getEndStationIndex()] < currentNode1.getFare()) {
						System.out.println("skip\n"); //test 문구
						continue;
						} break;
				default: System.out.println("weightType Error!"); //에러 메세지
			}
			
			//현재 노드의 주변 노드를 전부 검사해서 비용을 계산
			//dist에 저장된 값보다 시작역부터 다음 노드까지의 비용이 적다면 dist 값 수정 후 힙 트리에 삽입
			//계산할 비용의 형태에 따라 계산
			for (int i=0 ; i < DB1.Node.get(currentNode1.getEndStationIndex()).size() ; i++) {
				Data nextNode1 = DB1.Node.get(currentNode1.getEndStationIndex()).get(i);	//현재 노드에서 갈 수 있는 주변 노드
				
				switch (weightType) {
					case 0: if (dist1[nextNode1.getEndStationIndex()] > currentNode1.getTime() + nextNode1.getTime()) {
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test 문구
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getTime() + nextNode1.getTime())); //test 문구
						
							dist1[nextNode1.getEndStationIndex()] = currentNode1.getTime() + nextNode1.getTime();
							PQ1.offer(new Data(currentNode1.getEndStationIndex(), nextNode1.getEndStationIndex(), dist1[nextNode1.getEndStationIndex()], 0, 0)); //힙 트리 삽입
					
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test 문구
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t최소값 갱신\n"); //test문구
					
							} else System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex() + "\n" + dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getTime() + nextNode1.getTime()) + "\n"); //test 문구
							break;
					case 1: if (dist1[nextNode1.getEndStationIndex()] > currentNode1.getDistance() + nextNode1.getDistance()) {
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test 문구
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getDistance() + nextNode1.getDistance()));//test 문구
					
							dist1[nextNode1.getEndStationIndex()] = currentNode1.getDistance() + nextNode1.getDistance();
							PQ1.offer(new Data(currentNode1.getEndStationIndex(), nextNode1.getEndStationIndex(), 0, dist1[nextNode1. getEndStationIndex()], 0)); //힙 트리 삽입
					
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t최소값 갱신\n"); //test 문구
					
							} else System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex() + "\n" + dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getDistance() + nextNode1.getDistance()) + "\n"); //test 문구
							break;
					case 2: if (dist1[nextNode1.getEndStationIndex()] > currentNode1.getFare() + nextNode1.getFare()) {
							System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex()); //test 문구
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getFare() + nextNode1.getFare())); //test 문구
					
							dist1[nextNode1.getEndStationIndex()] = currentNode1.getFare() + nextNode1.getFare();
							PQ1.offer(new Data(currentNode1.getEndStationIndex(), nextNode1.getEndStationIndex(), 0, 0, dist1[nextNode1. getEndStationIndex()])); //힙 트리 삽입				
					
							System.out.println(dist1[nextNode1.getEndStationIndex()] + "\t최소값 갱신\n"); //test문구
					
							} else System.out.println("nextNodeIndex = " + nextNode1.getEndStationIndex() + "\n" + dist1[nextNode1.getEndStationIndex()] + "\t" + (currentNode1.getDistance() + nextNode1.getDistance()) + "\n"); //test 문구
							break;
					default: System.out.println("weightType Error!"); //에러 메세지
				}
			}
			System.out.println("계산된 가중치 현황(해당 인덱스의 역으로 가기 위한 비용) : " + Arrays.toString(dist1) + "\n"); //test 문구
		}
		return resultNode1;
	}
	
	// 김선권 - 이미 있는지 확인하는 코드
	public boolean findBookMark(int StationIndex) {
		boolean isExist = false;
		for(int i=0 ; i<DB.bookMark.size() ; i++) {
			if(DB.bookMark.get(i) == StationIndex) {
				System.out.println("이미 있는 거 확인!");
				isExist = true;
				break;
			}
		}
		return isExist;
	}
	
	// 김선권 - 검색 기록 초기화
	public void resetBookMark() {
		DB.bookMark.clear();
	}
	// 김선권	- 메모 초기화
	public void resetMemo() {
		for(int i = 0; i < 111; i++)
			DB.memo[i] = "";
	}
}

