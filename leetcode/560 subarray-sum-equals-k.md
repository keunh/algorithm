```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] m = new int[nums.length];
        m[0] = nums[0];

        for(int i=1 ; i<nums.length ; i++) {
            m[i] = m[i-1] + nums[i];
        }

        for (int i=0 ; i<nums.length ; i++) {
            for (int j=i ; j>=0 ; j--) {
                if (i==j) {
                    if (m[i]==k) {
                        result++;
                    }
                } else if (m[i]-m[j]==k) {
                    result++;
                }
            }
        }

        return result;
    }
}
```
