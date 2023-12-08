package com.flexhamp.leetcode;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
//        Node node = GraphBuilder.build(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
//        System.out.println(node);
//        Node cloned = cloneGraph2(node);
//        System.out.println(node != cloned);
    }

    static Map<Integer, Node> nodes1 = new HashMap<>();
    static Map<Node, Node> nodes2 = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (!nodes1.containsKey(node.val)) {
            nodes1.put(node.val, new Node(node.val));
        }
        Node curr = nodes1.get(node.val);
        for (Node neighb : node.neighbors) {
            if (!nodes1.containsKey(neighb.val)) {
                cloneGraph(neighb);
            }
            curr.neighbors.add(nodes1.get(neighb.val));
        }
        return nodes1.get(1);
    }




    public static Node cloneGraph2(Node node) {
        if (node == null) return null;

        if (nodes2.containsKey(node)) {
            return nodes2.get(node);
        }

        Node copy = new Node(node.val);
        nodes2.put(node, copy);

        for (Node n : node.neighbors) {
            copy.neighbors.add(cloneGraph2(n));
        }
        return copy;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
