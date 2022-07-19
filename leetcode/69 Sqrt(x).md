69. Sqrt(x)

https://leetcode.com/problems/sqrtx/

```java
class Solution {
    public int mySqrt(int x) {
        int num = 1;
        while (true) {
            if (((long)num*num) > x) {
                return num-1;
            }
            num++;
        }
    }
}
```
