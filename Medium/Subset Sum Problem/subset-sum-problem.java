//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: If the sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) { // if current element is less than or equal to sum
                    // Pick the current element
                    boolean pick = dp[i - 1][j - arr[i - 1]];
                    // Not pick the current element
                    boolean notPick = dp[i - 1][j];
                    // Update dp table
                    dp[i][j] = pick || notPick;
                } else {
                    // Not pick the current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}