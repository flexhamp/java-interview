package com.flexhamp.leetcode;

import com.flexhamp.util.TreeNode;

import java.util.HashMap;

public class PathSumIII {
    /*
    Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

    The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).



    Example 1:


    Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
    Output: 3
    Explanation: The paths that sum to 8 are shown.
    Example 2:

    Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    Output: 3


    Constraints:

    The number of nodes in the tree is in the range [0, 1000].
    -109 <= Node.val <= 109
    -1000 <= targetSum <= 1000
     */
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Long> sum = new HashMap();
        sum.put(0L, 1L);
        return (int) helper(root, 0, targetSum, sum);
    }

    public long helper(TreeNode root, long currSum, int targetSum, HashMap<Long, Long> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        long res = preSum.getOrDefault(currSum - targetSum, 0L);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0L) + 1);

        res += helper(root.left, currSum, targetSum, preSum) + helper(root.right, currSum, targetSum, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
