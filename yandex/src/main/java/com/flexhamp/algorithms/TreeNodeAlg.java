package com.flexhamp.algorithms;

import com.flexhamp.util.TreeNode;

public class TreeNodeAlg {
    static int answer = 0;

    public static void main(String[] args) {
//        final TreeNode treeNode = new TreeNode(1, new TreeNode(4, new TreeNode(2), new TreeNode(3, new TreeNode(2))),
//                new TreeNode(7, new TreeNode(5), new TreeNode(4)));
//
//        System.out.println(maxPathSum(treeNode));


//        final TreeNode treeNode2 = new TreeNode(
//                -10,
//                new TreeNode(9),
//                new TreeNode(20,
//                        new TreeNode(-3,
//                                new TreeNode(5,
//                                        new TreeNode(-2)),
//                                new TreeNode(-4)),
//                        new TreeNode(8, new TreeNode(-2)))
//        );
//        final TreeNode treeNode2 = new TreeNode(-3);

//        final TreeNode treeNode2 = new TreeNode(2, new TreeNode(-1));

        final TreeNode treeNode2 = new TreeNode(1, new TreeNode(-2), new TreeNode(3));

        System.out.println(maxPathSum2(treeNode2));
    }

    /*
    O(n) - сложность по времени
    O(n) - сложность по памяти

    */
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftPath = maxPathSum(root.left);
        int maxRightPath = maxPathSum(root.right);
        return Math.max(maxLeftPath, maxRightPath) + root.val;
    }

    /*
    O(n) - сложность по времени
    O(n) - сложность по памяти

    */
    //    https://www.youtube.com/watch?v=R4UHOLZ-bEk
    public static int maxPathSum2(TreeNode root) {
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

//    private static int helper(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int maxLeftPath = helper(root.left);
//        int maxRightPath = helper(root.right);
//
//        final int max = Math.max(Math.max(maxLeftPath, maxRightPath), maxLeftPath + maxRightPath);
//
//        answer = Math.max(Math.max(answer, max + root.val), root.val);
//        return max + root.val;
//    }
}

