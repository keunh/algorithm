169. Majority Element

https://leetcode.com/problems/majority-element/

```java
class Solution {
    public int majorityElement(int[] nums) {
        int numsLength = (nums.length / 2) + 1;
        Map<Integer, Integer> countByNums = new HashMap<>();
        
        for(int num : nums) {
            int count = countByNums.getOrDefault(num, 0) + 1;
            if (count >= numsLength) {
                return num;
            }

            countByNums.put(num, count);
        }
        
        return 0;
    }
}
```
