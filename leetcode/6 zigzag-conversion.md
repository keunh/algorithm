https://leetcode.com/problems/zigzag-conversion/

```java
class Solution {
    public String convert(String s, int numRows) {
        if (s.length()==1 || numRows==1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int row = 0;
        int a = (numRows-1)*2, b = a;
        while (row<numRows && row<s.length()) {
            int idx = row;
            sb.append(s.charAt(idx));

            while (true) {
                idx += (b==0) ? a : b;
                if (idx >= s.length()) {
                    break;
                }
                sb.append(s.charAt(idx));
                
                idx += ((a==b || b==0) ? a : Math.abs(a-b));
                if (idx >= s.length()) {
                    break;
                }
                sb.append(s.charAt(idx));
            }
            
            row++;
            b-=2;
        }
        return sb.toString();
    }
}
```
