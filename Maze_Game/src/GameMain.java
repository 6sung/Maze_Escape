import java.util.Scanner;
public class GameMain {
	static Scanner in = new Scanner(System.in);
	static String name;
	public static void main(String[] args) {
		clearScreen();
		int size,menu;
		/*System.out.printf("맵의 크기 (20~25사이 ) : "); size=in.nextInt();
		*/
		int aa=0;
		do{
			if(aa==1) break;
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★미로탈출 게임★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("1. 게임설명(필독)");
			System.out.println("2. 게임시작");
			System.out.println("3. 게임전적");
			System.out.println("0. 게임종료");
			System.out.printf("메뉴 입력>> "); menu=in.nextInt();
			switch (menu) {
				case 1 :clearScreen();explainGame(); clearScreen(); break;
				case 2 : clearScreen(); startGame(); clearScreen(); aa=1;break;
				case 3 : clearScreen();statGame(); clearScreen(); break;
			}
		}while(menu!=0);
	}
	public static void explainGame() {
		System.out.println("***** cls대신 사용한 매 30번의 줄바꿈으로 콘솔창 길이가 너무 길어져 게임을 딱1번 실행후 항상 종료하는걸로 수정했습니다*****");
		System.out.println("Normal / Hard 두개의 난이도가 존재합니다.");
		System.out.println("20~25 사이의 수를 입력하여 원하는 n*n크기로 미로를 생성합니다.");
		System.out.println("최소의 이동 횟수로 어두운 미로를 탈출하는 것이 게임의 목적입니다.");
		System.out.println("미로의 입구와 출구는 랜덤으로 생성되는데 항상 입구는 왼쪽벽에 출구는 오른쪽 벽에 생성됩니다.");
		System.out.println("게임 테마는 어둠속의 미로에서 빛이나는 램프 하나를 들고 탈출하라는 설정입니다.");
		System.out.println("따라서 자신의 주위 한칸씩만 빛으로 보이고 나머지는 어둠으로 보이지않지만 출구만 ♠♠ 표시가됩니다.");
		System.out.println("난이도 Normal은 난이도 Hard보다 벽이  상대적으로 적고 출구가 표시됩니다.");
		System.out.println("난이도 Hard는 난이도 Normal보다 벽이 상대적으로 많고 출구 근처 1칸 이내로 접근할때 까지는 출구가 나타나지 않습니다.");
		System.out.println("캐릭터 이동은 ↑:w /↓:s /→:d /←:a로 할 수 있습니다.");
		System.out.println("");
		while(true) {
			int menu;
			System.out.printf("0. 메인메뉴 이동 >> "); menu=in.nextInt();
			if(menu==0) break;
		}
	}
	public static void startGame() {
		int qual,size;
		System.out.printf("유저 아이디 입력 >>> "); name=in.next();
		clearScreen();
		System.out.println("게임 난이도 >>> 1. Normal 2.Hard");
		System.out.printf("난이도 >> ");qual=in.nextInt();
		System.out.printf("맵의 크기 입력(20~25사이) : ");size=in.nextInt();
		if(qual==1) {
			StartGame sg = new StartGame(500);
			sg.Maze(name,size,1);
		}
		else{
			
			StartGame sg = new StartGame(500);
			sg.Maze(name,size,2);
		}
		clearScreen();
	}
	public static void statGame() {
		FileInputOutput fileMgr = new FileInputOutput("Record.java" , "Record.java"); // 경로 지정할때는 c:\\javawork\\	
		fileMgr.loadLine();
		int menu;
		System.out.println("");
		while(true) {
			System.out.printf("(0) 메인메뉴 이동 >> "); menu=in.nextInt();
			if(menu==0) break;
		}
	}
	public static void clearScreen() { //c에서의 cls같은 역활 -> 화면 클리어
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	}
}
