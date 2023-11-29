package hard;

public class FirstMissingPositive {

	
//	Given an unsorted integer array nums, return the smallest missing positive integer.
//	You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//	Input: nums = [3,4,-1,1]
//	Output: 2
//	Explanation: 1 is in the array but 2 is missing.
	
	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] nums = {0,1,2};
		int firstMissing = fmp.firstMissingPositive(nums);
		System.out.println(firstMissing);
	}
	public int firstMissingPositive(int[] nums) {
		        
		int i=0;
		while(i<nums.length) { 
			
			if(nums[i] < 1 || nums[i] == i+1) { 
				i++;
				continue;
			}
			else { 
				int first = nums[i]; //3
				if(first<=nums.length) {
					int second = nums[nums[i]-1];
					if(first == second) {
						i++;
						continue;
					}
					int tmp = second;
					nums[nums[i]-1] = first;
					nums[i] = second;
				}
				else { 
					i++;
					continue;
				}
			}
		}
		return findMissing(nums);
	}
	public int findMissing(int[] nums) { 
		for(int i=0; i<nums.length; i++) { 
			if(nums[i]-1 != i) { 
				return i+1;
			}
		}
		return nums.length+1;
	}
	public String printNums(int[] nums) { 
		String s = " ";
		for(int i=0; i<nums.length; i++) { 
			s += nums[i];
		}
		return s;
	}
}
