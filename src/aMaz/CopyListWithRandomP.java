package aMaz;

import java.util.*;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Tags: Hashtable, Linkedlist
 * 难点在于如何知道一个点是不是在之前就已经被copy 比如先通过随机的指针建立了节点3
 * 当通过next访问到3的时候如何知道3是之前创建过的
 * 只需要用一个hashtable跟踪一下就知道了
 * 右边的解法用了defaultdict 十分简单 重要
 */
class CopyListWithRandomP {
    public static void main(String[] args) {
        RandomListNode node = buildList();
        RandomListNode res = new CopyListWithRandomP().copyRandomListA(node);
        while (res != null) {
            System.out.print(res.label + ",");
            if (res.random != null) {
                System.out.print(res.random.label + ",");
            }
            res = res.next;
        }
    }

    /**
     * Use a hashmap to store map between original node and copy node 递归 最好的 第一解法
     * Get copy node from map
     */
    public RandomListNode copyRandomListA(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        return helper(head, map);
    }

    public RandomListNode helper(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node); // return copy
        RandomListNode res = new RandomListNode(node.label);
        map.put(node, res); // build map
        res.next = helper(node.next, map); // build next
        res.random = helper(node.random, map); // build copy
        return res;
    }

    /**
     * creek ------ 不要了
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);
        p = p.next;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }
        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null)
                q.random = map.get(p.random);
            else
                q.random = null;
            p = p.next;
            q = q.next;
        }
        return newHead;
    }

    static RandomListNode buildList() {
        RandomListNode node0 = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(6);
        node0.next = node1;
        node0.random = node2;
        node1.next = node2;
        return node0;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}