/**
 *  Created by sooglejay on 16/1/11.
 *
 *
 *  LeetCode:Add Two Numbers
 *  You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  Subscribe to see which companies asked this question
 *
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode ll1 = new ListNode(0);
        ListNode ll2 = new ListNode(3);
        ListNode ll3 = new ListNode(6);
        ListNode ll4 = new ListNode(7);
        ListNode ll5 = new ListNode(3);
        ListNode ll6 = new ListNode(2);
        ListNode ll7 = new ListNode(1);
        ListNode ll8 = new ListNode(5);
        l1.next = ll1;
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;
        ll5.next = ll6;
        ll6.next = ll7;
        ll7.next = ll8;

        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(2);
        ListNode l9 = new ListNode(2);
        ListNode l10 = new ListNode(4);

        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        System.out.println("" + addTwoNumbers(l1, l2));


    }

    public static ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        long sumL1 = 0;
        long sumL2 = 0;
        long sum;

        int count = 0;
        while (L1 != null) {
            sumL1 += L1.val * (long) Math.pow(10, count);
            L1 = L1.next;
            count++;


        }
        count = 0;
        while (L2 != null) {
            sumL2 += L2.val * (long) Math.pow(10, count);
            L2 = L2.next;
            count++;
        }
        sum = sumL1 + sumL2;
//        System.out.println("123:"+ sum);

        long temp = sum % 10;
        sum = sum / 10;

        ListNode resultNode = new ListNode((int) temp);
        ListNode footer = resultNode;
        while (sum > 0) {

            temp = sum % 10;
            ListNode nextNode = new ListNode((int) temp);
            nextNode.next = footer.next;
            footer.next = nextNode;
            sum = sum / 10;
            footer = footer.next;

        }
        return resultNode;
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
