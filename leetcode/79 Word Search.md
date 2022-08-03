79. Word Search

https://leetcode.com/problems/word-search/

```java
class Solution {
    
    private int[] x = {1,-1,0,0};
    private int[] y = {0,0,-1,1};
    private boolean result = false;
    private int m, n;
    private boolean[][] check;
    
    public boolean exist(char[][] board, String word) {
        
        m = board.length;
        n = board[0].length;
        
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (word.charAt(0) == board[i][j]) {
                    check = new boolean[m][n];
                    check[i][j] = true;
                    recursive(board, word, j, i, 1);
                }
            }
        }
        
        return result;
    }
    
    public void recursive(char[][] board, String word, int xx, int yy, int d) {
        if (d == word.length()) {
            result = true;
            return;
        }
        
        for (int i=0 ; i<4; i++) {
            if (result) {
                return;
            }
            
            int tmpX = xx + x[i];
            int tmpY = yy + y[i];
            
            if (tmpY<0 || tmpY>=m || tmpX<0 || tmpX>=n || check[tmpY][tmpX]) {
                continue;
            }
            if (word.charAt(d) != board[tmpY][tmpX]) {
                continue;
            }
            
            check[tmpY][tmpX] = true;
            recursive(board, word, tmpX, tmpY, d+1);
            check[tmpY][tmpX] = false;
        }
    }
}
```
