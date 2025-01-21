...............

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> sets = new HashSet<>();

        while (head!=null) {
            if (!sets.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
```

Solution
```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
```
