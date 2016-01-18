/**
 * Created by sooglejay on 16/1/18.
 *

 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,


 */
public class OddEvenList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
//        ListNode l7 = new ListNode(7);
//        ListNode l8 = new ListNode(8);
//        ListNode l9 = new ListNode(9);
//        ListNode l10 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
//        l6.next=l7;
//        l7.next=l8;
//        l8.next=l9;
//        l9.next=l10;

        System.out.print(oddEvenList(l1).toString());
    }


    /**
     * Created by sooglejay on 16/1/16.
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        int i = 1;
        ListNode oddList = head;
        ListNode oddListHeader = oddList;


        ListNode evenList = null;
        ListNode evenListHeader = null;

        while (head.next != null) {
            head = head.next;
            i++;
            if (i % 2 != 0) {
                oddList.next = head;
                oddList = oddList.next;
            } else if (i == 2) {
                evenList = head;
                evenListHeader = evenList;
            } else {
                evenList.next = head;
                evenList = evenList.next;
            }
        }

        if (i % 2 != 0) {
            evenList.next = null;
        }
        oddList.next = evenListHeader;
        return oddListHeader;
    }
    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }


    }

}
