package offer;

import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/16 10:02
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        /***
         * 有一个小坑，因为反转链表需要3个结点，所以要记录第三个结点的位置
         * @param head
         * @return
         */
        public ListNode ReverseList(ListNode head) {
            ListNode pre = null;
            ListNode node = head;
            ListNode rever = null;
            while (node != null){
                if (node.next == null){
                    rever = node;
                   // break;   后面的元素还是需要结点反转，不可以break
                }
                ListNode next = node.next;
                node.next = pre;

                pre = node ;
                node = next;
            }
            return rever;
        }
    }
}
