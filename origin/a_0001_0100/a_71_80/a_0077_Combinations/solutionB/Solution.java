package a_0001_0100.a_71_80.a_0077_Combinations.solutionB;

import java.util.ArrayList;
import java.util.List;

/**
 * 12.20提交
 * 执行用时：3 ms
 * 内存消耗：39.6 MB
 * 使用回溯剪枝
 *
 * 当n=4, k=4时，发现有一些树枝是没有必要去遍历的
 *            {1,  2,  3,  4}
 *       /        |       |     \
 *     取1       取2     取3     取4
 *      |        |       |       |
 *   {2,3,4}    剪枝     剪枝     剪枝
 *     |   \
 *    取2  剪枝
 *     |
 *   {3,4}
 *   [1,2]
 *     |
 *    取3
 *     |
 *    {4}
 *  [1,2,3]
 *     |
 *    取4
 *    |
 * [1,2,3,4]
 *
 * 因此，对for循环进行限制
 * 已加入tmpList的个数为：tmpList.size()
 * 剩余可加入tmpList的个数为：k-tmpList.size()
 * 因此 i<= n-(k-tmpList.size())
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        backTracking(resList, 0, n, k, new ArrayList<>());
        return resList;
    }

    private void backTracking(List<List<Integer>> resList, int startIndex, int n, int k, List<Integer> tmpList) {
        if (tmpList.size() >= k) {
            resList.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = startIndex; i <= n-(k-tmpList.size()); i++) {
            tmpList.add(i+1);
            backTracking(resList, i+1, n, k, tmpList);
            tmpList.remove(tmpList.remove(tmpList.size()-1));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4, 4));
    }
}
