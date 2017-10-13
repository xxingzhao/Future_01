package org.xiaoxz.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {1,5,2,10,3,1,88,99,10,25,63};
        for(int i=arr.length-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print("提交修改");
            System.out.print(arr[i] +"、");
        }
    }

}
