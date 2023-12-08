package com.flexhamp.leetcode;

import com.flexhamp.util.TreeNode;

public class BinaryTreeMaximumPathSum {
    static int answer = 0;

    /*
    A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

    The path sum of a path is the sum of the node's values in the path.

    Given the root of a binary tree, return the maximum path sum of any non-empty path.



    Example 1:


    Input: root = [1,2,3]
    Output: 6
    Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
    Example 2:


    Input: root = [-10,9,20,null,null,15,7]
    Output: 42
    Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


    Constraints:

    The number of nodes in the tree is in the range [1, 3 * 104].
    -1000 <= Node.val <= 1000
     */
    public static void main(String[] args) {
//        final TreeNode treeNode = new TreeNode(
//                -10,
//                new TreeNode(9),
//                new TreeNode(20,
//                        new TreeNode(-3,
//                                new TreeNode(5,
//                                        new TreeNode(-2)),
//                                new TreeNode(-4)),
//                        new TreeNode(8, new TreeNode(-2)))
//        );
//        final TreeNode treeNode = new TreeNode(-3);

//        final TreeNode treeNode = new TreeNode(2, new TreeNode(-1));

        final TreeNode treeNode = new TreeNode(1, new TreeNode(-2), new TreeNode(3));

        System.out.println(maxPathSum(treeNode));
    }

    public static int maxPathSum(TreeNode root) {
        answer = -1000;
        helper(root);
        return answer;
    }

    private static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftPath = Math.max(helper(root.left), 0);
        int maxRightPath = Math.max(helper(root.right), 0);
        answer = Math.max(answer, maxLeftPath + maxRightPath + root.val);
        return Math.max(maxLeftPath, maxRightPath) + root.val;
    }
}
