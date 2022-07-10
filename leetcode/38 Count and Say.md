38. Count and Say

https://leetcode.com/problems/count-and-say/submissions/

```java
class Solution {
    public String countAndSay(int n) {
        String num = "1";
        if (n == 1) {
            return num;
        }

        int index = 1;
        while(index < n) {
            char[] nums = num.toCharArray();
            StringBuilder sb = new StringBuilder();

            int count = 1;
            for(int i=0 ; i<nums.length ; i++) {
                if(i+1<nums.length && nums[i] == nums[i+1]) {
                    count++;
                    continue;
                }

                sb.append(count)
                  .append(nums[i]);

                count = 1;
            }
            index++;
            num = sb.toString();
        }

        return num;
    }
}
```
