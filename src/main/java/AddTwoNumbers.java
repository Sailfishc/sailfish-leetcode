/**
 * https://leetcode.com/problems/add-two-numbers/description/ Medium
 *
 * https://leetcode-cn.com/problems/add-two-numbers/solution/
 *
 * @author sailfish
 * @create 2018-06-21-下午2:06
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list. You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // 获取链表的值
//        // 记录链表的值
//        // 针对值相加
//        StringBuilder leftSb = new StringBuilder();
//        while (l1.next != null) {
//            int val = l1.val;
//            leftSb.append(val);
//        }
//
//        StringBuilder rightSb = new StringBuilder();
//        while (l2.next != null) {
//            int val = l2.val;
//            rightSb.append(val);
//        }
//
//        int space = leftSb.length() - rightSb.length();
//        if (space > 0) {
//            rightSb.append(0);
//        } else {
//            leftSb.append(0);
//        }
//
//        int leftVal = Integer.parseInt(leftSb.reverse().toString());
//        int rightVal = Integer.parseInt(rightSb.reverse().toString());
//
//        int sum = leftVal + rightVal;
//        String strSum = "" + sum;
////        int reverseSum = Integer.parseInt()
//        while (sum > 0) {
//            int i = sum / 10;
//
//        }
//        return null;
//    }


    /**
     * 整个链表yinggaishi
     * 0 -> node1 -> node2 -> node3
     * 然后返回的链表元素从第二个元素开始
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个哑结点
        ListNode headNode = new ListNode(0);
        ListNode p = l1, q = l2, cur = headNode;
        int carry = 0;
        // 如果p或者q其中有一个不为空，那么就执行
        while (p != null || q != null) {
            // 如果其中有一个链表的元素为null了，那么赋值为0
            int x = (p != null ? p.val : 0);
            int y = (q != null ? q.val : 0);
            int sum = x + y + carry;
            // 表示进位
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        // 构造链表
        ListNode l1Node1 = new ListNode(2);
        ListNode l1Node2 = new ListNode(4);
        ListNode l1Node3 = new ListNode(3);
        ListNode l2Node1 = new ListNode(5);
        ListNode l2Node2 = new ListNode(6);
        ListNode l2Node3 = new ListNode(4);

        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;

        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;

        ListNode listNode = addTwoNumbers(l1Node1, l2Node1);
        while (listNode != null) {
            int val = listNode.val;
            System.out.println(val);
            listNode = listNode.next;
        }

    }

}
