234. Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

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
    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        ListNode reverse = new ListNode(tmp.val);
        int length = 1;

        while (true) {
            if (tmp.next == null) {
                break;
            }
            length++;
            tmp = tmp.next;
            reverse = new ListNode(tmp.val, reverse);
        }
        
        length = length/2;
        while (length-- > 0) {
            if (head.next == null) {
                return false;
            }
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}
```
