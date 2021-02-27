import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyApp1 {		
	
	private static boolean isExists(List<Integer> list,int element) {
		int length = list.size();
		for(int i=0;i<length;i++) {
			if(list.get(i) == element) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] arguments) {
		
		// to use two array elements and sort it as a single array without duplicates
		
		// Getting the input
		Scanner scanner = new Scanner(System.in);
		int length1 = scanner.nextInt();
		int length2 = scanner.nextInt();
		
		int[] array1  = new int[length1];
		int[] array2  = new int[length2];
		
		for(int i=0;i<length1;i++) {
			array1[i] = scanner.nextInt();
		}
		for(int i=0;i<length2;i++) {
			array2[i] = scanner.nextInt();
		}
		scanner.close();

		// sort each array first
	
		for(int i=0;i<array1.length;i++) {
			for(int j=0;j<array1.length;j++) {
				if(array1[i]<array1[j]) {
					int temp = array1[i];
					array1[i] = array1[j];
					array1[j] = temp;
				}
			}
		}			
		
		for(int i=0;i<array2.length;i++) {
			for(int j=0;j<array2.length;j++) {
				if(array2[i]<array2[j]) {
					int temp = array2[i];
					array2[i] = array2[j];
					array2[j] = temp;
				}
			}
		}
				
		// loop through both array to make it a single sorted array
		
		int maxLength = array1.length + array2.length;					
		
		List<Integer> list = new ArrayList<>();
		int i=0;
		int j=0;
		
		for(int k=0;k<maxLength && i<array1.length && j < array2.length;k++) {
			if(array1[i] <= array2[j] && !isExists(list,array1[i]))
			{
				list.add(array1[i]);
				i++;
			}
			else if( array1[i]> array2[j] && !isExists(list,array2[j]))
			{
				list.add(array2[j]);
				j++;
			}
		}
		
		for(;i<array1.length;i++) {
			if(!isExists(list,array1[i]))
				list.add(array1[i]);
		}
		for(;j<array2.length;j++) {
			if(!isExists(list,array2[i]))
				list.add(array2[j]);
		}
		
		System.out.println(list);
	}
}
