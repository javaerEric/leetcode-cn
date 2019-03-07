package com.company.difficult;

/**
 * 第4题
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author : duozl
 * @date : 2019/3/7 14:54
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3;
        if (null == nums1) {
            nums3 = nums2;
        } else if (null == nums2) {
            nums3 = nums1;
        }else {
            // 两个数组都不为空
            nums3 = new int[nums1.length + nums2.length];
            int i = 0;
            int j = 0;
            int index = 0;
            while (i < nums1.length || j < nums2.length) {
                if (i >= nums1.length) {
                    nums3[index] = nums2[j];
                    j++;
                } else if (j >= nums2.length || nums1[i] < nums2[j]) {
                    nums3[index] = nums1[i];
                    i++;
                } else if (nums1[i] >= nums2[j]) {
                    nums3[index] = nums2[j];
                    j++;
                }
                index++;
            }
        }

        int length = nums3.length;
        if (length % 2 == 0) {
            return (nums3[length / 2 - 1] + nums3[length / 2]) / 2.0;
        } else {
            return nums3[length / 2];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        double median = medianOfTwoSortedArrays.findMedianSortedArrays(num1, num2);
        System.out.println(median);
    }
}
