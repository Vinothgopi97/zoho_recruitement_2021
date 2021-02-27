import java.util.Scanner;

public class MyApp2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		
		int[] array1 = new int[length];
		
		for(int i=0;i<length;i++) {
			array1[i] = scanner.nextInt();
		}		
		scanner.close();
		
		//sort the array in asc order
		
		for(int i=0;i<array1.length;i++) {
			for(int j=0;j<array1.length;j++) {
				if(array1[i]<array1[j]) {
					int temp = array1[i];
					array1[i] = array1[j];
					array1[j] = temp;
				}
			}
		}			
		
		int[] outputArray = new int[array1.length];
		
		int k=0;
		int l = array1.length -1;
		
		for(int i=0;i<array1.length && k!=l+1;i++) {
			if(i%2!=0) {
				// nth max
				outputArray[i] = array1[k++];
			}
			else {
				//nth min
				outputArray[i] = array1[l--];
			}
		}
		
		// print the output
		for(int i=0;i<outputArray.length;i++) {
			System.out.print(outputArray[i]+" ");
		}
		
	}

}
