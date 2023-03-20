203. Remove Linked List Elements

https://leetcode.com/problems/remove-linked-list-elements/description/

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode next = head;
        ListNode prev = null;
        head = null;
        while (next != null) {
            if (next.val == val) {
                if (prev != null) {
                    prev.next = next.next;
                }
                next = next.next;
                continue;
            }
            if (head == null) {
                head = next;
            }
            prev = next;
            next = next.next;
        }
        return head;       
    }
}
```
