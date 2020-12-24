/**
 * @author lvyue
 * @since 2020/8/31
 */
public class RedBlackTreeDemo {

    private final int R = 0;
    private final int B = 1;

    /**
     * 红黑树的根节点
     */
    private Node root = null;

    class Node {
        // 存的具体数字
        int data;
        // 插入的节点默认都是红色节点。
        int color = R;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 插入部分
     * root节点一定不为空，最开始就默认进去了。
     */
    public void insert(Node root, int data) {
        // 表示插入到右边。
        if (root.data < data) {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    public void leftRotate(Node node) {
        // 表示是根节点左旋
        if (node.parent == null) {
            Node E = root;
            Node S = E.right;

            // 第一步 移S的左子树
            E.right = S.left;
            S.left.parent = E;

            // 第二步 修改E的指针
            E.parent = S;
            // 第三步 修改S的指针
            S.parent = null;

        }
    }
}
