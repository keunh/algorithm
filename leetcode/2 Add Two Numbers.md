2. Add Two Numbers

https://leetcode.com/problems/add-two-numbers/

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next = null;
        boolean isOver = false;
            
        while(l1!=null || l2!=null) {
            int tmp = (isOver ? 1 : 0);
            
            if (l1!=null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            if (tmp >= 10) {
                isOver = true;
                tmp = tmp%10;
            } else {
                isOver = false;
            }
            
            if (result == null) {
                result = new ListNode(tmp);
                next = result;
            } else {
                next.next = new ListNode(tmp);
                next = next.next;
            }
        }
        
        if (isOver) {
            next.next = new ListNode(1);
        }
        
        return result;
    }
}
```

미리 더미를 만드는 방식도 있었다
https://leetcode.com/problems/add-two-numbers/solution/
