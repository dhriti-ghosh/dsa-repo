package com.dsa.arrays;

public class HashMap {

    public static void main(String[] args) {

        String s1 = "Dhriti";
        String s2 = "itiDhr";
        System.out.println(s1 + " and " + s2 + " are anagrams: " + isAnagram(s1, s2));

    }


    /* O(n)
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
}
