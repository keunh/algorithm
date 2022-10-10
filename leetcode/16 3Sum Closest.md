16. 3Sum Closest
https://leetcode.com/problems/3sum-closest/submissions/

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        for (int i=0 ; i<nums.length-2 ; i++) {
            int j=i+1;
            int k=nums.length-1;

            while (j<k) {
                if(nums[j]+nums[k] == target-nums[i]) {
                    return target;
                }
                
                int tmpResult = nums[i]+nums[j]+nums[k];
                int tmpDiff = tmpResult-target;
                int tmpAbsDiff = Math.abs(tmpResult-target);
                if (diff > tmpAbsDiff) {
                    result = tmpResult;
                    diff = tmpAbsDiff;
                }
                
                if (tmpDiff<0) {
                    int tmpJ = j;
                    while (j<nums.length-1 && nums[tmpJ]==nums[j]) {
                        j++;
                    }
                } else {
                    int tmpK = k;
                    while(k>0 && nums[tmpK]==nums[k]) {
                        k--;
                    }
                }
            }

            int tmpI = i;
            while(i<nums.length-1 && nums[tmpI]==nums[i+1]) {
                i++;
            }
        }

        return result;
    }
}
```
