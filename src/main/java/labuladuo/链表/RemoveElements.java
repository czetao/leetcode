package labuladuo.链表;

/**
 * @description 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @author chenzetao
 * @time 2024/4/9 16:36
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode(0, head);
        ListNode prev = listNode;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            }else{
                prev = current;
            }

            current = prev.next;

        }
        return listNode.next;

    }
}
