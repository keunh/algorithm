54. Spiral Matrix

https://leetcode.com/problems/spiral-matrix/

```java
class Solution {
    
    private int[] x = {1,0,-1,0};
    private int[] y = {0,1,0,-1};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int xLength = matrix[0].length;
        int yLength = matrix.length;
        int xx = 0, yy = 0;
        int index = 0, beforeIndex = 0;
        
        result.add(matrix[yy][xx]);
        matrix[yy][xx] = 101;
        
        while(true) {
            while(true) {
                xx += x[index];
                yy += y[index];
                
                if (xx<0 || xx>=xLength || yy<0 || yy>=yLength || matrix[yy][xx]>100) {
                    beforeIndex = index;
                    index = (index+1) % 4;
                    break;
                }
                result.add(matrix[yy][xx]);
                matrix[yy][xx] = 101;
            }
            
            if ((matrix.length==1) || (matrix[0].length==1 && beforeIndex==1)) {
                break;
            }
            
            xx -= x[beforeIndex];
            yy -= y[beforeIndex];
            
            if (isDone(matrix, xx, yy, index)) {
                break;
            }
        }
        
        return result;
    }
    
    private boolean isDone(int[][] matrix, int xx, int yy, int index) {
        int tmpX = xx + x[index];
        int tmpY = yy + y[index];
        if (tmpX>=0 && tmpX<matrix[0].length && tmpY>=0 && tmpY<matrix.length && matrix[tmpY][tmpX]<=100) {
            return false;
        }
        return true;
    }
}
```
