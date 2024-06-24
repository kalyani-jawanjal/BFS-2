import java.util.ArrayList;
import java.util.List;

//Time - O(n), SPace - O(h), Approach - DFS- Recursive
public class BinaryTreeRightSideView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level) {
        if(root == null) return;

        if(level == result.size()) {
            result.add(root.val);
        }

        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
