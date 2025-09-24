package leetcode.editor.cn.mycode.ID25;

import leetcode.editor.util.ListNode;

public class K个一组翻转链表 {

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root=new ListNode();
        root.next=head;
        ListNode pre=root;
        while (true){
            ListNode nextTail = nextTail(pre, k);
            if(nextTail==null){
                break;
            }
            ListNode next=nextTail.next;
            ListNode tail=pre.next;
            nextTail.next=null;
            ListNode newHead = reverse(pre.next);
            pre.next=newHead;
            tail.next=next;
            pre=tail;
        }
            return root.next;
        }
        public ListNode nextTail(ListNode head,int k){
            while (k>0){
                if(head!=null){
                    k--;
                    head=head.next;
                }else {
                    return null;
                }
            }
            return head;
        }


        private ListNode reverse(ListNode head){
            ListNode pre=null;
            ListNode curr=head;
           while (curr!=null){
               ListNode next = curr.next;
               curr.next=pre;
               pre=curr;
               curr=next;
           }
            return pre;
        }

    }
}
