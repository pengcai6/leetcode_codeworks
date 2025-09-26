package leetcode.editor.cn.mycode.ID143;

import leetcode.editor.util.ListNode;

public class 重排链表 {
    class Solution {
        public void reorderList(ListNode head) {
            ListNode middleNode = middleNode(head);
            ListNode head2 = reverse(middleNode);
            while (head2.next != null) {
                ListNode nxt = head.next;
                ListNode nxt2 = head2.next;
                head.next = head2;
                head2.next = nxt;
                head = nxt;
                head2 = nxt2;
            }
        }


        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }


        public ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode net = cur.next;
                cur.next = pre;
                pre = cur;
                cur = net;
            }

            return pre;
        }

    }

}

