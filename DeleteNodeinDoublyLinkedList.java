

/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if (x == 1) {
            if (head == null) return null; // Empty list
            if (head.next != null) {
                head.next.prev = null;
            }
            return head.next;
        }
        
        Node current = head;
        int position = 1;
        
        // Traverse to the node at position x
        while (current != null && position < x) {
            current = current.next;
            position++;
        }
        
        // If position is out of bound
        if (current == null) return head;
        
        // current is the node to be deleted
        
        // Adjust the pointers of previous and next nodes
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        
        // Free the memory of the node to be deleted (in Java, setting to null does this)
        current = null;
        
        return head;
    }
}
