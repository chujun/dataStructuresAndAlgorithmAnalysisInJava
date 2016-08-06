package com.jun.algorithm.first_chapter;

import java.util.ArrayList;
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

        System.out.println(sumSubSequence(Arrays.asList(2,-3,4,3,-5)));
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

        //用于存储最大子序列值
        List<Integer> subSequence=new ArrayList<Integer>();
        for (Integer value : list) {
            thisSum += value;
            subSequence.add(value);
            if (thisSum > maxSum) {
                //存储当前和最大的子序列和值
                maxSum = thisSum;
            }
            if (thisSum < 0) {
                //重新开始计算可能的最大子序列
                thisSum = 0;
                subSequence=new ArrayList<Integer>();
            }
        }

        System.out.println(subSequence);
        return maxSum;
    }
}

//[1, 2, 3, -5, 6, 7, 8, -3, 4, 3, 5]
//            31
//            []
//            -1
//            [4, 3, -5]
//            7
