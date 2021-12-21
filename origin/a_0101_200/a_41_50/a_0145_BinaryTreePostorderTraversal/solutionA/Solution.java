package a_0101_200.a_41_50.a_0145_BinaryTreePostorderTraversal.solutionA;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 12.21提交
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.3 MB, 在所有 Java 提交中击败了95.43%的用户
 * 通过测试用例：68 / 68
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        traversal(postorderList, root);
        return postorderList;
    }

    private void traversal(List<Integer> postorderList, TreeNode root) {
        if (Objects.isNull(root)){
            return;
        }
        traversal(postorderList, root.left);
        traversal(postorderList, root.right);
        postorderList.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        Solution s = new Solution();
        System.out.println(s.postorderTraversal(a));
    }
}
