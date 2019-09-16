package offer;

import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/15 21:10
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /***
     * 简单：两个指针，第一个指针走k-1步，第二个开始出发。第一个到达终点时，第二个到达倒数第k个结点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k ==0){
            return null;
        }
        ListNode node = head;
        ListNode newNode = head;
        //结点的下一个要看好，以及程序的鲁棒性
        for (int i = 0 ;i<k-1;i++){
            if (node.next != null) {
                node = node.next;
            }else {
                return null;
            }
        }

        while(node.next !=null){
            newNode = newNode.next;
            node = node.next;
        }
        return newNode;

    }
}
