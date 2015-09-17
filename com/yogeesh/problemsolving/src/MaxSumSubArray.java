
/**
 * @author yogeesh.srkvs@gmail.com
 *
 * The trick I guess is to find all sub sequence of positive sequences and to consider max among those
 */
public class MaxSumSubArray {
	
	public static void main(String []args) {
		
		int arr[] = {-2000, -1, 2000, -4000}, sum=0, start=-1, end=0, maxsum=0, tempStrt=0;
		
		for (int index=0; index < arr.length; index++) {
			
			sum = sum + arr[index];
			
			if (sum<0) {
				sum=0;
				tempStrt=index+1;
			}
			
			if (maxsum < sum) {
				maxsum=sum;
				start=tempStrt;
				end=index;
			}
			
		}
				
		System.out.println("Max Sub Array is ("+start+" to "+end+")  : ");
		
		for (int j=start; j<=end && start>=0; j++) {
			System.out.println(arr[j]+" ");
		}
		
		System.out.println("Max Sum is : " + maxsum);
		
	}

}
