package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.util.*;

public class ID148SortList{
	public static void main(String[] args) {
		Solution solution = new ID148SortList().new Solution();
		StringBuilder sb = new StringBuilder();
		
		//执行测试
		
		System.out.println(sb);		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode fast = head.next, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tmp = slow.next;
		slow.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(tmp);
		ListNode h = new ListNode(0);
		ListNode res = h;
		while (left != null && right != null) {
			if (left.val < right.val) {
				h.next = left;
				left = left.next;
			} else {
				h.next = right;
				right = right.next;
			}
			h = h.next;
		}
		h.next = left != null ? left : right;
		return res.next;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}