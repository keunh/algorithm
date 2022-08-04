19. Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int size = 1;
        
        while (tmp.next != null) {
            tmp = tmp.next;
            size++;
        }
        
        if (size == n) {
            return head.next;
        }
        
        tmp = head;
        ListNode before = head;
        while (size-- != n) {
            before = tmp;
            tmp = tmp.next;
        }
        before.next = tmp.next;
        
        return head;        
    }
}
```
