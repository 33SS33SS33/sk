package aMaz;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * Tags: Linkedlist
 */
class SwapNodesinPairs {
    public static void main(String[] args) {
        SwapNodesinPairs r = new SwapNodesinPairs();
        ListNode head = buildList();
        ListNode r2 = r.swapNodesinPairs(head);
        while (r2.next != null) {
            System.out.print(r2.next == null ? r2.val : r2.val + "->");
            r2 = r2.next;
        }
        System.out.println();
        ListNode head2 = buildList();
        ListNode r3 = r.swapNodeinPairsa(head2);
        while (r3.next != null) {
            System.out.print(r3.next == null ? r3.val : r3.val + "->");
            r3 = r3.next;
        }
/*        System.out.println();
        ListNode head3 = buildList();
        ListNode r4 = r.swapNodeinPairsc(head3);
        while (r4.next != null) {
            System.out.print(r4.next == null ? r4.val : r4.val + "->");
            r4 = r4.next;
        }*/
    }

    /**
     * 递归
     */
    public ListNode swapNodesinPairs(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapNodesinPairs(head.next.next);
        n.next = head;
        return n;
    }

    /**
     * create a node at before the head
     * swap two next nodes on the node before them
     */
    public ListNode swapNodeinPairsa(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null && cur.next.next != null) {
            cur.next = swap(cur.next, cur.next.next);
            cur = cur.next.next;
        }
        return dummy.next;
    }

    private static ListNode swap(ListNode next1, ListNode next2) {
        next1.next = next2.next;
        next2.next = next1;
        return next2; // return latter node 
    }

/*    public ListNode swapNodeinPairsb(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
            p = r;
        }
        return dummy.next;
    }*/

    /**
     * -----creek---
     */
/*    public ListNode swapNodeinPairsc(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        while (p.next != null && p.next.next != null) {
            //use t1 to track first node
            ListNode t1 = p;
            p = p.next;
            t1.next = p.next;

            //use t2 to track next node of the pair
            ListNode t2 = p.next.next;
            p.next.next = p;
            p.next = t2;
        }
        return h.next;
    }*/

    static ListNode buildList() {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        return node0;
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
