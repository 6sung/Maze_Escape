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
	private File file; // File 클래스는 파일을 관리하는 기능 제공
	
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
			System.out.println("파일 열기에 실패했습니다. 파일명 : "+filename);
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
				//1.  아이디>>  jihyun  난이도>>  Hard  게임카운트>>  000  Clear
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
			System.out.println("파일 열기에 실패했습니다. 파일명 : "+filename);
		}
		catch(IOException e) {
			//e.printStackTrace();
		}
	}
	//버퍼를 이용해서 파일에 텍스트 데이터를 출력. 한 줄씩 출력하기
	public void saveRecord(String name,int k, int count) {
		try {
			//출력할 파일 오픈
			FileWriter writer = new FileWriter(filename2);
			BufferedWriter bufWriter = new BufferedWriter(writer);
			//파일에 데이터 기록하기
			if(cncn==0) {
				
				String lv="";
				if(k==1) lv = "Normal";
				else lv="Hard";
				//1.  아이디>>  jihyun  난이도>>  Hard  게임카운트>>  000  Clear
				bufWriter.write(number+".  아이디>>  "+name+"  난이도>>  "+lv+"  게임카운트>>  "+count+"  Clear");
				bufWriter.newLine();
				number++;
			}else {
				String lv="";
				if(k==1) lv = "Normal";
				else lv="Hard";
				//1.  아이디>>  jihyun  난이도>>  Hard  게임카운트>>  000  Clear
				bufWriter.write(number+".  아이디>>  "+name+"  난이도>>  "+lv+"  게임카운트>>  "+count+"  Clear");
				bufWriter.newLine();
				int cn=0;
				number++;
				while(record[cn].getId() != null) {
					String id=record[cn].getId(); String level=record[cn].getLevel();
					int cct=record[cn].getCnt();
					bufWriter.write(number+".  아이디>>  "+id+"  난이도>>  "+level+"  게임카운트>>  "+cct+"  Clear");
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