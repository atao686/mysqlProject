package com.atao.mysql.algorithm;

import java.util.Arrays;

/**
 * @Description (LeetCode-215) 数组中的第K个最大元素
 * @Author atao
 */
public class KthInArray {

    /*数组排序后，直接返回第 k 个元素*/
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

}
