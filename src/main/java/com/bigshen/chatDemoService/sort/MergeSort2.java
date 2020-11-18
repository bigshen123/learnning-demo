package com.bigshen.chatDemoService.sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort2
 * @Description: TODO 二路归并算法
 * @Author BYJ
 * @Date 2020/10/18
 * @Version V1.0
 **/
public class MergeSort2 {

    /**
     * 二路归并算法
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] a,int left,int mid,int right){
        int[] tmp=new int[a.length];
        //p1,p2是检测指针，k是存放指针
        int p1=left,p2=mid+1,k=left;
        while (p1<=mid && p2<=right){
            if (a[p1]<=a[p2]){
                tmp[k++]=a[p1++];
            }else{
                tmp[k++]=a[p2++];
            }
        }
        //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p1<=mid){
            tmp[k++]=a[p1++];
        }
        //同上
        while (p2<=right){
            tmp[k++]=a[p2++];
        }
        //复制回原数组
        for (int i=left;i<=right;i++){
            a[i]=tmp[i];
        }
    }

    /**
     * 归并排序
     * @param a
     * @param start
     * @param end
     */
    public static void mergeSort(int[] a,int start,int end){
        //当子序列中只有一个元素时结束递归
        if (start<end){
            //划分子序列
            int mid=(start+end)/2;
            //对左侧子序列进行递归排序
            mergeSort(a,start,mid);
            //对右侧子序列进行递归排序
            mergeSort(a,mid+1,end);
            //合并
            merge(a,start,mid,end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 2, 45, 6, 34, 77, 4, 22, 54, 36};
        System.out.println("排序前的数组：" + Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }
}
