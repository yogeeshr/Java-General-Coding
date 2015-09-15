
/**
 * @author I306479
 *
 * The trick I guess is to find all sub sequence of positive sequences and to consider max among those
 */
public class MaxSumSubArray {
	
	public static void main(String []args) {
		
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3}, sum=0, start=0, end=0, maxsum=0, tempStrt=0;
		
		for (int index=0; index < arr.length; index++) {
			
			//handle when we get negative numbers
			if (arr[index]<0) {
				if (maxsum<sum) {
					start=tempStrt;
					end=index-1;
					maxsum=sum;
				}
				sum=0;
				tempStrt=index+1;
				continue;
			}
			
			if (sum+arr[index] > sum) {
				sum = sum + arr[index];
			} 
			
		}
		
		//this is where last sub sequence results to the max array
		if (sum > maxsum) {
			start=tempStrt;
			end=arr.length-1;
			maxsum=sum;
		}
		
		System.out.println("Max Sub Array is : ");
		
		for (int j=start; j<=end; j++) {
			System.out.println(arr[j]+" ");
		}
		
		System.out.println("Max Sum is : " + maxsum);
		
	}

}
