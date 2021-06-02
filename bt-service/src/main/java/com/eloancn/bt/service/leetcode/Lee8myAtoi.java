package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee8myAtoi
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/11$ 5:21 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/11$ 5:21 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee8myAtoi {

    public int myAtoi(String str) {
        int res = 0;//最终结果
        int index = 0;//指针；
        char[] chars = str.toCharArray();

        //1.去除前面空格
        if(str==null || str.length()==0){
            return 0;
        }
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }
        if (index == chars.length) {
            return 0;
        }
        //2.正负判断
        int sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        }else if(chars[index] == '+'){
            index++;
        }


        //3.取值
        while (index < chars.length) {

            char temp = chars[index];

            if (temp >= '0' && temp <= '9') {
                if (res < Integer.MIN_VALUE / 10 ||(res == Integer.MIN_VALUE / 10 && (temp-'0')> -(Integer.MIN_VALUE%10)))
                    return Integer.MIN_VALUE;
                if (res > Integer.MAX_VALUE / 10 ||(res == Integer.MAX_VALUE / 10 && (temp-'0')>Integer.MAX_VALUE%10))
                    return Integer.MAX_VALUE;
                res = res * 10 + (temp - '0') * sign;
            }else{
                return  res;
            }
            index++;
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.print(new Lee8myAtoi().myAtoi("2147483648"));
    }

}
