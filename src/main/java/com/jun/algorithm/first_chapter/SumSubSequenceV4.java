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

        System.out.println(sumSubSequenceWithResult(Arrays.asList(1,2,3,-7,3,4,-3,2,4,-11,3,-2)));
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
                //存储当前和最大的子序列和值
                maxSum = thisSum;
            }
            if (thisSum < 0) {
                //重新开始计算可能的最大子序列
                thisSum = 0;
            }
        }

        return maxSum;
    }

    /**
     * 改进型:
     * 同时输出最大子序列
     * 时间复杂度也是O(N)
     * @param list
     * @return
     */
    public static int sumSubSequenceWithResult(List<Integer> list){
        if(null==list||list.size()==0){
            return 0;
        }
        int maxSum=list.get(0),thisSum=0;
        //用于存储最大子序列值
        int maxStart=0,maxEnd=0;
        int tempStart=0;
        for (int i=0;i<list.size();i++) {
            thisSum += list.get(i);
            if (thisSum > maxSum) {
                //存储当前和最大的子序列和值
                maxSum = thisSum;
                if(maxStart!=tempStart){
                    maxStart=tempStart;
                }
                maxEnd=i;
            }
            if (thisSum < 0) {
                //重新开始计算可能的最大子序列
                thisSum = 0;
                tempStart=i+1;
            }
        }
        List<Integer> subSequence=new ArrayList<Integer>();
        for(int i=maxStart;i<=maxEnd;i++){
            subSequence.add(list.get(i));
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
