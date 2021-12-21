package a_0201_0300.a_11_20.a_0216_CombinationSum3.solutionA;

import java.util.ArrayList;
import java.util.List;

/**
 * 12.20提交
 * 执行用时：1 ms, 在所有Java提交中击败了18.13%的用户
 * 内存消耗：35.7 MB, 在所有Java提交中击败了83.42%的用户
 * 通过测试用例：18/18
 *
 * 回溯问题优先思考构造树结构
 * 此问题树结构根集合即1-9的集合，深度为k
 * 终止条件为tmpList集合元素和等于n
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resList = new ArrayList<>();
        backTracking(resList, n, k, 0, new ArrayList<>());
        return resList;
    }

    private void backTracking(List<List<Integer>> resList, int n, int k, int depth, List<Integer> tmpList) {
        int tmpSum = getSum(tmpList);
        if (tmpList.size() == k) {
            if (tmpSum == n) {
                resList.add(new ArrayList<>(tmpList));
            }
            return;
        }
        // 剪枝
        for (int i = depth+1; i <= Math.min(n-tmpSum, 9); i++) {
            tmpList.add(i);
            backTracking(resList, n, k, i, tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }

    private int getSum(List<Integer> tmpList) {
        int sum = 0;
        for (int i : tmpList) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum3(2, 18));
    }
}
