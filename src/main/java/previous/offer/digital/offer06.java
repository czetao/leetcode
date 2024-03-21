package previous.offer.digital;

import java.util.LinkedList;

/**
 * 2023/2/22
 * czetao
 * Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 **/
public class offer06 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }

    // 利用递归，走到底再输出
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null){
            stack.addLast(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] num = new int[size];

        for (int i = 0; i < size; i++) {
            num[i] = stack.removeLast();
        }
        return num;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        int[] x = reversePrint(listNode);
        for (int i = 0; i < x.length; i++) {

            System.out.println(x[i]);
        }
    }

}
