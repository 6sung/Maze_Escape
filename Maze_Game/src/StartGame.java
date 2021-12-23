import java.util.Scanner;
public class StartGame {
	static Scanner in = new Scanner(System.in);
	public static GoToXY[] gotoXY;
	public static int count=0;
	public static int maxCount;
	public static int size;
	public static int k;
	static int fir,las;
	static String[][] gmap;
	StartGame(int maxCount){
		this.maxCount=maxCount;
		gotoXY=new GoToXY[maxCount];
	}
	public void Maze(String name,int size,int k) {
		gmap=new String[size][size]; int i,j;
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				gmap[i][j]=null;
			}
		}
		if(k==1) {
			Map map = new Map(size);
			map.EasySetMap(); fir=map.fir; las=map.las;
			for( i=0;i<size;i++) {
				for( j=0;j<size;j++) {
					gmap[i][j]=map.map[i][j];
				}
			}
		}
		else {
			HMap hmap = new HMap(size);
			hmap.HardSetMap(); fir=hmap.fir; las=hmap.las;
			for( i=0;i<size;i++) {
				for( j=0;j<size;j++) {
					gmap[i][j]=hmap.map[i][j];
				}
			}
		}
		gmap[las][size-1]="♠♠";
		int x=fir, y=0;gmap[x][y]=null; gmap[x][y]="♠♠"; String emt="  "; String blk="▒▒";
		gotoXY[count]=new GoToXY(0, 0, 0);
		gotoXY[count].setX(x); gotoXY[count].setY(0);
		gotoXY[count].setCnt(count); count++; pScreen(size,x,y,k);
		while(true) {
			gotoXY[count]=new GoToXY(0, 0, 0);
			String key;
			//clearScreen(); pScreen(size);
			System.out.printf("입력 (↑:w /↓:s /→:d /←:a) >> ");key=in.next();
			
			if(key.equals("w")) {
				if(gmap[x-1][y] != blk && (x-1)>0 ) {
					gmap[x][y]=emt; x--; gmap[x][y]="♠♠";
					gotoXY[count].setX(x); gotoXY[count].setY(y);
					gotoXY[count].setCnt(count); count++;
					clearScreen(); pScreen(size,x,y,k);
				}else {
					clearScreen();System.out.println("그 위치는 벽이 있습니다. 다시 입력하시오.");
					pScreen(size,x,y,k);
				}
			}
			if(key.equals("s")) {
				if(gmap[x+1][y] != blk && (x+1)<size ) {
					gmap[x][y]=emt; x++; gmap[x][y]="♠♠";
					gotoXY[count].setX(x); gotoXY[count].setY(y);
					gotoXY[count].setCnt(count); count++;
					clearScreen(); pScreen(size,x,y,k);
				}else {
					clearScreen();System.out.println("그 위치는 벽이 있습니다. 다시 입력하시오.");
					pScreen(size,x,y,k);
				}
			}
			if(key.equals("d")) {
				if(gmap[x][y+1] != blk && (y+1)<size ) {
					gmap[x][y]=emt; y++; gmap[x][y]="♠♠";
					gotoXY[count].setX(x); gotoXY[count].setY(y);
					gotoXY[count].setCnt(count); count++;
					clearScreen(); pScreen(size,x,y,k);
				}else {
					clearScreen();System.out.println("그 위치는 벽이 있습니다. 다시 입력하시오.");
					pScreen(size,x,y,k);
				}
			}
			if(key.equals("a")) {
				if(y==0) {
					clearScreen();System.out.println("맵의 끝입니다. 다시입력하시오.");
					pScreen(size,x,y,k);}
				else if(gmap[x][y-1] != blk && (y-1)>0 ) {
					gmap[x][y]=emt; y--; gmap[x][y]="♠♠";
					gotoXY[count].setX(x); gotoXY[count].setY(y);
					gotoXY[count].setCnt(count); count++;
					clearScreen(); pScreen(size,x,y,k);
				}else {
					clearScreen();System.out.println("그 위치는 벽이 있습니다. 다시 입력하시오.");
					pScreen(size,x,y,k);
				}
			}
			if(x==las && y==(size-1)) { 
				endGame(); 
				System.out.println("!!!!!!!!!!!!!!!!미로탈출성공!!!!!!!!!!!!!!!!!!");
				break;
			}
		}
		int yes;
		System.out.printf("게임 기록을 저장하시겠습니까?(1: 저장  / 0: 게임종료) >>> "); yes=in.nextInt();
		if(yes==1) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~현재게임기록~~~~~~~~~~~~~~~~~~~~~~~~");
			FileInputOutput fileMgr = new FileInputOutput("Record.java" , "Record.java");
			fileMgr.loadRecord();
			fileMgr.saveRecord(name, k , count);
			int menu;
			while(true) {
			System.out.printf("저장이 완료되었습니다. 게임종료(0)>> ");menu=in.nextInt();
			if(menu==0) break;
			}
		}
		//fileMgr.saveLine();
	}
	public static void clearScreen() {
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	}
	public static void pScreen(int size,int x,int y,int k) {
		int i,j;
		if(k==1) { //난이도 normal일때
			for(i=0;i<size;i++) {
				for(j=0;j<size;j++) {
					if(i==0 || j==(size-1) || j==0 || i==(size-1)) {
						System.out.printf(gmap[i][j]);
					}
					else if(i==(x-1)){
						if(j==(y-1) || j==(y+1) || j==y) System.out.printf(gmap[i][j]);
						else System.out.printf("  ");
					}
					else if(i==x) {
						if(j==(y-1) || j==(y+1) || j==y) System.out.printf(gmap[i][j]);
						else System.out.printf("  ");
					}
					else if(i==(x+1)) {
						if(j==(y-1) || j==(y+1) || j==y) System.out.printf(gmap[i][j]);
						else System.out.printf("  ");
					}
					else{
						System.out.printf("  ");
					}
				}
				System.out.println("");
			}
		}else { //난이도 hard일때
			for(i=0;i<size;i++) {
				for(j=0;j<size;j++) {
					if(i==0 || j==0 || i==(size-1)) {
						System.out.printf(gmap[i][j]);
					}
					else if(j==(size-1)) {
						if(y==(size-2)) {
							if(x==las || x==(las-1) || x==(las+1)) {
								System.out.printf(gmap[i][j]);
							}
						}
						else {System.out.printf("▒▒");}
					}
					else if(i==(x-1)){
						if(j==(y-1) || j==(y+1) || j==y) System.out.printf(gmap[i][j]);
						else System.out.printf("  ");
					}
					else if(i==x) {
						if(j==(y-1) || j==(y+1) || j==y) System.out.printf(gmap[i][j]);
						else System.out.printf("  ");
					}
					else if(i==(x+1)) {
						if(j==(y-1) || j==(y+1) || j==y) System.out.printf(gmap[i][j]);
						else System.out.printf("  ");
					}
					else{
						System.out.printf("  ");
					}
				}
				System.out.println("");
			}
		}
	}
	public static void endGame() {
		int i,j;
		System.out.println(count+"회 이동으로 탈출 성공");
		for(i=0;i<count;i++) {
			int x=gotoXY[i].getX();
			int y=gotoXY[i].getY();
			int cnt=gotoXY[i].getCnt();
			System.out.println("("+x+","+y+")이동 -> count : "+(cnt+1));
		}
	}
}
