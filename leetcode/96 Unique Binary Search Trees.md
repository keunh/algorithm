96. Unique Binary Search Trees
https://leetcode.com/problems/unique-binary-search-trees/

🫥 못풀었다....
```
class Solution {
    public int numTrees(int n) {
        int g[] = new int[n+1];
        g[0] = 1;
        
        for (int i=1 ; i<=n ; i++) {
            for (int j=1 ; j<=i ; j++) {
                g[i] += g[j-1] * g[i-j];
            }
        }
        
        return g[n];
    }
}
```
