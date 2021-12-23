import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class FileInputOutput{
	static Scanner in = new Scanner(System.in);
	public static Record[] record;
	static int cncn=0;
	static int number=1;
	private String filename ,filename2;
	private File file; // File Ŭ������ ������ �����ϴ� ��� ����
	
	FileInputOutput(String fname , String fname2){
		record=new Record[50];
		filename=fname;
		filename2=fname2;
		for(int i=0;i<50;i++) {
			record[i]=new Record(null, null, 0);
		}
	}
	public void loadLine() {
		String title="",book="",base="";
		String line=null;
		try {
			FileReader reader = new FileReader(filename);	
			BufferedReader bufReader = new BufferedReader(reader);
			while((line = bufReader.readLine()) != null) {
				System.out.println(line);
			}
			bufReader.close();
		}catch(FileNotFoundException e){
			System.out.println("���� ���⿡ �����߽��ϴ�. ���ϸ� : "+filename);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadRecord() {
		String id="",level=""; int count;
		String line=null; int  cn=0;
		try {
			FileReader reader = new FileReader(filename);	
			BufferedReader bufReader = new BufferedReader(reader);
			while((line = bufReader.readLine()) != null) {

				StringTokenizer token = new StringTokenizer(line,"  ");
				String a=token.nextToken();
				String b=token.nextToken();
				//1.  ���̵�>>  jihyun  ���̵�>>  Hard  ����ī��Ʈ>>  000  Clear
				id = token.nextToken();
				String c=token.nextToken();
				level = token.nextToken();
				String d=token.nextToken();
				count = Integer.parseInt(token.nextToken());
				String e=token.nextToken();
				record[cn].setId(id); record[cn].setLevel(level);
				record[cn].setCnt(count);
				System.out.println(line);
				cn++;
				cncn++;
			}
			bufReader.close();
		}catch(FileNotFoundException e){
			System.out.println("���� ���⿡ �����߽��ϴ�. ���ϸ� : "+filename);
		}
		catch(IOException e) {
			//e.printStackTrace();
		}
	}
	//���۸� �̿��ؼ� ���Ͽ� �ؽ�Ʈ �����͸� ���. �� �پ� ����ϱ�
	public void saveRecord(String name,int k, int count) {
		try {
			//����� ���� ����
			FileWriter writer = new FileWriter(filename2);
			BufferedWriter bufWriter = new BufferedWriter(writer);
			//���Ͽ� ������ ����ϱ�
			if(cncn==0) {
				
				String lv="";
				if(k==1) lv = "Normal";
				else lv="Hard";
				//1.  ���̵�>>  jihyun  ���̵�>>  Hard  ����ī��Ʈ>>  000  Clear
				bufWriter.write(number+".  ���̵�>>  "+name+"  ���̵�>>  "+lv+"  ����ī��Ʈ>>  "+count+"  Clear");
				bufWriter.newLine();
				number++;
			}else {
				String lv="";
				if(k==1) lv = "Normal";
				else lv="Hard";
				//1.  ���̵�>>  jihyun  ���̵�>>  Hard  ����ī��Ʈ>>  000  Clear
				bufWriter.write(number+".  ���̵�>>  "+name+"  ���̵�>>  "+lv+"  ����ī��Ʈ>>  "+count+"  Clear");
				bufWriter.newLine();
				int cn=0;
				number++;
				while(record[cn].getId() != null) {
					String id=record[cn].getId(); String level=record[cn].getLevel();
					int cct=record[cn].getCnt();
					bufWriter.write(number+".  ���̵�>>  "+id+"  ���̵�>>  "+level+"  ����ī��Ʈ>>  "+cct+"  Clear");
					bufWriter.newLine();
					cn++;
					number++;
				}
			}
			bufWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}