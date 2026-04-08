package com.dsa.hashmaps;

import java.util.*;

public class TwoSumHashMap {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.print("[");
        for(int i : twoSum(nums, 9)){
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
        nums = new int[]{1, 5, 3, 4, 2};
        pairsWithDiff(nums, 2).forEach(pair -> {
            System.out.print("[");
            for(int i : pair){
                System.out.print(i + "  ");
            }
            System.out.print("]  ");

        });
    }

    /*
    For each number, compute complement = target − num.
    If complement is already in the map → answer found.
    Otherwise store num → index in the map.
    One pass, O(n). The map lets you avoid the O(n²) brute-force nested loop.
    Given an array nums and a target target, return indices of two numbers such that:
    nums[i] + nums[j] = target

    Time: O(n) Space: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /*
    Find all pairs where a − b = diff.
    Rearranges to: a = b + diff.
    So for each number b, check if b + diff exists in the set.
    Store all numbers first, then scan — or do it in one pass if duplicates are handled carefully.
     */
    public  static List<int[]> pairsWithDiff(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        List<int[]> res = new ArrayList<>();
        for(int num: nums){
            if(set.contains(diff + num))
                res.add(new int[]{diff + num, num});
        }
        return res;
    }
}


