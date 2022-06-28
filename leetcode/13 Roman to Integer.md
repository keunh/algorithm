13. Roman to Integer

https://leetcode.com/problems/roman-to-integer/submissions/

```java
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman =
                Map.of('I', 1,
                        'V', 5,
                        'X', 10,
                        'L', 50,
                        'C', 100,
                        'D', 500,
                        'M', 1000);

        int sum = 0;
        int previous = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            int current = roman.get(c);
            if (current > previous) {
                sum -= (previous * 2);
            }
            
            previous = current;
            sum += current;
        }

        return sum;
    }
}
```
