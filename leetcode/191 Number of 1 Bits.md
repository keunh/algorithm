191. Number of 1 Bits

https://leetcode.com/problems/number-of-1-bits/

```java
public class Solution {
    public int hammingWeight(int n) {
        int num = 1;
        int count = 0;
        
        for(int i=0 ; i<32 ; i++) {
            if ((n & num) != 0) {
                count++;
            }
            
            num = num << 1;
        }
        
        return count;
    }
}
```
