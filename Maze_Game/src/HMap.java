import java.util.Random;
public class HMap{ // 랜덤 미로생성 클래스
	static int size;
	static int result;
	public static String[][] map;
	public static String[][] exmap;
	static int fir,las;
	HMap(int n){
		map=new String[n][n];
		exmap=new String[n][n];
		size=n;
	}
	public void HardSetMap(){ // 랜덤으로 미로 생성
		String emt="  "; String blk="▒▒";
		Random random = new Random();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[i][j]="  ";
				exmap[i][j]="  ";
			}
		}
		int i,j,r;
		fir = random.nextInt(size-2)+1;
		las = random.nextInt(size-2)+1;
		for(i=0;i<size;i++) { map[0][i]=blk; map[size-1][i]=blk;}
		for(i=1;i<size;i++) { map[i][0]=blk; map[i][size-1]=blk;}
		map[fir][0]=emt; map[las][size-1]=emt;
		while(true) {
			for(i=1;i<size-1;i++) {
				for(j=1;j<size-1;j++) {
					r = random.nextInt(4);
					if(r==0 || r==3) {map[i][j]=blk;}
					else if(r==2 || r==1) {map[i][j]=emt;}
				}
			}
			for(i=0;i<size;i++) {
				for(j=0;j<size;j++) {
					exmap[i][j]=map[i][j];
				}
			}
			HardMakeMap(fir,0);
			map[fir][0]=emt;
			if(result==1) { //백트래킹 검사후 이상없으면 result는 1 랜덤 미로완성
				break;
			}
			result=0;
		}
	}
	public int HardMakeMap(int x,int y) { //백트래킹으로 랜덤으로 생성된 미로가 길이 있는지 확인
		String emt="  "; String blk="▒▒";	
		if(exmap[x][y]==blk || result==1) return 0;
		if(x==las && y==(size-1)) {
			result=1;
			return 0;
		}
		exmap[x][y]=blk;
		if(y==0) {
			HardMakeMap(x,y+1);
			HardMakeMap(x+1,y);
			HardMakeMap(x-1,y);
			return 0;	
		}
		else if(x==0) {
			HardMakeMap(x,y+1);
			HardMakeMap(x,y-1);
			HardMakeMap(x+1,y);
			return 0;
		}
		else {
			HardMakeMap(x,y+1);
			HardMakeMap(x,y-1);
			HardMakeMap(x+1,y);
			HardMakeMap(x-1,y);
			return 0;
		}
	}
}