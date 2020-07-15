package step1;

import java.util.Arrays;

/**
 * 병합정렬
 * 이지수
 */
public class MergeSort {
    static int sortData[] = new int [20];
    public static void merge(int data[], int low, int middle, int high){
        int size = data.length;
        int i,j,k;
        i = low;
        j = middle +1;
        k = low;

        while (i <= middle && j <= high){
            if (data[i] <= data[j])
                sortData[k] = data[i++];
            else sortData[k] = data[j++];
            k++;
        }
        if (i > middle){
            for (int ii=j; ii<=high; ii++, k++)
                sortData[k] = data[ii];
        }
        else {
            for (int ii=i; ii<=middle; ii++, k++){
                sortData[k] = data[ii];
            }
        }

        for (int ii=low; ii<=high; ii++)
            data[ii] = sortData[ii];
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int a[], int low, int high){
        int middle;
        if (low < high){
            middle = (low+high)/2;
            mergeSort(a, low, middle);
            mergeSort(a, middle+1, high);
            merge(a, low, middle, high);
        }
    }

    public static void main (String args[]){
        int[] dataList = {87, 23, 40, 31, 27, 4, 53, 15, 72};
        int size = dataList.length;

        System.out.print("\n*** Sort 자료 : ");

        for (int i = 0; i < size; i++)
            System.out.print(dataList[i] + " ");
        System.out.println("\n");

        System.out.println("******** Merge Sort 진행 과정 ********");

        mergeSort(dataList, 0, size-1);
    }


}
