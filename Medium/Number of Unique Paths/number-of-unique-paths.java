//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][]=new int[a+1][b+1];
        return f(dp,0,0,a,b);
    }
    public static int f(int [][]dp,int i,int j,int a,int b){
        if(i>=a||j>=b) return 0;
        if(i==a-1 && j==b-1) return 1;
        if(dp[i][j]!=0) return dp[i][j];
        int r=f(dp,i+1,j,a,b);
        int c=f(dp,i,j+1,a,b);
        return dp[i][j]=r+c;
    }
}