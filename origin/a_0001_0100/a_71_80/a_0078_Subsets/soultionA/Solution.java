package a_0001_0100.a_71_80.a_0078_Subsets.soultionA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 12.17提交
 * 执行用时: 2 ms
 * 内存消耗: 38.7 MB
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        resList.add(new ArrayList<>());
        backTracking(resList, new ArrayList<>(), numList);
        return resList;
    }

    private void backTracking(List<List<Integer>> resList, List<Integer> traversedList, List<Integer> remainList) {
        if (remainList.size() == 0) {
            return;
        }
        for (int i = 0; i < remainList.size(); i++) {
            traversedList.add(remainList.get(i));
            resList.add(new ArrayList<>(traversedList));
            backTracking(resList, traversedList, remainList.subList(Math.min(i+1, remainList.size()), remainList.size()));
            traversedList.remove(remainList.get(i));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution s = new Solution();
        System.out.println(s.subsets(nums));
    }
}
