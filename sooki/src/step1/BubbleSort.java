package step1;

import java.util.Arrays;

/**
 * 2020-07-11
 * 버블정렬
 * 이지수
 * 맨 왼쪽부터 오른쪽 수랑 비교함. 크면 오른쪽으로. 반복해서 가장 큰 수를 맨 오른쪽에 위치하도록.
 * 오름차순으로 정렬이 됨.
 */
public class BubbleSort {

    public static void bubbleSort(int data[]){
        int size = data.length;

        System.out.println("sort 자료 : ");
        for (int i=0; i<size; i++)
            System.out.print(data[i] + " ");
        System.out.println();

        System.out.println("*** Bubble Sort 진행 과정 ***");

        System.out.println("사이즈 : " + size);
        for (int i = size-1; i>0; i--){
            boolean change = false;
            System.out.print(size-i+" 단계 ");
            for (int j=0; j<i; j++){
                if (data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    change = true;
                }
                System.out.println("\t"+ Arrays.toString(data));
            }
            if (!change)    break;

        }
    }

    public static void main (String args[]){
        int[] dataList = {23,87,31,40,3,27,15,53,72};
        bubbleSort(dataList);
    }

}
