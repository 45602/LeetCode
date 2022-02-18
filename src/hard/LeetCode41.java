package hard;

public class LeetCode41 {

    public int firstMissingPositive(int[] nums) {
        
        int i=0;
        while(i<nums.length){ 
            if(nums[i] != i+1 && nums[i]>0 && nums[i]<nums.length) { 
                if(nums[nums[i]-1] != nums[i]) { 
                    swap(i, nums[i]-1, nums);
                }
                else {
                    i++;
                }
            }
            else { 
                i++;
            }
        }
        boolean found = false;
        i=0;
        while(!found && i<nums.length) {
            if(i+1!=nums[i]) { 
                found = true;
            }
            else { 
                i++;
            }
        }
        return i+1;
    }
    public void swap(int p, int k, int[] nums) { 
        int temp = nums[p];
        nums[p] = nums[k];
        nums[k] = temp;
    }
}
