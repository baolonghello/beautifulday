package com.eloancn.bt.service.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ Description   :  CheckSubString
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/1/28$ 11:38 上午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/1/28$ 11:38 上午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class CheckSubString {


    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println("res=" + CheckSubString.lengthOfLongestSubstring2(s));
    }

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
    public static int lengthOfLongestSubstring(String s) {

        Set<String> ss = new HashSet();
        int start = 0; //保存起始位置
        int max = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            i = Math.max(start, i);
            String temp = s.substring(i, i + 1);
            if (ss.add(temp)) {
                max++;
                res = Math.max(res, max);
            } else {
                start++;
                max = 0;
                i = 0;
                ss = new HashSet();
            }
            if (start >= s.length()) {
                break;
            }
        }
        return res;
    }

    //解法2
    public static int lengthOfLongestSubstring2(String s) {

        int[] last = new int[128];// 记录字符上一次出现的位置
        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);//字母转化为阿斯克码,作为数组下标
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            System.out.println("i=" + i + ",start=" + start + ",res=" + res + ",last[" + index + "]=" + last[index]);
            last[index] = i + 1;
        }
        return res;
    }

}
