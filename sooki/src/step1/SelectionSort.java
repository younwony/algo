package step1;

import java.util.Arrays;

/**
 * 2020-07-11
 * 선택정렬
 * 이지수
 * 최소값(최대값)을 찾아서 배열의 맨 앞(맨 뒤) 위치의 수랑 자리 변경
 * 첫번째(마지막) 수를 제외한 나머지 원소들 중에서 최소(최대)값을 선택하여 반복
 */
public class SelectionSort {

    public static void selectionSort(int data[]) {
        int size = data.length;

        System.out.print("\n*** Sort 자료 : ");

        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");

        System.out.println("\n");

        System.out.println("******** Selecttion Sort 진행 과정 ********");

        for (int i = 0; i < size - 1; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (data[j] < data[min])
                    min = j;

                    int temp = data[i];
                    data[i] = data[min];
                    data[min] = temp;
                    min = i;

                    System.out.println((i + 1) + "단계 : " + Arrays.toString(data));

            }
        }
    }


    public static void main (String args[]){
        int[] dataList = {23,87,31,40,3,27,15,53,72};
        selectionSort(dataList);
    }



}
