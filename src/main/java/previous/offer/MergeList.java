package previous.offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/16 10:36
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /***
     * 谁大排在谁后面。可以使用递归函数
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        //代码鲁邦性，以及递归终止条件
         if (list1 == null){
             return list2;
         }else if (list2 == null){
             return list1;
         }
         ListNode headNode = null;
         if (list1.val < list2.val){
             headNode = list1;
             headNode.next = Merge(list1.next ,list2);
         }else {
             //>=别忘记还有等于
             headNode = list2;
             headNode.next = Merge(list1,list2.next);
         }
         return headNode;
    }



}
