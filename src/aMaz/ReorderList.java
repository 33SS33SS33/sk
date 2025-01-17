package aMaz;

/**
 * Created by GAOSHANSHAN835 on 2016/1/8.
 */
class ReorderList {
    public static void main(String[] args) {
        // {1,2,3,4,5,6}
        ListNode head = buildTestList1();
        ReorderList r = new ReorderList();
        r.printList(head);
        r.reorderList(head);
        r.printList(head);

        ListNode head2 = buildTestList1();
        r.printList(head2);
//        r.reorderList2(head2);
        r.printList(head2);
    }

    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * You must do this in-place without altering the nodes' values.
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     * 第一步是用快慢指针找到链表的中点 然后把链表从中点分成两部分(记得处理前一部分的最后一个元素 让他的next = None）
     * 第二步 把第二部分的链表倒序反转（记得处理第二部分的第一个元素 让他的next=None ）
     * 第三部 将第二部分的元素每隔一个插入第一部分的链表里（
     * 记得要处理当第一部分的指针下一个已经是None但是第二部分还有不止一个元素的情况）
     * Find mid point, then split list into 2 halves
     * Reverse latter half, then merge two lists
     */
    private void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // find mid point use runner's technique
        ListNode mid = head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            mid = mid.next;
            tail = tail.next.next;
        }
        ListNode cur = mid.next;
        mid.next = null; // split mid and mid.next
        // reverse list 2
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = mid.next; // insert after mid
            mid.next = cur;
            cur = temp; // move to next node
        }
        // reorder list
        ListNode left = head;
        ListNode right = mid.next;
        while (right != null) { // latter half has fewer elements
            mid.next = right.next;
            right.next = left.next;
            left.next = right;
            // move to next node
            left = right.next;
            right = mid.next;
        }
    }

    /**
     * TLE, O(n^2)
     */
/*    private void reorderList2(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode cur = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode beforeTail = cur.next;
            ListNode curNext = cur.next;
            while (beforeTail != null && beforeTail.next != null && beforeTail.next.next != null) {
                beforeTail = beforeTail.next;
            }
            cur.next = beforeTail.next;
            beforeTail.next.next = curNext;
            beforeTail.next = null;
            cur = curNext;
        }
        return;
    }*/
    static ListNode buildTestList1() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        return head;
    }

    private void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("NULL");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
