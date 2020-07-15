package step1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2750 수 정렬하기
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
 *
 */
public class sooki_2751_merge {
    static int sortData[];
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


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int [n];
        sortData = new int [n];
        for (int i = 0 ; i < n ; i++)
            nArr[i] = sc.nextInt();

        mergeSort(nArr, 0, n-1);

       for (int i = 0 ; i < n ; i++)
        {
            System.out.println(sortData[i]);
        }
    }
}
