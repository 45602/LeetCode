package hard;

/*
 				Descrption
An attendance record for a student can be represented as a string where each
character signifies whether the student was absent, late, or present on that day. 
The record only contains the following three characters:
'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n 
that make a student eligible for an attendance award. The answer may be very large, 
so return it modulo 109 + 7.

*/

public class LeetCode552 {
	
	//test ckass
	public static void main(String args[]) {
		System.out.println(checkRecord(3));
	}
	
	//Brute force solution 
	public static int checkRecord(int n) {
        if(n==0) {
            return 0;
        }
        else {
           return generateMore(true,false,false,n-1)+
                  generateMore(false,false,true,n-1)+
                  generateMore(false,false,false,n-1) ;
        }
    }
    public static int generateMore(boolean absent,boolean lateLastTwoDays, boolean lateLastDay,int n) {
        if(n==0) {
            return 1;
        }
        //ako kasni prosla dva dana
        if(lateLastTwoDays) {
            //ako je vec jednom bio odsutan
            if(absent) {
                 return generateMore(true,false,false,n-1);
            }
            else {
                 return generateMore(true,false,false,n-1)+
                        generateMore(false,false,false,n-1);
            }
           
        }
        else if(lateLastDay) {
            if(absent) {
               return generateMore(true,true,true,n-1)+
                      generateMore(true,false,false,n-1); 
            }
            else {
                return generateMore(true,false,false,n-1)+
                       generateMore(false,false,false,n-1)+
                       generateMore(false,true,true,n-1);
            }
            
        }
        else if(absent) {
              return generateMore(true,false,false,n-1)+
                     generateMore(true,false,true,n-1);      
        }
        else {
            return generateMore(true,false,false,n-1)+
                   generateMore(false,false,true,n-1)+
                   generateMore(false,false,false,n-1);            
        }
    }

}
