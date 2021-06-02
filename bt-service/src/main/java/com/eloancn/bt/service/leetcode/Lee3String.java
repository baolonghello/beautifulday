package com.eloancn.bt.service.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例1：
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例2：
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Lee3String {

    //解法一
    public static int lengthOfLongestSubstring(String s) {

        HashSet<String> baseSet = new HashSet<String>();
        int res = 0;
        int start = 0;
        int stepmax = 0;
        for (int i = 0; i < s.length(); i++) {
            i = Math.max(i, start);
            String item = s.substring(i, i + 1);
            if (baseSet.add(item)) {
                stepmax++;
                res = Math.max(res, stepmax);
            } else {
                baseSet = new HashSet<String>();
                i = 0;
                start++;
                stepmax = 0;
            }
            if (start >= s.length()) {
                break;
            }
        }
        return res;
    }

    //解法二
    public static int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int start = 0, maxLen = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put(s.charAt(0) + "", 0);

        for (int i = 1; i < s.length(); i++) {

            String item = s.charAt(i) + "";

            if (map.get(item) != null
                    && map.get(item) >= start
                    && map.get(item) < i) {

                start = map.get(item) + 1;//更新位置
                map.remove(item, i);//移除此键值对,下次就不会再找到重复的
            }

            //不管i之前是不是存在key相等的index,都要加上当前的键值对
            map.put(item, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }


    public static void main(String[] args) {

        System.out.println(Lee3String.lengthOfLongestSubstring2("abcabcdbb"));

        System.out.println("abcabcbb".charAt(0));

    }
}
