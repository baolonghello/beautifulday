package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee8
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/6/2$ 7:17 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/6/2$ 7:17 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee8 {

    public int myAtoi(String s) {

        int res = 0;
        int sign = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                index++;
                continue;
            }
            if (s.charAt(i) == '-') {
                sign = -1;
                index++;
                break;
            }
            if (s.charAt(i) == '+') {
                index++;
                break;
            }
        }
        for (int i = index; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            if (temp > 9 || temp < 0) {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp * sign > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp * sign < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + temp * sign;

        }
        return res;
    }

    public static void main(String[] args) {
       // System.out.print(new Lee8().myAtoi("4199 aa"));

        int i=8;
        System.out.println(i>>1);
        System.out.println(i>>1);
        System.out.println(5%4);

    }
}
