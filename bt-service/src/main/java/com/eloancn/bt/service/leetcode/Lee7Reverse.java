package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee7Reverse
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/11$ 3:51 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/11$ 3:51 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee7Reverse {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10 ) {
                return 0;
            }
            int temp = x % 10;
            x = x / 10;
            res = res * 10 + temp;
        }
        return res;
    }



    public static void main(String[] args) {
        //System.out.print(new Lee7Reverse().reverse(-1234567));

        char a='3';
        if(a<='9' && a>='0'){
            System.out.println("数字："+(a-'1'));

        }else{
            System.out.println("字母");
        }
    }

}
