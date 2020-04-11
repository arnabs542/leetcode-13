/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Arrays;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/24
 */
public class LC_395_Longest_SubString_K_Repeat_Character {
    /*

    For each h, apply two pointer technique to find the
    longest substring with at least K repeating characters
    and the number of unique characters in substring is h.

     */
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();

        int[] counts = new int[26];

        int h, i, j, idx, max = 0, unique, noLessThanK;

        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;

            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;

                    i++;
                }

                if (unique == h && unique == noLessThanK) {
                    max = Math.max(j - i, max);
                }
            }

        }

        return max;
    }

    /*

    In each step, just find the infrequent elements (show less than k times)
    as splits since any of these infrequent elements couldn't be any part
    of the substring we want.

     */


    public int longestSubstring_2(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}