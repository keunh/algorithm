https://leetcode.com/problems/spiral-matrix-ii/description/

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int[] row = new int[]{0,1,0,-1};
        int[] col = new int[]{1,0,-1,0};

        int idx = -1;
        int r = 0, c = -1;
        int num = 1;
        while (num<=n*n) {
            idx++;
            idx %= 4;

            while (true) {
                r += row[idx];
                c += col[idx];

                if (r<0 || c<0 || r>=n || c>=n || nums[r][c]>0) {
                    r -= row[idx];
                    c -= col[idx];
                    break;
                }
                nums[r][c] = num;
                num++;
            }
        }

        return nums;
    }
}
```
