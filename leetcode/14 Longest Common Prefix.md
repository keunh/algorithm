14. Longest Common Prefix

https://leetcode.com/problems/longest-common-prefix/

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String[] prefixs = new String[strs[0].length()+1];

        for(int i=0 ; i<=strs[0].length() ; i++) {
            prefixs[i] = strs[0].substring(0, i);
        }

        int min = prefixs.length-1;
        for(String str : strs) {
            if(str.length() == 0) {
                min = 0;
                break;
            }

            int tmpMin = 0;
            for(int i=0 ; i<prefixs.length ; i++) {
                if (!str.startsWith(prefixs[i])) {
                    tmpMin--;
                    break;
                }
                tmpMin++;
            }

            min = Math.min(min, tmpMin);
        }

        return prefixs[min];
    }
}
```


Solution!
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                } 
            }
        }
        return prefix;
    }
}

```
