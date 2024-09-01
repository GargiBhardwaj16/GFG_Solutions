//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> findPath(int[][] m) {
        ArrayList<String> ans = new ArrayList<String>();
        int n=m.length;
        func(m, 0, 0, n, ans,"");
        return ans;
    }

    public static void func(int[][] m, int i, int j, int n, ArrayList<String> ans, String path) {
        if (i == -1 || i == n || j == -1 || j == n || m[i][j] == 0) return;
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }
        m[i][j] = 0;
        func(m, i + 1, j, n, ans, path+"D");
        func(m, i - 1, j, n, ans, path+"U");
        func(m, i, j + 1, n, ans, path+"R");
        func(m, i, j - 1, n, ans, path+"L");
        m[i][j] = 1;
    }
}