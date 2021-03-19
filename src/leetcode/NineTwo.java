package leetcode;

import java.util.List;

/**
 * 92. 反转链表 II
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @author lvyue
 * @since 2021/3/18
 */
public class NineTwo {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode aaa = reverseBetween(node1, 2, 4);
        while (null != aaa) {
            System.out.println(aaa.val);
            aaa = aaa.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 添加一个虚拟节点，指向head。
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode succ = dummyNode;
        ListNode a = dummyNode;
        ListNode b = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < right; i++) {
            b = b.next;
        }
        a = pre.next;
        succ = b.next;

        pre.next = null;
        b.next = null;

        ListNode reverseList = reverse(a);

        pre.next = b;
        a.next = succ;

        return dummyNode.next;
    }

    public static ListNode reverse(ListNode head) {
        if (null != head && null == head.next) {
            return head;
        } else if (null != head && null != head.next) {
            ListNode lastNode = head;
            ListNode node = head.next;
            head.next = null;
            while (node != null ) {
                ListNode nextNode = node.next;
                node.next = lastNode;
                lastNode = node;
                node = nextNode;
            }
            return lastNode;
        } else {
            return null;
        }
    }

}
