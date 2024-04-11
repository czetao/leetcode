package labuladuo.链表;

/**
 * @description 你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @author chenzetao
 * @time 2024/4/9 16:52
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null,cur = head,temp = null;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
