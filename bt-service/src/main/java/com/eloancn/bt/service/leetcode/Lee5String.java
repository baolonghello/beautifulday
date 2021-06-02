package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee5String
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/11$ 1:10 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/11$ 1:10 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 * <p>
 * 最大回文子串（左右对称）
 * 例如“1212134”的最长回文子串是“12121”
 * 回文字：左右对称，或者中心左右对称  如 abba  abcba
 */
public class Lee5String {

    String ans = "";
    /**
     * 中心扩散法——两种情况
     * 一种是回文子串长度为奇数（如aba，中心是b）
     * 另一种回文子串长度为偶数（如abba，中心是b，b）
     */

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(i, i, s);
            helper(i, i+1, s);
        }
        return ans;
    }


    private void helper(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        String temp = s.substring(start + 1, end);
        if(temp.length()>ans.length()){
            ans=temp;
        }
    }






//    public String longestPalindrome(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            // 回文子串长度是奇数,最中间是同一个数,所以取一个就行
//            helper(i, i, s);
//            // 回文子串长度是偶数,取两个数字
//            helper(i, i + 1, s);
//        }
//        return ans;
//    }
//    public void helper(int m, int n, String s) {
//        while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
//            m--;
//            n++;
//        }
//        // 注意此处m,n的值循环完后  是恰好不满足循环条件的时刻
//        // 此时m到n的距离为n-m+1，但是mn两个边界不能取 所以应该取m+1到n-1的区间  长度是n-m-1
//        if (n - m - 1 > ans.length()) {
//            //substring要取[m+1,n-1]这个区间
//            //end处的值不取,所以下面写的是n不是n-1
//            ans = s.substring(m + 1, n);
//        }
//    }



    public static void main(String[] args) {
        System.out.print(new Lee5String().longestPalindrome("ddabbba339"));
    }

}
