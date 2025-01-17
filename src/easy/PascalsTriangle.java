package easy;

import java.util.*;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * Tags: Array
 * 两边一定是1 中间的就是i+i-1
 */
class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        int k = 3;
        System.out.println(p.pascalsTriangle(k).toString());
        System.out.println(p.pascalsTriangleb(k).toString());
        System.out.println(p.pascalsTrianglec(k).toString());
    }

     /**
     * Given numRows, generate the first numRows of Pascal's triangle. For example, given numRows = 5,
     */
    public List<List<Integer>> pascalsTriangle(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    /**
     * Definition two loops, one go through the row, one go through the column
     * calculate element value: K(i)(j)=K(i-1)(j-1)+K(i-1)(j) except for the first and last
     * element
     */
    public List<List<Integer>> pascalsTriangleb(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0)
            return triangle;
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<Integer>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * creek----
     */
    public ArrayList<ArrayList<Integer>> pascalsTrianglec(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0)
            return result;
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last
            result.add(cur);
            pre = cur;
        }
        return result;
    }
}