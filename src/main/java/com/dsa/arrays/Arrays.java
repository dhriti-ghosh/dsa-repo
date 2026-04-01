package com.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};

        System.out.println("sum of any subarray in O(1): " + sumSubArrayO1(arr, 2, 4));

        int[] nums = {2, 5, 8, 12, 16, 23, 38, 56, 100};
        int target = 23;
        System.out.println("Binary Search: " + binarySearch(nums, target));

        nums = new int[]{1, 3, 3, 5, 7};
        target = 6;
        System.out.println("Lower Bound: " + lower_bound(nums, target));

        nums = new int[]{1, 3, 3, 5, 7};
        target = 3;
        System.out.println("Upper Bound: " + upper_bound(nums, target));

        nums = new int[]{4, 5, 6, 7, 1, 2, 3};
        target = 7;
        System.out.println("Rotated Array binary Search: " + binarySearchRotatedArray(nums, target));

        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println("Koko eating bananas - min speed: " + minimumEatingSpeed(piles, h));

        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println("Container With Most Water: " + maxArea(heights));

        nums = new  int[]{-2, -1, 0, 0, 1, 2};
        System.out.println("Three sums == 0: " + threeSum(nums));

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped rain water - Brute Force O(n^2): " + rainWaterBruteForce(height));
        System.out.println("Trapped rain water - Prefix Array O(n): " + rainWaterPrefixArray(height));
        System.out.println("Trapped rain water - Two pointers O(n): " + rainWaterTwoPointers(height));

        nums = new  int[]{30,11,23,4,20};
        int k = 3;
        System.out.println("Max avg - sliding window: " + findMaxAvg(nums, k));
    }



    // O(1)
    public static int sumSubArrayO1(int[] nums, int l, int r) {

        // Given: nums = [3, 1, 4, 1, 5, 9, 2, 6]
        // Problem: find sum of any subarray in O(1)

        // Build prefix sum array

        int[] prefix = new int[nums.length+1];
        prefix[0] = 0;
        for(int i=0; i<nums.length; i++){
            prefix[i+1] = nums[i]+prefix[i];
        }

        return prefix[r+1]-prefix[l];
    }


    // O(log n)
    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }

    public static int lower_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] < target)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }

    public static int upper_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] <= target)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }

    /*
    Rotated array
    Original sorted:  [1, 2, 3, 4, 5, 6, 7]

    Rotate by 3:      [4, 5, 6, 7, 1, 2, 3]
                        ↑           ↑
                        right part  left part
                        came first  came after
     */

    public static int binarySearchRotatedArray(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            } else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else
                    right = mid-1;
            }
        }
        return -1;
    }

    /*
    https://leetcode.com/problems/koko-eating-bananas/description/
    Koko Eating Bananas
    Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
    Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    Return the minimum integer k such that she can eat all the bananas within h hours.

    Example 1:
    Input: piles = [3,6,7,11], h = 8
    Output: 4
    Example 2:
    Input: piles = [30,11,23,4,20], h = 5
    Output: 30
    Example 3:
    Input: piles = [30,11,23,4,20], h = 6
    Output: 23

    Constraints:
    1 <= piles.length <= 104
    piles.length <= h <= 109
    1 <= piles[i] <= 109
     */

    public static int minimumEatingSpeed(int[] piles, int h){
        int left = 0, right = java.util.Arrays.stream(piles).max().getAsInt();
        while(left<right){
            int mid = left+(right-left)/2;
            if(canFinish(piles, mid, h))
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }


    public static boolean canFinish(int[] piles, int speed, int h){
        int hours = 0;
        for(int pile:piles){
            hours += (pile+speed-1)/speed;
        }
        return hours <= h;
    }

    /*
    https://leetcode.com/problems/container-with-most-water/description/
    Container With Most Water
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    Example 2:
    Input: height = [1,1]
    Output: 1
    Constraints:
    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
     */

    public static int maxArea(int[] height){
        int left = 0, right = height.length-1;
        int maxWater = 0;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int w = right-left;
            maxWater = Math.max(maxWater, h*w);
            if(height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxWater;
    }

    /*
    Understand 2Sum in sorted array = Find pair summing to target in sorted array
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) { found  }
        else if (sum < target) left++;
            else right--;
            }
    3Sum = fix one element + run 2Sum on the rest
    Given an array of integers, find all unique triplets [a, b, c] such that:
    a + b + c = 0
     */
    public static List<List<Integer>> threeSum(int[] nums){
        java.util.Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i] > 0)
                break;
            int left = i+1, right = nums.length-1;
            int target = -nums[i];
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum == target){
                    result.add(java.util.Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if(sum > target){
                    right--;
                } else {
                    left++;
                }

            }
        }
        return  result;
    }

    /*
    https://leetcode.com/problems/trapping-rain-water/description/
    Trapping Rain Water
    Given n non-negative integers representing an elevation map
    where the width of each bar is 1, compute how much water it can trap after raining.
    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9
     */

    public static int rainWaterBruteForce(int[] height){
        int water = 0;
        for(int i=1; i<height.length-1; i++){
            int maxLeft=0, maxRight=0;
            for(int j=0; j<i; j++)
                maxLeft = Math.max(maxLeft, height[j]);
            for(int j=i+1; j< height.length; j++)
                maxRight = Math.max(maxRight, height[j]);
            int trapped = Math.min(maxLeft, maxRight) - height[i];
            if (trapped > 0) water += trapped;
        }
        return water;
    }

    public static int rainWaterPrefixArray(int[] height){
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for(int i=1; i<height.length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        maxRight[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }

        int water = 0;
        for(int i=0; i<n-1; i++){
            water += Math.min(maxLeft[i], maxRight[i])-height[i];
        }
        return water;
    }

    public static int rainWaterTwoPointers(int[] height){
        int left=0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int water = 0;
        while(left<right){
            if(height[left] < height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }else{
                    water += maxLeft-height[left];
                }
                left++;
            }else {
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }else {
                    water += maxRight-height[right];
                }
                right--;
            }
        }
        return water;
    }

    /*
    Sliding Window — From Scratch
    A window is a contiguous subarray. You maintain it by:
    - **Expanding right:** always safe (add element to window)
    - **Shrinking left:** when window violates a condition
    ```
    Array:  [a, b, c, d, e, f, g]
             ^left          ^right

    Window grows right →→→
    Window shrinks ←← left when invalid
     */

    public static double findMaxAvg(int[] nums, int k){
        double windowSum = 0;
        for(int i=0; i<k; i++){
            windowSum += nums[i];
        }
        double maxSum = windowSum;
        for(int right=k; right<nums.length; right++){
            windowSum += nums[right];
            windowSum -= nums[right-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum/k;
    }

    /*
    Variable window
     // Template — memorise this structure
    int left = 0;
    // windowState tracks what's inside the window (map, count, sum etc.)

    for (int right = 0; right < n; right++) {
        // 1. Add nums[right] to window
        addToWindow(nums[right]);

        // 2. Shrink while invalid
        while (windowIsInvalid()) {
            removeFromWindow(nums[left]);
            left++;
        }

        // 3. Window is now valid — update answer
        updateAnswer(right - left + 1);
    }

    Minimum Window Substring
    s = "ADOBECODEBANC"
    t = "ABC"
    Find the SMALLEST window (substring) in s that contains
    ALL characters of t (including duplicates).
    Answer: "BANC"
    Order does NOT matter. "BANC" contains B, A, N, C — the A, B, C are all there even though not in order.
     */

    public static String getMinimumWindow(String str, String target){



        return "";
    }

    /*
    Max Sliding window
    Given an array nums and a sliding window of size k, return the maximum value in the window at each step as it moves from left to right. •
    nums = [1,3,-1,-3,5,3,6,7], k = 3 •
    Target Output: [3,3,5,5,6,7]
     */
//    public static int[] getMaximumWindow(int[] nums, int target){
//        int n = nums.length;
//        int[] result = new int[n-target+1];
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//
//        }
//
//    }


}
