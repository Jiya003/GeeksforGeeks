

/*
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}*/

class Solution {
    // Function to check whether two linked lists are identical or not.
    public boolean areIdentical(Node head1, Node head2) {
        if(head1==null && head2==null) return true;
        if(head1==null || head2==null) return false;
        // write your code here
        Node p=head1;
        Node q=head2;
        
        
        while(p!=null && q!=null){
            if(p.data!=q.data){
                return false;
            }
            
            p=p.next;
            q=q.next;
        }
        return (p==null && q==null);
        
    }
}
