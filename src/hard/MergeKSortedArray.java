package hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by GAOSHANSHAN835 on 2016/3/4. HARD TODO
 * creek----This problem can be solved by using a heap. The time is O(nlog(n)).
 */

public class MergeKSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10, 11};

        int[] result = mergeKSortedArray(new int[][]{arr1, arr2, arr3});
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeKSortedArray(int[][] arr) {
        //PriorityQueue is heap in Java
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<>();
        int total = 0;
        //add arrays to heap
        for (int i = 0; i < arr.length; i++) {
            queue.add(new ArrayContainer(arr[i], 0));
            total = total + arr[i].length;
        }
        int m = 0;
        int result[] = new int[total];
        //while heap is not empty
        while (!queue.isEmpty()) {
            ArrayContainer ac = queue.poll();
            result[m++] = ac.arr[ac.index];
            if (ac.index < ac.arr.length - 1) {
                queue.add(new ArrayContainer(ac.arr, ac.index + 1));
            }
        }
        return result;
    }

    static class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            if (this.arr[this.index] > o.arr[o.index]) {
                return 1;
            } else if (this.arr[this.index] < o.arr[o.index]) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
