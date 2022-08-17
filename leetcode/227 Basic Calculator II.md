227. Basic Calculator II

https://leetcode.com/problems/basic-calculator-ii/

🫠
```java
class Solution {
    public int calculate(String s) {
        List<Integer> list = new ArrayList<>();
        int tmp = -1;

        for(int i=0 ; i<s.length() ; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                list.add(tmp);
                list.add(-ch);
                tmp = -1;
            } else {
                if (tmp == -1) {
                    tmp = 0;
                }
                tmp = tmp * 10;
                tmp += ch - '0';
            }
        }
        list.add(tmp);

        List<Integer> list2 = new ArrayList<>();
        list2.add(list.get(0));
        for (int i=1 ; i<list.size() ; i++) {
            int tmp2 = list.get(i);
            if (tmp2 == -'*') {
                int list2Size = list2.size()-1;
                int tmp1 = list2.get(list2Size);
                list2.set(list2Size, tmp1 * list.get(i+1));
                i++;
            } else if (tmp2 == -'/'){
                int list2Size = list2.size()-1;
                int tmp1 = list2.get(list2Size);
                list2.set(list2Size, tmp1 / list.get(i+1));
                i++;
            } else {
                list2.add(tmp2);
            }
        }

        if (list2.size() == 1) {
            return list2.get(0);
        }

        int result = list2.get(0);
        for (int i=1 ; i<list2.size() ; i++) {
            int tmp2 = list2.get(i);
            if (tmp2 == -'+') {
                result += list2.get(i+1);
                i++;
            } else if (tmp2 == -'-') {
                result -= list2.get(i+1);
                i++;
            }
        }
        return result;
    }
}
```
