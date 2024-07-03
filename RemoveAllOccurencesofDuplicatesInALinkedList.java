/*
Remove all occurences of duplicates in a linked list
Difficulty: MediumAccuracy: 49.82%Submissions: 30K+Points: 4

Given a sorted linked list, delete all nodes that have duplicate numbers (all occurrences), leaving only numbers that appear once in the original list, and return the head of the modified linked list. 

Examples:

Input: Linked List = 23->28->28->35->49->49->53->53
Output: 23 35
Explanation: 

The duplicate numbers are 28, 49 and 53 which are removed from the list.

Input: Linked List = 11->11->11->11->75->75
Output: Empty list
Explanation: 

All the nodes in the linked list have duplicates. Hence the resultant list would be empty.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ size(list) ≤ 105

*/
//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GFG {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            GFG llist = new GFG();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public Node removeAllDuplicates(Node head) {
        if(head==null) return head;
        Node dummy=new Node(0);
        
        dummy.next=head;//Showing the previous node
        
        Node curr=head;
        Node prev=dummy;
        
        while(curr!=null){
            if(curr.next!=null && curr.data==curr.next.data){
                while(curr.next!=null && curr.data==curr.next.data){
                    curr=curr.next;
                }
                prev.next=curr.next;
            }else{
                prev=prev.next;
            }
            curr=curr.next;
        }
        
        return dummy.next;
    }
}
