48. Rotate Image

https://leetcode.com/problems/rotate-image/

.....🫠 그냥 구현...
```java
class Solution {
    private int[] x = {0,1,0,-1};
    private int[] y = {-1,0,1,0};
        
    public void rotate(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix.length];
        for (int i=0 ; i<matrix.length ; i++) {
            for (int j=0 ; j<matrix.length ; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        int diff = matrix.length-1;
        int originXx = 0, originYy = 0;
        int xx = 0, yy = matrix.length-1;
        for (int i=0 ; i<(matrix.length/2) ; i++) {
            int originTmpX = originXx;
            int originTmpY = originYy;
            int tmpX = xx;
            int tmpY = yy;

            for (int n=0 ; n<4 ; n++) {
                int diffXx = tmpX;
                int diffYy = tmpY;
                for (int m=0 ; m<matrix.length ; m++) {
                    matrix[originTmpY][originTmpX] = copy[tmpY][tmpX];

                    if ((tmpX+x[n])<0 || (tmpY+y[n])<0 || (tmpX+x[n])>=matrix.length || (tmpY+y[n])>=matrix.length) {
                        break;
                    }
                    int diffX = Math.abs((tmpX + x[n]) - diffXx);
                    int diffY = Math.abs((tmpY + y[n]) - diffYy);
                    if (diffX > diff || diffY > diff) {
                        break;
                    }

                    tmpX += x[n];
                    tmpY += y[n];

                    int tmpIndex = (n+1)%4;
                    originTmpX += x[tmpIndex];
                    originTmpY += y[tmpIndex];
                }
            }

            originXx++;
            originYy++;
            xx++;
            yy--;
            diff -= 2;
        }
    }
}
```

Soloution 상세한 설명 👍
https://leetcode.com/problems/rotate-image/solution/
```
class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        
        for (int i=0 ; i<length ; i++) {
            for (int j=i+1 ; j<length ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }       
        
        for (int i=0 ; i<length ; i++) {
            for (int j=0 ; j<(length/2) ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length-1-j];
                matrix[i][length-1-j] = tmp;
            }
        }
    }
}
```
