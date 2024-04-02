//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.pairsViolatingBST(n, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int count;

    public static void inorder(ArrayList<Integer> l, Node root) {
        if (root == null) return;
        inorder(l, root.left);
        l.add(root.data);
        inorder(l, root.right);
    }

    public static int pairsViolatingBST(int n, Node root) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        count = 0;
        inorder(l, root);
        
        count = mergeSortAndCount(l, 0, l.size() - 1);
        
        return count;
    }
    
    private static int mergeSortAndCount(ArrayList<Integer> arr, int l, int r) {
        int invCount = 0;
        if (l < r) {
            int m = (l + r) / 2;

            // Count inversions in left subarray
            invCount += mergeSortAndCount(arr, l, m);

            // Count inversions in right subarray
            invCount += mergeSortAndCount(arr, m + 1, r);

            // Merge two sorted subarrays and count inversions
            invCount += mergeAndCount(arr, l, m, r);
        }
        return invCount;
    }

    private static int mergeAndCount(ArrayList<Integer> arr, int l, int m, int r) {
        ArrayList<Integer> temp = new ArrayList<>();
        int invCount = 0;

        int i = l, j = m + 1;

        while (i <= m && j <= r) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;

                // Inversion found
                invCount += (m - i + 1);
            }
        }

        while (i <= m) {
            temp.add(arr.get(i));
            i++;
        }

        while (j <= r) {
            temp.add(arr.get(j));
            j++;
        }

        for (int k = l; k <= r; k++) {
            arr.set(k, temp.get(k - l));
        }

        return invCount;
    }
}