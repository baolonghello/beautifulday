package com.eloancn.bt.service.leetcode;

/**
 * @ Description   :  Lee88
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/25$ 12:40 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/25$ 12:40 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res=new int[m+n];
        int index1=0;
        int index2=0;
        for(int i=0;i<(m+n);i++){

            if (index1<m && nums1[index1]<nums2[index2]){
                res[i]=nums1[index1];
                index1++;
            }else{
                res[i]=nums2[index2];
                index2++;
            }
        }
        for(int i=0;i<m;i++){
            nums1[i]=res[i];
        }

    }

    public int myAtoi(String s) {

        char[] strs=s.toCharArray();
        int index=0;
        for(int i=0;i<s.length();i++){
            if(strs[i]==' '){
                index++;
            }else{
                break;
            }
        }
        int sign=1;
        if(strs[index] =='-'){
            sign=-1;
            index++;
        }
        if(strs[index] =='+'){
            index++;
        }
        if(index==s.length()-1){
            return 0;
        }
        int res=0;
        for(int i=index;i<s.length();i++){
            int cur=strs[i]-'0';
            if(cur>9 || cur<0){
                break;
            }
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE && cur> Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if(res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE && cur> sign*(Integer.MIN_VALUE%10))){
                return Integer.MIN_VALUE;
            }

            res=res*10+cur*sign;

        }
        return res;
    }
    public static void main(String[] args) {

        new Lee88().myAtoi(" -2147483649  a");
    }
}
