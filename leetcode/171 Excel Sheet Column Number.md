171. Excel Sheet Column Number

https://leetcode.com/problems/excel-sheet-column-number/

```java
class Solution {
    public int titleToNumber(String columnTitle) {
        int length = columnTitle.length();
        int sum = 0;
        char[] charColumnTitle = columnTitle.toCharArray();
        for (int i=length-1 ; i>=0 ; i--) {
            int num = charColumnTitle[i] - 64;
            if (i==length-1) {
                sum += num;
                continue;
            }
            sum = sum + (num * (int) Math.pow(26.0, length-i-1));
        }
        return sum;
    }
}
```
