package com.flexhamp.leetcode;

//https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println("1 = " + numIslands(new char[][]{
                {'1'},
        }));
        System.out.println();
        System.out.println("0 = " + numIslands(new char[][]{
                {'0'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'0', '1', '0'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'1', '1', '0'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'0', '1', '1'},
        }));
        System.out.println();
        System.out.println("2 = " + numIslands(new char[][]{
                {'1', '0', '1'},
        }));
        System.out.println();
        System.out.println("2 = " + numIslands(new char[][]{
                {'1'},
                {'0'},
                {'1'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'1'},
                {'1'},
                {'0'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'0'},
                {'1'},
                {'1'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        }));
        System.out.println();
        System.out.println("2 = " + numIslands(new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("3 = " + numIslands(new char[][]{
                {'1', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("2 = " + numIslands(new char[][]{
                {'1', '0', '1', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("2 = " + numIslands(new char[][]{
                {'1', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'1', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'0', '0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'1', '1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'1', '0', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
        }));
        System.out.println();
        System.out.println("1 = " + numIslands(new char[][]{
                {'0', '0', '0', '0', '0', '0'},
                {'0', '1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0', '1'},
                {'0', '1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
        }));
        System.out.println();
    }


    public static int numIslands(char[][] grid) {
        int r = 0;

        for (short i = 0; i < grid.length; i++) {
            for (short j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    new Cross(i, j, grid);
                    r++;
                }
            }
        }

        return r;
    }

    static class Cross {
        Cross(short i, short j, char[][] grid) {
            grid[i][j] = '0';
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                new Cross((short) (i - 1), j, grid);
            }
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                new Cross((short) (i + 1), j, grid);
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                new Cross(i, (short) (j - 1), grid);
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                new Cross(i, (short) (j + 1), grid);
            }
        }
    }
}
