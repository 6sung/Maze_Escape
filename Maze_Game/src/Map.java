import java.util.Random;
public class Map{ // ���� �̷λ��� Ŭ����
	static int size;
	static int result;
	public static String[][] map;
	public static String[][] exmap;
	static int fir,las;
	Map(int n){
		map=new String[n][n];
		exmap=new String[n][n];
		size=n;
	}
	public void EasySetMap(){ // �������� �̷� ����
		String emt="  "; String blk="�Ƣ�";
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[i][j]=null;
				exmap[i][j]=null;
			}
		}
		Random random = new Random();
		int i,j,r;
		fir = random.nextInt(size-2)+1;
		las = random.nextInt(size-2)+1;
		for(i=0;i<size;i++) { map[0][i]=blk; map[size-1][i]=blk;}
		for(i=1;i<size;i++) { map[i][0]=blk; map[i][size-1]=blk;}
		map[fir][0]=emt; map[las][size-1]=emt;
		while(true) {
			for(i=1;i<size-1;i++) {
				for(j=1;j<size-1;j++) {
					r = random.nextInt(5);
					if(r==0 || r==3) {map[i][j]=blk;}
					else if(r==2 || r==1 || r==4) {map[i][j]=emt;}
				}
			}
			for(i=0;i<size;i++) {
				for(j=0;j<size;j++) {
					exmap[i][j]=map[i][j];
				}
			}
			EasyMakeMap(fir,0);
			map[fir][0]=emt;
			if(result==1) { //��Ʈ��ŷ �˻��� �̻������ result�� 1 ���� �̷οϼ�
				break;
			}
			result=0;
		}
	}
	public int EasyMakeMap(int x,int y) { //��Ʈ��ŷ���� �������� ������ �̷ΰ� ���� �ִ��� Ȯ��
		String emt="  "; String blk="�Ƣ�";	
		if(exmap[x][y]==blk || result==1) return 0;
		if(x==las && y==(size-1)) {
			result=1;
			return 0;
		}
		exmap[x][y]=blk;
		if(y==0) {
			EasyMakeMap(x,y+1);
			EasyMakeMap(x+1,y);
			EasyMakeMap(x-1,y);
			return 0;	
		}
		else if(x==0) {
			EasyMakeMap(x,y+1);
			EasyMakeMap(x,y-1);
			EasyMakeMap(x+1,y);
			return 0;
		}
		else {
			EasyMakeMap(x,y+1);
			EasyMakeMap(x,y-1);
			EasyMakeMap(x+1,y);
			EasyMakeMap(x-1,y);
			return 0;
		}
	}
}