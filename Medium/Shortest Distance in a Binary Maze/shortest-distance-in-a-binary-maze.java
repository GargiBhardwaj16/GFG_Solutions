//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int dis;
    int x;
    int y;
    pair(int dis,int x,int y){
        this.dis=dis;
        this.x=x;
        this.y=y;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0]&&source[1]==destination[1]){
            return 0;
        }
        Queue<pair> pq=new LinkedList<pair>();
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[source[0]][source[1]]=0;
        pq.add(new pair(0,source[0],source[1]));
        int nr[]={0,0,1,-1};
        int nc[]={1,-1,0,0};
        while(pq.size()!=0){
            int dis=pq.peek().dis;
            int r=pq.peek().x;
            int c=pq.peek().y;
            pq.remove();
            for(int i=0;i<4;i++){
                int newr=r+nr[i];
                int newc=c+nc[i];
                if(newr>=0&&newr<n&&newc>=0&&newc<m&&grid[newr][newc]==1&&dist[newr][newc]>1+dis){
                    dist[newr][newc]=1+dis;
                if(newr==destination[0]&&newc==destination[1]){
                    return dis+1;
                }
                    pq.add(new pair(dis+1,newr,newc));
                }
            }
        }
        return -1;
    }
}
