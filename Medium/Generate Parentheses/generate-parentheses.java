//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> l=new ArrayList<>();
        func(l,0,0,"",n);
        return l;
    }
    public static void func(List<String> l,int open,int close,String s,int totalpairs){
        if(s.length()==totalpairs*2){
            l.add(s);
            return;
        }
        if(open<totalpairs){
            func(l,open+1,close,s+"(",totalpairs);
        }
        if(open>close){
            func(l,open,close+1,s+")",totalpairs);
        }
    }
}