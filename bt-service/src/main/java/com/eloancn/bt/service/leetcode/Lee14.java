package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee14
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/18$ 2:40 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/18$ 2:40 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String res = strs[0];

        for (int j = 1; j < strs.length; j++) {
            String temp = strs[j];
            while (res.length() > 0) {
                if (temp.length() < res.length() || !temp.substring(0, res.length()).equals(res)) {
                    res = res.substring(0, res.length() - 1);
                    continue;
                }
                break;
            }
            if (res.length() == 0) {
                return "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] root = new String[]{"flower", "flow", "flight"};
        System.out.print(new Lee14().longestCommonPrefix(root));
    }


}
