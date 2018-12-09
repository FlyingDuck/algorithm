package com.dongshujin.leetcode;

import java.util.*;

public class Code438 {

    public static List<Integer> findAnagrams(String s, String p) {
        if (null == s || s.length() < p.length())
            return Collections.emptyList();

        Map<Character, Integer> dict = new HashMap<>();
        for (Character ch : p.toCharArray()) {
            if (dict.containsKey(ch)) {
                int times = dict.get(ch);
                dict.put(ch, times+1);
            } else {
                dict.put(ch, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        final int len = p.length();
        final char[] chars = s.toCharArray();
        while (start+len <= s.length()) {
            int step = 0;
            Map<Character, Integer> map = new HashMap<>(dict);
            while (step < len) {
                char ch = chars[start+step];
                if (map.containsKey(ch)) {
                    int times = map.get(ch);
                    times--;
                    if (times <= 0)
                        map.remove(ch);
                    else
                        map.put(ch, times);
                    step++;
                } else {
                    if (!dict.containsKey(ch)) {
                        start = start + step + 1;
                    } else {
                        start++;
                    }
                    break;
                }
            }

            if (step == len) {
                if (map.isEmpty())
                    result.add(start);
                start++;
            }
        }

        return result;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        int[] map = new int[256];
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        List<Integer> res = new ArrayList<>();
        int j = 0;
        int len = p.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]--;
            while(map[c] < 0) {
                char c2 = s.charAt(j++);
                map[c2]++;
            }
            if (i - j + 1 == len) {
                res.add(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams2(s, p);
        for (Integer index : list) {
            System.out.print(index + " ");
        }
    }
}
