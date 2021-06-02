package com.eloancn.bt.service.leetcode;

import java.util.*;

/**
 * @ Description   :  Lee102
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/27$ 2:45 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/27$ 2:45 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class Lee102 {
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {

            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode item = queue.pop();
                level.add(item.val);
                if (item.left != null) {
                    queue.add(item.left);
                }
                if (item.right != null) {
                    queue.add(item.right);
                }
            }
            res.add(level);
        }

        return res;

    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
