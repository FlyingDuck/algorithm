package com.dongshujin.year2018.leetcode;

public class Code200 {

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                islands += sink(grid, i, j);
            }
        }
        return islands;
    }

    private int sink(char[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        sink(grid, i+1, j);
        sink(grid, i, j+1);
        sink(grid, i-1, j);
        sink(grid, i, j-1);
        return 1;
    }

}
