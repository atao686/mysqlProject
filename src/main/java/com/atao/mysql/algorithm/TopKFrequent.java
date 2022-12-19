package com.atao.mysql.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description (LeetCode-347) 前 K 个高频元素
 *      给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按任意顺序返回答案。
 * @Author atao
 */
public class TopKFrequent {

    public int[] topKFrequentWithPQ(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        /*每个放进优先队列的数组int[]只有两个元素，
        第一个元素代表数组的值，第二个元素代表了该值出现的次数**/
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k,(a, b)->(a[1]-b[1]));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int count = entry.getValue();
            if (minHeap.size() == k) {
                if (minHeap.peek()[1] < count) {
                    minHeap.poll();
                    minHeap.offer(new int[]{entry.getKey(), count});
                }
            }else{
                minHeap.offer(new int[]{entry.getKey(), count});
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = minHeap.poll()[0];
        }
        return ret;
    }

}
