https://leetcode.com/problems/next-greater-element-i/description/
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] next = new int[10001];

        for (int i=0 ; i<nums2.length ; i++) {
            next[nums2[i]] = i+1;
        }

        for (int i=0 ; i<nums1.length ; i++) {
            int tmp = -1;
            for (int j=next[nums1[i]] ; j<nums2.length ; j++) {
                if (nums1[i]<nums2[j]) {
                    tmp = nums2[j];
                    break;
                }
            }
            nums1[i] = tmp;
        }

        return nums1;
```

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        for (int i=0 ; i<nums1.length ; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
```
