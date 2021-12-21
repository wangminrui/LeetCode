package a_0101_200.a_41_50.a_0144_BinaryTreePreorderTraversal.solutionA;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * 12.21提交
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了34.06%的用户
 * 通过测试用例：69 / 69
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        traversal(root, preorderList);
        return preorderList;
    }

    private void traversal(TreeNode root, List<Integer> preorderList) {
        if (Objects.isNull(root)) {
            return;
        }
        preorderList.add(root.val);
        traversal(root.left, preorderList);
        traversal(root.right, preorderList);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        Solution s = new Solution();
        System.out.println(s.preorderTraversal(a));
    }
}
