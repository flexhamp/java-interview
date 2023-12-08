package com.flexhamp.leetcode;

import com.flexhamp.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://aaronice.gitbook.io/lintcode/trees/path-sum-ii
public class PathSumII {
    static List<List<Integer>> list = new ArrayList();

    public static void main(String[] args) {
//        final TreeNode treeNode = new TreeNode(5,
//                new TreeNode(4,
//                        new TreeNode(11,
//                                new TreeNode(7),
//                                new TreeNode(2))),
//                new TreeNode(8,
//                        new TreeNode(13),
//                        new TreeNode(4,
//                                new TreeNode(5),
//                                new TreeNode(1))));
//        int target = 22;

        final TreeNode treeNode = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(1)),
                        new TreeNode(2,
                                new TreeNode(-1),
                                new TreeNode(0))),
                new TreeNode(1,
                        new TreeNode(0,
                                new TreeNode(-1),
                                new TreeNode(0)),
                        new TreeNode(-1,
                                new TreeNode(1),
                                new TreeNode(0))));
        int target = 2;

        System.out.println(pathSum(treeNode, target));
    }

    //Simplify Helper Function
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        return list;
    }

    //Simplify Helper Function
    private static void helper(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            list.add(new ArrayList<>(path));
        } else {
            helper(root.left, targetSum - root.val, path);
            helper(root.right, targetSum - root.val, path);
        }

        path.remove(path.size() - 1);
    }





}
