package medium;

import java.util.HashMap;

//3
//Given a string s, find the length of the longest substring without repeating characters.
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

//14% and 32% 
public class LongestCommonSubstringWRC {
	
	public static void main(String[] args) { 
		LongestCommonSubstringWRC lcs = new LongestCommonSubstringWRC();
		int length = lcs.lengthOfLongestSubstring("abcabcbb");
		System.out.println(length);
	}
	
    public int lengthOfLongestSubstring(String s) {
        
    	int currChar = 0;
    	int maxSubstring = 0;
    	int currMaxSubstring = 0;
    	HashMap<Character, Integer> positions = new HashMap<Character, Integer>();
    	while(currChar <= s.length()-1) { 
    		if(positions.containsKey(s.charAt(currChar))) {
    			currChar = positions.get(s.charAt(currChar))+1;
    			positions = new HashMap<Character, Integer>();
    			currMaxSubstring=0;
    		}
    		else { 
    			positions.put(s.charAt(currChar), currChar);
	    		currMaxSubstring+=1;
	    		currChar++;
    		}
			if(currMaxSubstring>maxSubstring) { 
				maxSubstring = currMaxSubstring;
			}
    	}
    	return maxSubstring;
    } 
}
