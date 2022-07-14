28. Implement strStr()

https://leetcode.com/problems/implement-strstr/

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        } else if (haystack.length() == needle.length()) {
            if (haystack.equals(needle)) {
                return 0;
            }
            return -1;
        }
        
        char[] hayChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        
        for (int i=0 ; i<hayChar.length - needleChar.length + 1 ; i++) {
            boolean isSame = true;
            int tmpI = i;
            for (char c : needleChar) {
                if (c != hayChar[tmpI++]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                return i;
            }
        }

        return -1;
    }
}
```
