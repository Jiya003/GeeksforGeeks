/*
Linked list of strings forms a palindrome
Difficulty: Easy Accuracy: 58.6% Submissions: 39K+ Points: 2

Given a linked list with string data, check whether the combined string formed is palindrome. If the combined string is palindrome then return true otherwise return false.

Example:

Input:

Output : true
Explanation: As string "abcddcba" is palindrome the function should return true.

Input:

Output : false
Explanation: As string "abcdba" is not palindrome the function should return false.

Expected Time Complexity:  O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Node.data.length<= 103
1<=list.length<=103
*/
//{ Driver Code Starts
import java.util.*;

class Node {
    String data;
    Node next;

    Node(String x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() { head = null; }

    void addNode(String str) {
        if (head == null) {
            head = new Node(str);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(str);
        }
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int K = sc.nextInt();
            LinkedList list = new LinkedList();

            for (int i = 0; i < K; i++) {
                String str = sc.next();
                list.addNode(str);
            }

            Solution ob = new Solution();
            boolean ans = ob.compute(list.head);
            if (ans) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean compute(Node root) {
        String s=linkedListtoString(root);
        String rev=Reverse(s);
        
        return (s.equals(rev));
        
    }
    
    public String linkedListtoString(Node root){
        StringBuilder res=new StringBuilder();
        
        if(root==null) return "";
        Node curr=root;
        while(curr!=null){
            res.append(curr.data);
            curr=curr.next;
        }
        
        return res.toString();
    }
    
    public String Reverse(String s){
        int len=s.length();
        
        StringBuilder rev=new StringBuilder();
        
        for(int i=len-1;i>=0;i--){
            rev.append(s.charAt(i));
        }
        
        return rev.toString();
    }
}
