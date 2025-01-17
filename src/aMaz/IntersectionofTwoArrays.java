package aMaz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shanshan on 16/6/17.
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = intersectionofTwoArrays(num1, num2);
        int[] res2 = intersectionofTwoArraysb(num1, num2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + " ");
        }
    }

    /**
     * Given two arrays, write a function to compute their intersection.
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     * Note: Each element in the result must be unique.
     * The result can be in any order.
     */
    public static int[] intersectionofTwoArrays(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    public static int[] intersectionofTwoArraysb(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

}
