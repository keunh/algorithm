3. Longest Substring Without Repeating Characters

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int result = 1;
        int longLength = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i=1 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            int indexOf = sb.toString().indexOf(c);

            if (indexOf > -1) {
                longLength = sb.length() - indexOf - 1;
                sb = new StringBuilder(sb.substring(indexOf+1));
            }

            longLength++;
            sb.append(c);
            result = Math.max(result, longLength);
        }
        return result;
    }
}
```

투포인터를 사용한 방식!
https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
