package step1;

import java.util.Arrays;

/**
 * 퀵정렬
 * 이지수
 *
 */
public class QuickSort {

    public static void quickSort(final int[] data, int start, int end){
        if (start < end){
            int low = start;
            int high = end;
            int pivot = data[(low+high)/2];
            while(low<high){
                while(data[low]<pivot)
                    low++;
                while(data[high]>pivot)
                    high--;
                if (low < high){
                    int temp = data[low];
                    data[low] = data[high];
                    data[high] = temp;
                }
            }

            System.out.println(Arrays.toString(data));
            quickSort(data, start, low -1);
            quickSort(data, low+1, end);
        }

    }

    public static void main (String args[]){
        int[] dataList = {23,87,31,40,3,27,15,53,72};

        int size = dataList.length;

        System.out.print("\n*** Sort 자료 : ");

        for (int i = 0; i < size; i++)
            System.out.print(dataList[i] + " ");


        System.out.println("\n");

        System.out.println("******** Selecttion Sort 진행 과정 ********");

        quickSort(dataList, 0, size-1);

    }
}
