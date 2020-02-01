package samples.problems;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class BFSAdjacentValues {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int minimumHours(int rows, int columns, List<List<Integer>> grid)
    {
        // WRITE YOUR CODE HERE
        int[][] newGrid = convertListGrid(rows, columns,grid);

        return minHours(newGrid);
    }
    // METHOD SIGNATURE ENDS

    private int[][] convertListGrid(int rows, int columns, List<List<Integer>> grid) {
        int row = 0;
        int[][] result = new int[rows][columns];
        for (List<Integer> g : grid){
            int column = 0;
            for(Integer j : g){
                result[row][column] = j;
                column++;
            }
            row++;
        }

        return result;
    }

    private int minHours(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int target = grid.length * grid[0].length;
        int count = 0, result = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[] {i,j});
                    count++;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(count == target)
                return result;
            for(int i=0;i<size;i++) {
                int[] cur = queue.poll();
                for(int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 0) {
                        count++;
                        queue.offer(new int[] {ni, nj});
                        grid[ni][nj] = 1;
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
