package com.dsa.hashmaps;

import java.util.*;

public class FrequencyCountHashMap {

    public static void main(String[] args) {

        String s1 = "Dhriti";
        String s2 = "itiDhr";
        System.out.println(s1 + " and " + s2 + " are anagrams: " + isAnagram(s1, s2));

        int[] arr = {1, 1, 1, 2, 2, 3};
        int[] topK = toKFrequent(arr, 2);
        System.out.println(Arrays.toString(topK));

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs).forEach(
                group -> {
                    System.out.println("[");
                    group.forEach(System.out::println);
                    System.out.println("]");
                }
        );

    }


    /* Time O(n) Space O(1)
     Valid Anagram — core idea
     Count character frequencies in both strings.
     If every character count matches, they're anagrams.
     One HashMap, one pass for each string — O(n) time, O(1) space (26 lowercase letters at most).
     */
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char c : s1.toLowerCase().toCharArray()) freq[c - 'a']++;
        for (char c : s2.toLowerCase().toCharArray()) freq[c - 'a']--;
        for (int i : freq) if (i != 0) return false;
        return true;
    }

    /*
    Top K Frequent Elements — core idea
    Step 1: count frequencies with a HashMap.
    Step 2: use a min-heap of size K — if heap grows beyond K, evict the minimum.
    Result: the K survivors are the most frequent. O(n log k) —
    much better than sorting at O(n log n) when k is small.

    Time O(n log k)
    Space O(n + k)
    Vs normal Sort O(n log n)
     */

    public static int[] toKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new java.util.HashMap<>();
        //V merge(K key, V value, BiFunction<V, V, V> remappingFunction)
        //merge() combines an existing value with a new value using a function.
        for (int num : nums) freq.merge(num, 1, Integer::sum);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(freq::get));
        for (int num : freq.keySet()) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.stream().mapToInt(i -> i).toArray();
    }

    /*
    Time O(n·k log k) Space O(n·k)
    Group Anagrams — core idea
    Anagrams share the same sorted characters.
    Use sorted(word) as a HashMap key.
    All words mapping to the same key belong together.
    O(n · k log k) where k = max word length. No comparisons between words needed.
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new java.util.HashMap<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }


}
