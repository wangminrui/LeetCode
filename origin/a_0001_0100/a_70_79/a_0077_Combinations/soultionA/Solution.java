package a_70_79.a_0077_Combinations.soultionA;

import java.util.ArrayList;
import java.util.List;

/**
 * 12.18提交
 * 执行用时：58 ms
 * 内存消耗：39.6 MB
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
        for (int i = startIndex; i < n; i++) {
            tmpList.add(i+1);
            backTracking(resList, i+1, n, k, tmpList);
            tmpList.remove(tmpList.remove(tmpList.size()-1));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4, 2));
    }
}
