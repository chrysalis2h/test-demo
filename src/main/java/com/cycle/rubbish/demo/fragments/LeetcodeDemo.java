package com.cycle.rubbish.demo.fragments;

import java.util.Arrays;

/**
 * @ClassName: LeetcodeDemo
 * @Description: LeetcodeDemo
 * @Author: HeJin
 * @Date: 2021\4\6 0006 13:24
 * @Version: v1.0 文件初始创建
 */
public class LeetcodeDemo {

    /*
     * @lc app=leetcode.cn id=242 lang=java
     *
     * [242] 有效的字母异位词
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            int index = t.indexOf(sArr[i]);
            if (index < 0) {
                return false;
            }
            t = t.substring(0, index) + t.substring(index + 1);
        }
        return t.length() == 0;
    }

    /*
     * @lc app=leetcode.cn id=4 lang=java
     *
     * [4] 寻找两个正序数组的中位数
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("----------" + nums[i]);
        }
        if (nums.length % 2 == 0) {
            int len = nums.length / 2 - 1;
            return (nums[len] + nums[len + 1]) / 2.0;
        } else {
            return nums[Math.round(nums.length / 2)];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }
}
