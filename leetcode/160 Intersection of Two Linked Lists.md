160. Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

못 풀었지만 아이디어.!!

https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aTemp = headA;
        ListNode bTemp = headB;
        
        while(aTemp != bTemp) {
            if (aTemp == null) {
                aTemp = headB;
            } else {
                aTemp = aTemp.next;
            }
            
            if (bTemp == null) {
                bTemp = headA;
            } else {
                bTemp = bTemp.next;
            }
        }
        
        return aTemp;
    }
}
```
