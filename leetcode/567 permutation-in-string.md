힌트 확인

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int ch1[] = new int[26];
        int ch2[] = new int[26];
        for (int i=0 ; i<s1.length() ; i++) {
            ch1[s1.charAt(i)-'a']++;
            ch2[s2.charAt(i)-'a']++;
        }

        if (Arrays.equals(ch1, ch2)) {
            return true;
        }

        int idx=0;
        for (int i=s1.length() ; i<s2.length() ; i++) {
            ch2[s2.charAt(idx)-'a']--;
            ch2[s2.charAt(i)-'a']++;
            idx++;

            if (Arrays.equals(ch1, ch2)) {
                return true;
            }
        }

        return false;
    }
}
```
