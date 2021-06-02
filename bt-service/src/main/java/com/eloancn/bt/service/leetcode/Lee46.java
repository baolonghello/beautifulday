package com.eloancn.bt.service.leetcode;

import java.util.*;

/**
 * @ Description   :  Lee46
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/27$ 7:36 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/27$ 7:36 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(1));
        for(int i=0;i<10000;i++){
            System.out.println("----"+i);
            Thread.sleep(1000);
        }
    }

}
