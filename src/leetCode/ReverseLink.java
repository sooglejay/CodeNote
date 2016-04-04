package leetCode;

/**
 * Created by sooglejay on 16/1/16.
 */
public class ReverseLink {
    public static void main(String[] args) {


        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);

        ll1.next = ll2;
        ll2.next = null;

        ListNode l3 = reverseList(ll1);
        System.out.print(l3 == null ? "null" : l3.toString());
    }

    /***
     * While you are traversing the list, change the current node's next pointer to point to its previous element
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;//store  current node's next
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            i++;
            tempNode = tempNode.next;
        }
        if (i < 2) {
            return head;
        }
        int data[] = new int[i];

        i = 0;
        while (head != null) {
            data[i++] = head.val;
            head = head.next;
        }

        i = 0;
        for (; i < data.length; i++) {
            int val = data[i];
            int index = n - (i + 1 - m) - 1;
            if (index < data.length && i + 1 >= m && i + 1 <= n && index >= 0) {
                val = data[index];
            }
            if (i == 0) {
                tempNode = new ListNode(val);
                head = tempNode;
                continue;
            }
            ListNode node = new ListNode(val);
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        return head;
    }

}
