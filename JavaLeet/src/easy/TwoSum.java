package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
	//1
	//Given an array of integers nums and an integer target, 
	//return indices of the two numbers such that they add up to target.
	//You may assume that each input would have exactly one solution, 
	//and you may not use the same element twice.
	//You can return the answer in any order.
	
	public static void main(String[] args) { 
		
		TwoSum ts = new TwoSum();
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] rez = ts.twoSum(nums, target);
		System.out.println(rez[0] +  " " + rez[1]);
		
	}
	
//first solution, 56% and 6% memory
	
//    public int[] twoSum(int[] nums, int target) {
//        int[] rez = new int[2];
//        
//        HashMap<Integer, ArrayList<Integer>> occurences = createSet(nums);
//        
//        for(Integer key : occurences.keySet()) {
//        	if(occurences.containsKey(target-key)) {
//        		if(target-key == key) { 
//            		if(occurences.get(key).size()>=2) { 
//            			rez[0] = occurences.get(key).get(0);
//            			rez[1] = occurences.get(key).get(1);
//            		}
//        		}
//        		else { 
//        			rez[0] = occurences.get(key).get(0);
//        			rez[1] = occurences.get(target-key).get(0);
//        		}
//        	}
//        }
//        return rez;
//    }
//    public static HashMap<Integer, ArrayList<Integer>> createSet(int[] nums) { 
//        HashMap<Integer, ArrayList<Integer>> occurences = new HashMap<Integer, ArrayList<Integer>>();
//        for(int i=0; i<nums.length; i++) { 
//        	if(occurences.containsKey(nums[i])) { 
//        		ArrayList<Integer> indexes = occurences.get(nums[i]);
//        		indexes.add(i);
//        		occurences.put(nums[i], indexes);
//        	}
//        	else { 
//        		ArrayList<Integer> indexes = new ArrayList<Integer>();
//        		indexes.add(i);
//        		occurences.put(nums[i], indexes);
//        	}
//        }
//        return occurences;
//    }
	
	
// 85% and 95% (best attempt out of 3 submits)
//goes only once through array, could still be better because we don't need integer,arrayList<integer>
//as with this approach we only check if the element has occured before, if it did, we only care about that 
//one index (that will ultimately be the only one needed in the map
//	public int[] twoSum(int[] nums, int target) {
//     
//		int[] rez = new int[2];
//		HashMap<Integer, ArrayList<Integer>> occurences = new HashMap<Integer, ArrayList<Integer>>();
//		
//		for(int i=0; i<nums.length; i++) { 
//			if(occurences.containsKey(target-nums[i])) { 
//				if(target-nums[i] == nums[i]) { 
//					rez[0] = occurences.get(target-nums[i]).get(0);
//					rez[1] = i;
//				}
//				else {
//					rez[0] = i;;
//					rez[1] = occurences.get(target - nums[i]).get(0);
//					return rez;
//				}
//			}
//			if(occurences.containsKey(nums[i])) { 
//				ArrayList<Integer> indexes = occurences.get(nums[i]);
//				indexes.add(i);
//				occurences.put(nums[i], indexes);
//			}
//			else {
//				ArrayList<Integer> indexes = new ArrayList<Integer>();
//				indexes.add(i);
//				occurences.put(nums[i], indexes);
//			}
//		}
//		
//		return rez;
//	}
	
	
//time between 80-100 constantly, most optimal
//memory varies, still better than the last one
	public int[] twoSum(int[] nums, int target) {
	     
		int[] rez = new int[2];
		HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++) { 
			if(occurences.containsKey(target-nums[i])) { 
				if(target-nums[i] == nums[i]) { 
					rez[0] = occurences.get(target-nums[i]);
					rez[1] = i;
				}
				else {
					rez[0] = i;;
					rez[1] = occurences.get(target - nums[i]);
					return rez;
				}
			}
			occurences.put(nums[i], i);
		}
		
		return rez;
	}
}
