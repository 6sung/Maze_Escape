import java.util.Scanner;
public class GameMain {
	static Scanner in = new Scanner(System.in);
	static String name;
	public static void main(String[] args) {
		clearScreen();
		int size,menu;
		/*System.out.printf("���� ũ�� (20~25���� ) : "); size=in.nextInt();
		*/
		int aa=0;
		do{
			if(aa==1) break;
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڹ̷�Ż�� ���ӡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
			System.out.println("1. ���Ӽ���(�ʵ�)");
			System.out.println("2. ���ӽ���");
			System.out.println("3. ��������");
			System.out.println("0. ��������");
			System.out.printf("�޴� �Է�>> "); menu=in.nextInt();
			switch (menu) {
				case 1 :clearScreen();explainGame(); clearScreen(); break;
				case 2 : clearScreen(); startGame(); clearScreen(); aa=1;break;
				case 3 : clearScreen();statGame(); clearScreen(); break;
			}
		}while(menu!=0);
	}
	public static void explainGame() {
		System.out.println("***** cls��� ����� �� 30���� �ٹٲ����� �ܼ�â ���̰� �ʹ� ����� ������ ��1�� ������ �׻� �����ϴ°ɷ� �����߽��ϴ�*****");
		System.out.println("Normal / Hard �ΰ��� ���̵��� �����մϴ�.");
		System.out.println("20~25 ������ ���� �Է��Ͽ� ���ϴ� n*nũ��� �̷θ� �����մϴ�.");
		System.out.println("�ּ��� �̵� Ƚ���� ��ο� �̷θ� Ż���ϴ� ���� ������ �����Դϴ�.");
		System.out.println("�̷��� �Ա��� �ⱸ�� �������� �����Ǵµ� �׻� �Ա��� ���ʺ��� �ⱸ�� ������ ���� �����˴ϴ�.");
		System.out.println("���� �׸��� ��Ҽ��� �̷ο��� ���̳��� ���� �ϳ��� ��� Ż���϶�� �����Դϴ�.");
		System.out.println("���� �ڽ��� ���� ��ĭ���� ������ ���̰� �������� ������� ������������ �ⱸ�� ���� ǥ�ð��˴ϴ�.");
		System.out.println("���̵� Normal�� ���̵� Hard���� ����  ��������� ���� �ⱸ�� ǥ�õ˴ϴ�.");
		System.out.println("���̵� Hard�� ���̵� Normal���� ���� ��������� ���� �ⱸ ��ó 1ĭ �̳��� �����Ҷ� ������ �ⱸ�� ��Ÿ���� �ʽ��ϴ�.");
		System.out.println("ĳ���� �̵��� ��:w /��:s /��:d /��:a�� �� �� �ֽ��ϴ�.");
		System.out.println("");
		while(true) {
			int menu;
			System.out.printf("0. ���θ޴� �̵� >> "); menu=in.nextInt();
			if(menu==0) break;
		}
	}
	public static void startGame() {
		int qual,size;
		System.out.printf("���� ���̵� �Է� >>> "); name=in.next();
		clearScreen();
		System.out.println("���� ���̵� >>> 1. Normal 2.Hard");
		System.out.printf("���̵� >> ");qual=in.nextInt();
		System.out.printf("���� ũ�� �Է�(20~25����) : ");size=in.nextInt();
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
		FileInputOutput fileMgr = new FileInputOutput("Record.java" , "Record.java"); // ��� �����Ҷ��� c:\\javawork\\	
		fileMgr.loadLine();
		int menu;
		System.out.println("");
		while(true) {
			System.out.printf("(0) ���θ޴� �̵� >> "); menu=in.nextInt();
			if(menu==0) break;
		}
	}
	public static void clearScreen() { //c������ cls���� ��Ȱ -> ȭ�� Ŭ����
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	}
}
