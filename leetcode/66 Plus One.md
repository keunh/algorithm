66. Plus One
 
https://leetcode.com/problems/plus-one/

```java
import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int digit : digits) {
            sb.append(digit);
        }
        
        BigInteger num = new BigInteger(sb.toString());
        num = num.add(BigInteger.ONE);

        char[] numChar = String.valueOf(num).toCharArray();
        int[] result = new int[numChar.length];
        for(int i=0 ; i<result.length ; i++) {
            result[i] = numChar[i] - '0';
        }
        
        return result;
    }
}
```

https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
```
