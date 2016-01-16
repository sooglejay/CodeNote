/**
 * Created by sooglejay on 16/1/16.
 */
public class ReverseLink {
    public static void main(String[] args) {


        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(3);
        ListNode ll4 = new ListNode(4);
        ListNode ll5 = new ListNode(5);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;
        ll5.next = null;

        ListNode l3 = reverseBetween(ll1, 1, 5);
        System.out.print(l3 == null ? "null" : l3.toString());
    }

    public static ListNode reverseList(ListNode head) {
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
        while (head != null) {
            data[--i] = head.val;
            head = head.next;
        }

        ListNode footer = new ListNode(data[0]);
        head = footer;
        for (int j = 1; j < data.length; j++) {
            ListNode node = new ListNode(data[j]);
            footer.next = node;
            footer = footer.next;
        }
        return head;
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
