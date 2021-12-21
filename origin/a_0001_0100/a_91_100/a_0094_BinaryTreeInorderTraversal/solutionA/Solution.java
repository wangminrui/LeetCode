package a_0001_0100.a_91_100.a_0094_BinaryTreeInorderTraversal.solutionA;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 12.21提交
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了27.03%的用户
 * 通过测试用例：70 / 70
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        traversal(inorderList, root);
        return inorderList;
    }

    private void traversal(List<Integer> inorderList, TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        traversal(inorderList, root.left);
        inorderList.add(root.val);
        traversal(inorderList, root.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        Solution s = new Solution();
        System.out.println(s.inorderTraversal(a));
    }
}
