package com.eloancn.bt.service.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;


/*题目一：
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

        示例 ：
        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    */
public class Lee1Sum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] res = Lee1Sum.twoSum(nums, target);

        System.out.println("nums:" + JSON.toJSONString(nums) + " target:" + target);
        System.out.println("res:" + JSON.toJSONString(res));

    }

    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];

        HashMap<Integer, Integer> tempHM = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tempHM.containsKey(nums[i])) {
                res[0] = tempHM.get(nums[i]);
                res[1] = i;
                break;
            }
            tempHM.put(target - nums[i], i);
        }
        return res;
    }
}
