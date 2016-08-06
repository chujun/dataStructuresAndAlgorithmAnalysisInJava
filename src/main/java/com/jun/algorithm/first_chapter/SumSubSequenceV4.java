package com.jun.algorithm.first_chapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chujun on 16/8/6.
 * 算法:求一个序列当中和最大的子序列(可正,可负)
 */
public class SumSubSequenceV4 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(-1, 1, 2, 3, -5, 6, 7, 8, -3, 4, 3, 5);
        System.out.println(sumSubSequence(list));

        System.out.println(sumSubSequence(Arrays.asList(-1)));
    }

    /**
     * 时间复杂度为O(N)
     * @param list 列表
     * @return 总和
     */
    public static int sumSubSequence(List<Integer> list){
        if(null==list||list.size()==0){
            return 0;
        }
        int maxSum=list.get(0),thisSum=0;

        for (Integer value : list) {
            thisSum += value;
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }



}
