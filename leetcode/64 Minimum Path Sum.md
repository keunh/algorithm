64. Minimum Path Sum

https://leetcode.com/problems/minimum-path-sum/

DP 힌트 확이 후 풂..
```java
class Solution {
    private int[] x = {1, 0};
    private int[] y = {0, 1};
    
    public int minPathSum(int[][] grid) {
        
        for(int i=grid.length-1 ; i>=0 ; i--) {
            for (int j=grid[0].length-1 ; j>=0 ; j--) {

                int tmp = Integer.MAX_VALUE;

                for (int n=0 ; n<2 ; n++) {
                    int tmpY = i+y[n];
                    int tmpX = j+x[n];
                    if (tmpX<0 || tmpX>=grid[0].length || tmpY<0 || tmpY>=grid.length) {
                        continue;
                    }
                    tmp = Math.min(tmp, grid[tmpY][tmpX]);
                }

                if (tmp != Integer.MAX_VALUE) {
                    grid[i][j] += tmp;
                }
            }
        }
        
        return grid[0][0];
    }
}
```
