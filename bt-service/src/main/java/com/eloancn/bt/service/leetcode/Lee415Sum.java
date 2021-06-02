package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee415Sum
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/20$ 12:32 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/20$ 12:32 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee415Sum {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();

    }

    public static void main(String[] args) {
        char i='9';
        char j='7';
        int a=i-j;
        System.out.println(i-j);
        //new Lee415Sum().addStrings("99","9");
    }
}
