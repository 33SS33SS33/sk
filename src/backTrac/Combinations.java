package backTrac;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * Tags: Backtracking
 */

class Combinations {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists3 = combineB(4, 2);
        for (ArrayList<Integer> l : lists3) {
            System.out.print(l.toString());
        }
    }

    /**
     * 最好的
     * creek DFS
     */
    public static ArrayList<ArrayList<Integer>> combineB(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || n < k)
            return result;
        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result); // because it need to begin from 1
        return result;
    }

    private static void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1); //
        }
    }

}
