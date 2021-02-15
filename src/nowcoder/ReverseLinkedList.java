package nowcoder;

/**
 * @author lvyue
 * @since 2021/1/21
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode2 = listNode1.next;
        listNode3 = listNode2.next;

        StringBuffer stringBuffer = new StringBuffer();
        String s = null;
        ListNode aaa = null;
        ListNode listNode = listNode1;
        while (listNode.next != null) {
            stringBuffer.append(String.valueOf(listNode.val));
        }
        if (stringBuffer != null) {
            s = stringBuffer.reverse().toString();
        }
        byte[] bytes = s.getBytes();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                aaa = new ListNode(bytes[0]);
            } else {
                ListNode listNode4 = new ListNode(bytes[i]);
//                listNode4 =
            }

        }
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
