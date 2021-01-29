package com.eloancn.bt.service.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @ Description   :  ShowTwoSum 两数之和
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/1/27$ 3:16 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/1/27$ 3:16 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class ShowTwoSum {


    public static void main(String[] args) {
        System.out.println("题目一:" + JSON.toJSON(ShowTwoSum.twoSum(new int[]{2, 8, 4, 7}, 9)));

        ListNode listNodeItem1 = new ListNode(9);
        listNodeItem1.next = new ListNode(9);
        listNodeItem1.next.next = new ListNode(9);
        ListNode listNodeItem2 = new ListNode(9);
        listNodeItem2.next = new ListNode(9);
        listNodeItem2.next.next = new ListNode(9);
        ListNode res = ShowTwoSum.twoSum2(listNodeItem1, listNodeItem2);
        String resStr = "";
        while (res != null) {
            resStr += res.val;
            res = res.next;
        }
        System.out.println("题目二:" + resStr);
    }

    /*题目一：
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

        示例 ：
        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                res[0] = hm.get(nums[i]);
                res[1] = i;
                break;
            }
            hm.put(target - nums[i], i);
        }
        return res;
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    public static ListNode twoSum2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;//进位变量
        int item = 0;
        while (l1 != null || l2 != null || item != 0) {
            if (l1 != null) {
                item += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                item += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(item % 10);
            temp = temp.next;
            item = item / 10;
        }
        return res.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}