/**
 * Given a sorted linked list, 
 * delete all duplicates such that each element appear only once.
 * Example
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3
 */
package chapter4;

public class RemoveDuplicatesfromSortedList {
	
    public ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if ( head == null ) {
            return null;
        }
        
        ListNode current = head;
        while(current.next !=null) {
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		head.next = node;
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(ListNode.printListfromHeadtoTail(head));
		RemoveDuplicatesfromSortedList removeDuplicatesfromSortedList = new RemoveDuplicatesfromSortedList();
		removeDuplicatesfromSortedList.deleteDuplicates(head);
		System.out.println(ListNode.printListfromHeadtoTail(head));
		
		

	}

}
