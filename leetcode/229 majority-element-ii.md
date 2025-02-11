https://leetcode.com/problems/majority-element-ii/description/

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        Set<Integer> list = new HashSet<>();

        for (int num : nums) {
            int cnt = maps.getOrDefault(num, 0);
            if (nums.length/3 < cnt+1) {
                list.add(num);
            }
            maps.put(num, cnt+1);
        }

        return new ArrayList<>(list);
    }
}
```
