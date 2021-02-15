package leetcode;

import java.util.Arrays;

/**
 * @author lvyue
 * @since 2021/1/23
 */
public class TwentyOne {

    public static void main(String[] args) {

    }

    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        ListNode21 listNode = new ListNode21(0);
        ListNode21 listNode1 = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        if (l1 == null && l2 != null) {
            listNode.next = l2;
        }
        if (l1 != null && l2 == null) {
            listNode.next = l1;
        }
        return listNode1.next;
    }

    public ListNode21 mergeTwoLists2(ListNode21 l1, ListNode21 l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}

class ListNode21 {
    int val;
    ListNode21 next;

    ListNode21() {
    }

    ListNode21(int val) {
        this.val = val;
    }

    ListNode21(int val, ListNode21 next) {
        this.val = val;
        this.next = next;
    }
}
