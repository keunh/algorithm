11. Container With Most Water

https://leetcode.com/problems/container-with-most-water/

힌트 확인 후 풀이

```java
class Solution {
    public int maxArea(int[] height) {
        int result = 0;

        int start = 0;
        int end = height.length-1;

        while(start < end) {
            int min = Math.min(height[start], height[end]);
            result = Math.max(result, (end - start) * min);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
```
