package medium;

/**
 * Sort a linked list using insertion sort.
 * Tags: Linkedlist, Sort
 * 模拟插入排序即可 需要用的到假链表头
 * 注意先不要将dummy和head连起来 这样是两个独立的链表 会比较好 把未排序的链表的元素插入进排序好的链表里
 * 要不容易打环
 */
class InsertionSortList {
    public static void main(String[] args) {
        ListNode n1 = buildList();
        n1 = insertionSortLista(n1);
        printList(n1);
    }

    /**
     * 最好的
     */
    public static ListNode insertionSortLista(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }

    /**
     * Check the list one by one to find a node that has smaller value than
     * nodes before it and swap
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        for (ListNode p = head.next, prev = head; p != null; prev = p, p = p.next) {
            for (ListNode c = pre; c.next != p; c = c.next) {
                if (c.next.val > p.val) {
                    prev.next = p.next; // skip p
                    p.next = c.next; // insert between cur and cur.next
                    c.next = p;
                    p = prev; // p is inserted to somewhere in the front, reset
                    break;
                }
            }
        }
        return pre.next;
    }

    public static void printList(ListNode x) {
        if (x != null) {
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }

    public static ListNode buildList() {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
