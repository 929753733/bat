/**
 * @author lvyue
 * @since 2021/2/1
 */
public class Ali {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        Node node6 = new Node(4);
        Node node7 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node node = deleteDuplication(node1);
        while (node!=null) {
            System.out.println(node.value);
            node = node.next;
        }

    }

    public static Node deleteDuplication(Node head){
        if (null == head) {
            return null;
        }
        Node p = new Node(-1);
        p.next = head;
        Node pre = p;
        Node p1 = head;
        Node p2 = head.next;

        while (null != p2) {
            if (p1.value != p2.value) {
                pre = p1;
                p1 = p2;
                p2 = p2.next;
            } else {
                while (null != p2 && p1.value == p2.value) {
                    p2 = p2.next;
                }
                pre.next = p2;
                p1 = p2;
                if (null != p2) {
                    p2 = p2.next;
                }
            }
        }
        return p.next;
    }
}



class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
