package nowcoder;

import java.util.ArrayList;

/**
 * @author lvyue
 * @since 2021/2/2
 */
public class Fifty {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (null == root || "#".equals(root.val)) {
            return returnList;
        } else {
            ArrayList<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            returnList = aaa(nodeList, list);
            return returnList;
        }
    }

    public static ArrayList<ArrayList<Integer>> aaa(ArrayList<TreeNode> nodeList, ArrayList<ArrayList<Integer>> list) {
        if (nodeList.size() > 0) {
            ArrayList<Integer> valList = new ArrayList<>();
            ArrayList<TreeNode> newNodeList = new ArrayList<>();
           for (int i = 0; i < nodeList.size(); i++) {
               TreeNode treeNode = nodeList.get(i);
               int nodeVal = treeNode.val;
               valList.add(nodeVal);

               if (null != treeNode.left) {
                   if (!"#".equals(treeNode.left.val)) {
                       newNodeList.add(treeNode.left);
                   }
               }
               if (null != treeNode.right) {
                   if (!"#".equals(treeNode.right.val)) {
                       newNodeList.add(treeNode.right);
                   }
               }
           }
           list.add(valList);

           if (newNodeList.size() > 0) {
               aaa(newNodeList, list);
           }
           return list;
        } else {
            return list;
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
