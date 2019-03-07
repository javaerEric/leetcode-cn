package com.company.middle;

import com.company.middle.util.ListNode;

/**
 * 第2题：
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author : duozl
 * @date : 2019/3/6 14:24
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;

        int up = 0;
        while (null != l1 || null != l2) {
            int val;
            if (null != l1 && null != l2) {
                val = l1.val + l2.val + up;
                l1 = l1.next;
                l2 = l2.next;
            } else if (null != l1) {
                val = l1.val + up;
                l1 = l1.next;
            } else {
                val = l2.val + up;
                l2 = l2.next;
            }
            up = val / 10;
            if (null == current) {
                result = new ListNode(val % 10);
                current = result;
            } else {
                current.next = new ListNode(val % 10);
                current = current.next;
            }
        }

        if (up > 0) {
            current.next = new ListNode(up);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.add(4);
        listNode1.add(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.add(6);
        listNode2.add(4);

        System.out.println("list1:" + listNode1.toString());
        System.out.println("list2:" + listNode2.toString());

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        System.out.println("listNode:" + listNode.toString());
    }
}
