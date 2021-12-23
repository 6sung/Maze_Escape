
public class GoToXY {
	private int x;
	private int y;
	private int cnt;
	
	GoToXY(int x,int y,int cnt){
		this.x=x; this.y=y; this.cnt=cnt;
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setCnt(int cnt) {
		this.cnt=cnt;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getCnt() {
		return cnt;
	}
}
