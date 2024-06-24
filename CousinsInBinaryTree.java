import java.util.LinkedList;
import java.util.Queue;

//Approach - BFS - Iterative
//Time - O(n), Space - O(n)
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        boolean xFound = false, yFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    xFound = true;
                }
                if(curr.val == y) {
                    yFound = true;
                }
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                }
            }
            if(xFound && yFound) {
                return true;
            }
            if(!xFound && yFound) {
                return false;
            }
            if(xFound && !yFound) {
                return false;
            }
        }

        return xFound && yFound;
    }
}
