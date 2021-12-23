
public class Record {
	private String id;
	private String level;
	private int cnt;
	
	Record(String id,String level,int cnt){
		this.id=id; this.level=level; this.cnt=cnt;
	}
	public void setId(String id) {
		this.id=id;
	}
	public void setLevel(String level) {
		this.level=level;
	}
	public void setCnt(int cnt) {
		this.cnt=cnt;
	}
	public String getId() {
		return id;
	}
	public String getLevel() {
		return level;
	}
	public int getCnt() {
		return cnt;
	}
}
