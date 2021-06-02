package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee9HW
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/11$ 6:25 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/11$ 6:25 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee9HW {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 &&x!=0)) {
            return false;
        }

        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }

        if (x == temp || x == temp / 10) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.print(new Lee9HW().isPalindrome(0));
        String a="ab";
        System.out.println(a.charAt(1));
    }
}
