//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


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
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.dis-y.dis);
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        pq.add(new pair(0,0,0));
        int nr[]={0,0,1,-1};
        int nc[]={1,-1,0,0};
        while(pq.size()!=0){
            int dis=pq.peek().dis;
            int r=pq.peek().x;
            int c=pq.peek().y;
            pq.remove();
            if(r==n-1 && c==m-1) return dis;
            for(int i=0;i<4;i++){
                int newr=r+nr[i];
                int newc=c+nc[i];
                if(newr>=0&&newr<n&&newc>=0&&newc<m){
                    int neweff=Math.max(Math.abs(heights[r][c]-heights[newr][newc]),dis);
                    if(neweff < dist[newr][newc]){
                        dist[newr][newc]=neweff;
                        pq.add(new pair(neweff,newr,newc));
                    }
                }
            }
        }
        return 0;
    }
}
