242. Valid Anagram

https://leetcode.com/problems/valid-anagram/submissions/

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCount = charCount(s);
        int[] tCount = charCount(t);

        for(int i=0 ; i<26 ; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] charCount(String s) {
        int[] result = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            result[index]++;
        }
        return result;
    }
}
```

* 간단한 구현
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s_charArray = s.toCharArray();
        char[] t_charArray = t.toCharArray();

        Arrays.sort(s_charArray);
        Arrays.sort(t_charArray);
        
        return Arrays.equals(s_charArray, t_charArray);
    }
}
```
