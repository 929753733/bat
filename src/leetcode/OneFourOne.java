package leetcode;

/**
 * 141. 环形链表
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * @author lvyue
 * @since 2021/3/18
 */
public class OneFourOne {

    class ListNode141 {
        int val;
        ListNode141 next;

        ListNode141(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 本题思路：我们可以根据上述思路来解决本题。具体地，我们定义两个指针，一快一满。
     * 慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，而快指针在位置 head.next。
     * 这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。否则快指针将到达链表尾部，该链表不为环形链表。
     * <p>
     * 扩展：如果存在环，如何判断环的长度呢？方法是，快慢指针相遇后继续移动，直到第二次相遇，两次相遇间的移动次数即为环的长度。
     */
    public boolean hasCycle(ListNode141 head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode141 slow = head;
        ListNode141 fast = head.next;
        while (slow != fast) {
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;


    }

}


