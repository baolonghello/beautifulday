package com.eloancn.bt.service.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 题目二
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Lee2Sum {

    public static void main(String[] args) {
        ListSumNode l1 = new ListSumNode(2);
        l1.next = new ListSumNode(4);
        l1.next.next = new ListSumNode(3);
        ListSumNode l2 = new ListSumNode(5);
        l2.next = new ListSumNode(6);
        l2.next.next = new ListSumNode(4);

        ListSumNode res = Lee2Sum.twoSum(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }

    public static ListSumNode twoSum(ListSumNode l1, ListSumNode l2) {
        ListSumNode res = new ListSumNode();
        ListSumNode resTemp = res;//进位变量
        int sumTemp = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sumTemp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sumTemp += l2.val;
                l2 = l2.next;
            }
            resTemp.next = new ListSumNode(sumTemp % 10);
            resTemp = resTemp.next;
            sumTemp = sumTemp / 10;
        }
        return res.next;
    }
}

class ListSumNode {
    int val;
    ListSumNode next;

    ListSumNode() {
    }

    ListSumNode(int val) {
        this.val = val;
    }

    ListSumNode(int val, ListSumNode next) {
        this.val = val;
        this.next = next;
    }
}
