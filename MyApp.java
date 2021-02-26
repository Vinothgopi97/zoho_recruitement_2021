import java.util.Scanner;

public class MyApp {

	public static void main(String[] args) {		
			
		 Scanner scan = new Scanner(System.in);
			String word = scan.next();
			int count = word.length();
			int middle = count/2;			
			int spaceCount = count;
			String sub = "";
			for(int i=middle;i<=count;i++) {
				String spaces = new String(new char[spaceCount]).replace('\0', ' ');
				System.out.print(spaces);
				sub = word.substring(middle,i);
				System.out.println(sub);
				spaceCount--;
			}
			for(int i=0;i<middle;i++){
			    String spaces = new String(new char[spaceCount]).replace('\0', ' ');
			    spaceCount--;
			    String sub1 = word.substring(0,i+1);
			    System.out.print(spaces);
			    System.out.println(sub+sub1);
			}
			scan.close();
	     }
	}
