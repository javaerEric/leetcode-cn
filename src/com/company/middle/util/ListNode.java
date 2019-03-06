package com.company.middle.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Deprecated
    public void add(int x) {
        ListNode tail = this;
        while (null != tail.next) {
            tail = tail.next;
        }
        tail.next = new ListNode(x);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode tail = next;
        while (null != tail) {
            sb.append("->");
            sb.append(tail.val);
            tail = tail.next;
        }
        return sb.toString();
    }
}