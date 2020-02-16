package seleniumInterviewQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNGParameter {

	
		public static void main(String[] args) {
			
			int [] num = {8,50,45,20,29};
			getMinimumDis(num);
			
			int [] nums = {2,5,6,8,9,12,22,30,75};
			System.out.println(getBinariSearch(nums, 30));
			System.out.println(getPrime(10));
			System.out.println(isPrime(2));
		}
		
		
		public static boolean isPrime(int num) {
			boolean result = true;
			
			for(int i = 2; i < num; i ++) {
				if(num%i==0) {
					result = false;
				}else {
					return result;
				}
			}
			
			
			return result;
		}
		
		
		public static List<Integer> getPrime(int num){
			
			List<Integer> primeList = new ArrayList<Integer>();
			
			for (int i = 2; i <= num; i ++) {
				
				for(int j = 2; j <= num; j ++) {
					
					if (i == j) {
						
						primeList.add(j);
					}
					if(i % j == 0) {
						
						break;
					}
				}
			}
			
			
			
			return primeList;
		}
		
		public static int getBinariSearch(int [] arr, int input) {
			int start = 0;
			int last = arr.length-1;
			
			while(start <= last) {
				int mid = (start+last)/2;
				if(arr[mid] == input) {
					return mid;
				}
				else if(input > arr[mid]) {
					start = mid + 1;
				}
				else if(input < arr[mid]) {
					
					last = mid - 1;
				}
			}
			
			
			
			return 0;
		}
		
		public static int getMinimumDis(int [] arr) {
			int minDis = 0;
			Arrays.sort(arr);
			int min = arr[1] - arr[0];
			int indexOne=0;
			int indexTwo=0;
			for(int i = 0; i < arr.length-1; i++) {
				
				if(min > arr[i+1] - arr[i]) {
					
					min = arr[i+1] - arr[i];					
					indexOne = i;	
					indexTwo = i+1;
					
				}
			}
			minDis = min;
			System.out.println("Minmum Distance of value: "+ arr[indexOne] + " & " + arr[indexTwo] + " Distance is: " + minDis);
			
			return minDis;
		}
}
